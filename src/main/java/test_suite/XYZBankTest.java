package test_suite;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class XYZBankTest {

  private static final String URL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
  private static final String USERNAME = "Harry Potter";
  private static final int DEPOSIT_AMOUNT = 200;
  private static final int WITHDRAW_AMOUNT = 100;
  private WebDriver driver;
  private LoginPage loginPage;

  @BeforeAll
  void setup() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get(URL);
    loginPage = new LoginPage(driver);
  }

  @Test
  void customerTransactionsTest() throws InterruptedException {
    CustomerPage customerPage = loginPage.navigateToCustomerPage();
    customerPage.selectUser(USERNAME);
    UserPage userPage = customerPage.loginSelectedUser();
    TransactionsPage transactionsPage = userPage.navigateToTransactions();
    List<WebElement> transactions = transactionsPage.getAllTransactions();
    assertTrue(transactions.isEmpty());
    transactionsPage.returnToUserPage();
    DepositPage depositPage = userPage.navigateToDeposit();
    depositPage.depositMoney(DEPOSIT_AMOUNT);
    Thread.sleep(1000);
    WithdrawPage withdrawPage = userPage.navigateToWithdraw();
    withdrawPage.withdrawMoney(WITHDRAW_AMOUNT);
    Thread.sleep(1000);
    userPage.navigateToTransactions();
    transactions = transactionsPage.getAllTransactions();
    int expectedNumberOfTransactions = 2;
    int actualNumberOfTransactions = transactions.size();
    assertEquals(expectedNumberOfTransactions, actualNumberOfTransactions);
  }

  @AfterAll
  void cleanup() {
    driver.quit();
  }
}
