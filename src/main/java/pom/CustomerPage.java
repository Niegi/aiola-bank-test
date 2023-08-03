package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage {
  private final WebDriver driver;
  private final By userList = By.id("userSelect");
  private final By loginButton = By.cssSelector("button[type='submit']");

  public CustomerPage(WebDriver driver) {
    this.driver = driver;
  }

  public void selectUser(String userName) {
//    WebElement ddl = driver.findElement(userList);
    Select users = new Select(driver.findElement(userList));
    users.selectByVisibleText(userName);
  }

  public UserPage loginSelectedUser() {
    driver.findElement(loginButton).click();
    return new UserPage(driver);
  }
}
