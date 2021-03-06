import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webdriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
  	  return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
  	  goTo("http://localhost4567/");
  	  assertThat(pageSource()).contains("Leap year detector");

  }

  @Test
  public void isALeapYear() {
    goTo("http://localhost4567");
    fill("#year").with("2004");
    submit(".btn");
    assertThat(pageSource()).contains("2004 is a leap year!");
  }

  @Test
    public void isNotALeapYear() {
      goTo("http://localhost4567");
      fill("#year").with("2003");
      submit("#submit-button");
      assertThat(pageSource()).contains("2003 is not a leap year!");
    }
}