package Cart;

import model.ShopItem;

import java.util.HashSet;

public class ShopItemSet {
	
	private HashSet<ShopItem> shopItems;
	private int discount;
	
	public ShopItemSet(HashSet<ShopItem> shopItems, int discount){
		this.shopItems = shopItems;
		this.discount = discount;
	}
	
	public HashSet<ShopItem> getShopItems() {
		return shopItems;
	}
	
	public int getDiscount() {
		return discount;
	}
	
}
