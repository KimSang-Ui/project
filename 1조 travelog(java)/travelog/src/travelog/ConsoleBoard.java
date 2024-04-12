package travelog;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleBoard {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DB db = new DB();
		
		while (true) {
			db.listSelect();
			
			System.out.println();
			System.out.print("1. 카테고리 선택   ");
			System.out.print("2. 게시글 선택   ");
			System.out.print("3. 게시글 등록   ");
			System.out.println("0. 종료");
			System.out.println();
			System.out.print("메뉴(번호) 선택: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // 개행 문자 처리

			switch (choice) {
			case 1:
				Listpage.main(args);
				break;
			case 2:
				BoardDetail.main(args);
				break;
			case 3:
				Board_write.main(args);
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("잘못된 메뉴 선택입니다.");
			}
		}
	}
}
