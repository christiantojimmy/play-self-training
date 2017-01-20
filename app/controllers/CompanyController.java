package controllers;

import models.Company;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by christiantojimmy on 1/18/17.
 */
public class CompanyController extends Controller {

    public static Result index() {
        return ok();
    }

    public static Result all() {
        return ok(Json.toJson(Company.find.all()));
    }

}
