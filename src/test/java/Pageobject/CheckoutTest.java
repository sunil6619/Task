package Pageobject;



import java.awt.AWTException;

import org.testng.annotations.*;

public class CheckoutTest extends Base{
	


	@Test
	
	public void checkout() throws AWTException {
		CheckoutPage ob= new CheckoutPage();
		ob.verifytitle();
		ob.searchadd();
		ob.verifyincart();
		ob.login();
	}
	
	

	
	



}





