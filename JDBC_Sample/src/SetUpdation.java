import java.sql.*;

public class SetUpdation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
			Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/myDb" , "root" , "Vallabhuni@11");
			Statement statement = connection.createStatement();
			
			String query = String.format("update students set age = %d where name = '%s' ", 17 , "Ram" );
//			String query = String.format("delete from students where id > %d", 5 );
			int rowsAffected = statement.executeUpdate( query );
			
			if( rowsAffected > 0 ) {
				System.out.println( "Data Successfully.... Updated ");
			}
			else {
				System.out.println( "Data is Un-Successful to update.... ");
			}
			
		}
		catch( Exception e ) {
			System.out.println( e );
		}
	}

}
