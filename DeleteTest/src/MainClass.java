import jdbc.DBConnection;
import jdbc.DeleteTest;

public class MainClass {

	public static void main(String[] args) {
		DBConnection.initConnection();
		
		DeleteTest dt = new DeleteTest();
		String name = "홍길동";
		boolean b = dt.delete(name);
		if (b) {
			System.out.println("정상 삭제");
		}else {
			System.out.println("실패");
		}
	}

}
