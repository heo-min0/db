package cls;

import java.util.Scanner;

import dao.AccountDao;

public class UpdateCls {

	public UpdateCls() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수정할 내용:");
		String suse = sc.next();
		
		AccountDao.getInstance().selete("", suse);
		
		System.out.print("수정할 금액:");
		int smoney = sc.nextInt();
		
		AccountDao.getInstance().update(suse, smoney);
		System.out.println("수정되었습니다.");
		sc.close();
	}

}
