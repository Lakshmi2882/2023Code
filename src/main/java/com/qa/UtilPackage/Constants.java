package com.qa.UtilPackage;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	
	public static final String  LOGIN_TITLE="Account Login";

	public static final String Login_URL="opencart/index.php?route=account/login";
	public static final String Account_Title="My Account";

	public static final Object Product_Imagecount = 5;
	public static List<String> AccountList()
	{
		ArrayList<String> al=new ArrayList<String>();
		al.add("My Account");
		al.add("My Orders");
		al.add("My Affiliate Account");
		al.add("Newsletter");
		return al;
		
	}
public static List<String> Barlist()
{
	ArrayList<String> Bl=new ArrayList<String>();
	Bl.add("Desktops");
	Bl.add("Laptops&Notebooks");
	Bl.add("Components");
	Bl.add("Tablets");
	Bl.add("Software");
	Bl.add("Phones&PDAs");
	Bl.add("Cameras");
	Bl.add("MP3 Players");
	return Bl;
}
public static List<String> RHListValues()
{
	ArrayList<String> RH=new ArrayList<String>();
	RH.add("My Account");
	RH.add("Edit Account");
	RH.add("Password");
	RH.add("Address Book");
	RH.add("Wish List");
	RH.add("Order History");
	RH.add("Downloads");
	RH.add("Recurring payments");
	RH.add("Reward Points");
	RH.add("Returns");
	RH.add("Transactions");
	RH.add("Newsletter");
	RH.add("Logout");
	return RH;
}

}
