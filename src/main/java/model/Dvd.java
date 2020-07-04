package model;

public class Dvd extends ShopItem{
	
	private String title;
	
	public Dvd (String title,int price){
		super(price);
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public boolean equals(Object o){
		if(o == null) return false;
		if(!(o instanceof Dvd)) return false;
		Dvd other = (Dvd) o;
		return this.title.equals(other.getTitle());
	}
	
	
	public int hashCode(){
		return title.hashCode();
	}
}
