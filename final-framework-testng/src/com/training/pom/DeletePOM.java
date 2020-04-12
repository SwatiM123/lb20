package com.training.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePOM {
	private WebDriver driver; 
	
	public DeletePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="Sale")
	private WebElement Sales; 
	//driver.findElement(By.linkText("Sales")).click();
	
	@FindBy(xpath="//div[@class='text-right']/button")
	private WebElement catalog; 
	driver.switchTo().window(vars.get("win320").toString());
	
	driver.close();
    // 13 | mouseOver | css=tr:nth-child(2) .btn | 
    driver.switchTo().window(vars.get("root").toString());
    // 14 | mouseOut | css=tr:nth-child(2) .btn | 
    driver.findElement(By.linkText("Returns")).click();
    // 15 | click | name=selected[] | 
    {
      WebElement element = driver.findElement(By.cssSelector("tr:nth-child(2) .btn"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 16 | mouseOver | css=.btn-danger | 
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    // 17 | mouseOut | css=.btn-danger | 
    driver.findElement(By.name("selected[]")).click();
    // 18 | chooseOkOnNextConfirmation |  | 
    {
      WebElement element = driver.findElement(By.cssSelector(".btn-danger"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 19 | click | css=.btn-danger | 
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    // 21 | webdriverChooseOkOnVisibleConfirmation |  | 
    driver.findElement(By.cssSelector(".btn-danger")).click();
    assertThat(driver.switchTo().alert().getText(), is("Are you sure?"));
    driver.switchTo().alert().accept();
  }
}

}
}