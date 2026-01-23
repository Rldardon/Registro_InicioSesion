package stepdefinition;

import io.cucumber.java.Before;
import runners.BannerHelper;

public class GlobalHooks {

    @Before(order = Integer.MIN_VALUE) // Se ejecuta primero de todo
    public void beforeAllScenarios() {
        BannerHelper.displayBanner();
    }
}
