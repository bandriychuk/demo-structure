package com.socks.ui;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.socks.api.routes.Routes.address;

public class ShoppingCartPage {

	public SelenideElement totalAmount() {
		return $("#orderGrandTotal");
	}

	public static ShoppingCartPage open(){
		Selenide.open(address +"/basket.html");
		return new ShoppingCartPage();
	}

	public ShoppingCartPage deleteItem(){
//		$("#cart-list > tr > td:ntn-child(8) > a > i").click();
		return this;
	}

}
