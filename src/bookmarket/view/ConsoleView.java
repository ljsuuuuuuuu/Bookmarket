package bookmarket.view;

import java.util.Scanner;

import bookmarket.model.BookStorage;
import bookmarket.model.Cart;

public class ConsoleView {

	public void displayWelcome() {
		String greeting = "*****************************************\n" + "*    Welcome to LJSuuuuu Book Market    *\n"
				+ "*****************************************";
		System.out.println(greeting);
	}

	public int selectMenu(String[] menuList) {
		Scanner sc = new Scanner(System.in);
		int menu;
		do {
			displayMenu(menuList);
			System.out.print(">> 메뉴 선택 : ");
			menu = sc.nextInt();
			if (menu < 0 || menu >= menuList.length) {
				System.out.printf("0 ~ %d 까지의 숫자 입력해야 합니다\n", menuList.length - 1);
			}
		} while (menu < 0 || menu >= menuList.length);
		return menu;
	}

	private void displayMenu(String[] menuList) {
		System.out.println("=========================================\n");
		for (int i = 1; i < menuList.length; i += 1) {
			System.out.println(menuList[i]);
		}
		System.out.println(menuList[0]);
		System.out.println("=========================================\n");
	}

	public void displayBookInfo(BookStorage mBookStorage) {
		for (int i = 0; i < mBookStorage.getNumBooks(); i += 1) {
			System.out.println(mBookStorage.getBookInfo(i));
		}

	}

	public void displayCart(Cart mCart) {
		if (mCart.isEmpty()) {
			System.out.println(">> 장바구니가 비어있습니다.");
			return;
		}

		for (int i = 0; i < mCart.getNumItems(); i += 1) {
			System.out.println(mCart.getItemInfo(i));
		}
	}

	public void showMessage(String message) {
		System.out.println(message);
	}

	public boolean askConfirm(String message, String response) {
		System.out.print(message);

		Scanner sc = new Scanner(System.in);

		if (sc.nextLine().equals(response))
			return true;

		return false;
	}

	public int selectBookId(BookStorage mBookStorage) {
		Scanner sc = new Scanner(System.in);
		boolean result;
		int bookId;
		do {
			System.out.print("추가할 도서의 ID를 입력하세요 : ");
			bookId = sc.nextInt();
			result = mBookStorage.isValidBook(bookId);
			if (!result) {
				System.out.println("잘못된 도서의 ID입니다.");
			}
		} while (!result);
		return bookId;

	}

}
