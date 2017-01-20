package seed;

import models.Company;

/**
 * Created by christiantojimmy on 1/18/17.
 */
public class Seed {

    public static void seedCompany() {
        if(Company.find.findRowCount() == 0) {
            Company.createCompany("Appschef");
            Company.createCompany("WGS");
            Company.createCompany("Empveep");
        }
    }
}
