package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;


public class Base {
	
	// we have open a class which will create browser object for all other class/test cases
	
		public static WebDriver driver;
		public Properties prop;
		
		public WebDriver initializeDriver () throws IOException {
		prop = new Properties();// this file will read from the fileinputstream class connections
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties"); 
		
		prop.load(fis);// we passed the file to properties for reading
		
		String browserName=prop.getProperty("browser");//from the file it will look for the value of browser
		
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chorme.driver", "C:\\Users\\Taufik\\Documents\\Selenium-RahulShetty\\API\\2.Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Taufik\\Documents\\Selenium-RahulShetty\\API\\3.Firefoxdriver\\geckodriver.exe");
			driver = new  FirefoxDriver();			
		} else if (browserName.equalsIgnoreCase("ie")) {
			
			 System.setProperty("webdriver.ie.driver", "C:\\Users\\Taufik\\Documents\\Selenium-RahulShetty\\API\\4.InternetExplorere\\IEDriverServer.exe");

			 driver = new  InternetExplorerDriver();
				
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
			
		
		return driver;
	}

		
		
}
