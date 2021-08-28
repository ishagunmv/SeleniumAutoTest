package common;

public class Config {
    /**
     * Specify the browser to test:
     * chrome, firefox - windows and linux
     **/
    public static String BROWSER = "chrome";
    /**
     * Whether to clean the browser's cookies after each iteration
     */
    public static boolean CLEAR_COOKIES = false;
    /**
     * Clean the directory with the screen before starting the build
     */
    public static boolean CLEAR_REPORTS_DIR = true;
    /**
     * Whether to keep the browser open after the tests
     */
    public static final boolean HOLD_BROWSER_OPEN = false;
}