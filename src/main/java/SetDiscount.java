public class SetDiscount {
	
	private int differentCopies;
	private int discount;
	
	public SetDiscount(int differentCopies, int discount){
		this.differentCopies = differentCopies;
		this.discount = discount;
	}
	
	public int getDifferentCopies(){
		return differentCopies;
	}
	
	public int getDiscount(){
		return discount;
	}
}
