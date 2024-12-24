import java.sql.*;
import java.sql.PreparedStatement;
import java.util.*;

public class BatchProcessingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
			Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/myDb" , "root" , "Vallabhuni@11" );
			
			String query = "INSERT into students(name , age , marks) values( ? , ? , ? ) ";
			PreparedStatement preparedStatement = connection.prepareStatement( query );
			
			Scanner scan = new Scanner( System.in );
			while( true ) {
				System.out.print("Enter Name : ");
				String name = scan.next();
				
				System.out.print("Enter Age : ");
				int age = scan.nextInt();
				
				System.out.print("Enter Marks : ");
				double marks = scan.nextDouble();
				
				preparedStatement.setString( 1 ,  name );
				preparedStatement.setInt( 2 ,  age );
				preparedStatement.setDouble( 3 ,  marks );
				
				preparedStatement.addBatch();
				
				System.out.print( "Enter more (Y/N) : " );
				String check = scan.next();
				
				if( check.toUpperCase().equals( "N" ) ) {
					break;
				}
				
			}
			int[] arr = preparedStatement.executeBatch();
				
//			for(int i=0 ; i<arr.length ; i++) {
//				if( arr[i] == 0 ) {
//					System.out.println( "Query " + (i+1) + " Failed " );
//				}
//			}
			if( arr.length>0 ) {
				System.out.println( "Multiple Date Successfully Inserted..." );
			}
			else {
				System.out.println( "No Data is Inserted..." );
			}
		}
		catch( Exception e ) {
			System.out.println( e );
		}
	}

}
