package controllers;

import base.BaseTest;
import org.fest.assertions.Assertions;
import org.junit.Test;
import play.mvc.Http;
import play.mvc.Result;
import play.test.FakeRequest;
import play.test.Helpers;

/**
 * Created by christiantojimmy on 1/18/17.
 */
public class EmployeeControllerTest extends BaseTest {

    @Test
    public void testIndex() {
        Result result = Helpers.route(new FakeRequest("GET", "/employee/index"));
        Assertions.assertThat(Helpers.status(result)).isEqualTo(Http.Status.OK);
    }

    @Test
    public void testAll() {
        Result result = Helpers.route(new FakeRequest("GET", "/employees"));
        Assertions.assertThat(Helpers.status(result)).isEqualTo(Http.Status.OK);
    }

    @Test
    public void testShowFound() {
        Result result = Helpers.route(new FakeRequest("GET", "/employee/1"));
        Assertions.assertThat(Helpers.status(result)).isEqualTo(Http.Status.OK);
    }

    @Test
    public void testShowNotFound() {
        Result result = Helpers.route(new FakeRequest("GET", "/employee/100"));
        Assertions.assertThat(Helpers.status(result)).isEqualTo(Http.Status.NOT_FOUND);
    }
}
