import java.sql.*;

public class SetConnection {
	     // Initialize class variables to create a connection
        static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/atiwari4";
        private static Connection connection = null;
        private static Statement statement = null;
        private static ResultSet result = null;
        public static Connection connection() {
              try{
                	Class.forName("org.mariadb.jdbc.Driver");
                	String user = "atiwari4";
                	String password = "dbmsscammers";
                	connection = DriverManager.getConnection(jdbcURL, user, password);
			            System.out.println("now the connection is estb");
                	statement = connection.createStatement();
                	connection.setCatalog("atiwari4");
               		return connection;
               }catch(Exception e){ System.out.println(e);}
		          return null;
       }

	      static void close(Connection connection) {
               if(connection != null) {
                   try {
                       connection.close();
                   } catch(Throwable whatever) {}
                }
        }
        static void close(Statement statement) {
               if(statement != null) {
		               try{
                   statement.close();
                   } catch(Throwable whatever) {}
               }
        }
        static void close(ResultSet result) {
              if(result != null) {
                  try {
                  result.close();
              } catch(Throwable whatever) {}
              }
        }

}
