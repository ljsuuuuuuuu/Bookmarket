package noOOP;

import java.util.Scanner;

public class SuBookMarket {

	static final int MENU_LAST_NUMBER = 4;

	static String[][] bookList = { { "ID2401", "쉽게 배우는 자바 프로그래밍 2판", "우종정", "한빛아", "20,000원" },
			{ "ID2402", "코딩 자율학습 HTML+CSS+자바스크립트", "김기수", "길벗", "30,000원" },
			{ "ID2403", "Do It! 자료구조와 함께 배우는 알고리즘 입문 - 자바편", "보요시바타", "이지스퍼", "25,000원" } };
	static int[] cartList = { 0, 0, 0 };
	static int numCartItem = 0;

	public static void main(String[] args) {

		displayWelcome();

		boolean quit = false;
		while (!quit) {
			int menu = displayGetMenu();
			switch (menu) {
			case 1:
				menuBookList();
				break;
			case 2:
				menuCartList();
				break;
			case 3:
				menuAddCartItem();
				break;
			case 4:
				menuClearCart();
				break;
			case 0:
				menuExit();
				quit = true;
				break;
			default:
				menuWrongNumber();
			}
		}
	}

	private static void displayWelcome() {
		String greeting = "*****************************************\n" + "*    Welcome to LJSuuuuu Book Market    *\n"
				+ "*****************************************";
		System.out.println(greeting);
	}

	private static int displayGetMenu() {
		String menu = "=========================================\n" + "1. 도서 목록 보기\n" + "2. 장바구니 보기\n"
				+ "3. 장바구니에 도서 추가\n" + "4. 장바구니 비우기\n" + "0. 종료\n" + "=========================================\n"
				+ ">> 메뉴 선택 : ";

		System.out.print(menu);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	private static void menuBookList() {
		printBookList();
	}

	private static void menuCartList() {
		if (!cartEmpty()) {
			printCart();
		}
	}

	private static void printCart() {
		String bookListStrart = ">> 도서 목록\r\n"
				+ "------------------------------------------------------------------------\r\n";
		String bookListEnd = "------------------------------------------------------------------------\n";
		System.out.print(bookListStrart);
		for(int i = 0; i < cartList.length; i += 1) {
			if(cartList[i] != 0) {
				System.out.print(cartList[i] + "권" + " ");
				printSelBookNum(i);
			}
		}
		System.out.print(bookListEnd);
	}

	private static boolean cartEmpty() {
		if(numCartItem != 0) {
			return false;
		}
		System.out.println(">> 장바구니가 비어 있습니다.");
		return true;
	}

	private static void menuAddCartItem() {
		Scanner sc = new Scanner(System.in);
		String bookId;
		do {
			printBookList();
			System.out.print(">> 추가할 도서 ID 입력(0 입력시 종료) : ");
			bookId = sc.nextLine();
			if(bookId.equals("0")) {
				break;
			}
			int equal = 0;
			for (int i = 0; i < bookList.length; i += 1) {
				if (bookId.equals(bookList[i][0])) {
					cartList[i] += 1;
					numCartItem += 1;
					equal += 1;
					System.out.printf(">> 장바구니 추가 : %s\n", bookList[i][1]);
				}
			}
			if(equal == 0) {
				System.out.println(">> 없는 ID입니다. 도서 목록에 있는 ID를 입력하세요.");
			}
		} while (true);
	}

	private static void menuClearCart() {
		if (!cartEmpty()) {
			clearCart();
		}
	}

	private static void clearCart() {
		for(int i = 0; i < cartList.length; i += 1) {
			cartList[i] = 0;
		}
		numCartItem = 0;
		System.out.println(">> 장바구니에 있는 아이템을 모두 삭제하였습니다.");
	}

	private static void menuExit() {
		System.out.println(">> LJSuuuuu Book Market을 종료합니다.");
	}

	private static void printBookList() {
		String bookListStrart = ">> 도서 목록\r\n"
				+ "------------------------------------------------------------------------\r\n";
		String bookListEnd = "------------------------------------------------------------------------\n";

		System.out.print(bookListStrart);
		printSelBookNum(0);
		printSelBookNum(1);
		printSelBookNum(2);
		System.out.print(bookListEnd);
	}

	private static void printSelBookNum(int num) {
		for(int i = 0; i < bookList[num].length; i += 1) {
			System.out.print(bookList[num][i] + " / ");
		}
		System.out.println();

	}


	private static void menuWrongNumber() {
		System.out.printf("없는 메뉴입니다. 0번부터 %d번까지의 메뉴 중에서 선택하세요.\n", MENU_LAST_NUMBER);
	}

}
