package bookmarket.controller;

import bookmarket.model.BookStorage;
import bookmarket.model.Cart;
import bookmarket.view.ConsoleView;

public class BookMarketController {
	ConsoleView view;
	BookStorage mBookStorage;
	Cart mCart;
	String[] menuList = {
			"0. 종료", "1. 도서보기", "2. 장바구니 보기", "3. 장바구니에 도서 담기", "4. 장바구니 비우기"
	};
	
	public BookMarketController(ConsoleView view, BookStorage mBookStorage, Cart mCart) {
		this.view = view;
		this.mBookStorage = mBookStorage;
		this.mCart = mCart;
	}
	
	public void start() {
		view.displayWelcome();
		
		int menu;
		
		do {
			menu = view.selectMenu(menuList);
			switch (menu) {
			case 1 : viewBookInfo(); break;
			
			case 2 : viewCart(); break;
			
			case 3 : addBook2Cart(); break;
			
			case 4 : resetCart(); break;
			}
		} while(menu != 0);
		
		view.showMessage(">> LJSuuuuu Book Market을 종료합니다.");
	}

	private void viewBookInfo() {
		view.displayBookInfo(mBookStorage);
	}
	
	private void viewCart() {
		view.displayCart(mCart);
	}
	
	private void resetCart() {
		view.displayCart(mCart);
		if(!mCart.isEmpty()) {
			if(view.askConfirm(">> 장바구니를 비우려면 Yes를 입력하세요 : ", "Yes")) {
				mCart.resetCart();
				view.showMessage(">> 장바구니가 비워졌습니다.");
			}
		}
	}
	
	private void addBook2Cart() {
		view.displayBookInfo(mBookStorage);
		int bookId = view.selectBookId(mBookStorage);
		mCart.addItem(mBookStorage.getBookId(bookId));
		view.showMessage("장바구니에 도서를 추가하였습니다.");
	}
	
}
