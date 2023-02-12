package org.acme;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.time.StopWatch;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;

@Path("/hello")
public class GreetingResource {

    @Inject
    MeterRegistry registry;

    StopWatch stopWatch = StopWatch.createStarted();

    List<String> list;
    Counter counter;
    Integer numberGuage;
    Timer timer;

    /**
     * 
     */
    @PostConstruct
    public void init() {
        counter = registry.counter("hello", "counter for call", "value of description");
        registry.gauge("guage", Tags.of("This is gausfe,", "2"), stopWatch, StopWatch::getTime);
        registry.gaugeCollectionSize("collectionSize", Tags.of("hello-collectionSize-tag", "test"), list);
        numberGuage = registry.gauge("numberGuage", 0);
        timer = registry.timer("timer123", Tags.of("123", "345"));
    }

    // localhost:8080/q/metrics/application
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        stopWatch.reset();
        stopWatch.start();
        counter.increment();

        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/hello1")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello1() {
        stopWatch.reset();
        stopWatch.start();
        numberGuage++;
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(String.valueOf(numberGuage));

        timer.record(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("print " + i);
            }
        });
        return "Hello1";
    }
}