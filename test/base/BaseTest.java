package base;

import com.avaje.ebean.Ebean;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import play.test.FakeApplication;
import play.test.Helpers;
import seed.Seed;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by christiantojimmy on 1/18/17.
 */
public class BaseTest {

    public static FakeApplication app;
    public static String createDdl = "";
    public static String dropDdl = "";

    @BeforeClass
    public static void startApp() {
        Map<String, String> configuration = new HashMap<String, String>();
//		configuration.put("db.default.driver", "org.postgresql.Driver");
//		configuration.put("db.default.url", "jdbc:postgresql://localhost:5432/kudos-backend-test");
//		configuration.put("db.default.user", "testuser");
//		configuration.put("db.default.password", "");

        configuration.put("db.default.driver", "org.h2.Driver");
        configuration.put("db.default.url", "jdbc:h2:mem:play");
        configuration.put("db.default.logStatements", "false");
        configuration.put("ebean.default", "models.*");

        app = Helpers.fakeApplication(configuration);
        Helpers.start(app);

        // Reading the evolution file
        try {
            String evolutionContent = evolutionContent = FileUtils.readFileToString(app.getWrappedApplication().getFile("conf/evolutions/default/1.sql"));

            // Splitting the String to get Create & Drop DDL
            String[] splittedEvolutionContent = evolutionContent.split("# --- !Ups");
            String[] upsDowns = splittedEvolutionContent[1].split("# --- !Downs");
            createDdl = upsDowns[0];
            dropDdl = upsDowns[1];
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void stopApp() {
        Ebean.execute(Ebean.createCallableSql(dropDdl));
        Helpers.stop(app);
    }

    @Before
    public void prepareDb() {
        Ebean.execute(Ebean.createCallableSql(dropDdl));
        Ebean.execute(Ebean.createCallableSql(createDdl));

//        Ebean.execute(Ebean.createCallableSql("ALTER TABLE company ALTER COLUMN id RESTART WITH 1"));
//        Ebean.execute(Ebean.createCallableSql("ALTER TABLE employee ALTER COLUMN id RESTART WITH 1"));

        Seed.seedCompany();
    }
}
