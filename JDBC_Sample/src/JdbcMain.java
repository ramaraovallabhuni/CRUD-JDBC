import java.sql.*;
import java.lang.String;

public class JdbcMain {
	private static final String url = "jdbc:mysql://localhost:3306/myDb" ;
	private static final String UserName = "root" ;
	private static final String Password = "Vallabhuni@11" ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
		}
		catch( ClassNotFoundException e ) {
//			e.printStackTrace();
			System.out.println( e.getMessage() );
		}
		
		try {
			Connection connection = DriverManager.getConnection( url , UserName , Password );
			Statement statement = connection.createStatement();
			
			
			//                    *** 1.1 Retrieving Data ***
//			String query = "select * from students";
//			ResultSet resultSet = statement.executeQuery( query );
//			
//			while( resultSet.next() ) {
//				int id = resultSet.getInt( "id" );
//				String name = resultSet.getString( "name" );
//				int age = resultSet.getInt( "age" );
//				double marks = resultSet.getDouble( "marks" );
//				System.out.println( id + " : " + name + " " + age + " " + marks );
//			}
			
			//                    *** 1.2 Data Insertion/Updation ***
//			String query = "insert into students(name,age,marks) values('Shiva' ,'21' ,97.3)";
//			String query = String.format("insert into students(name,age,marks) values('%s',%o,%f)" , "Shiva" , 21 , 97.3 );
//			int rowsAffected = statement.executeUpdate( query );
//			if( rowsAffected > 0 ) {
//				System.out.println( "Data inserted successfully...");
//			}
//			else {
//				System.out.println( "Data insertion is unsuccessfully...");
//			}
			
			//                   *** 1.3 Set/Updation of values ***
//			String query = String.format( "update students set marks = %f where name = '%s' ", 96.96 , "Shiva");
//			int rowsAffected = statement.executeUpdate( query );
//			if( rowsAffected > 0 ) {
//				System.out.println( "Data Updation successfully...");
//			}
//			else {
//				System.out.println( "Data Updation is unsuccessfully...");
//			}
			
		//          *** 1.4 Deletion of row/attribute ***
			String query = String.format( "delete from students where name = '%s' ", "Shiva");
			int rowsAffected = statement.executeUpdate( query );
			if( rowsAffected > 0 ) {
				System.out.println( "Data Deletion successfully...");
			}
			else {
				System.out.println( "Data Deletion is unsuccessfully...");
			}
		}
		catch( Exception e ) { // SQLException
			System.out.println( e.getMessage() );
		}
	}

}
