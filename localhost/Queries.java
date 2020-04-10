
// import java.sql.ResultSet;
import java.sql.*;

public class Queries {
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
				p.in.nextLine();
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

		PreparedStatement s6 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter the publication_id of the record to which editor has to be assigned: ");

			String pub_id = p.in.nextLine();
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	// pending
	public static void deleteIssuePublication(User p) {

		PreparedStatement s7 = null;
		try {
			p.in.nextLine();
			System.out.println("\nEnter the publication_id of the record to which editor has to be assigned: ");

			String pub_id = p.in.nextLine();
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

	public static void findBook(User p) {

		PreparedStatement s12 = null;
		try {
			p.in.nextLine();
			System.out.println(
					"What do you want to search by? \n1) Date of creation (YYYY-MM-DD)\n2) Date of publication (YYYY-MM-DD) \n3) Topic\n4) Title\n");
			System.out.println("Enter you choice: ");
			int ch = p.in.nextInt();
			p.in.nextLine();
			if (ch == 1) {
				System.out.println("Enter a date of creation (YYYY-MM-DD): ");
				// String doc = p.in.nextLine();

				s12 = (PreparedStatement) p.conn.prepareStatement(
						"SELECT P.title, P.publication_id, P.typical_topics FROM Book B JOIN Publication P ON P.publication_id = B.publication_id  WHERE P.type = 'book' AND date_of_creation = '2018-10-10';");
				// s12.setString(1, doc);
				ResultSet rs = s12.executeQuery();
				System.out.println("###################################");
				System.out.println("Title\tPublication Id\tTypical Topics");
				System.out.println("###################################");

				while (rs.next()) {
					System.out.printf("%s\t%s\t%s", rs.getString("P.title"), rs.getString("P.publication_id"),
							rs.getString("P.typical_topics"));
					System.out.println();
				}
			} else if (ch == 2) {

			} else if (ch == 3) {

			} else if (ch == 4) {

			} else {
				System.out.println("Invalid Input!");
			}
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void findArticle(User p) {

		PreparedStatement s13 = null;
		try {
			System.out.println("\nEnter the publication_id of the record to which editor has to be assigned: ");

			String pub_id = p.in.nextLine();
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void enterPayementInfo(User p) {

		PreparedStatement s14 = null;
		try {
			System.out.println("\nEnter the publication_id of the record to which editor has to be assigned: ");
			String pub_id = p.in.nextLine();
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

	public static void viewPubInfoReponsible(User p) {
		PreparedStatement s18 = null;
		try {
			System.out.println("\nEnter the contributor id whose publication partners you want to know about: ");
			String contributorId = p.in.nextLine();
			s18 = (PreparedStatement) p.conn.prepareStatement(
					"SELECT * FROM Publication WHERE publication_id IN (SELECT publication_id FROM worksFor WHERE contributor_id = ?");
			s18.setString(1, contributorId);

			if (s18.executeUpdate() == 1)
				System.out.println("Info. Retrieved");
			else
				System.out.println("Sorry, the info. couldn't be added");
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void addArticles(User p) {
		PreparedStatement s19 = null;
		try {
			System.out.println("\nEnter the Article id and Issue id in which article is to inserted : ");
			String articleId = p.in.nextLine();
			String issueId = p.in.nextLine();
			s19 = (PreparedStatement) p.conn.prepareStatement("INSERT INTO consistOf VALUES (?,?)");
			s19.setString(1, articleId);
			s19.setString(2, issueId);

			if (s19.executeUpdate() == 1)
				System.out.println("Info. added");
			else
				System.out.println("Sorry, the info. couldn't be added");
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void deleteArticle(User p) {
		PreparedStatement s20 = null;
		try {
			System.out.println("\nEnter the article id and issue id from which an article is to be deleted : ");
			String articleId = p.in.nextLine();
			String issueId = p.in.nextLine();
			s20 = (PreparedStatement) p.conn
					.prepareStatement("DELETE FROM consistOf WHERE article_id = ? AND issue_id = ?");
			s20.setString(1, articleId);
			s20.setString(2, issueId);

			if (s20.executeUpdate() == 1)
				System.out.println("Info. Deleted");
			else
				System.out.println("Sorry, the info. couldn't be added");
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void addChapter(User p) {
		PreparedStatement s21 = null;
		try {
			System.out.println("\nEnter the Chapter id and Book ISBN in which chapter is to inserted : ");
			String chapterId = p.in.nextLine();
			String BookISBN = p.in.nextLine();
			s21 = (PreparedStatement) p.conn.prepareStatement(
					"INSERT INTO Chapter VALUES (9, 9, 'Black Widow', 'The best movie of 2020', 987654321);");
			s21.setString(1, chapterId);
			s21.setString(2, BookISBN);

			if (s21.executeUpdate() == 1)
				System.out.println("Info. added");
			else
				System.out.println("Sorry, the info. couldn't be added");
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

	public static void deleteChapter(User p) {
		PreparedStatement s20 = null;
		try {
			System.out.println("\nEnter the Chapter id and Book ISBN from which a chapter is to be deleted : ");
			String chapterId = p.in.nextLine();
			String BookISBN = p.in.nextLine();
			s22 = (PreparedStatement) p.conn.prepareStatement("DELETE FROM Chapter WHERE chapter = ?");
			s22.setString(1, chapterId);

			if (s22.executeUpdate() == 1)
				System.out.println("Info. Deleted");
			else
				System.out.println("Sorry, the info. couldn't be added");
		} catch (Exception e) {
			System.out.println("Error >>" + e);
		}
	}

}