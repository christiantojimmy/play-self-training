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
public class CompanyControllerTest extends BaseTest {

    @Test
    public void testIndex() {
        Result result = Helpers.route(new FakeRequest("GET", "/company/index"));
        Assertions.assertThat(Helpers.status(result)).isEqualTo(Http.Status.OK);
    }
}
