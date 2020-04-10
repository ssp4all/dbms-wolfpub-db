// import java.sql.*;
public class Wolfcity {

	public static void main(final String[] args) {
		System.out.println("##################################");
		System.out.println("\nWelcome to the Wolfcity Publishing House\n");
		System.out.println("##################################");

		User r = new User();
		// Boolean flag = true;
		r.choose_role();
		try {
			r.conn.close();
			r.in.close();
		} 
		catch (final Exception e) {
			System.out.println("WARNING: Connection could not be closed!\n" + e);
		}
		System.out.println("Thank You!");

	}
}