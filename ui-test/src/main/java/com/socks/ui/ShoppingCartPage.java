package com.socks.ui;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPage {

	public SelenideElement totalAmount() {
		return $("#orderGrandTotal");
	}

	public static ShoppingCartPage open(){
		Selenide.open("167.172.178.86/basket.html");
		return new ShoppingCartPage();
	}

	public ShoppingCartPage deleteItem(){
//		$("#cart-list > tr > td:ntn-child(8) > a > i").click();
		return this;
	}

}
