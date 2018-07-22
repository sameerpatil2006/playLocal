import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class PlayLocalTest {

    public static void main(String args []) throws Exception {

        WebDriver driver;
        /*DesiredCapabilities cap = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
        */
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sameer\\IdeaProjects\\playLocal\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.playlocal.com/");

        DateFormat dateFormat = new SimpleDateFormat("dd");

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 14);
        String formattedDate = dateFormat.format(c.getTime());
        String finalDate = formattedDate.replaceFirst("^0+(?!$)", "");
        System.out.println(dateFormat.format(c.getTime()));

        WebElement signOn = driver.findElement(By.linkText("Sign in"));
        signOn.click();

        WebElement user =  driver.findElement(By.id("session_email"));
        user.click();
        user.sendKeys("anything4tennis@gmail.com");

        WebElement password = driver.findElement(By.id("session_password"));
        password.click();
        password.sendKeys("tennis@123");

        WebElement login = driver.findElement(By.name("commit"));
        login.click();

        WebElement date = driver.findElement(By.id("search_friendly_date"));
        date.click();

        WebElement nextMonth = driver.findElement(By.className("ui-datepicker-next") );
        if( nextMonth.isDisplayed() ){
            nextMonth.click();
        }
        WebElement datePicker = driver.findElement(By.linkText(String.valueOf(finalDate)));
        datePicker.click();

        WebElement findCourts = driver.findElement(By.xpath("/html/body/div[1]/section/section[1]/article/div/div[1]/div[2]/form/input[4]"));
        findCourts.click();

        WebElement selectTime = driver.findElement(By.xpath("/html/body/div[1]/section[2]/ul/li[1]/ul/li[4]"));
        selectTime.click();

        WebElement reserve = driver.findElement(By.linkText("Reserve"));
        reserve.click();

        /*WebElement courtNo = driver.findElement(By.xpath("//*[@id=\"new_reservation\"]/section/section[1]/span/h4/span[1]/text()"));
        System.out.println(courtNo.getText());
*/
        WebElement acceptTerms = driver.findElement(By.id("reservation_accepted_terms_of_service"));
        acceptTerms.click();

        WebElement confirm = driver.findElement(By.xpath("//*[@id=\"new_reservation\"]/section/article/span[2]/input"));
        confirm.click();

        WebElement skip = driver.findElement(By.linkText("skip this step"));
        skip.click();

        driver.close();
    }

}
