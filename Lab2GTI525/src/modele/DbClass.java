package modele;
import java.sql.*;

public class DbClass {
    public String sUrl="jdbc:sqlite:C:/Users/Hani/workspace/Lab2GTI525/BD/bd.sqlite"; // for advertising and debug purposes
    private String sDriverName = "org.sqlite.JDBC"; 
    private Connection conn = null;
    private Statement stmt = null;
 
    public DbClass() {
    
        try {
			setConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    private void setConnection() throws Exception {
        try {
            Class.forName(sDriverName);
        } catch (Exception e) {
            // connection failed.
            System.out.println("DriverName: " + sDriverName
                    + " was not available");
            System.err.println(e);
            throw e;
        }
            // create a database connection
            conn = DriverManager.getConnection(sUrl);
            try {
                stmt = conn.createStatement();
            } catch (Exception e) {
                try { conn.close(); } catch (Exception ignore) {}
                conn = null;
            }
    }
 
    // this method should undoubtedly be public as we'll want to call this
    // to close connections externally to the class
    public void closeConnection() {
        if (stmt!=null) { try { stmt.close(); } catch (Exception ignore) {} }
        if (conn!=null) { try { conn.close(); } catch (Exception ignore) {} }
    }
 
    // and we will definitely want to be able to call the following two
    // functions externally since they expose the database
    // behaviour which we are trying to access
    public ResultSet executeQuery(String instruction) throws SQLException {
        return stmt.executeQuery(instruction);
    }
 
    public void execute(String instruction) throws SQLException {
        stmt.executeUpdate(instruction);
    }
 
}