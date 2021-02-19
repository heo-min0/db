import jdbc.InsertTest;

public class MainClass {

	public static void main(String[] args) {
		
		InsertTest it = new InsertTest();
		int count = it.insertData("aaa", "일이삼", 14);
		count = it.insertData("bbb", "나어림", 8);
		count = it.insertData("ccc", "나늙음", 72);
		if (count >= 1) {
			System.out.println("데이터 " + count + "개 추가");
		} else {
			System.out.println("추가 실패");
		}
	}
	/*int count = it.insertData("abc", "홍길동", 24);
	count = it.insertData("bcd", "성춘향", 21);
	count = it.insertData("cde", "일지매", 22);*/
}
