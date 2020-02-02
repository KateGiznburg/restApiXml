package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class bookDepository {

    public String authorNameWebSite;

    public String getAuthorName(WebDriver driver) {
        driver.get("https://www.bookdepository.com/author/1");
        authorNameWebSite = driver.findElement(By.xpath("//div[@class='tab search']//div[1]//div[2]//p[1]//span[1]//a[1]//span[1]")).getText();
        return authorNameWebSite;
    }

}
