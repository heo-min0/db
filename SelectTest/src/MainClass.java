import java.util.List;

import jdbc.DBConnection;
import jdbc.SelectTest;
import jdbc.UserDTO;

public class MainClass {

	public static void main(String[] args) {
		DBConnection.initConnection(); //1번만 호출 셀랙 클래스생성자에 넣어주는게 나음
		
		SelectTest st = new SelectTest();
		String id = "bcd";
		UserDTO dto = st.search(id);
		if (dto != null) {
			System.out.println(dto.toString());
		}else {
			System.out.println("데이터 없음");
		}

		id = "cde";
		UserDTO user = st.select(id);
		if (user != null) {
			System.out.println(user.toString());
		}else {
			System.out.println("데이터 없음");
		}
		
		/*System.out.println("--------------------");
		List<UserDTO> list = st.getUserList();
		
		for (UserDTO userDTO : list) {
			System.out.println(userDTO.toString());
		}*/
		
		System.out.println("--------------------");
		List<UserDTO> list = st.getUserList(20);
		
		for (UserDTO userDTO : list) {
			System.out.println(userDTO.toString());
		}
	}

}
