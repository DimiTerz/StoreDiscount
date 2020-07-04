package model;

public class VideoTape extends ShopItem{
	
	private String title;
	
	
	public VideoTape (String title,int price){
		super(price);
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public boolean equals(Object o){
		if(o == null) return false;
		if(!(o instanceof VideoTape)) return false;
		
		VideoTape other = (VideoTape) o;
		return this.title.equals(other.getTitle());
	}
	
	
	public int hashCode(){
		return title.hashCode();
	}
}
