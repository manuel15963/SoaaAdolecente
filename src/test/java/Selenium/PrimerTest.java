package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;


public class PrimerTest {

    private static WebDriver driver;

    public WebElement name;
    public WebElement father_surname;
    public WebElement mother_surname;
    public WebElement documentType;
    public WebElement document_number;
    public WebElement cellPhone;
    public WebElement address;
    public WebElement gender;
    public WebElement crimecommited;
    public WebElement attorney;
    public WebElement Guardar;
    public WebElement birthdate;
    public WebElement cajaText;


    public static void setUpDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\cupej\\Downloads\\Nueva carpeta (6)\\chromedriver-win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-minimized");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:4200/adolescente-form");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpClass(){
        setUpDriver();
    }

    @Test()
    public void PrimerTest() throws InterruptedException{
        name = driver.findElement(By.id("name"));
        name.click();
        Thread.sleep(1000);
        cajaText = driver.findElement(By.id("name"));
        cajaText.click();
        cajaText.sendKeys("Daniel");
        Thread.sleep(1000);

        father_surname = driver.findElement(By.id("father_surname"));
        father_surname.click();
        Thread.sleep(1000);
        cajaText = driver.findElement(By.id("father_surname"));
        cajaText.click();
        cajaText.sendKeys("Quispe");
        Thread.sleep(1000);

        mother_surname = driver.findElement(By.id("mother_surname"));
        mother_surname.click();
        Thread.sleep(1000);
        cajaText = driver.findElement(By.id("mother_surname"));
        cajaText.click();
        cajaText.sendKeys("Rojas");
        Thread.sleep(1000);

        documentType = driver.findElement(By.id("documentType"));
        documentType.click();
        Thread.sleep(1000);
        cajaText = driver.findElement(By.id("documentType"));
        cajaText.sendKeys("DNI");
        Thread.sleep(1000);

        document_number = driver.findElement(By.id("document_number"));
        document_number.click();
        Thread.sleep(1000);
        cajaText = driver.findElement(By.id("document_number"));
        cajaText.click();
        cajaText.sendKeys("73451232");
        Thread.sleep(1000);

        birthdate = driver.findElement(By.id("birthdate"));
        birthdate.click();
        Thread.sleep(1000);
        cajaText = driver.findElement(By.id("birthdate"));
        cajaText.sendKeys("22082003");
        Thread.sleep(1000);

        cellPhone = driver.findElement(By.id("cellPhone"));
        cellPhone.click();
        Thread.sleep(1000);
        cajaText = driver.findElement(By.id("cellPhone"));
        cajaText.click();
        cajaText.sendKeys("920834543");
        Thread.sleep(1000);

        address = driver.findElement(By.id("address"));
        address.click();
        Thread.sleep(1000);
        cajaText = driver.findElement(By.id("address"));
        cajaText.click();
        cajaText.sendKeys("San Vicente");
        Thread.sleep(1000);

        gender = driver.findElement(By.id("gender"));
        gender.click();
        Thread.sleep(1000);
        cajaText = driver.findElement(By.id("gender"));
        cajaText.sendKeys("Hombre");
        Thread.sleep(1000);

        crimecommited = driver.findElement(By.id("crimecommited"));
        crimecommited.click();
        Thread.sleep(1000);
        cajaText = driver.findElement(By.id("crimecommited"));
        cajaText.sendKeys("Robo");
        Thread.sleep(1000);

        attorney = driver.findElement(By.id("attorney"));
        attorney.click();
        Thread.sleep(1000);
        cajaText = driver.findElement(By.id("attorney"));
        cajaText.sendKeys("Juan Quispe Berrocal");
        Thread.sleep(1000);

        Guardar = driver.findElement(By.id("Guardar"));
        Guardar.click();
        Thread.sleep(1000);
    }
}
