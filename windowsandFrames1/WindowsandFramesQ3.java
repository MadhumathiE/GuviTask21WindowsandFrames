package windowsandFrames1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsandFramesQ3 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		
		//Switch to the top frame
        driver.switchTo().frame("frame-top");
        
       // Verify that there are three frames on the page
        int frameCount = driver.findElements(By.tagName("frame")).size();
        if (frameCount == 3) {
            System.out.println("There are three frames on the page.");
        } else {
            System.out.println("There are NOT three frames on the page.");
        }
        
       // Switch to the left frame
        driver.switchTo().frame("frame-left");
        
       // Verify that the left frame has text "LEFT"
        WebElement leftFrameText = driver.findElement(By.tagName("body"));
        if (leftFrameText.getText().equals("LEFT")) {
            System.out.println("The left frame has the text 'LEFT'.");
        } else {
            System.out.println("The left frame does NOT have the text 'LEFT'.");
        }
       // Switch back to the top frame
        driver.switchTo().parentFrame();

       // Switch to the middle frame
        driver.switchTo().frame("frame-middle");

        // Verify that the middle frame has text "MIDDLE"
        WebElement middleFrameText = driver.findElement(By.id("content"));
        if (middleFrameText.getText().contains("MIDDLE")) {
            System.out.println("The middle frame has the text 'MIDDLE'.");
        } else {
            System.out.println("The middle frame does NOT have the text 'MIDDLE'.");
        }

        //  Switch back to the top frame
        
        driver.switchTo().parentFrame();
        
        // Switch to the right frame
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-right']")));

        //  Verify that the right frame has text "Right"
        WebElement rightFrameText = driver.findElement(By.tagName("body"));
        if (rightFrameText.getText().equals("RIGHT")) {
            System.out.println("The right frame has the text 'RIGHT'.");
        } else {
            System.out.println("The right frame does NOT have the text 'RIGHT'.");
        }

        //  Switch back to the top frame
        driver.switchTo().parentFrame();

        //  Switch back to the Bottom frame
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-bottom']")));

        //  Verify that the bottom frame has text "Bottom"
        WebElement bottomFrameText = driver.findElement(By.tagName("body"));
        if (bottomFrameText.getText().equals("BOTTOM")) {
            System.out.println("The bottom frame has the text 'BOTTOM'.");
        } else {
            System.out.println("The bottom frame does NOT have the text 'BOTTOM'.");
        }

        // Switch back to the top frame
        driver.switchTo().defaultContent();

        //  Verify that the page title is "Frames"
        String pageTitle = driver.getTitle();
        if (pageTitle.equals("Frames")) {
            System.out.println("The page title is 'Frames'.");
        } else {
            System.out.println("The page title is NOT 'Frames'.");
        }

        //  Close the browser instance
        driver.quit();
    }
}

	
	
	
	
	


