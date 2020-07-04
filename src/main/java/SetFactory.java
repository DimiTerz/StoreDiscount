import Cart.CartItem;
import Cart.ShopItemSet;
import model.ShopItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SetFactory {
	
	List<SetDiscount> discounts;
	
	public SetFactory(List<SetDiscount> discounts){
		this.discounts = discounts;
	}
	
	public List<ShopItemSet> getDifferentshopItemsSetsWithMaxTotalDiscount(List<CartItem> shoppingCartItems) {
		
		List<ShopItemSet> optimizeSetList;
		
		optimizeSetList = getBestCombinationShopItemSets(shoppingCartItems);
		
		return optimizeSetList;
	}
	
	private List<ShopItemSet> getBestCombinationShopItemSets(List<CartItem> shoppingCartItems) {
		List<List<ShopItemSet>> differentShopItemsSetsCombinations = new ArrayList<>();
		
		for (int i = shoppingCartItems.size();i>=1;i--){
			differentShopItemsSetsCombinations.add(calculateDifferentShopItemsSetsByMaxSize(shoppingCartItems,i));
		}
		
		List<ShopItemSet> optimizeSetList;
		
		if(differentShopItemsSetsCombinations.size() > 1)
			optimizeSetList = selectShopItemsSetsWithMaxDiscount(differentShopItemsSetsCombinations);
		else
			optimizeSetList = differentShopItemsSetsCombinations.get(0);
		return optimizeSetList;
	}
	
	private List<ShopItemSet> calculateDifferentShopItemsSetsByMaxSize(List<CartItem> shoppingCartItems, int maxSizeSet) {
		List<CartItem> remainingShoppingCartItems = cloneShoppingCartItems(shoppingCartItems);
		List<ShopItemSet> setsOfDifferentShopItems = new ArrayList<>();
		
		while (!remainingShoppingCartItems.isEmpty()) {
			final ShopItemSet oneSetOfDifferentShopItems = createNextSet(remainingShoppingCartItems,maxSizeSet);
			setsOfDifferentShopItems.add(oneSetOfDifferentShopItems);
		}
		
		return setsOfDifferentShopItems;
	}
	
	private ShopItemSet createNextSet(List<CartItem> remainingShoppingCartItems, int maxSizeSet) {
		HashSet<ShopItem> shopItems = new HashSet<>();
		
		for (CartItem item:new ArrayList<>(remainingShoppingCartItems)) {
			
			shopItems.add(item.getShopItem());
			
			if (item.getQuantity() == 1)
				remainingShoppingCartItems.remove(item);
			else
				item.setQuantity(item.getQuantity() - 1);
			
			if (shopItems.size() == maxSizeSet)
				break;
		}
		return new ShopItemSet(shopItems,getDiscount(shopItems.size()));
	}
	
	private List<ShopItemSet> selectShopItemsSetsWithMaxDiscount(List<List<ShopItemSet>> shopItemsSetsCombinations) {
		List<ShopItemSet> maxDiscountShopItemsSets = null;
		int maxShopItemsSetsDiscount = 0;
		int totalShopItemsSetsDiscount = 0;
		
		for (List<ShopItemSet> shopItemSets:shopItemsSetsCombinations) {
			for (ShopItemSet shopItemSet:shopItemSets) {
				totalShopItemsSetsDiscount += shopItemSet.getDiscount();
			}
			
			if (maxShopItemsSetsDiscount < totalShopItemsSetsDiscount) {
				maxDiscountShopItemsSets = shopItemSets;
				maxShopItemsSetsDiscount = totalShopItemsSetsDiscount;
			}
			
			totalShopItemsSetsDiscount = 0;
		}
		
		return maxDiscountShopItemsSets;
	}
	
	
	private List<CartItem> cloneShoppingCartItems (List<CartItem> shoppingCartItems){
		List<CartItem> shoppingCartItemsCopy = new ArrayList<>();
		
		for (CartItem item:shoppingCartItems) {
			shoppingCartItemsCopy.add(new CartItem(item.getShopItem(), item.getQuantity()));
		}
		
		return shoppingCartItemsCopy;
	}
	
	private int getDiscount(int differentShopItemssCount){
		int defaultDiscount = 0;
		
		for (SetDiscount discount:discounts){
			if (differentShopItemssCount == discount.getDifferentCopies())
				return discount.getDiscount();
		}
		
		return defaultDiscount;
	}
}
