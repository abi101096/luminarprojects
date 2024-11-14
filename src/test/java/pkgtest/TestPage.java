package pkgtest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagepkg.Naukarilogin;

public class TestPage {
WebDriver driver;
 @BeforeTest
 public void setup() {
	 driver =new ChromeDriver();
 }
 @BeforeMethod
 public void login() {
	 driver.get("https://www.naukri.com/");
	 
 }
 @Test
 public void test1() throws Exception {
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	 Naukarilogin ob= new Naukarilogin(driver);
	 driver.manage().window().maximize();
	 ob.clogin();
	 ob.actuallogin("dummymail9610@gmail.com", "Abcde@12");
	 ob.moveelement();
	 ob.Recomdjob();
	 ob.window();
	 ob.resume();
	 ob.shot();
	 ob.scrollMultipleTimes(500, 4);
	 ob.dateof("10", "may", "1996");
	 ob.titleverification();
	// ob.savee();
 }
 
}
