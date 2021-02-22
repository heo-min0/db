package cls;

import java.util.Scanner;

import dao.AccountDao;

public class SelectCls {

	public SelectCls() {
		Scanner sc = new Scanner(System.in);
		String sdate = "";
		String suse = "";
		
		System.out.print("검색할 항목(1.날짜/2.제목):");
		int num = sc.nextInt();
		
		if(num == 1) {
			System.out.print("월=");
			int month = sc.nextInt();

			System.out.print("일=");
			int day = sc.nextInt();
			
			String smonth = (month < 10)? "0"+month : ""+month;
			String sday =   (day   < 10)? "0"+day   : ""+ day;
			sdate = 21 + smonth + sday;
		
		}else if(num == 2) {
			System.out.print("검색할 제목:");
			suse = sc.next();
		}
		
		AccountDao.getInstance().selete(sdate, suse);
		sc.close();
	}

}
