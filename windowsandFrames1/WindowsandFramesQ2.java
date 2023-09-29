package windowsandFrames1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsandFramesQ2 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		//Open a new instance of the Chrome browser
        driver.get("https://the-internet.herokuapp.com/windows");
        
       // Click the "Click Here" button to open a new window
        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();
        
       // Switch to the newly opened window
        String originalWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        
      //  Verify that the text "New Window" is present on the page
        String newWindowText = driver.findElement(By.tagName("h3")).getText();
        if (newWindowText.equals("New Window")) {
            System.out.println("Text 'New Window' is present on the page.");
        } else {
            System.out.println("Text 'New Window' is NOT present on the page.");
        }
      //  Close the new window
        driver.close();
        
      //  Switch back to the original window
        driver.switchTo().window(originalWindowHandle);


      // Close the browser instance
        driver.quit();

	}
	

}
