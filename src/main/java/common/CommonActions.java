package common;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static common.Config.BROWSER;
import static constants.Constants.TimeoutVariables.IMPLICIT_WAIT;

public class CommonActions {

    public WebDriver driver;
    public static CommonActions instance = null;

    /**
     *Select and install the driver according to the selected version in the config
     */
    public CommonActions() {
        switch (BROWSER) {
            case "chrome" :
                if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                } else {
                    driver = new ChromeDriver();
                    break;
                }
            case "firefox" :
                if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                } else {
                    driver = new FirefoxDriver();
                    break;
                }
            default:
                Assertions.fail("INCORRECT BROWSER NAME " + BROWSER);
                Assertions.fail("Такого браузера у нас нет -> " + BROWSER + ". Выбери другой");
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * static method to create instance of Singleton class
     */
    public static CommonActions getInstance() {
        if (instance == null)
            instance = new CommonActions();
        return instance;
    }
}