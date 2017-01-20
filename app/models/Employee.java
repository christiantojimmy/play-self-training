package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import play.db.ebean.Model;

import javax.persistence.*;

/**
 * Created by christiantojimmy on 1/18/17.
 */
@Entity
@Table(name = "employee")
public class Employee extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String name;

    public int age;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    public Company company;

    public static Finder<Long, Employee> find = new Finder<Long, Employee>(Long.class, Employee.class);

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
