package bookmarket.model;

public class Cart {
	
	private CartItem[] itemList = new CartItem[64];
	private int numItems = 0;
	
	public String getItemInfo(int i) {
		return itemList[i].toString();
	}
	
	public boolean isInCart(Book book) {
		return false;
	}
	
	public void addItem(Book book) {
		
		CartItem item = getCartItem(book);
		if(item == null) {
			itemList[numItems++] = new CartItem(book);			
		} else {
			item.addQuantity(1);
		}
	}
	
	private CartItem getCartItem(Book book) {
		for (int i = 0; i < numItems; i += 1) {
			if(itemList[i].getBook() == book) {
				return itemList[i];
			}
		}
		return null;
	}

	public int getNumItems() {
		return numItems;
	}
	
	public boolean isEmpty() {
		return numItems == 0;
	}

	public void resetCart() {
		itemList = new CartItem[64];
		numItems = 0;
	}
	
	
	
}
