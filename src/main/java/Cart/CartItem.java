package Cart;

import model.ShopItem;

public class CartItem {
	
	private ShopItem shopItem;
	
	private int quantity;
	
	public CartItem(ShopItem shopItem, int quantity){
		this.shopItem = shopItem;
		this.quantity = quantity;
	}
	
	public ShopItem getShopItem() {
		return shopItem;
	}
	
	public void setShopItem(ShopItem shopItem) {
		this.shopItem = shopItem;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
