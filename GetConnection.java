
import java.sql.*;

public class GetConnection {
    // Initialize class variables to create a connection
    static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/atiwari4";
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet result = null;

    public static Connection connection() {
        // Establishes a connection with a remote mariaDB server
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            final String user = "atiwari4";
            final String password = "dbmsscammers";
            connection = DriverManager.getConnection(jdbcURL, user, password);
            System.out.println("\nThe connection has been established!");
            statement = connection.createStatement();
            connection.setCatalog("atiwari4");
            return connection;
        } 
        catch (final Exception e) {
            System.out.println("Error >>" + e);
            // System.out.println(e);
        }
        return null;
    }

    public static void main(String args[]){
        Connection con = connection();
        System.out.println(con);
    }

    static void close(final Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } 
            catch (final Throwable whatever) {
            }
        }

    
    }

    static void close(final Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } 
            catch (final Throwable whatever) {
            }
        }
    }

    static void close(final ResultSet result) {
        if (result != null) {
            try {
                result.close();
            } 
            catch (final Throwable whatever) {
            }
        }
    }

}
