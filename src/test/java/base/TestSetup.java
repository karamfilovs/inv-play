package base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.App;
import pages.Defaults;

import java.nio.file.Paths;
import java.time.LocalDateTime;

public class TestSetup {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestSetup.class);
    protected App app;
    private static Browser browser;
    private BrowserContext context;
    private Page page;
    private static boolean isBrowserStarted = false;
    private static boolean headless = Boolean.valueOf(System.getProperty("headless"));
    private static String browserType = System.getProperty("browser");

    @BeforeAll
    public static void beforeAll() {
        while (!isBrowserStarted) {
            switch (browserType.toLowerCase()) {
                case "chrome":
                    setupChrome();
                    break;
                case "firefox":
                    setupFirefox();
                    break;
                default:
                    new Exception("Not supported browser");
                    break;
            }
            isBrowserStarted = true; //Starting it once before all tests(little hack)
        }

    }

    public static void setupChrome() {
        LOGGER.info("Starting Chrome browser before all tests");
        browser = Playwright.create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().setTimeout(10000).setHeadless(headless));
    }

    public static void setupFirefox() {
        LOGGER.info("Starting Firefox browser");
        browser = Playwright.create()
                .firefox()
                .launch(new BrowserType.LaunchOptions().setTimeout(10000).setHeadless(headless));
    }


    @AfterAll
    public static void afterAll() {
        // browser.close(); //May be not needed since the process is killed anyway
    }


    @BeforeEach
    public void setUp(TestInfo info) {
        LOGGER.info("STARTING TEST:" + info.getDisplayName().toUpperCase());
        context = browser.newContext();
        page = context.newPage();
        page.navigate(Defaults.BASE_URL);
        app = new App(page);

    }

    @AfterEach
    public void tearDown(TestInfo info) {
        takeScreenshot(info.getDisplayName());
        context.close();
    }

    public void takeScreenshot(String testName) {
        String name = testName.replace(" ", "_");
        String time = LocalDateTime.now().toString().replace(":", "_");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/screenshots/" + name + "_" + time + ".png")));
    }
}
