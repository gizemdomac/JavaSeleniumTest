package WebOtomasyonUygulamasi.Otomasyon;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.Console;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;


public class App 
{
	public static void main(String[] arg) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver_win32_new/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.n11.com"); //Siteye yönlendirme yapildi.
		
		WebElement link = null;
		link=driver.findElement(By.className("btnSignIn")); //Giriş yap butonu
		link.click();
		Thread.sleep(5000);
		
		WebElement username;
		username=driver.findElement(By.id("email"));
		username.sendKeys("");//Buraya e mail yazılacak
		
		WebElement userpass;
		userpass=driver.findElement(By.id("password"));
		userpass.sendKeys("");//Buraya şifre yazılacak
		
		WebElement link2 = null;
		link2=driver.findElement(By.id("loginButton")); //login işlemi yapıldı
		link2.click();
		Thread.sleep(5000);
		
		WebElement searchBox;
		searchBox=driver.findElement(By.id("searchData"));
		searchBox.sendKeys("Bilgisayar"); //bilgisayar kelimesi arama butonuna girildi
		Thread.sleep(5000);
		
		WebElement link3 = null;
		link3=driver.findElement(By.className("seg-popup-close")); //reklam kapatıldı
		link3.click();
		Thread.sleep(5000);
		
		WebElement link4=null;
		link4=driver.findElement(By.className("searchBtn")); //arama butonuna tıklanıldı
		link4.click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//a[contains(.,'2')]")).click();
		driver.get("https://www.n11.com/arama?q=Bilgisayar&pg=2"); //ikinci sayfaya yönlendirildi
		
		WebElement product=null;
		product=driver.findElement(By.xpath("//a[@data-id='381305630']"));//rasgele seçilen ürün 
		product.click();
		Thread.sleep(5000);
		
		WebElement basketadd=null;
		basketadd=driver.findElement(By.xpath("//a[@class='btn btnGrey btnAddBasket']"));//ürün sepete eklendi
		basketadd.click();
		Thread.sleep(5000);
		
		String value= driver.findElement(By.xpath("//*[@id=\"contentProDetail\"]/div/div[3]/div[2]/div[3]/div[2]/div/div[1]/div/ins")).getText();
		System.out.println(value);//ürünün değeri tutuldu
		
		WebElement gobasket=null;
		gobasket=driver.findElement(By.xpath("//a[@class='btn btnBlack btnGoBasket']"));//sepete gidildi
		//gobasket=driver.findElement(By.xpath("//a[@class='myBasket']"));
		gobasket.click();
		Thread.sleep(5000);
		
		String basketvalue= driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[1]/section[2]/table[2]/tbody/tr/td[3]/div[2]/div/span")).getText();
		System.out.println(basketvalue);//sepetteki ürünün değeri tutuldu	
		if (value==basketvalue) //ürünler karsılastırıldı
		{
		  
		  System.out.println("Doğru");
		}
		else
		{
			System.out.println("Yanlış");
		}
		
		WebElement Up=null;
		Up=driver.findElement(By.xpath("//div[@class='spinnerFieldContainer']/span[@class='spinnerUp spinnerArrow']"));//ürün adedi artırıldı
		Up.click();
		Thread.sleep(5000);
		
		WebElement Trash=null;
		Trash=driver.findElement(By.xpath("//div[@class='prodAction']/span[@class='removeProd svgIcon svgIcon_trash']"));//ürünler sepetten silindi
		Trash.click();
		Thread.sleep(5000);
		
		
		driver.quit();
	}
      
}
