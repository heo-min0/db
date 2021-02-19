import jdbc.JdbcConnect;

public class MainClass {

	public static void main(String[] args) {
		
		JdbcConnect jc = new JdbcConnect();
	
		jc.getConnection();
		
	}

}
