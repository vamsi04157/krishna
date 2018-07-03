package com.watchers.selenium_Test;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
    	
    	WebDriverManager.getInstance(CHROME).setup();
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.weightwatchers.com/us/");
    	
	    // verify page title displayed
	
		WebElement pageTitle = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"slice-id--84631\"]/div/div[2]/div/div/div/div/div[1]/div/div/h1/em")));
		if (pageTitle.getText().contains("Weight Loss Program, Recipes & Help | Weight Watchers")){
			System.out.println("Page title says -'Weight Loss Program, Recipes & Help | Weight Watchers'");
		}else {
			System.err.println("Page title does not match to -'Weight Loss Program, Recipes & Help | Weight Watchers'");
			System.out.println("The correct page title is -" + pageTitle.getText());
		}
	    
		// Find a meeting
		
		WebElement findMeeting = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("ela-menu-visitor-desktop-supplementa_find-a-meeting")));
        if (findMeeting.isDisplayed())
        {
        	findMeeting.click();
            System.out.println("'Find a meeting' element is present and clicked"); 	
        }else {
        	System.err.println("Unable to find the Find a Meeting element");
        }
        
        
        WebElement verifyFindMeetingTitle = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div/ui-view/ui-view/div/div/div/div/div[1]/h1")));
	    if(verifyFindMeetingTitle.getText().contains("Get Schedules & Times Near You")) {
	    	System.out.println("Page title says -'Get Schedules & Times Near You'");
	    }else {
	    	System.err.println("Page title does not match to -'Get Schedules & Times Near You'");
	    	System.out.println("The correct page title is -" + verifyFindMeetingTitle.getText());
	    }
        
        driver.findElement(By.id("meetingSearch")).sendKeys("10011");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/ui-view/ui-view/div/div/div/div/div[2]/div[1]/div/form/div[1]/span/button")).click();
        
        WebElement locationTitle = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ml-1180510\"]/result-location/div/div[1]/a/location-address/div/div/div[1]/div[1]/span")));
        if(locationTitle.isDisplayed()) {
        	System.out.println("The title of the nearest store is -" + locationTitle.getText());
        }else {
        	System.err.println("Unable to find the element");
        }
        
        WebElement locationDistance = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ml-1180510\"]/result-location/div/div[1]/a/location-address/div/div/div[1]/div[2]")));
        if(locationDistance.isDisplayed()) {
        	System.out.println("The distance of the nearest store is -" + locationDistance.getText());
        }else {
        	System.err.println("Unable to find the element");
        }
       
        locationDistance.click();
        if(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/ui-view/ui-view/div[1]/div/div/div[1]/div[2]/div[2]/div/location-address/div/div/div[1]/div/span")).getText().contains("WEIGHT WATCHERS STORE 23RD ST-5TH AVE")) {
            System.out.println("The title of the first search and the displayed title of the page are both same and satisfies 7th step");
        }else {
    	   System.err.println("The title of the first search and the displayed title both are not same");
        }
        

        
        } 
}
