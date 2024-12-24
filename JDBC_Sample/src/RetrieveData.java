import java.sql.*;

public class RetrieveData {
	private static final String url = "jdbc:mysql://localhost:3306/myDb";
	private static final String username = "root";
	private static final String password = "Vallabhuni@11";
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName( "com.msql.cj.jdbc.Driver" );
		}
		catch( Exception e ) {}
		try {
			Connection connection = DriverManager.getConnection( url , username , password );
			Statement statement = connection.createStatement();
			
			String query = "select * from students where id<4 ";
			ResultSet resultset = statement.executeQuery( query );
			
			while( resultset.next() ) {
				System.out.println( "id : " + resultset.getInt("id") );
				System.out.println( "name : " + resultset.getString("name") );
			}
		}
		catch( Exception e ) {}
	}

}
