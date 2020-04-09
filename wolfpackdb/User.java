package wolfpackdb;
import java.util.Scanner;
import java.sql.*;

import java.util.Scanner;

public class User {
	Connection conn;
	int role;
	String id;
	int operation;
	Scanner in;

	User() {
		// This is a User's constructor
		this.conn = (Connection) GetConnection.connection();
		this.operation = 0;
		this.in = new Scanner(System.in);
	}

	int choose_role() {
		int chosen_role = 0;
		// final Scanner in = new Scanner(System.in);
		do {
			System.out.println(
					"\nWho would you like to log in as? Enter"+
						"\n1: Manager" +
							"\n2: Contributor" +
								"\n3: Exit");
			System.out.println("\nEnter you choice: ");
			chosen_role = this.in.nextInt();
			this.in.close();
			if (chosen_role == 3){
				System.out.println("\nExiting...");
				break;
			}
			if (chosen_role >= 1 || chosen_role < 3) {
				System.out.println("Role chosen successfully");
			} 
			else {
				System.out.println("Incorrect input! Please enter a number between 1 and 4.");
			}

		} while (chosen_role < 1 || chosen_role > 3);
		
		return chosen_role;
	}

	void list_of_operations() {
		switch (this.role) {
			case 1:
				System.out.println("Hello Admin");
				break;

			case 2:
				System.out.println("Hello Managers, what would you like to do ?");
				// Enter all the operations managers could perform
				System.out.println("1: Enter new Publication Information");
				System.out.println("2: Update Publication Information");
				System.out.println("3: Assign Editors to Publication");

				System.out.println("6: Enter a new book edition of a Publication");
				System.out.println("7: Enter a new issue of a Publication");
				System.out.println("6: Delete book edition of a Publication");
				System.out.println("7: Delete issue of a Publication");

				System.out.println("8: Enter a new article");
				System.out.println("9: Update article info");
				System.out.println("10: Enter article text");
				System.out.println("11: Update article text");
				System.out.println("12: Find books by topic, date, author's name");
				System.out.println("13: Find articles by topic, date, author's name");
				System.out.println("14: Enter payment info for Contributors");
				System.out.println("15: Track payment info");

				System.out.println("2: Enter new Distributor");
				System.out.println("2: Update Distributor Information");
				System.out.println("2: Delete a Distributor");
				System.out.println("2: Enter new order Information for a distributor");
				System.out.println("2: Bill Distributor for an order");
				System.out.println("2: Change outstanding balance on receipt of payment");

				System.out.println(
						"22: Generate montly reports: number and total price of copies of each publication bought per distributor per month");
				System.out.println("23: Total revenue of publishing house");
				System.out.println("24: Total expenses of publishing house");
				System.out.println("25: Get total current number of distributors");
				System.out.println("25: Get total current number of distributors");
				System.out.println(
						"26: Calculate total revenue (since inception) per city, per distributor, and per location");
				System.out.println(
						"27: Calculate total payments to the editors and authors, per time period and per work type");

				break;

			case 3:
				System.out.println("Hello Contributors, what are you doing today ?");
				// Enter all the operations Contributors could perform
				System.out.println("28: View Publication info Contributor is reponsible for");
				System.out.println("4: Add Articles to periodic Publication");
				System.out.println("5: Delete articles from periodic Publication");
				System.out.println("6: Add Chapters to Book");
				System.out.println("7: Delete chapters from Book");
				break;

				this.operation = in.nextInt();
		}
	}

	public void run_query() {
		switch (this.operation) {
			case 1:
				Queries.enter_new_publication(this);
				break;
			case 2:
				Queries.update_publication_info(this);
				break;

		}
	}

}