package Pageobject;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage extends Base{



	public CheckoutPage(){
		//		driver=rdriver;
		PageFactory.initElements(driver,this);

	}


	@FindBy(xpath = "//input[@name=\"q\"]")
	private WebElement searchinput;
	@FindBy(xpath = "//div[contains(text(),'Acer Aspire 3 Intel Core i3 12th Gen 1215U')]")
	private WebElement product;
	@FindBy(xpath = "//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")
	private WebElement addtocart;
	@FindBy(xpath = "//a[contains(text(),'Acer Aspire 3 Intel Core i3 12th Gen 1215U')]")
	private WebElement cartproduct;
	@FindBy(xpath = "//button[@class=\"_2KpZ6l _2ObVJD _3AWRsL\"]")
	private WebElement placeorder;
	@FindBy(xpath = "//input[@type=\"text\"]")
	private WebElement enteremail;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement submit;
	@FindBy(xpath = "//span[contains(text(),'Kumar')]")
	private WebElement verifylogin;
	@FindBy(xpath = "(//button[contains(text(),'Change')])[2]")
	private WebElement changebutton;
	@FindBy(xpath = "//button[contains(text(),'EDIT')]")
	private WebElement edit;
	@FindBy(xpath = "//input[@name=\"name\"]")
	private WebElement entername;
	@FindBy(xpath = "//input[@name=\"phone\"]")
	private WebElement enterphone;
	@FindBy(xpath = "//input[@name=\"pincode\"]")
	private WebElement enterpincode;
	@FindBy(xpath = "//textarea[@name=\"addressLine1\"]")
	private WebElement enteraddress;
	@FindBy(xpath = "//input[@name=\"city\"]")
	private WebElement entercity;	
	@FindBy(xpath = "//button[contains(text(),'Save and Deliver Here')]")
	private WebElement savedeliver;
	@FindBy(xpath = "//button[contains(text(),'CONTINUE')]")
	private WebElement continu;
	@FindBy(xpath = "//button[contains(text(),'Accept & Continue')]")
	private WebElement accept;	
	@FindBy(xpath = "//span[contains(text(),'Credit / Debit / ATM Card')]")
	private WebElement creditcard;
	@FindBy(xpath = "//div[contains(text(),'Acer Aspire 3 Intel Core i3 12th Gen 1215U')]")
	private WebElement ordersummary;


	//	

	// verifying home page loads successfully
	public void verifytitle() {
		String expectedTitle=driver.getTitle();
		Assert.assertEquals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!", expectedTitle);
	}
	// searching laptop and adding product to cart
	public void searchadd() throws AWTException {
		searchinput.sendKeys("laptop");
		searchinput.sendKeys(Keys.ENTER);
		explicit(product);
		product.click();
		Set<String> windowhandles=driver.getWindowHandles();
		List<String>windowhandlesList=new ArrayList<>(windowhandles);
		driver.switchTo().window(windowhandlesList.get(1));
		scroll(addtocart);
		explicit(addtocart);
		addtocart.click();
	}
	// verify product in cart and placing order
	public void verifyincart() {
		String expected=cartproduct.getText();
		Assert.assertEquals("Acer Aspire 3 Intel Core i3 12th Gen 1215U - (8 GB/512 GB SSD/Win...",expected);
		explicit(placeorder);
		placeorder.click();
	}
    // login but cannot login without OTP in FlipKart,
	public void login() {
		enteremail.sendKeys("ssunilkumar619@gmail.com");
		submit.click();
//		String expected=verifylogin.getText();
//		Assert.assertEquals("Sunil Kumar", expected);	
	}
  // enter shipping information
	public void shipinformation() {
		changebutton.click();
		edit.click();
		entername.clear();
		entername.sendKeys("Sunil kumar");
		enterphone.clear();
		enterphone.sendKeys("9971833376");
		enterpincode.clear();
		enterpincode.sendKeys("201102");
		enteraddress.clear();
		enteraddress.sendKeys("L-191");
		entercity.clear();
		entercity.sendKeys("Ghaziabad");
		savedeliver.click();
		continu.click();
		explicit(accept);
		accept.click();	
	}
// verifying order summary
	public void verifyordersummary() {
		String expected=ordersummary.getText();
		Assert.assertEquals("Acer Aspire 3 Intel Core i3 12th Gen 1215U - (8 GB/512", expected);
	}
// payment method select
	public void payment() {
		creditcard.click();
	}

}
