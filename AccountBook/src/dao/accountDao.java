package dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import dto.accountDto;

// Data Access Object
public class accountDao {
	Scanner sc = new Scanner(System.in);

	// 서류철
	private accountDto accountBook[] = new accountDto[100];
	private int indexCount;
	
	public accountDao() {
		indexCount = 0;
	}	
	
	// 추가
	public void insert() {
		System.out.print("지출(1)/수입(2) = ");
		int c = sc.nextInt();				
		String classify = (c == 1)?"지출":"수입";
		
		System.out.print("금액 = ");
		int money = sc.nextInt();
		
		System.out.print("사용처 = ");
		String use = sc.next();
		
		System.out.print("memo = ");
		String memo = sc.next();
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy년 MM월 dd일 HH시mm분ss초");
		Calendar cal = Calendar.getInstance();	
		String dateTime = f.format(cal.getTime()); // 2021년 01월 28일 10시42분51초
		
		// 배열에 추가
		accountBook[indexCount] = new accountDto(dateTime, use, classify, money, memo);
		indexCount++;
	}
	
	// 삭제
	public void delete() {
		System.out.print("삭제할 데이터 = ");
		String use = sc.next();
		
		int index = search(use);
		if(index == -1) {
			System.out.println("데이터를 찾을 수 없습니다");
			return;
		}
		
		accountBook[index].setClassify("");
		accountBook[index].setDateTime("");
		accountBook[index].setMemo("");
		accountBook[index].setMoney(0);
		accountBook[index].setUse("");
		
		System.out.println("데이터를 삭제 하였습니다");
	}
	
	// 검색
	public void select() {
		System.out.println("검색할 날짜 >>");
		
		System.out.print("월 = ");
		int month = sc.nextInt();
		System.out.print("일 = ");
		int day = sc.nextInt();		// yyyy년 MM월 dd일 HH시mm분ss초
									//		 01  09 	
		String smonth = (month < 10)?"0"+month:""+month;
		String sday = (day < 10)?"0"+day:""+ day;	// 9,1  09,01
		
		for (int i = 0; i < accountBook.length; i++) {
			if(accountBook[i] != null && !accountBook[i].getUse().equals("")) {
				accountDto dto = accountBook[i];
				String dateTime = dto.getDateTime();
				
				String monthDay = dateTime.substring(6, 13);
			//	System.out.println(monthDay);
				
				String searchDay = smonth + "월 " + sday + "일";
			//	System.out.println(searchDay);
				if(searchDay.equals(monthDay)) {
					System.out.println(dto.toString());
				}
			}
		}			
	}
	
	// 수정
	public void update() {
		System.out.print("수정할 데이터 = ");
		String use = sc.next();
		
		int index = search(use);
		if(index == -1) {
			System.out.println("데이터를 찾을 수 없습니다");
			return;
		}
		
		System.out.print("수정할 금액 = ");
		int money = sc.nextInt();
		
		accountBook[index].setMoney(money);
		
		System.out.println("수정되었습니다");		
	}
	
	// 모두 출력
	public void allprint() {
		for (int i = 0; i < accountBook.length; i++) {
			if(accountBook[i] != null 
					&& !accountBook[i].getClassify().equals("")) {
				System.out.println(accountBook[i].toString());
			}
		}
	}
	
	// 조회
	public int search(String use) {
		int index = -1;
		for (int i = 0; i < accountBook.length; i++) {
			if(accountBook[i] != null && !accountBook[i].getUse().equals("")) {
				if(accountBook[i].getUse().contains(use)) {
					index = i;
					break;
				}
			}
		}		
		
		return index;
	}
	
	
}





