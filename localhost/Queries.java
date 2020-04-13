
// import java.sql.ResultSet;
import java.sql.*;

public class Queries {
	public static void showTable(User p, String table) {
		PreparedStatement s0 = null;
		try {
			s0 = (PreparedStatement) p.conn.prepareStatement("select * from " + table);
			ResultSet r0 = s0.executeQuery();
			ResultSetMetaData meta = r0.getMetaData();
			int columnCount = meta.getColumnCount();
			System.out.println();
			System.out.println(table);
			System.out.println("###################################");
			for (int i = 1; i <= columnCount; i++) {
				String name = meta.getColumnName(i);
				System.out.printf("%s\t", name);
			}
			System.out.println("\n###################################");
			while (r0.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String name = meta.getColumnName(i);
					System.out.printf("%s\t", r0.getString(name));
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Error >>>" + e);
		}
	}

	public static void enterNewPublication(User p) {
		/* CRUD for a publication details */
		PreparedStatement s1 = null;

		try {
			p.in.nextLine();
			System.out.println("Enter following details: \n " + "1) Publication_id \n " + "2) Title \n "
					+ "3) Typical topics \n " + "4) Type \n " + "5) Periodicity \n");

			String publication_id = p.in.nextLine();
			String title = p.in.nextLine();
			String typical_topics = p.in.nextLine();
			String type = p.in.nextLine();
			String periodicity = p.in.nextLine();

			s1 = (PreparedStatement) p.conn.prepareStatement("INSERT INTO Publication VALUES (?,?,?,?,?)");
			s1.setString(1, publication_id);
			s1.setString(2, title);
			s1.setString(3, typical_topics);
			s1.setString(4, type);
			s1.setString(5, periodicity);

			if (s1.executeUpdate() == 1)
				System.out.println("Publication Info added");
			else
				System.out.println("Sorry, the Publication info. couldn't be added");
		} catch (Exception e) {
			System.out.println("Error >>>" + e);
		}
	}

	public static void updatePublication(User p) {
		String table = "Publication";
		showTable(p, table);
		PreparedStatement s2 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter the publication_id of the record to be updated: ");
			String pub_id = p.in.nextLine();

			System.out.println(
					"What do you want to update? \n1) Title \n2) Typical Topics \n3) Type \n4) Periodicity \n");
			System.out.println("Enter you choice: ");
			int ch = p.in.nextInt();
			p.in.nextLine();
			// p.in.nextLine();
			if (ch == 1) {
				// p.in.nextLine();
				System.out.println("Enter a new title: ");
				String title1 = p.in.nextLine();
				s2 = (PreparedStatement) p.conn
						.prepareStatement("UPDATE Publication SET title = ? WHERE publication_id = ?");

				s2.setString(1, title1);
				s2.setString(2, pub_id);
				if (s2.executeUpdate() == 1)
					System.out.println("Publication Info Updated!");
				else
					System.out.println("Couldn't update the Publication Info");
			} else if (ch == 2) {
				System.out.println("Enter the new typical_topics : ");
				String tt1 = p.in.nextLine();

				s2 = (PreparedStatement) p.conn
						.prepareStatement("UPDATE Publication SET typical_topics = ? WHERE publication_id = ?");

				s2.setString(1, tt1);
				s2.setString(2, pub_id);
				if (s2.executeUpdate() == 1)
					System.out.println("Publication Info Updated!");
				else
					System.out.println("Couldn't update the Publication Info");
			} else if (ch == 3) {
				System.out.println("Enter the new type : ");
				String type1 = p.in.nextLine();

				s2 = (PreparedStatement) p.conn
						.prepareStatement("UPDATE Publication SET type = ? WHERE publication_id = ?");

				s2.setString(1, type1);
				s2.setString(2, pub_id);
				if (s2.executeUpdate() == 1)
					System.out.println("Publication Info Updated!");
				else
					System.out.println("Couldn't update the Publication Info");
			} else if (ch == 4) {
				System.out.println("Enter the new periodicity : ");
				// p.in.nextLine();
				String period1 = p.in.nextLine();

				s2 = (PreparedStatement) p.conn
						.prepareStatement("UPDATE Publication SET periodicity = ? WHERE publication_id = ?");

				s2.setString(1, period1);
				s2.setString(2, pub_id);
				if (s2.executeUpdate() == 1)
					System.out.println("Publication Info Updated!");
				else
					System.out.println("Couldn't update the Publication Info");
			} else {
				System.out.println("Invalid Input!");
			}
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void assignEditor(User p) {
		String table = "Publication";
		Queries.showTable(p, table);
		table = "Contributor";
		Queries.showTable(p, table);
		PreparedStatement s3 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter the publication_id:");
			String pub_id = p.in.nextLine();
			System.out.println("\nEnter the Editor's id: ");
			String ed_id = p.in.nextLine();
			s3 = (PreparedStatement) p.conn.prepareStatement("INSERT INTO worksFor VALUES(?,?)");

			s3.setString(1, ed_id);
			s3.setString(2, pub_id);
			if (s3.executeUpdate() == 1)
				System.out.println("Info Updated!");
			else
				System.out.println("Couldn't update the Publication Info");

		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void newBookEdition(User p) {
		String table = "Publication";
		Queries.showTable(p, table);

		PreparedStatement s4 = null;
		try {
			p.in.nextLine();
			System.out.println("Enter following details: \n " + "1) ISBN \n " + "2) Publication ID \n "
					+ "3) Date of Creation (YYYY-MM-DD) \n " + "4) Date of Publication (YYYY-MM-DD)\n "
					+ "5) Edition No \n");

			String isbn = p.in.nextLine();
			String pubId = p.in.nextLine();
			String doc = p.in.nextLine();
			String dop = p.in.nextLine();
			String ed = p.in.nextLine();

			s4 = (PreparedStatement) p.conn.prepareStatement("INSERT INTO Book VALUES (?,?,?,?,?)");
			s4.setString(1, isbn);
			s4.setString(2, pubId);
			s4.setString(3, doc);
			s4.setString(4, dop);
			s4.setString(5, ed);

			if (s4.executeUpdate() == 1)
				System.out.println("Info. added");
			else
				System.out.println("Sorry, the info. couldn't be added");
		} catch (Exception e) {
			System.out.println("Error >>>" + e);
		}
	}

	public static void newIssuePublication(User p) {
		String table = "Publication";
		Queries.showTable(p, table);

		PreparedStatement s5 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter: \n1)Issue-ID\n2)Date of Issue (YYYY-MM-DD)\n3)Publication-ID\n");

			String issueId = p.in.nextLine();
			String doi = p.in.nextLine();
			String pubId = p.in.nextLine();
			s5 = (PreparedStatement) p.conn.prepareStatement("INSERT INTO Issue VALUES (?,?,?)");

			s5.setString(1, issueId);
			s5.setString(2, doi);
			s5.setString(3, pubId);

			if (s5.executeUpdate() == 1)
				System.out.println("Info. added");
			else
				System.out.println("Sorry, the info. couldn't be added");

		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	// Pending
	public static void deleteBookEdition(User p) {
		String table = "Book";
		Queries.showTable(p, table);
		PreparedStatement s6 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter the isbn of the book edition");
			String isbn = p.in.nextLine();
			s6 = (PreparedStatement) p.conn.prepareStatement("DELETE FROM `Book` WHERE `isbn` = ?");
			s6.setString(1, isbn);
			if (s6.executeUpdate() == 1) {
				System.out.println("This edition of the book is deleted");
			}
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	// pending
	public static void deleteIssuePublication(User p) {
		String table = "Issue";
		Queries.showTable(p, table);
		PreparedStatement s7 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter the id of the issue you want to delete: ");
			String issue_id = p.in.nextLine();
			s7 = (PreparedStatement) p.conn.prepareStatement("DELETE FROM `Issue` WHERE `issue_id` = ?");
			s7.setString(1, issue_id);
			if (s7.executeUpdate() == 1) {
				System.out.println("This issue is deleted");
			}
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void enterNewArticle(User p) {
		PreparedStatement s8 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter: \n1)Article-ID\n2)Date of creation (YYYY-MM-DD)\n3)content\n");

			String articleId = p.in.nextLine();
			String doc = p.in.nextLine();
			String content = p.in.nextLine();
			s8 = (PreparedStatement) p.conn.prepareStatement("INSERT INTO Article VALUES (?,?,?)");

			s8.setString(1, articleId);
			s8.setString(2, doc);
			s8.setString(3, content);

			if (s8.executeUpdate() == 1)
				System.out.println("Info. added");
			else
				System.out.println("Sorry, the info. couldn't be added");

		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void updateArticleInfo(User p) {
		String table = "Article";
		Queries.showTable(p, table);
		PreparedStatement s9 = null;
		try {
			p.in.nextLine();
			System.out.println("Enter an Article-ID: ");
			String articleId = p.in.nextLine();

			System.out.println("What do you want to update? \n1) Date of creation (YYYY-MM-DD) \n2) Content\n");
			System.out.println("Enter you choice: ");
			int ch = p.in.nextInt();
			p.in.nextLine();
			if (ch == 1) {
				System.out.println("Enter a date of creation (YYYY-MM-DD): ");
				String doc = p.in.nextLine();

				s9 = (PreparedStatement) p.conn
						.prepareStatement("UPDATE Article SET date_of_creation = ? WHERE article_id = ?");

				s9.setString(1, doc);
				s9.setString(2, articleId);
				if (s9.executeUpdate() == 1)
					System.out.println("Info. added");
				else
					System.out.println("Sorry, the info. couldn't be added");

			} else if (ch == 2) {
				System.out.println("Enter the content: ");
				String content = p.in.nextLine();
				s9 = (PreparedStatement) p.conn.prepareStatement("UPDATE Article SET content = ? WHERE article_id = ?");
				s9.setString(1, content);
				s9.setString(2, articleId);
				if (s9.executeUpdate() == 1)
					System.out.println("Info. added");
				else
					System.out.println("Sorry, the info. couldn't be added");
			} else {
				System.out.println("Invalid Input!");
			}
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}
	/*
	 * Not needed as ANkit has convered this in findBookArticle function
	 */
	// public static void findBook(User p) {

	// PreparedStatement s12 = null;
	// try {
	// p.in.nextLine();
	// System.out.println(
	// "What do you want to search by? \n1) Date of creation (YYYY-MM-DD)\n2) Date
	// of publication (YYYY-MM-DD) \n3) Topic\n4) Title\n");
	// System.out.println("Enter you choice: ");
	// int ch = p.in.nextInt();
	// p.in.nextLine();
	// if (ch == 1) {
	// System.out.println("Enter a date of creation (YYYY-MM-DD): ");
	// // String doc = p.in.nextLine();

	// s12 = (PreparedStatement) p.conn.prepareStatement(
	// "SELECT P.title, P.publication_id, P.typical_topics FROM Book B JOIN
	// Publication P ON P.publication_id = B.publication_id WHERE P.type = 'book'
	// AND date_of_creation = '2018-10-10';");
	// // s12.setString(1, doc);
	// ResultSet rs = s12.executeQuery();
	// System.out.println("###################################");
	// System.out.println("Title\tPublication Id\tTypical Topics");
	// System.out.println("###################################");

	// while (rs.next()) {
	// System.out.printf("%s\t%s\t%s", rs.getString("P.title"),
	// rs.getString("P.publication_id"),
	// rs.getString("P.typical_topics"));
	// System.out.println();
	// }
	// } else if (ch == 2) {

	// } else if (ch == 3) {

	// } else if (ch == 4) {

	// } else {
	// System.out.println("Invalid Input!");
	// }
	// } catch (Exception e) {
	// System.out.println("Error >>" + e);
	// }
	// }

	public static void findBookArticle(User p) {
		PreparedStatement s13 = null;
		try {
			p.in.nextLine();
			System.out.println(
					"What do you want to search by? \n1) Date of creation / publication (YYYY-MM-DD)\n2) Topic\n3) Author's name\n");
			System.out.println("Enter you choice: ");
			int ch = p.in.nextInt();
			p.in.nextLine();
			if (ch == 1) {
				System.out.println("Enter a date of creation / publication (YYYY-MM-DD): ");
				String date = p.in.nextLine();

				s13 = (PreparedStatement) p.conn.prepareStatement(
						"SELECT B.isbn AS 'Book/Article', publication_date AS Date FROM Book B WHERE publication_date = ? UNION SELECT A.article_id AS 'Book/Article', date_of_creation AS Date FROM Article A WHERE date_of_creation = ?");
				s13.setString(1, date);
				s13.setString(2, date);
				ResultSet rs = s13.executeQuery();
				System.out.println("###################################");
				System.out.println("Book / Article\tDate");
				System.out.println("###################################");

				while (rs.next()) {
					System.out.printf("%s\t%s", rs.getString("Book/Article"), rs.getString("Date"));
					System.out.println();
				}
			} else if (ch == 2) {
				System.out.println("Enter a topic to search by : ");
				String topic = p.in.nextLine();
				s13 = (PreparedStatement) p.conn.prepareStatement(
						"SELECT X.isbn AS 'Book/Article', Y.typical_topics AS Topic FROM Book X JOIN Publication Y ON X.publication_id = Y.publication_id WHERE title LIKE ? UNION SELECT A.article_id AS 'Book/Article' , C.typical_topics AS Topic FROM consistOf A JOIN Issue B ON A.issue_id = B.issue_id JOIN Publication C ON B.publication_id = C.publication_id  WHERE  typical_topics LIKE ?");
				s13.setString(1, topic + "%");
				s13.setString(2, topic + "%");

				ResultSet rs = s13.executeQuery();
				System.out.println("###################################");
				System.out.println("Book / Article\tTopic");
				System.out.println("###################################");

				while (rs.next()) {
					System.out.printf("%s\t%s", rs.getString("Book/Article"), rs.getString("Topic"));
					System.out.println();
				}
			} else if (ch == 3) {
				System.out.println("Enter Author name : ");
				String name = p.in.nextLine();
				s13 = (PreparedStatement) p.conn.prepareStatement(
						"SELECT B.isbn AS 'Book/Article', name FROM Book B JOIN bookAuthor BA ON B.isbn = BA.isbn JOIN Contributor C ON C.contributor_id = BA.author_id WHERE name = ? UNION SELECT D.article_id AS 'Book/Article', name FROM Article D JOIN articleAuthor E ON D.article_id = E.author_id JOIN Contributor F ON F.contributor_id = E.author_id WHERE name = ?");
				s13.setString(1, name);
				s13.setString(2, name);
				ResultSet rs = s13.executeQuery();
				System.out.println("###################################");
				System.out.println("Book / Article\tTopic");
				System.out.println("###################################");

				while (rs.next()) {
					System.out.printf("%s\t%s", rs.getString("Book/Article"), rs.getString("name"));
					System.out.println();
				}
			} else {
				System.out.println("Invalid Input!");
			}
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void enterPayementInfo(User p) {
		String table = "Contributor";
		Queries.showTable(p, table);
		PreparedStatement s14 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter\n1)Contributor-id\n2)Amount\n3)Payment date(YYYY-MM-DD)\n4)Payment-id\n");
			String contributor_id = p.in.nextLine();
			String amount = p.in.nextLine();
			String paymentDate = p.in.nextLine();
			String paymentID = p.in.nextLine();

			s14 = (PreparedStatement) p.conn.prepareStatement("INSERT INTO Pays VALUES(?, ?, ?, ?)");
			s14.setString(1, contributor_id);
			s14.setString(2, amount);
			s14.setString(3, paymentDate);
			s14.setString(4, paymentID);

			if (s14.executeUpdate() == 1)
				System.out.println("Payment Info added");
			else
				System.out.println("Payment Info couldn't be added!");

		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void trackPayment(User p) {
		String table = "Contributor";
		Queries.showTable(p, table);
		PreparedStatement s15 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter the contributor id to track payment : ");
			String contributor_id = p.in.nextLine();

			s15 = (PreparedStatement) p.conn.prepareStatement("SELECT * FROM Pays WHERE contributor_id = ?");
			s15.setString(1, contributor_id);

			ResultSet rs = s15.executeQuery();
			System.out.println("###################################");
			System.out.println("Payment id\tContributor id\tAmount\tDate");
			System.out.println("###################################");

			while (rs.next()) {
				System.out.printf("%s\t%s\t%s\t%s", rs.getString("payment_id"), rs.getString("contributor_id"),
						rs.getString("amount"), rs.getString("payment_date"));
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	// public static void findBook(User p) {

	// PreparedStatement s13 = null;
	// try {
	// System.out.println("\nEnter the publication_id of the record to which editor
	// has to be assigned: ");

	// String pub_id = p.in.nextLine();
	// }
	// catch (Exception e) {
	// System.out.println("Error >>" + e);
	// }
	// }
	// public static void enterPayementInfo(User p) {

	// PreparedStatement s14 = null;
	// try {
	// System.out.println("\nEnter the publication_id of the record to which editor
	// has to be assigned: ");

	// String pub_id = p.in.nextLine();
	// }
	// catch (Exception e) {
	// System.out.println("Error >>" + e);
	// }
	// }

	public static void enterNewDistributor(User p) {
		PreparedStatement s16 = null;
		try {
			p.in.nextLine();
			System.out.println(
					"\nEnter the new distributor details :\n1) Distributor ID\n2) Name\n3) Distributor type\n4) Address\n5) City\n6) Contact person \n7) Balance\n8) Phone number");
			String distributorId = p.in.nextLine();
			String name = p.in.nextLine();
			String distType = p.in.nextLine();
			String address = p.in.nextLine();
			String city = p.in.nextLine();
			String contactPerson = p.in.nextLine();
			String balance = p.in.nextLine();
			String phoneNo = p.in.nextLine();

			s16 = (PreparedStatement) p.conn.prepareStatement("INSERT INTO Distributor VALUES(?,?,?,?,?,?,?,?)");
			s16.setString(1, distributorId);
			s16.setString(2, name);
			s16.setString(3, distType);
			s16.setString(4, address);
			s16.setString(5, city);
			s16.setString(6, contactPerson);
			s16.setString(7, balance);
			s16.setString(8, phoneNo);

			if (s16.executeUpdate() == 1)
				System.out.println("New Distributor Added");
			else
				System.out.println("Sorry, the distributor couldn't be added");

		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void updateDistributor(User p) {
		String table = "Distributor";
		Queries.showTable(p, table);
		PreparedStatement s17 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter the distributor_id of the record to be updated: ");
			String distributorId = p.in.nextLine();

			System.out.println(
					"What do you want to update? \n1) name \n2) dist_type \n3) address \n4) city \n5) contact_person \n6) balance \n7) phone_number \n");
			System.out.println("Enter you choice: ");
			int ch = p.in.nextInt();
			p.in.nextLine();
			if (ch == 1) {
				System.out.println("Enter a new name: ");
				String name = p.in.nextLine();
				s17 = (PreparedStatement) p.conn
						.prepareStatement("UPDATE Distributor SET name = ? WHERE distributor_id = ?");

				s17.setString(1, name);
				s17.setString(2, distributorId);
				if (s17.executeUpdate() == 1)
					System.out.println("Distributor Info Updated!");
				else
					System.out.println("Couldn't update the Distributor Info");
			} else if (ch == 2) {
				System.out.println("Enter the new dist_type : ");
				String type = p.in.nextLine();

				s17 = (PreparedStatement) p.conn
						.prepareStatement("UPDATE Distributor SET dist_type = ? WHERE distributor_id = ?");

				s17.setString(1, type);
				s17.setString(2, distributorId);
				if (s17.executeUpdate() == 1)
					System.out.println("Distributor Info Updated!");
				else
					System.out.println("Couldn't update the Distributor Info");
			} else if (ch == 3) {
				System.out.println("Enter the new address : ");
				String address = p.in.nextLine();

				s17 = (PreparedStatement) p.conn
						.prepareStatement("UPDATE Distributor SET address = ? WHERE distributor_id = ?");

				s17.setString(1, address);
				s17.setString(2, distributorId);
				if (s17.executeUpdate() == 1)
					System.out.println("Distributor Info Updated!");
				else
					System.out.println("Couldn't update the Distributor Info");
			} else if (ch == 4) {
				System.out.println("Enter the new city : ");
				String city = p.in.nextLine();

				s17 = (PreparedStatement) p.conn
						.prepareStatement("UPDATE Distributor SET city = ? WHERE distributor_id = ?");

				s17.setString(1, city);
				s17.setString(2, distributorId);
				if (s17.executeUpdate() == 1)
					System.out.println("Distributor Info Updated!");
				else
					System.out.println("Couldn't update the Distributor Info");
			} else if (ch == 5) {
				System.out.println("Enter the new contact person : ");
				String contactPerson = p.in.nextLine();

				s17 = (PreparedStatement) p.conn
						.prepareStatement("UPDATE Distributor SET contact_person = ? WHERE distributor_id = ?");

				s17.setString(1, contactPerson);
				s17.setString(2, distributorId);
				if (s17.executeUpdate() == 1)
					System.out.println("Distributor Info Updated!");
				else
					System.out.println("Couldn't update the Distributor Info");
			} else if (ch == 6) {
				System.out.println("Enter the new balance : ");
				String balance = p.in.nextLine();

				s17 = (PreparedStatement) p.conn
						.prepareStatement("UPDATE Distributor SET balance = ? WHERE distributor_id = ?");

				s17.setString(1, balance);
				s17.setString(2, distributorId);
				if (s17.executeUpdate() == 1)
					System.out.println("Distributor Info Updated!");
				else
					System.out.println("Couldn't update the Distributor Info");
			} else {
				System.out.println("Invalid Input!");
			}
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void deleteDistributor(User p) {
		String table = "Distributor";
		Queries.showTable(p, table);
		PreparedStatement s18 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter the distributor id of the distributor you want to delete : ");
			String distributorId = p.in.nextLine();

			s18 = (PreparedStatement) p.conn.prepareStatement("DELETE FROM Distributor WHERE distributor_id = ?");
			s18.setString(1, distributorId);

			if (s18.executeUpdate() == 1)
				System.out.println("Info. Deleted");
			else
				System.out.println("Sorry, the info. couldn't be added");
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void addNewOrder(User p) {
		String table = "Distributor";
		Queries.showTable(p, table);
		table = "Book";
		Queries.showTable(p, table);
		table = "Issue";
		Queries.showTable(p, table);
		PreparedStatement s19 = null;
		try {
			p.conn.setAutoCommit(false);
			p.in.nextLine();
			System.out.println(
					"\nEnter the new order details with \nbook / issue of a publication for a distributor :\n1) Order ID\n2) Shipping cost\n3) Price\n4) Order date\n5) Number of copies\n6) Book ID\n7) Issue ID\n8) Payment Status\n9) Distributor ID\n10) Delivery date");
			String orderId = p.in.nextLine();
			String shippingCost = p.in.nextLine();
			String price = p.in.nextLine();
			String orderDate = p.in.nextLine();
			String noOfCopies = p.in.nextLine();
			String bookId = p.in.nextLine();
			String issueId = p.in.nextLine();
			String paymentStatus = p.in.nextLine();
			String distributorId = p.in.nextLine();
			String deliveryDate = p.in.nextLine();

			String publicationId = "";
			if (bookId == "NULL") {
				PreparedStatement s19_1 = null;
				s19_1 = (PreparedStatement) p.conn
						.prepareStatement("SELECT publication_id FROM Issue where issue_id = ?");
				s19_1.setString(1, issueId);
				ResultSet rs1 = s19_1.executeQuery();
				while (rs1.next()) {
					publicationId = rs1.getString("publication_id");
				}
			} else if (issueId == "NULL") {
				PreparedStatement s19_2 = null;
				s19_2 = (PreparedStatement) p.conn.prepareStatement("SELECT publication_id FROM Book where isbn = ?");
				s19_2.setString(1, bookId);
				ResultSet rs2 = s19_2.executeQuery();
				while (rs2.next()) {
					publicationId = rs2.getString("publication_id");
				}
			}

			if (publicationId == "") {
				try {
					p.conn.rollback();
					p.conn.setAutoCommit(true);
					System.out.println("Transaction failed");
					return;
				} catch (Exception e) {
					System.out.println(e);
				}
			}

			s19 = (PreparedStatement) p.conn.prepareStatement("INSERT INTO `Order` VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			s19.setString(1, orderId);
			s19.setString(2, shippingCost);
			s19.setString(3, price);
			s19.setString(4, orderDate);
			s19.setString(5, noOfCopies);
			s19.setString(6, bookId);
			s19.setString(7, issueId);
			s19.setString(8, paymentStatus);
			s19.setString(9, distributorId);
			s19.setString(10, deliveryDate);
			s19.setString(11, publicationId);

			if (s19.executeUpdate() == 1) {
				System.out.println("New Order Added");
			} else {
				System.out.println("Sorry, the order couldn't be added");
				p.conn.rollback();
				p.conn.setAutoCommit(true);
				System.out.println("Transaction failed");
			}
			p.conn.commit();
			p.conn.setAutoCommit(true);

		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void billDistributor(User p) {
		String table = "`Order`";
		Queries.showTable(p, table);
		PreparedStatement s20 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter the order id to bill distributor for :");
			String orderId = p.in.nextLine();
			s20 = (PreparedStatement) p.conn.prepareStatement(
					"SELECT SUM(price * no_of_copies + shipping_cost) AS Bill_Amount FROM `Order` WHERE order_id = ?");
			s20.setString(1, orderId);

			ResultSet rs = s20.executeQuery();
			System.out.println("###################################");
			System.out.println("Bill Amount");
			System.out.println("###################################");

			while (rs.next()) {
				System.out.printf("%s", rs.getString("Bill_Amount"));
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void changeOutstandingBalance(User p) {
		String table = "`Order`";
		Queries.showTable(p, table);

		PreparedStatement s21_1 = null;
		PreparedStatement s21_2 = null;
		PreparedStatement s21_3 = null;
		try {
			p.in.nextLine();
			p.conn.setAutoCommit(false);

			System.out.println("Enter the order_id of the order for which payment received :");
			String orderId = p.in.nextLine();
			s21_1 = (PreparedStatement) p.conn.prepareStatement(
					"SELECT shipping_cost, no_of_copies*price AS order_cost, distributor_id FROM `Order` WHERE order_id = ?");
			s21_1.setString(1, orderId);
			ResultSet rs_1 = s21_1.executeQuery();
			int shippingCost = 0;
			int orderCost = 0;
			String distributorId = "";

			while (rs_1.next()) {
				shippingCost = Integer.parseInt(rs_1.getString("shipping_cost"));
				orderCost = Integer.parseInt(rs_1.getString("order_cost"));
				distributorId = rs_1.getString("distributor_id");
			}

			if (distributorId == "") {
				try {
					p.conn.rollback();
					p.conn.setAutoCommit(true);
					System.out.println("Transaction failed");
					return;
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			// if (!rs_1.next()) {
			// try {
			// p.conn.rollback();
			// p.conn.setAutoCommit(true);
			// System.out.println("Transaction failed");
			// return;
			// } catch (Exception e) {
			// System.out.println(e);
			// }
			// }

			s21_3 = (PreparedStatement) p.conn
					.prepareStatement("UPDATE `Order` SET payment_status = 'paid' WHERE order_id = ?");
			s21_3.setString(1, orderId);
			s21_2 = (PreparedStatement) p.conn
					.prepareStatement("UPDATE Distributor SET balance = balance - (?+?) WHERE distributor_id = ?");

			s21_2.setInt(1, shippingCost);
			s21_2.setInt(2, orderCost);

			s21_2.setString(3, distributorId);

			if (s21_3.executeUpdate() != 1 || s21_2.executeUpdate() != 1) {
				try {
					p.conn.rollback();
					p.conn.setAutoCommit(true);
					System.out.println("Transaction failed");
					return;
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			p.conn.commit();
			p.conn.setAutoCommit(true);

		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void getMonthlyReport(User p) {

		PreparedStatement s22 = null;
		try {
			p.in.nextLine();
			System.out.println("\nMonthly Report");
			s22 = (PreparedStatement) p.conn.prepareStatement(
					"select sum(price*no_of_copies) AS total_amount, sum(no_of_copies) AS total_copies, distributor_id, DATE_FORMAT(order_date,'%M %Y') AS date, Book.publication_id from `Order`, `Book` where `Order`.book_id = `Book`.isbn group by distributor_id, publication_id, DATE_FORMAT(order_date,'%M %Y') UNION ALL select sum(price*no_of_copies), sum(no_of_copies), distributor_id, DATE_FORMAT(order_date,'%M %Y'), Issue.publication_id from `Order`, `Issue` where `Order`.issue_id = `Issue`.issue_id group by distributor_id, publication_id, DATE_FORMAT(order_date,'%M %Y')");

			ResultSet rs = s22.executeQuery();
			System.out.println("###################################");
			System.out.println("total\ttotal_copies\tdistributor_id\tDate\tpublication_id");
			System.out.println("###################################");

			while (rs.next()) {
				System.out.printf("%s\t%s\t%s\t%s\t%s", rs.getString("total_amount"), rs.getString("total_copies"),
						rs.getString("distributor_id"), rs.getString("date"), rs.getString("publication_id"));
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void totalRevenue(User p) {
		PreparedStatement s23 = null;
		try {
			p.in.nextLine();
			// System.out.println("\nTotal Revenue");
			s23 = (PreparedStatement) p.conn
					.prepareStatement("SELECT SUM(no_of_copies*price + shipping_cost) AS total FROM `Order`");

			ResultSet rs = s23.executeQuery();
			System.out.println("###################################");
			System.out.println("Total Revenue");
			System.out.println("###################################");

			while (rs.next()) {
				System.out.printf("%s", rs.getString("total"));
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void totalExpenses(User p) {
		PreparedStatement s24 = null;

		try {
			// p.in.nextLine();
			// // System.out.println("\nTotal shipping cost");
			// s24 = (PreparedStatement) p.conn.prepareStatement("SELECT SUM(shipping_cost)
			// FROM `Order`");
			// // int shippingCost = 0;
			// ResultSet rs1 = s24.executeQuery();
			// System.out.println("###################################");
			// System.out.println("Total shipping cost");
			// System.out.println("###################################");

			// while (rs1.next()) {
			// // shippingCost = Integer.parseInt(rs1.getString("SUM(shipping_cost)"));
			// System.out.printf("%s", rs1.getString("SUM(shipping_cost)"));
			// System.out.println();
			// }
			// s24 = (PreparedStatement) p.conn.prepareStatement("SELECT SUM(shipping_cost)
			// FROM `Order`");
			// int shippingCost = 0;
			// ResultSet rs1 = s24.executeQuery();
			// System.out.println("###################################");
			// System.out.println("Total shipping cost");
			// System.out.println("###################################");

			// while (rs1.next()) {
			// shippingCost = Integer.parseInt(rs1.getString("SUM(shipping_cost)"));
			// System.out.printf("%s", rs1.getString("SUM(shipping_cost)"));
			// System.out.println();
			// }

			// if (!rs1.next()) {
			// try {
			// p.conn.rollback();
			// p.conn.setAutoCommit(true);
			// System.out.println("Transaction failed");
			// return;
			// } catch (Exception e) {
			// System.out.println(e);
			// }
			// }

			s24 = (PreparedStatement) p.conn.prepareStatement("SELECT SUM(amount) FROM `Pays`");
			// int salaries = 0;
			ResultSet rs2 = s24.executeQuery();
			System.out.println("###################################");
			System.out.println("Total payment to editors & authors");
			System.out.println("###################################");

			while (rs2.next()) {
				// salaries = Integer.parseInt(rs2.getString("SUM(amount)"));
				System.out.printf("%s", rs2.getString("SUM(amount)"));
				System.out.println();
			}

			// if (!rs2.next()) {
			// try {
			// p.conn.rollback();
			// p.conn.setAutoCommit(true);
			// System.out.println("Transaction failed");
			// return;
			// } catch (Exception e) {
			// System.out.println(e);
			// }
			// }

			// System.out.printf("Total expenses on contributor salary is %d ", salaries);

			// p.conn.commit();
			// p.conn.setAutoCommit(true);
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void totalNumberOfDistributors(User p) {
		PreparedStatement s25 = null;
		try {
			p.in.nextLine();
			// System.out.println("\nTotal Number of distributors");

			s25 = (PreparedStatement) p.conn
					.prepareStatement("SELECT COUNT(distributor_id) AS Number_of_distributors FROM Distributor");

			ResultSet rs = s25.executeQuery();
			System.out.println("###################################");
			System.out.println("Number_of_distributors");
			System.out.println("###################################");

			while (rs.next()) {
				System.out.printf("%s", rs.getString("Number_of_distributors"));
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void totalRevenueOrder(User p) {
		PreparedStatement s26 = null;
		try {
			p.in.nextLine();
			System.out
					.println("Do you want the total revenue? \n1) per distributor \n2) per city \n3) per location \n");
			System.out.println("Enter your choice: ");
			int ch = p.in.nextInt();
			p.in.nextLine();
			if (ch == 1) {
				// payment status must be paid
				s26 = (PreparedStatement) p.conn.prepareStatement(
						"select Distributor.distributor_id, sum(price * no_of_copies + shipping_cost) as revenue from `Order` join Distributor on Order.distributor_id = Distributor.distributor_id where payment_status = 'paid' group by distributor_id");

				ResultSet rs = s26.executeQuery();
				System.out.println("###################################");
				System.out.println("Distributor ID\tRevenue");
				System.out.println("###################################");

				while (rs.next()) {
					System.out.printf("%s\t%s", rs.getString("distributor_id"), rs.getString("revenue"));
					System.out.println();
				}
			} else if (ch == 2) {
				// payment status must be paid
				s26 = (PreparedStatement) p.conn.prepareStatement(
						"select city, sum(price * no_of_copies + shipping_cost) as revenue from `Order` join Distributor on Order.distributor_id = Distributor.distributor_id where payment_status = 'paid' group by city");

				ResultSet rs = s26.executeQuery();
				System.out.println("###################################");
				System.out.println("City\tRevenue");
				System.out.println("###################################");

				while (rs.next()) {
					System.out.printf("%s\t%s", rs.getString("city"), rs.getString("revenue"));
					System.out.println();
				}
			} else if (ch == 3) {
				// payment status must be paid
				s26 = (PreparedStatement) p.conn.prepareStatement(
						"select address, sum(price * no_of_copies + shipping_cost) as revenue from `Order` join Distributor on Order.distributor_id = Distributor.distributor_id where payment_status = 'paid' group by address");

				ResultSet rs = s26.executeQuery();
				System.out.println("###################################");
				System.out.println("Location\tRevenue");
				System.out.println("###################################");

				while (rs.next()) {
					System.out.printf("%s\t%s", rs.getString("address"), rs.getString("revenue"));
					System.out.println();
				}
			} else {
				System.out.println("Invalid Input!");
			}

		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void viewPaymentPerWorkType(User p) {
		PreparedStatement s27 = null;
		try {
			p.in.nextLine();
			System.out.println("\nFollowing is the list of payments details to editors and authors per work type ");

			s27 = (PreparedStatement) p.conn.prepareStatement(
					"SELECT SUM(amount), Publication.type, Contributor.designation FROM `Pays` JOIN `Publication` ON Pays.publication_id = Publication.publication_id JOIN `Contributor` ON Pays.contributor_id = Contributor.contributor_id WHERE Publication.type IN (SELECT DISTINCT(type) FROM Publication) AND Contributor.designation IN (SELECT DISTINCT(designation) FROM Distributor) GROUP BY Publication.type, Contributor.designation");

			ResultSet rs = s27.executeQuery();
			System.out.println("###################################");
			System.out.println("Sum(Amount)\ttype\tdesignation");
			System.out.println("###################################");

			while (rs.next()) {
				System.out.printf("%s\t%s\t%s", rs.getString("SUM(amount)"), rs.getString("Publication.type"),
						rs.getString("Contributor.designation"));
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void viewPubInfoReponsible(User p) {
		String table = "`Contributor`";
		Queries.showTable(p, table);
		PreparedStatement s28 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter the contributor id whose publication partners you want to know about: ");
			String contributorId = p.in.nextLine();
			s28 = (PreparedStatement) p.conn.prepareStatement(
					"SELECT * FROM Publication WHERE publication_id IN (SELECT publication_id FROM worksFor WHERE contributor_id = ?)");
			s28.setString(1, contributorId);

			ResultSet rs = s28.executeQuery();
			System.out.println("###################################");
			System.out.println("publication_id\ttitle\ttypical_topics\ttype\tperiodicity");
			System.out.println("###################################");

			while (rs.next()) {
				System.out.printf("%s\t%s\t%s\t%s\t%s", rs.getString("publication_id"), rs.getString("title"),
						rs.getString("typical_topics"), rs.getString("type"), rs.getString("periodicity"));
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void addArticles(User p) {
		String table = "`Issue`";
		Queries.showTable(p, table);
		table = "`Article`";
		Queries.showTable(p, table);
		PreparedStatement s29 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter the Article id and Issue id in which article is to inserted : ");
			String articleId = p.in.nextLine();
			String issueId = p.in.nextLine();
			s29 = (PreparedStatement) p.conn.prepareStatement("INSERT INTO consistOf VALUES (?,?)");
			s29.setString(1, articleId);
			s29.setString(2, issueId);

			if (s29.executeUpdate() == 1)
				System.out.println("Info. added");
			else
				System.out.println("Sorry, the info. couldn't be added");
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void deleteArticle(User p) {
		String table = "consistOf";
		Queries.showTable(p, table);
		table = "`Article`";
		Queries.showTable(p, table);
		table = "`Issue`";
		Queries.showTable(p, table);
		PreparedStatement s30 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter the article id and issue id from which an article is to be deleted : ");
			String articleId = p.in.nextLine();
			String issueId = p.in.nextLine();
			s30 = (PreparedStatement) p.conn
					.prepareStatement("DELETE FROM consistOf WHERE article_id = ? AND issue_id = ?");
			s30.setString(1, articleId);
			s30.setString(2, issueId);

			if (s30.executeUpdate() == 1)
				System.out.println("Info. Deleted");
			else
				System.out.println("Sorry, the info. couldn't be added");
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void addChapter(User p) {
		String table = "`Book`";
		Queries.showTable(p, table);
		PreparedStatement s31 = null;
		try {
			p.in.nextLine();
			System.out
					.println("\nEnter the \n1) Chapter ID\n2) Chapter Number\n3) Chapter Name\n4) Content\n5) ISBN : ");
			String chapterId = p.in.nextLine();
			String chapterNo = p.in.nextLine();
			String chapterName = p.in.nextLine();
			String content = p.in.nextLine();
			String BookISBN = p.in.nextLine();

			s31 = (PreparedStatement) p.conn.prepareStatement("INSERT INTO Chapter VALUES (?, ?, ?, ?, ?);");
			s31.setString(1, chapterId);
			s31.setString(2, chapterNo);
			s31.setString(3, chapterName);
			s31.setString(4, content);
			s31.setString(5, BookISBN);

			if (s31.executeUpdate() == 1)
				System.out.println("Info. added");
			else
				System.out.println("Sorry, the info. couldn't be added");
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void deleteChapter(User p) {
		String table = "`Chapter`";
		Queries.showTable(p, table);

		PreparedStatement s32 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter the Chapter id to be deleted : ");
			String chapterId = p.in.nextLine();

			s32 = (PreparedStatement) p.conn.prepareStatement("DELETE FROM Chapter WHERE chapter_id = ?");
			s32.setString(1, chapterId);

			if (s32.executeUpdate() == 1)
				System.out.println("Info. Deleted");
			else
				System.out.println("Sorry, the info. couldn't be added");
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

}