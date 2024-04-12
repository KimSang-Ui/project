package travelog;

import java.util.Scanner;

public class Board_write {

	public static void main(String[] args) {
		
		DB db = new DB();
		Scanner scan = new Scanner(System.in);

		System.out.println("글작성 페이지 입니다");
		System.out.println();

		boolean check = false;
		while (!check) { // 카테고리입력 상황에서 예시에 없는 단어를 치면 else를 출력하고 처음부터 반복
			System.out.println("카테고리를 입력해주세요");
			System.out.println("▶경기도 ▶강원도 ▶충청도 ▶경상도 ▶전라도");
			System.out.println();
			System.out.print("카테고리 : ");
			String board_category = scan.nextLine();
			if (Listpage.isValidCategory(board_category)) {
				check = true;
				System.out.print("작성자 : ");
		   		String board_writer = scan.nextLine();
				System.out.print("제목 : ");
				String board_title = scan.nextLine();
				System.out.print("내용 : ");
				String board_content = scan.nextLine();
				db.insert(board_category, board_writer, board_title, board_content);
			} else {
				System.out.println("없는 카테고리 입니다");
				System.out.println();
			}
		}
	}
}
