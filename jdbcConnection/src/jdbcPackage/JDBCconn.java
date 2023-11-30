package jdbcPackage;
import java.sql.*;

public class JDBCconn 
{
	public static void main(String[] args)
	{
		Connection conn=null;
		Statement stat= null;
		ResultSet rs = null;
		
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println("problem in loading the driver");
			ex.printStackTrace();
		}
		
		try {
			String db = "Employee.accdb";
			String dbURL = "jdbc.ucanaccess://" + db;
			conn = DriverManager.getConnection(dbURL);
			stat = conn.createStatement();
			rs = stat.executeQuery("SELECT * FROM EMPLOYEE");
			int id;
			while (rs.next())
			{
				System.out.print ("Name: " + rs.getString(2)  + "ID: "  + rs.getInt(1)  );
			}
			rs.close();
			stat.close();
			conn.close();
		}
		catch (SQLException ex)
		{
			System.out.println("Database not connected!");
		}
		
	}
}
