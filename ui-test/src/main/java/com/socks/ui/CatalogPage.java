package com.socks.ui;

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {

	public static CatalogPage open() {
		Selenide.open("167.172.178.86/category.html");
		return page(CatalogPage.class);
	}

	public CatalogPage addItemByIndex(int index){
		$$("#products .product .buttons a.btn-primary").get(index).click();
		return this;
	}

	public ShoppingCartPage goToCart(){
		$("#numItemsInCart").click();
		return page(ShoppingCartPage.class);

	}}
