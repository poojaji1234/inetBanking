package com.inetBanking.testCases;

import org.testng.annotations.*;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	   @Test
	    public void loginTest()
	    {
		    driver.get(baseURL);
		    
	    	
	    	LoginPage lp=new LoginPage(driver);
	    	
	    	
	    	lp.setUserName(username);
	    	
	    	lp.setPassword(password);
	    	lp.ClickSubmit();
	    	
	    	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	    	{
	    		Assert.assertTrue(true);
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false);
	    	}
	    	
	    }
	}



