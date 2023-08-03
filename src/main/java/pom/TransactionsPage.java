package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TransactionsPage {
  private final WebDriver driver;
  private final By back = By.cssSelector("button[ng-click='back()']");
  private final By transactionsTable = By.xpath("//table/tbody/tr");

  public TransactionsPage(WebDriver driver) {
    this.driver = driver;
  }

  public List<WebElement> getAllTransactions() {
    return driver.findElements(transactionsTable);
  }

  public UserPage returnToUserPage() {
    driver.findElement(back).click();
    return new UserPage(driver);
  }
}
