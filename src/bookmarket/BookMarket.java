package bookmarket;

import bookmarket.controller.BookMarketController;
import bookmarket.model.BookStorage;
import bookmarket.model.Cart;
import bookmarket.view.ConsoleView;

public class BookMarket {
	public static void main(String[] args) {
		ConsoleView view = new ConsoleView();
		BookStorage storage = new BookStorage();
		Cart cart = new Cart();
		BookMarketController controller = new BookMarketController(view, storage, cart);
		
		controller.start();
	}
}
