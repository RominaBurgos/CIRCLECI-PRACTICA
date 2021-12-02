package com.fca.calidad.katalon;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Test2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  
@Test
   public void testUadyPass() throws Exception {
   driver.get("https://es.uadyvirtual.uady.mx/login/index.php");
   driver.findElement(By.id("username")).click();
   driver.findElement(By.id("username")).click();
   driver.findElement(By.id("username")).clear();
   driver.findElement(By.id("username")).sendKeys("A15001281");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
   driver.findElement(By.id("password")).sendKeys("CLARINET33años");
    driver.findElement(By.id("login")).submit();
    
    pause(10000);
    
    String textoEjecucion= driver.findElement(By.xpath("/html/body/div[2]/footer/div/div[2]/div[1]/div[2]/a[1]")).getText();
    String textoEsperado="ROMINA ASAHELI BURGOS CHALE";
    assertThat(textoEsperado,is(textoEjecucion));
  }


  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  private void pause(long mils) {
	  try {
		  Thread.sleep(mils);
	  }catch(Exception e){
		  e.printStackTrace();
	  }
  }

}
