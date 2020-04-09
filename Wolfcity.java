package wolfpackdb;
// import wolfpackdb.User;
// import wolfpackdb.User;
import java.sql.*;

public class Wolfcity {

	public static void main(final String[] args) {
		System.out.println("Welcome to the Wolfcity Publishing House\n");

		User r = new User();
		Boolean flag = true;

		while (flag) {
			r.role = r.choose_role();

			while (r.role != 0) {
				r.list_of_operations();
				r.run_query();
				System.out.println("Press Enter to continue");
			}
		}
		try {
			r.conn.close();
			r.in.close();
		} 
		catch (final Exception e) {
			System.out.println("Connection could not be closed!" + e);
		}
		System.out.println("Thank You!");

	}
}