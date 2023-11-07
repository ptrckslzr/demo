package com.example;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.time.Duration;

//Class
public class DefaultSuiteTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();

  }
  @After
  public void tearDown() {
    driver.quit();
  }

  @Test

  
  //TestCase 1
  public void testCase1() {
    //Open Website 
    driver.get("https://jupiter.cloud.planittesting.com/");
    driver.manage().window().setSize(new Dimension(957, 668));

    //Navigate to Contact
    driver.findElement(By.cssSelector(".btn-navbar")).click();
    driver.findElement(By.linkText("Contact")).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    //Check Alert
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert")));
    assertThat(driver.findElement(By.cssSelector(".alert")).getText(), is("We welcome your feedback - tell it how it is."));

    //Click Submit
    driver.findElement(By.linkText("Submit")).click();
    //driver.findElement(By.cssSelector(".container-fluid:nth-child(2)")).click();

    //Validate forename
    driver.findElement(By.id("forename-err")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("forename-err")));
    assertThat(driver.findElement(By.id("forename-err")).getText(), is("Forename is required"));

    //Validate email
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email-err")));
    driver.findElement(By.id("email-err")).click();
    assertThat(driver.findElement(By.id("email-err")).getText(), is("Email is required"));

    //Validate message-err
    driver.findElement(By.id("message-err")).click();
    assertThat(driver.findElement(By.id("message-err")).getText(), is("Message is required"));

    //Input data
    driver.findElement(By.id("forename")).click();
    driver.findElement(By.id("forename")).sendKeys("test");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("test@yahoo.com");
    driver.findElement(By.id("message")).click();
    driver.findElement(By.id("message")).sendKeys("test");

    //Submit
    driver.findElement(By.linkText("Submit")).click();
    driver.findElement(By.cssSelector("h1")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert")));

    //Back and check Elements
    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("« Back")));
    driver.findElement(By.linkText("« Back")).click();

    //Verify Errors are Gone
    { 
      List<WebElement> elements = driver.findElements(By.id("forenamew-err"));
      assert(elements.size() == 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.id("email-err"));
      assert(elements.size() == 0);
    }
        {
      List<WebElement> elements = driver.findElements(By.id("message-err"));
      assert(elements.size() == 0);
    }
    
  }

  //Test Case 2
  @Test
  public void testCase2() {
    //Open Website 
    driver.get("https://jupiter.cloud.planittesting.com/");
    driver.manage().window().setSize(new Dimension(957, 668));

    //Navigate to Contact
    driver.findElement(By.cssSelector(".btn-navbar")).click();
    driver.findElement(By.linkText("Contact")).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    //Check Alert
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert")));
    assertThat(driver.findElement(By.cssSelector(".alert")).getText(), is("We welcome your feedback - tell it how it is."));

    //Input data
    driver.findElement(By.id("forename")).click();
    driver.findElement(By.id("forename")).sendKeys("test");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("test@yahoo.com");
    driver.findElement(By.id("message")).click();
    driver.findElement(By.id("message")).sendKeys("test");

    //Submit
    driver.findElement(By.linkText("Submit")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
    driver.findElement(By.cssSelector("h1")).click();
    
    //Back
    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("« Back")));
    driver.findElement(By.cssSelector(".alert")).click();
    assertThat(driver.findElement(By.cssSelector(".alert")).getText(), is("Thanks test, we appreciate your feedback."));
  }


    //Test Case 3
  @Test
  public void testCase3() {
    //Open Website 
    driver.get("https://jupiter.cloud.planittesting.com/");
    driver.manage().window().setSize(new Dimension(957, 668));

    //Navigate to Start Shopping
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Start Shopping »")));
    driver.findElement(By.linkText("Start Shopping »")).click();
    
    //Select Products
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#product-2 .btn")));
    driver.findElement(By.cssSelector("#product-2 .btn")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#product-2 .btn")));
    driver.findElement(By.cssSelector("#product-2 .btn")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#product-4 .btn")));
    driver.findElement(By.cssSelector("#product-4 .btn")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#product-4 .btn")));
    driver.findElement(By.cssSelector("#product-4 .btn")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#product-4 .btn")));
    driver.findElement(By.cssSelector("#product-4 .btn")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#product-4 .btn")));
    driver.findElement(By.cssSelector("#product-4 .btn")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#product-4 .btn")));
    driver.findElement(By.cssSelector("#product-4 .btn")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#product-7 .btn")));
    driver.findElement(By.cssSelector("#product-7 .btn")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#product-7 .btn")));
    driver.findElement(By.cssSelector("#product-7 .btn")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#product-7 .btn")));
    driver.findElement(By.cssSelector("#product-7 .btn")).click();

    //Navigate to Cart
    driver.findElement(By.cssSelector(".btn-navbar")).click();
    driver.findElement(By.linkText("Cart (10)")).click();

    //Validate values
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cart-item:nth-child(3) > .ng-binding:nth-child(4)")));
    assertThat(driver.findElement(By.cssSelector(".cart-item:nth-child(3) > .ng-binding:nth-child(4)")).getText(), is("$44.97"));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cart-item:nth-child(3) > .ng-binding:nth-child(2)")));
    assertThat(driver.findElement(By.cssSelector(".cart-item:nth-child(3) > .ng-binding:nth-child(2)")).getText(), is("$14.99"));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cart-item:nth-child(1) > .ng-binding:nth-child(2)")));
    assertThat(driver.findElement(By.cssSelector(".cart-item:nth-child(1) > .ng-binding:nth-child(2)")).getText(), is("$10.99"));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cart-item:nth-child(1) > .ng-binding:nth-child(4)")));
    assertThat(driver.findElement(By.cssSelector(".cart-item:nth-child(1) > .ng-binding:nth-child(4)")).getText(), is("$21.98"));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cart-item:nth-child(2) > .ng-binding:nth-child(2)")));
    assertThat(driver.findElement(By.cssSelector(".cart-item:nth-child(2) > .ng-binding:nth-child(2)")).getText(), is("$9.99"));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cart-item:nth-child(2) > .ng-binding:nth-child(4)")));
    assertThat(driver.findElement(By.cssSelector(".cart-item:nth-child(2) > .ng-binding:nth-child(4)")).getText(), is("$49.95"));
    assertThat(driver.findElement(By.cssSelector(".total")).getText(), is("Total: 116.9"));
  }
}
