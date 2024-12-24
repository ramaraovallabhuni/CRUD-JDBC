import java.sql.*;
import java.sql.PreparedStatement;
import java.util.*;

public class BatchProcessingStatements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
			Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/myDb" , "root" , "Vallabhuni@11" );
			
			Statement statement = connection.createStatement(); 
			
			
			Scanner scan = new Scanner( System.in );
			while( true ) {
				System.out.print("Enter Name : ");
				String name = scan.next();
				
				System.out.print("Enter Age : ");
				int age = scan.nextInt();
				
				System.out.print("Enter Marks : ");
				double marks = scan.nextDouble();
				
				String query = String.format( "INSERT into students(name , age , marks) values( '%s' , %d , %f ) " , name , age , marks );
				statement.addBatch( query );
				
				System.out.print( "Enter more (Y/N) : " );
				String check = scan.next();
				
				if( check.toUpperCase().equals( "N" ) ) {
					break;
				}
				
			}
			int[] arr = statement.executeBatch();
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

