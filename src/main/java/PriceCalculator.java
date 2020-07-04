import Cart.CartItem;
import Cart.ShopItemSet;
import Cart.ShoppingCart;
import model.ShopItem;

import java.util.List;

public class PriceCalculator implements ShoppingCart.PriceCalculator{
	
	private SetFactory setFactory;
	
	public PriceCalculator(SetFactory setFactory){
		this.setFactory = setFactory;
	}
	
	@Override
	public Double calculate(List<CartItem> shoppingCartItems) {
		List<ShopItemSet> setOFDifferentShopItems = setFactory.getDifferentshopItemsSetsWithMaxTotalDiscount(shoppingCartItems);
		
		double totalPrice =0.0;
		double setPrice =0.0;
		
		for (ShopItemSet shopItemSet:setOFDifferentShopItems){
			for (ShopItem shopItem:shopItemSet.getShopItems()) {
				setPrice += shopItem.getPrice();
			}
			
			setPrice = setPrice * (1.0 - (shopItemSet.getDiscount()/100.0));
			totalPrice +=setPrice;
			setPrice = 0;
		}
		
		return totalPrice;
	}
}
