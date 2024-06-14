package dataproviders;

import org.testng.annotations.DataProvider;

public class ScreenResolutionProvider {
    @DataProvider (name = "resolution")
    private static Object[][] resolutionMethod() {
        return new Object[][]{{"max"},
                {"1024 x 768"}, {"800 x 600"}
        };
    }
}
