import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.PreparedStatement;

public class PreparedStatementSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
			Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/myDb" , "root" , "Vallabhuni@11" );
//			Statement statement = connection.createStatement();
			String query = "INSERT into Students(name , age , marks) values(? , ? , ?) ";
			PreparedStatement preparedstatement = connection.prepareStatement( query );
			preparedstatement.setString( 1 , "Patlu" );
			preparedstatement.setInt( 2, 18 );
			preparedstatement.setDouble( 3, 79.67 );
			
			int rowsAffected = preparedstatement.executeUpdate();
//			ResultSet resultset = preparedstatement.executeQuery(); // use while retrieving data...
			if( rowsAffected > 0 ) {
				System.out.println( "Data Successfully Inserted...." );
			}
			else {
				System.out.println( "Data Un-Successfully to Inserted...." );
			}
			
		}
		catch( Exception e ) {
			System.out.println( e );
		}
	}

}
