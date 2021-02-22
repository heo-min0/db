package cls;

import java.util.Scanner;

import dao.AccountDao;
import dto.AccountDto;

public class InsertCls {

	public InsertCls() {
		Scanner sc = new Scanner(System.in);
		System.out.println("*입력항목 : 용도(ex.쇼핑), 분류(수입/지출), 금액, 내용");	// 항목 출력
		
		System.out.print("용도:");
		String use = sc.next();
		
		System.out.print("분류(1.수입/2.지출):");
		int num = sc.nextInt();
		String classify = (num == 1)? "수입" : "지출";

		System.out.print("금액:");
		int money = sc.nextInt();
		
		System.out.print("메모:");
		String memo = sc.nextLine();
		
		AccountDto dto = new AccountDto(null, use, classify, money, memo);
		boolean b = AccountDao.getInstance().insert(dto);

		if(b) {
			System.out.println("정상적으로 추가되었습니다.");
			return;
		}
		System.out.println("추가 실패");
		sc.close();
	}

}
