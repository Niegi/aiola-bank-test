package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WithdrawPage {
  private final WebDriver driver;
  private final By withdrawTextField = By.cssSelector("input[placeholder='amount']");
  private final By withdrawButton = By.cssSelector("button[type='submit']");

  public WithdrawPage(WebDriver driver) {
    this.driver = driver;
  }

  public void withdrawMoney(int amount) {
    driver
      .findElement(withdrawTextField)
      .sendKeys(String.valueOf(amount));
    driver.findElement(withdrawButton).click();
  }
}
