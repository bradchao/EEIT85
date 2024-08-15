package tw.brad.tutor;

import org.mindrot.BCrypt;

public class Brad66 {

	public static void main(String[] args) {
		String passwd = "123456";
		String newpasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(newpasswd);
		if (BCrypt.checkpw("123456", newpasswd)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	}

}
