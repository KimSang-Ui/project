package travelog;

import java.util.Scanner;

public class BoardUpdate {
	public static void boardUpdate(int boardNo) {
		Scanner sc = new Scanner(System.in);
		DB db = new DB();
		
		System.out.println("▶경기도 ▶강원도 ▶충청도 ▶경상도 ▶전라도");
		System.out.println("게시글 카테고리 > ");
		String category = sc.nextLine(); // 카테고리
		System.out.println("게시글 제목 > ");
		String title = sc.nextLine(); // 제목 작성
		System.out.println("게시글 내용 > ");
		String content = sc.nextLine(); // 내용 작성

		db.update(title, content, category, boardNo); // 수정한 게시판 번호

	}
}
