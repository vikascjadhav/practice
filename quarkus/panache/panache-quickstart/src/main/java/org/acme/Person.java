package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbCreator;
import javax.persistence.Entity;



/**
 * Example JPA entity defined as a Panache Entity.
 * An ID field of Long type is provided, if you want to define your own ID field extends <code>PanacheEntityBase</code> instead.
 *
 * This uses the active record pattern, you can also use the repository pattern instead:
 * .
 *
 * Usage (more example on the documentation)
 *
 * {@code
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.field = "field-1";
 *         entity1.persist();
 *
 *         List<MyEntity> entities = MyEntity.listAll();
 *     }
 * }
 */
@Entity
public class Person extends PanacheEntity {
   /*  @Id @GeneratedValue
    public Long id; */
    public String fname;
    public String lname;
    public double age;

    Person() {}

    @JsonbCreator
    public Person(String fname, String lname, double age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public double getAge() {
        return age;
    }
    public void setAge(double age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person [fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
    }

    


}
