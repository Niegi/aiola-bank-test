package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositPage {
  private final WebDriver driver;
  private final By depositTextField = By.cssSelector("input[placeholder='amount']");
  private final By depositButton = By.cssSelector("button[type='submit']");

  public DepositPage(WebDriver driver) {
    this.driver = driver;
  }

  public void depositMoney(int amount) {
    driver
      .findElement(depositTextField)
      .sendKeys(String.valueOf(amount));
    driver.findElement(depositButton).click();
  }
}
