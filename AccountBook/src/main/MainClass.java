package main;

import java.util.Scanner;

import cls.DeleteCls;
import cls.InsertCls;
import cls.SelectCls;
import cls.UpdateCls;
import dao.AccountDao;

public class MainClass {

	public static void main(String[] args) {
		/*
		 * 추가하기
		 * 삭제하기
		 * 날짜로 검색하기
		 * 제목으로 검색하기
		 * 수정하기
		 * 모두출력
		 * -------------
		 * 합계출력
		 * */
		new MainClass().loop();
	}
	
	public void loop() {
		while(true) { menu(); }
	}
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("================= M E N U =====================");
		System.out.println("| 1.추가   2.삭제   3.검색   4.수정   5.출력   6.합계   7.종료 |");
		System.out.println("===============================================");
		System.out.print("입력>>");
		int workNum = sc.nextInt();

		switch(workNum) {
			case 1 : new InsertCls(); 		break;
			case 2 : new DeleteCls(); 		break;
			case 3 : new SelectCls(); 		break;
			case 4 : new UpdateCls();		break;
			case 5 : AccountDao.getInstance().selete();		break;
			case 6 : AccountDao.getInstance().totalSum();	break;
			case 7 : System.out.println("종료합니다.");
					 System.out.close();	break;
		}
		//sc.close();
	}

}





