package Cart;

import model.ShopItem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	private List<CartItem> shoppingCartItems = new ArrayList<>();
	
	private PriceCalculator priceCalculator;
	
	public ShoppingCart(PriceCalculator priceCalculator){
		this.priceCalculator = priceCalculator;
	}
	
	public void add(ShopItem shopItem) {
		
		CartItem existedItem = null;
		
		for (CartItem item:shoppingCartItems){
			if (item.getShopItem().equals(shopItem))
				existedItem = item;
		}
		
		if (existedItem != null)
			existedItem.setQuantity(existedItem.getQuantity() + 1);
		else
			shoppingCartItems.add(new CartItem(shopItem, 1));
	}
	
	public double getTotalPrice(){
		return priceCalculator.calculate(shoppingCartItems);
	}
	
	public interface PriceCalculator {
		Double calculate(List<CartItem> shoppingCartItems);
	}
}
