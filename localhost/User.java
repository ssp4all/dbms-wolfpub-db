import java.util.Scanner;
import java.sql.*;

public class User {
	// About to add more details here...
	Connection conn;
	int role;
	int operation;
	Scanner in;

	User() {
		// This is a User's constructor
		this.role = 0;
		this.conn = (Connection) GetConnection.connection();
		this.operation = 0;
		this.in = new Scanner(System.in);
	}

	void choose_role() {
		// Boolean flag = true;
		do {
			System.out.println("\nWho would you like to log in as? Enter" + "\n1: Manager" + "\n2: Contributor" +
			// "\n3: Want to change you role?" +
					"\n99: Exit\n");
			System.out.println("\nEnter you choice: ");
			this.role = this.in.nextInt();
			if (this.role == 99) {
				System.out.println("Thank You\nExiting...");
				System.exit(1);
				// break;
			}
			if (this.role == 1 || this.role == 2) {
				System.out.println("Role chosen successfully!");
				this.list_of_operations();
			}
			// else if (this.role == 3){
			// return flag;
			// }
			else {
				System.out.println("Incorrect input!");
			}

		} while (this.role >= 1 || this.role < 3);
	}

	void list_of_operations() {
		switch (this.role) {
		case 1:
			System.out.println("Hello Manager\n");
			// Enter all the operations managers could perform
			System.out.println("1: Enter new Publication Information");
			System.out.println("2: Update Publication Information");
			System.out.println("3: Assign Editors to Publication");

			System.out.println("4: Enter a new book edition of a Publication");
			System.out.println("5: Enter a new issue of a Publication");
			System.out.println("6: Delete book edition of a Publication");
			System.out.println("7: Delete issue of a Publication");

			System.out.println("8: Enter a new article");
			System.out.println("9: Update article info");
			// System.out.println("11: Update article text");

			System.out.println("13: Find book , articles by topic, date, author's name");
			System.out.println("14: Enter payment info for Contributors");
			System.out.println("15: Track payment info");

			System.out.println("16: Enter new Distributor");
			System.out.println("17: Update Distributor Information");
			System.out.println("18: Delete a Distributor");
			System.out.println("19: Enter new order Information for a distributor");
			System.out.println("20: Bill Distributor for an order");
			System.out.println("21: Change outstanding balance on receipt of payment");

			System.out.println(
					"22: Generate montly reports: number and total price of copies of each publication bought per distributor per month");
			System.out.println("23: Total revenue of publishing house");
			System.out.println("24: Total expenses of publishing house");
			System.out.println("25: Get total current number of distributors");
			System.out.println(
					"26: Calculate total revenue (since inception) per city, per distributor, and per location");
			System.out.println(
					"27: Calculate total payments to the editors and authors, per time period and per work type");
			break;

		case 2:
			System.out.println("Hello Contributors!");
			// Enter all the operations Contributors could perform
			System.out.println("28: View Publication info Contributor is reponsible for");
			System.out.println("29: Add Articles to periodic Publication");
			System.out.println("30: Delete articles from periodic Publication");
			System.out.println("31: Add Chapters to Book");
			System.out.println("32: Delete chapters from Book");
			break;

		case 99:
			System.out.println("\nThank You!\nExiting...");
			System.exit(0);
			break;

		default:
			System.out.println("Invalid Input!");
			break;
		}
		this.operation = this.in.nextInt();
		this.run_query();
	}

	void run_query() {
		switch (this.operation) {
		case 1:
			Queries.enterNewPublication(this);
			break;
		case 2:
			Queries.updatePublication(this);
			break;
		case 3:
			Queries.assignEditor(this);
			break;
		case 4:
			Queries.newBookEdition(this);
			break;
		case 5:
			Queries.newIssuePublication(this);
			break;
		case 6:
			Queries.deleteBookEdition(this);
			break;
		case 7:
			Queries.deleteIssuePublication(this);
			break;
		case 8:
			Queries.enterNewArticle(this);
			break;
		case 9:
			Queries.updateArticleInfo(this);
			break;
		// case 11:
		// Queries.updateArticleText(this);
		// break;
		case 12:
			Queries.findBook(this);
			break;
		case 13:
			Queries.findBookArticle(this);
			break;
		case 14:
			Queries.enterPayementInfo(this);
			break;

		case 16:
			Queries.enterNewDistributor(this);
			break;
		case 17:
			Queries.updateDistributor(this);
			break;
		case 18:
			Queries.deleteDistributor(this);
			break;
		case 19:
			Queries.addNewOrder(this);
			break;
		case 20:
			Queries.billDistributor(this);
			break;
		case 21:
			Queries.changeOutstandingBalance(this);
			break;
		case 22:
			Queries.getMonthlyReport(this);
			break;
		case 23:
			Queries.totalRevenue(this);
			break;
		case 24:
			Queries.totalExpenses(this);
			break;
		case 25:
			Queries.totalNumberOfDistributors(this);
			break;
		case 26:
			Queries.totalRevenue(this);
			break;
		case 27:
			Queries.viewPaymentPerWorkType(this);
			break;

		case 28:
			Queries.viewPubInfoReponsible(this);
			break;
		case 29:
			Queries.addArticles(this);
			break;
		case 30:
			Queries.deleteArticle(this);
			break;
		case 31:
			Queries.addChapter(this);
			break;
		case 32:
			Queries.deleteChapter(this);
			break;
		default:
			break;
		}
	}

}