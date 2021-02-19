package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import dao.accountDao;

public class MainClass {

	public static void main(String[] args) {
		// menu
		accountDao dao = new accountDao();
		
		dao.insert();
		dao.insert();
		dao.select();
		
		// 형식		
		
		/*SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시mm분ss초");
		
		Calendar cal = Calendar.getInstance();		
		
		String ftime1 = format1.format(cal.getTime());
		String ftime2 = format2.format(cal.getTime());
		
		System.out.println(ftime1);
		System.out.println(ftime2);*/
		
	}

}





