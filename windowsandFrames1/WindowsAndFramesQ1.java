package windowsandFrames1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsAndFramesQ1 {

	public static void main(String[] args) throws Exception {
		//Initialize EdgeDriver
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		//  Open a given URL
        driver.get("https://the-internet.herokuapp.com/iframe");
        
        // Switch to the iframe using the iframe's id or name attribute
        driver.switchTo().frame("mce_0_ifr"); 

        // Step 3: Locate the "p" tag inside the iframe
        WebElement pTag = driver.findElement(By.tagName("p"));

        // Step 4: Write the text "Hello People" to the "p" tag
        pTag.clear(); // Clear any existing text
        pTag.sendKeys("Hello People");
        Thread.sleep(1000);
        

        // Step 5: Switch back to the main page (outside of the iframe)
        driver.switchTo().defaultContent();

        // Step 6: Close the browser instance
        driver.quit();
    }

		

	}


