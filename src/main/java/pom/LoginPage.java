package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
  private final WebDriver driver;

  private final By customerLogin = By.cssSelector("button[ng-click='customer()']");
  private final By managerLogin = By.cssSelector("button[ng-click='manager()']");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public CustomerPage navigateToCustomerPage() {
    driver.findElement(customerLogin).click();
    return new CustomerPage(driver);
  }

//  breaking the YAGNI rule, just to show the possible extension of the test
  public ManagerPage navigateToManagerPage() {
    driver.findElement(managerLogin).click();
    return new ManagerPage(driver);
  }
}
