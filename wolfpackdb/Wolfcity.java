package wolfpackdb;

import java.sql.*;

public class Wolfcity {

	public static void main(String[] args) {
		System.out.println("Welcome to Wolfcity Publishing House!");

		User r = new User();
		Boolean flag = true;

		while (flag) {
			r.role = User.choose_role();

			while (p.role != 0) {
				r.list_of_operations();
				r.run_query();
				System.out.println("Press Enter to continue");
			}
		}
		try {
			r.conn.close();
			r.in.close();
		} catch (Exception e) {
			System.out.println("Connection could not be closed." + e);
		}
		System.out.println("Closed gracefully. Good Bye!");

	}
}