package travelog;

import java.util.Scanner;

public class Listpage {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DB db = new DB();
		
//		db.listSelect(); // 게시글목록
		
		while(true) {
			System.out.println("메뉴를 선택하세요:");
            System.out.println("1. 게시글 카테고리 입력 > (경상도 경기도 충청도 강원도 전라도)");
            System.out.println("2. 게시글 선택");
            System.out.println("3. 게시글 등록");
            System.out.println("4. 메인 화면으로 이동");

            int choice = scan.nextInt();
            scan.nextLine();

            switch(choice) {
            case 1:

            	String cate;
                
            	System.out.println("카테고리를 입력해주세요.");
            	System.out.println("경상도 경기도 충청도 강원도 전라도");
               
            	cate = scan.nextLine(); // 카테고리 입력 받기
                
                boolean check = true;
                // 카테고리 입력 확인
                while(check) {
                	// 카테고리 정확도 확인
                	if(isValidCategory(cate)) {
            			if(db.cateSelect(cate)) { // 조회내용 있는 경우
            				check = false;
            			} else { //조회내용 없는 경우
            				System.out.println("조회되는 내용이 없습니다. 카테고리를 다시 입력 해주세요");
            				System.out.println("경상도 경기도 충청도 강원도 전라도");
            				cate = scan.nextLine();
            			}
                    } else {
                    	System.out.println("카테고리를 정확히 다시 입력해주세요.");
                    	System.out.println("경상도 경기도 충청도 강원도 전라도");
                    	cate = scan.nextLine();
                    }
                }

                break;
            case 2:
            	// 게시글 선택
            	BoardDetail.main(args);
            	break;
			case 3:
				Board_write.main(args);
				ConsoleBoard.main(args);
	            // 게시글등록
	            break;
	        case 4:
	        	// 메인화면이동
	            System.out.println("메인 화면으로 이동합니다.");
	            ConsoleBoard.main(args);
	            return;  // 프로그램 종료
	        default:
	            System.out.println("올바른 메뉴를 선택하세요.");
            }
		}
	}
               
    public static boolean isValidCategory(String category) {
        // 유효한 카테고리인지 확인하는 메서드
        return category.equals("경상도") || category.equals("충청도") || category.equals("전라도")
                || category.equals("강원도") || category.equals("경기도");
    }

}

