package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
  private final WebDriver driver;
  private final By transactions = By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass1']");
  private final By deposit = By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass2']");
  private final By withdraw = By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass3']");

  public UserPage(WebDriver driver) {
    this.driver = driver;
  }

  public TransactionsPage navigateToTransactions() {
    driver.findElement(transactions).click();
    return new TransactionsPage(driver);
  }

  public DepositPage navigateToDeposit() {
    driver.findElement(deposit).click();
    return new DepositPage(driver);
  }

  public WithdrawPage navigateToWithdraw() {
    driver.findElement(withdraw).click();
    return new WithdrawPage(driver);
  }
}
