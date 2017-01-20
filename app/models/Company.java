package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by christiantojimmy on 1/18/17.
 */
@Entity
@Table(name = "company")
public class Company extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    public List<Employee> employees;

    public static Finder<Long, Company> find = new Finder<Long, Company>(Long.class, Company.class);

    public static Company createCompany(String name) {
        Company company = new Company();
        company.name = name;

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Employee at " + name + " number 1", 26));
        employees.add(new Employee("Employee at " + name + " number 2", 26));
        employees.add(new Employee("Employee at " + name + " number 3", 26));
        employees.add(new Employee("Employee at " + name + " number 4", 26));
        employees.add(new Employee("Employee at " + name + " number 5", 26));

        company.employees = employees;

        company.save();

        return company;
    }
}
