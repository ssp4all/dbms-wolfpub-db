/*

Wolfcity.java
This file should be executed first.

$ javac Wolfcity.java
$ java Wolfcity

Contains main function which creates connection 
object to interact with database.
*/

public class Wolfcity {

	// The main() which is called when Wolfcity.java is execute on command line
	public static void main(final String[] args) {
		System.out.println("##################################");
		System.out.println("\nWelcome to the Wolfcity Publishing House\n");
		System.out.println("##################################");

		User r = new User(); // Create new user object using User.java
		// Boolean flag = true;
		r.choose_role(); // Role is chosen using member functions of User
		try {
			r.conn.close();
			r.in.close();
		} catch (final Exception e) {
			System.out.println("WARNING: Connection could not be closed!\n" + e);
		}
		System.out.println("Thank You!");

	}
}