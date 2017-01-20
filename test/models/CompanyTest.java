package models;

import base.BaseTest;
import org.fest.assertions.Assertions;
import org.junit.Test;

/**
 * Created by christiantojimmy on 1/18/17.
 */
public class CompanyTest extends BaseTest {

    @Test
    public void testCreateCompany() {
        Company company = Company.createCompany("RCTI");

        Assertions.assertThat(company).isInstanceOf(Company.class);
        Assertions.assertThat(company.name).isEqualTo("RCTI");
        Assertions.assertThat(company.employees).isNotEmpty();
    }
}
