package seleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class class2 {
    int temperatureInInt ;
    String g;
    int price;
    HashMap<Integer,String> map = new HashMap();
    @Test
    public void try2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepanshusingh8\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://weathershopper.pythonanywhere.com/moisturizer");
        Thread.sleep(3000);
        WebElement moisturizerButton = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        moisturizerButton.click();
        int t=1;
        int p=2;
        while(t<=3 && p<=3 ) {
            String s = "*//div[1]/div["+ p +"]/div[" + t + "]/p[2]";
            List<WebElement> priceElements = driver.findElements(By.xpath(s));

            int j ,i;
            for (i = 0; i < priceElements.size() ; i++) {
                String n=priceElements.get(i).getText().replaceAll("[^\\d]", "");
                price = Integer.parseInt(n);
                map.put(price,"hello");
            }
            if(t==3){
                p++;
                t=0;
            }
            t++;

        }
        List<WebElement> nameElements = driver.findElements(By.xpath("//*[@class='font-weight-bold top-space-10']"));
        for(int j = 0;j<nameElements.size();j++){
            String s =nameElements.get(j).getText();
            map.replace( price,s );
        }
        for(Map.Entry m :map.entrySet()) {
            System.out.println(m.getKey()+ " "+m.getValue());
        }
    }
}
