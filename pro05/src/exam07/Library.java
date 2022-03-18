package exam07;

public class Library {
	private String bookName;
	private String bookAuthor;
	private String bookGenre;
	private int stock;
	public boolean rent = false;
	
	public Library(String bookName) {
		this.bookName = bookName;
	}
	
	public Library(String bookName, String bookAuthor) {
		this(bookName);
		this.bookAuthor = bookAuthor;		
	}
	
	public Library(String bookName, String bookAuthor, String bookGenre) {
		this(bookName, bookAuthor);
		this.bookGenre = bookGenre;		
	}
	
	public Library(String bookName, String bookAuthor, String bookGenre, int stock) {
		this(bookName, bookAuthor, bookGenre);
		this.stock += stock;		
	}
	
}



