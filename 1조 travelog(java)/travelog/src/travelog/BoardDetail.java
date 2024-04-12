package travelog;

import java.util.Scanner;

public class BoardDetail {
	public static void main(String[] args) {

		DB db = new DB();
		Scanner sc = new Scanner(System.in);

		System.out.println("게시물 번호를 입력하세요.");
		int choice = sc.nextInt();
		sc.nextLine();
		db.detailSelect(choice);
		boolean bo = true;

		while (bo) {
			System.out.println("1. 게시물 수정 2. 게시물 삭제 3. 뒤로가기 0. 종료");
			String BD = sc.nextLine();
			switch (BD) {
			case "1":
				BoardUpdate.boardUpdate(choice);
				db.detailSelect(choice);
				break;
			case "2":
				db.delete(choice);
				ConsoleBoard.main(args);
				break;
			case "3":
				BoardDetail.main(args);
				;
				break;
			case "0":
				System.out.println("종료합니다.");
				bo = false;
				ConsoleBoard.main(args);
			default:
				System.out.println("메뉴를 다시 선택해주세요");
				continue;

			}
		}
	}

}
