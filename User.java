import java.util.Scanner;
import java.sql.*;

import java.util.Scanner;

public class User{
	Connection conn;
	int role;
	string id;
	int operation;
	Scanner in;

	public User(){
		this.conn = (Connection) GetConnection.connection();
		this.operation = 0;
		this.in = new Scanner(System.in);
	}

	public static int choose_role(){
		int chosen_role = 0;
		do{
			System.out.println("Who would you like to log in as?\npress 1 for Admin, 2 for Managers, 3 for Contributor, 4 for Distributor\n");
			Scanner in = new Scanner(System.in); 
			chosen_role = in.nextInt();
			if(chosen_role >= 1 || chosen_role <= 4){
				System.out.println("Role chosen successfully");
			}
			else{
				System.out.println("Incorrect input. Please enter a number between 1 and 4.");
			}
			
		}while(role < 1 || role > 4);
		return chosen_role;
	}

	public void list_of_operations(){
		switch(this.role){
			case 1:
				System.out.println("Hello Admin");
				break;

			case 2:
				System.out.println("Hello Managers, what would you like to do ?");
				// Enter all the operations managers could perform
				break;

			case 3:
				System.out.println("Hello Contributors, what are you doing today ?");
				// Enter all the operations Contributors could perform
				break;

			case 4:
				System.out.println("Hello Distributors, select operations from the list below ?");
				// Enter all the operations Distributors could perform
				break;

			this.operation = in.nextInt();
		}
	}

	public void run_query(){
		switch(this.operation){
			case 1:
				Queries.enter_new_publication(this);
				break;
			case 2:
				Queries.update_publication_info(this);
				break;

		}
	}


}