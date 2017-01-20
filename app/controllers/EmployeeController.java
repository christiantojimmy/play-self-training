package controllers;

import models.Employee;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by christiantojimmy on 1/18/17.
 */
public class EmployeeController extends Controller {

    public static Result index() {
        return ok();
    }

    public static Result all() {
        return ok(Json.toJson(Employee.find.all()));
    }

    public static Result show(Long id) {
        Employee employee = Employee.find.byId(id);
        if(employee != null)
            return ok(Json.toJson(Employee.find.byId(id)));
        else
            return notFound();
    }
}
