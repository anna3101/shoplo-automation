package testBase;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FunctionalTest {
	   protected static WebDriver driver;

	    @BeforeClass
	    public static void setUp(){
	    	System.setProperty("webdriver.chrome.driver", "D:/Automation/Selenium/chromedriver.exe");
	        driver = new ChromeDriver();
	        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	        Dimension dimension = new Dimension(device.getDisplayMode().getWidth(), device.getDisplayMode().getHeight());
	        driver.manage().window().setSize(dimension);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }

	    @After
	    public void cleanUp(){
	        driver.manage().deleteAllCookies();
	    }

	    @AfterClass
	    public static void tearDown(){
	        driver.close();
	    }   
}
