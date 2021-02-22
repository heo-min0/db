package cls;

import java.util.Scanner;

import dao.AccountDao;

public class DeleteCls {

	public DeleteCls() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 내용:");
		String suse = sc.next(); 
		
		AccountDao.getInstance().selete("", suse);
		
		AccountDao.getInstance().delete(suse);
		
		System.out.println("삭제되었습니다.");
		sc.close();
	}

}
