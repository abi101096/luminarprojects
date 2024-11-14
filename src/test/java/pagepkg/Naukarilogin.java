package pagepkg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class Naukarilogin {
	WebDriver driver;
	
	 String parentwindow;
	By log =By.xpath("//*[@id=\"login_Layer\"]");
	By  mai =By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[2]/input");
	By pas = By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[3]/input");
	By cli = By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[6]/button");
	By jo =By.xpath("/html/body/div[3]/div[2]/nav/ul/li[1]/a/div");
	By recomjobs = By.xpath("/html/body/div[3]/div[2]/nav/ul/li[1]/div/ul/li[1]/a/div");
	By jobclick = By.xpath("//*[@id=\"root\"]/div[5]/div[1]/div[1]/div/div/article[1]/div[2]/div[1]/div[1]/p");
	By save =By.xpath("//*[@id=\"job_header\"]/div[2]/div[2]/button[1]");
	By profile =By.xpath("/html/body/main/div/div/div[3]/div/div[3]/div[2]/a");
	By resume = By.xpath("//*[@id=\"root\"]/div/div/span/div/div/div/div/div/div[2]/div[1]/div/div/ul/li[2]/a");
	By element = By.xpath("//*[@id=\"lazyPersonalDetail\"]/div/div/div/div[2]/div/div/div[1]/div[2]/a");
	By dob =By.xpath("//*[@id=\"lazyPersonalDetail\"]/div/div/div/div[1]/span[3]");
	By day =By.xpath("//*[@id=\"pd-dateFor\"]");
	By month =By.xpath("//*[@id=\"pd-monthFor\"]");
	By year =By.xpath("//*[@id=\"pd-yearFor\"]");
	
	By close =By.xpath("/html/body/div[6]/div[11]/div[1]/span");
	
public 	Naukarilogin(WebDriver driver) {
	this.driver=driver;
	this.parentwindow = driver.getWindowHandle();

}
public void clogin() {
	driver.findElement(log).click();
	
}
public void actuallogin(String email,String pass) {
	driver.findElement(mai).sendKeys(email);
	driver.findElement(pas).sendKeys(pass);
	driver.findElement(cli).click();
	
	
}
public void moveelement(){
	WebElement ele = driver.findElement(jo);
	Actions act = new Actions(driver);
	act.moveToElement(ele).perform();

}
public void Recomdjob() {
	driver.findElement(recomjobs).click();
	
	
}
public void window() {
	driver.findElement(jobclick).click();
	Set<String> allwindows = driver.getWindowHandles();
	for(String handle : allwindows) {
		
		if(!handle.equals(parentwindow)) {
			driver.switchTo().window(handle);
			driver.findElement(save).click();
			driver.switchTo().window(parentwindow);
			driver.navigate().back();
			
		}
	}
	}
public void resume() throws AWTException{
	driver.findElement(profile).click();
	driver.findElement(resume).click();
	fileupload ("C:\\Users\\91701\\Desktop\\sele\\imgtopdf_2609240120000.pdf");
	
}
  public void fileupload(String path) throws AWTException {
	  StringSelection st = new StringSelection(path);
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(st, null);
	  Robot rb = new Robot();
	  rb.delay(5000);
	  rb.keyPress(KeyEvent.VK_CONTROL);
	  rb.keyPress(KeyEvent.VK_V);
	  rb.keyRelease(KeyEvent.VK_V);
	  rb.keyRelease(KeyEvent.VK_CONTROL);
	  rb.keyPress(KeyEvent.VK_ENTER);
	  rb.keyRelease(KeyEvent.VK_ENTER);
  }
  public void shot() throws Exception {
	  File ss =	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileHandler.copy(ss,new File("C:\\Users\\91701\\Desktop\\sele//image10.png"));
	    
  }
  public void scrollMultipleTimes(int pixels, int times) throws Exception {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    for (int i = 0; i < times; i++) {
	        js.executeScript("window.scrollBy(0," + pixels + ")");
	        Thread.sleep(500); 
	    }
	}
   public void dateof(String i,String mon1,String j) {
	   driver.findElement(dob).click();
	   
	   driver.findElement(day).sendKeys(i,Keys.ENTER);
	   driver.findElement(month).sendKeys(mon1,Keys.ENTER);
	   driver.findElement(year).sendKeys(j,Keys.ENTER);
	   driver.findElement(close).click();
	   driver.navigate().back();
   }
  
  public void titleverification()  {
	 
	String actualtitle = driver.getTitle();
	String exptitle = "Profile | Mynaukri";
	Assert.assertEquals(actualtitle, exptitle);
	System.out.println("title verified");
	  
  }

   

	
}