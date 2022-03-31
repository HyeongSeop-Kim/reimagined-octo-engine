package exam09;

public interface Basket {
	public void add(String productName);
	public void add(String productname, int count);
	public void modify(String productName, int count);
	public void remove(String productName);
	
}
