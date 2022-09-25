import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak1 {

    /*
    Napraviti aplikaciju pomocu Selenium-a koji ce otvoriti sajt kupujemprodajem.com, izlistati
    sve kategorije (Stvari) sa leve strane i njihove linkove (kao spoken tekst “kategorija: link”),
    kliknuti iz te liste na Bicikli (bez hardkodovanja, posto imate listu, iskoristiti element iz nje
    da se klikne), kliknuti na Električni (mozete hardcodovati). Ostati na toj strani kao kraj zadatka.
    Uspavati program na 5 sekundi kako bi se video rezultat i posle toga browser zatvoriti.

    Obratiti paznju na "ad" koji kaze da se registrujete. Uzeti dugme x i kliknuti ga pre svega da ne bi ste
    imali problem da ne mozete da kliknete na kategoriju.
     Za 5+ nakon klika na kategoriju bicikli, treba izlistati sve kategorije koje pisu (Mountainbike, Gradski itd).
*/

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\bootcamp\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.kupujemprodajem.com/");
        driver.manage().window().maximize();

        // //*[@id="bodyTag"]/div[9]/div/div[2]
        WebElement closeRegForm = driver.findElement(By.xpath("//*[@id=\"bodyTag\"]/div[9]/div/div[2]"));
        closeRegForm.click();


        // //*[@id="tabs_new"]
        List<WebElement> stvari = driver.findElements(By.xpath("//*[@id='category-tree-content-goods']/a"));
        for (int i = 0; i < stvari.size(); i++) {
            System.out.println(stvari.get(i).getText() + ": " + stvari.get(i).getAttribute("href"));
        }
        //WebElement stvariMeni = driver.findElement(By.id("category-tree-tab-goods"));
        //stvariMeni.click();
        //bicikli.click();
        for (int i = 0; i < stvari.size(); i++) {
            WebElement bicikli = stvari.get(i);

            if (bicikli.getText().equals("Bicikli")) {
                bicikli.click();
                List<WebElement> bicikliLista = driver.findElements(By.className("categoryTitle"));
                for (int j = 0; j < bicikliLista.size(); j++) {
                    System.out.println(bicikliLista.get(i).getText());
                }
                WebElement elektricniBicikli = driver.findElement(By.xpath("//*[@id='groupBox1360']/div[1]/h2/a/span"));
                elektricniBicikli.click();

                Thread.sleep(5000);
                driver.quit();
            }
        }
    }
}