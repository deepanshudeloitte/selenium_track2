package seleniumPackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;



public class class1 extends base{
    @Test
    public int try1() throws NoSuchElementException, InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepanshusingh8\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://weathershopper.pythonanywhere.com/");
        Thread.sleep(3000);

        WebElement Temperature = driver.findElement(By.xpath("//*[@id='temperature']"));
        String s=Temperature.getText();
        s = s.replaceAll("[^\\d.]", "");
        int temperatureInInt =Integer.parseInt(s);

        // taking screenshot of temperature
        File SrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile,new File(".//screenshot/temperature.png")); // taking screen shot of temperature
        return temperatureInInt;
    }

}
