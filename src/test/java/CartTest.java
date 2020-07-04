import Cart.ShoppingCart;
import model.VideoTape;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CartTest {
	
	ShoppingCart shoppingCart;
	
	@Before
	public void setup(){
		List<SetDiscount> byDifferentCopiesDiscountList = new ArrayList<>();
		
		byDifferentCopiesDiscountList.add(new SetDiscount(2,5));
		byDifferentCopiesDiscountList.add(new SetDiscount(3,10));
		byDifferentCopiesDiscountList.add(new SetDiscount(4,20));
		byDifferentCopiesDiscountList.add(new SetDiscount(5,25));
		
		SetFactory setFactory = new SetFactory(byDifferentCopiesDiscountList);
		shoppingCart = new ShoppingCart(new PriceCalculator(setFactory));
	}
	
	@Test
	public void normalPriceOneCopy(){
		
		VideoTape rocky1 = VideoTapeCatalog.rocky1();
		
		shoppingCart.add(rocky1);
		
		
		Assert.assertThat(shoppingCart.getTotalPrice(), CoreMatchers.is(8.0));
		
	}
	
	@Test
	public void normalPriceSameCopyTwice(){
		
		VideoTape rocky1 = VideoTapeCatalog.rocky1();
		
		shoppingCart.add(rocky1);
		shoppingCart.add(rocky1);
		
		Assert.assertThat(shoppingCart.getTotalPrice(), CoreMatchers.is(16.0));
		
	}
	
	@Test
	public void discountTwoDifferent(){
		
		VideoTape rocky1 = VideoTapeCatalog.rocky1();
		VideoTape rocky2 = VideoTapeCatalog.rocky2();
		
		shoppingCart.add(rocky1);
		shoppingCart.add(rocky2);
		
		Assert.assertThat(shoppingCart.getTotalPrice(), CoreMatchers.is(15.20));
		
	}
	
	@Test
	public void discountThreeDifferent(){
		
		VideoTape rocky1 = VideoTapeCatalog.rocky1();
		VideoTape rocky2 = VideoTapeCatalog.rocky2();
		VideoTape rocky3 = VideoTapeCatalog.rocky3();
		
		shoppingCart.add(rocky1);
		shoppingCart.add(rocky2);
		shoppingCart.add(rocky3);
		
		
		Assert.assertThat(shoppingCart.getTotalPrice(), CoreMatchers.is(21.60));
		
	}
	
	
	@Test
	public void discountFourDifferent(){
		
		VideoTape rocky1 = VideoTapeCatalog.rocky1();
		VideoTape rocky2 = VideoTapeCatalog.rocky2();
		VideoTape rocky3 = VideoTapeCatalog.rocky3();
		VideoTape rocky4 = VideoTapeCatalog.rocky4();
		
		shoppingCart.add(rocky1);
		shoppingCart.add(rocky2);
		shoppingCart.add(rocky3);
		shoppingCart.add(rocky4);
		
		Assert.assertThat(shoppingCart.getTotalPrice(), CoreMatchers.is(25.60));
		
	}
	
	@Test
	public void discountFiveDifferent(){
		
		VideoTape rocky1 = VideoTapeCatalog.rocky1();
		VideoTape rocky2 = VideoTapeCatalog.rocky2();
		VideoTape rocky3 = VideoTapeCatalog.rocky3();
		VideoTape rocky4 = VideoTapeCatalog.rocky4();
		VideoTape rocky5 = VideoTapeCatalog.rocky5();
		
		shoppingCart.add(rocky1);
		shoppingCart.add(rocky2);
		shoppingCart.add(rocky3);
		shoppingCart.add(rocky4);
		shoppingCart.add(rocky5);
		
		Assert.assertThat(shoppingCart.getTotalPrice(), CoreMatchers.is(30.00));
	}
	
	@Test
	public void discountFourCopiesThreeDifferent(){
		
		VideoTape rocky1 = VideoTapeCatalog.rocky1();
		VideoTape arocky1 = VideoTapeCatalog.rocky1();
		VideoTape rocky2 = VideoTapeCatalog.rocky2();
		VideoTape rocky3 = VideoTapeCatalog.rocky3();
		
		shoppingCart.add(rocky1);
		shoppingCart.add(arocky1);
		shoppingCart.add(rocky2);
		shoppingCart.add(rocky3);
		
		Assert.assertThat(shoppingCart.getTotalPrice(), CoreMatchers.is(29.6));
		
	}
	
	@Test
	public void discountTwoSetsOfDifferentCopies(){
		
		VideoTape rocky1 = VideoTapeCatalog.rocky1();
		VideoTape arocky1 = VideoTapeCatalog.rocky1();
		VideoTape rocky2 = VideoTapeCatalog.rocky2();
		VideoTape arocky2 = VideoTapeCatalog.rocky2();
		VideoTape rocky3 = VideoTapeCatalog.rocky3();
		VideoTape arocky3 = VideoTapeCatalog.rocky3();
		VideoTape rocky4 = VideoTapeCatalog.rocky4();
		VideoTape rocky5 = VideoTapeCatalog.rocky5();
		
		shoppingCart.add(rocky1);
		shoppingCart.add(arocky1);
		shoppingCart.add(rocky2);
		shoppingCart.add(arocky2);
		shoppingCart.add(rocky3);
		shoppingCart.add(arocky3);
		shoppingCart.add(rocky4);
		shoppingCart.add(rocky5);
		
		Assert.assertThat(shoppingCart.getTotalPrice(), CoreMatchers.is(51.20));
		
	}
}
