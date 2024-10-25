package com.siva;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\chrome-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		//Model-1
		driver.get("https://www.facebook.com/login/");
		String good = driver.getTitle();
		System.out.println(good);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		driver.quit();
		
		//Model-2 locators
		driver.navigate().to("https://www.facebook.com/login/");
		WebElement egg=driver.findElement(By.xpath("//input[@id='email']"));
		egg.sendKeys("kavyaamurtha98@gmailcom");
		
		String attribute=egg.getAttribute("egg");
		System.out.println(attribute);
		
		WebElement pass=driver.findElement(By.xpath("//input[@id='pass']"));
		pass.sendKeys("gl12345gl");
		
		WebElement logId=driver.findElement(By.xpath("//button[@id='loginbutton']"));
		logId.click();
		
	driver.navigate().back();
	driver.navigate().forward();
	driver.navigate().refresh();
	
		//Model-3  Mouse over action
		driver.get("https://www.greenstechnologys.com");
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement courses=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'COURSES')])[1]")));
		Actions cour=new Actions(driver);
		cour.moveToElement(courses).perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,775)");
		
		WebElement Oracle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Oracle Training')])")));
		Actions orac=new Actions(driver);
		orac.moveToElement(Oracle).perform();

		WebElement sql=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Oracle Training']//following::*[text()='SQL Certification']")));
        sql.click();
        driver.quit();
		
		//Model-4 Drag and drop
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		WebElement source=driver.findElement(By.xpath("//a[text()=' SALES ']"));
		WebElement dest=driver.findElement(By.xpath("(//ol[@id='loan']//child::li)[1]"));
		Actions bad=new Actions(driver);
		bad.dragAndDrop(source, dest).perform();
		
		//Model-5 Select class
		driver.get("https://www.facebook.com/");
		WebElement txtUserName=driver.findElement(By.xpath("//a[text()='Create new account']"));
		txtUserName.click();
		Thread.sleep(10);
		WebElement drop_Day=driver.findElement(By.id("day"));
		Select m=new Select(drop_Day);
		m.selectByIndex(4);
		//m.selectByValue("4");
		m.selectByVisibleText("4");
		
		//Model-6 Select class
		
		driver.get("https://output.jsbin.com/osebed/2");
		WebElement zero=driver.findElement(By.id("fruits"));
		Select one=new Select(zero);
		List<WebElement> options=one.getOptions();
		
		for(int i=0; i< options.size(); i++) {
		WebElement value=options.get(i);
		String text=value.getText();
		System.out.println(text);
			
		//}
		
	//Model-7 Alert
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		WebDriverWait waits=new WebDriverWait(driver,30);
		WebElement coursess=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
	    coursess.click();
	    Alert a=driver.switchTo().alert();
	    System.out.println(a.getText());
	    a.accept();
	    driver.findElement(By.id("login1")).sendKeys("venkat123");
	    
		//Model-8 Confirmations alert
		
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		
       Alert a1=driver.switchTo().alert();
       a1.dismiss();
       
		//Model-9 Prompt alert
		
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
		driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
		 Alert a1s=driver.switchTo().alert();
		 System.out.println(a1s.getText());
		 Thread.sleep(10);
		 a1s.sendKeys("Siva");
		 a1s.accept();
		
		//Model-10 Window Handling
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("chocolate", Keys.ENTER );
		driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();
		String prtwindow=driver.getWindowHandle();
		System.out.println(prtwindow);
		
		Set<String> allwindows=driver.getWindowHandles();
		System.out.println(allwindows);
		
		for(String string:allwindows) {
			if(!prtwindow.equals(string)) {
				driver.switchTo().window(string);
				
			}
			
			driver.findElement(By.xpath("(//input[@class='a-button-input'])[1]")).click();
			
			}
		
		
		//Model-11 Frame Handling
		
		
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
	    List<WebElement> framecount = driver.findElements(By.tagName("frameset"));
	    int size=framecount.size();
	    System.out.println(size);
	    driver.switchTo().frame(0);
	    driver.findElement(By.xpath("//*[text()='Customer ID/ User ID']//following::*[@class='form-control text-muted']" )).sendKeys("Hi JAVA");
	    
		
	
	}

	}
}
