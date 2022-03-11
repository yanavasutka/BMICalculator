import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CategoriesTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void bmiShouldBeLessThan15() {

        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("38.3");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Starvation");
    }

    @Test
    public void bmiShouldBe15() {

        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("38.5");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Underweight");
    }

    @Test
    public void bmiShouldBeMoreThan15() {

        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("38.6");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Underweight");
    }

    @Test
    public void bmiShouldBe18andAHalf() {

        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("47.37");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Underweight");
    }

    @Test
    public void bmiShouldBeMoreThan18andAHalf() {

        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("48");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Normal");
    }

    @Test
    public void bmiShouldBe25() {

        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("64");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Normal");
    }

    @Test
    public void bmiShouldBeMoreThan25() {

        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("64.1");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Overweight");
    }

    @Test
    public void bmiShouldBe30() {

        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("76.8");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Overweight");
    }

    @Test
    public void bmiShouldBeMoreThan30() {

        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("76.9");
        driver.findElement(By.name("ht")).sendKeys("160");
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Obese");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}



