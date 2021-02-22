package cls;

import java.util.Scanner;

import dao.AccountDao;

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
		
		AccountDao.getInstance().insert(use, classify, money, memo);
		sc.close();
	}

}
