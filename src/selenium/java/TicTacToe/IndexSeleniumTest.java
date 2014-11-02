package is.ru.TicTacToe;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.WebDriver;

public class IndexSeleniumTest{
	
	static WebDriver driver;
	static String baseUrl;
	static String port;


	@BeforeClass
	public static void before() {
    	// Will be run before all tests in class are run
    	driver = new FirefoxDriver();
   		baseUrl = "https://hogridertictactoe.herokuapp.com/";
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void after() {
    	// Will be run after all tests in class have run
    	driver.close();
	}

	@Test
	public void testTitle(){
		driver.get(baseUrl);
		assertEquals("TicTacToe - HogRiders", driver.getTitle());
	}

    @Test
    public void testClickOneTile(){
        WebDriverWait webWait = new WebDriverWait(driver,20);
        driver.get(baseUrl);
        driver.findElement(By.id("1")).click();
        webWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("1")),"X"));
        assertEquals("X", driver.findElement(By.id("1")).getText());
    }

    @Test
    public void testClickTwoTiles(){
        WebDriverWait webWait = new WebDriverWait(driver,20);
        driver.get(baseUrl);
        driver.findElement(By.id("1")).click();
        webWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("1")),"X"));
        driver.findElement(By.id("2")).click();        
        webWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("2")),"O"));
        assertEquals("O", driver.findElement(By.id("2")).getText());
    }
}
