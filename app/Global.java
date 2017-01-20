import play.Application;
import play.GlobalSettings;
import seed.Seed;

/**
 * Created by christiantojimmy on 1/18/17.
 */
public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        super.onStart(app);

        Seed.seedCompany();
    }
}
