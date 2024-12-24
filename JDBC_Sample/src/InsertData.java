import java.sql.*;

public class InsertData {
	private static final String url = "jdbc:mysql://localhost:3306/myDb";
	private static final String userName = "root";
	private static final String password = "Vallabhuni@11";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
		}
		catch( Exception e ) {
			System.out.println( e );
		}
		
		try {
			Connection connection = DriverManager.getConnection( url , userName , password );
			
			Statement statement = connection.createStatement();
//			for(int i=0 ; i<2 ; i++) {
			String query = String.format( "insert into students(name , age , marks) values( '%s' , %o , %f )" , "Motu" , 18 , 89.89 );
			
			int rowsEffected = statement.executeUpdate( query );
			
			if( rowsEffected > 0 ) {
				System.out.println( "Data inserted SuccessFully...." );
			}
			else {
				System.out.println( "Data inserted is Un-SuccessFully...." );
			}
//			}
		}
		catch( Exception e ) {
			System.out.println( e );
		}
	}

}
