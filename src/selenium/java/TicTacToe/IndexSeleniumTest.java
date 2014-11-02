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
   		baseUrl = "https://hogriderstictactoestaging.herokuapp.com/";
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void after() {
    	// Will be run after all tests in class have run
    	driver.close();
	}

	@Test
	public void testTitle(){
        driver = new FirefoxDriver();
		driver.get(baseUrl);
		assertEquals("TicTacToe - HogRiders", driver.getTitle());
        driver.close();
	}

    @Test
    public void testWrong(){
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        assertEquals("Rassi prump", driver.getTitle());
        driver.close();
    }

    @Test
    public void testClickOneTile(){
        driver = new FirefoxDriver();
        WebDriverWait webWait = new WebDriverWait(driver,20);
        driver.get(baseUrl);
        driver.findElement(By.id("1")).click();
        webWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("1")),"X"));
        assertEquals("X", driver.findElement(By.id("1")).getText());
        driver.close();
    }

    @Test
    public void testClickTwoTiles(){
        driver = new FirefoxDriver();
        WebDriverWait webWait = new WebDriverWait(driver,20);
        driver.get(baseUrl);
        driver.findElement(By.id("1")).click();
        webWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("1")),"X"));
        driver.findElement(By.id("2")).click();        
        webWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("2")),"O"));
        assertEquals("O", driver.findElement(By.id("2")).getText());
        driver.close();
    }

    @Test
    public void testPlayerOneWinner(){
        driver = new FirefoxDriver();
        WebDriverWait webWait = new WebDriverWait(driver,20);
        driver.get(baseUrl);
        driver.findElement(By.id("1")).click();
        webWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("1")),"X"));
        driver.findElement(By.id("2")).click();        
        webWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("2")),"O"));
        driver.findElement(By.id("4")).click();        
        webWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("4")),"X"));
        driver.findElement(By.id("5")).click();        
        webWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("5")),"O"));
        driver.findElement(By.id("7")).click();        
        webWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("7")),"X"));
        webWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("displayWinner")),"player1 wins"));
        assertEquals("player1 wins", driver.findElement(By.id("displayWinner")).getText());
        driver.close();
    }
}
