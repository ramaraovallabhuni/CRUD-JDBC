import java.util.*;
import java.sql.*;
import java.sql.PreparedStatement;

public class TransactionControl {
	
	private static final String url = "jdbc:mysql://localhost:3306/Transactions";
	private static final String userName = "root";
	private static final String password = "Vallabhuni@11";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
//			Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/Transactions" , "root" , "Vallabhuni@11" );
			Connection connection = DriverManager.getConnection( url , userName , password );
			connection.setAutoCommit( false );
			
			Scanner scan = new Scanner( System.in );
			String debit_Query = "update accounts set amount = amount - ? where ACCno = ? ";
			String credit_Query = "update accounts set amount = amount + ? where ACCno = ? ";
			
			System.out.print( "Debit Account Number : " );
			int deb_accNo = scan.nextInt();
			System.out.print( "Debit Ammount : " );
			double deb_amount = scan.nextDouble();
			
			System.out.println();
			System.out.print( "Crediting Account Number : " );
			int cred_accNo = scan.nextInt();
			
			PreparedStatement debt_Statement = connection.prepareStatement( debit_Query );
			PreparedStatement cred_Statement = connection.prepareStatement( credit_Query );
			
			debt_Statement.setDouble(1 ,  deb_amount);
			debt_Statement.setInt(2 ,  deb_accNo);
			cred_Statement.setDouble(1 ,  deb_amount);
			cred_Statement.setInt(2 ,  cred_accNo);
			
			
			debt_Statement.executeUpdate();
			cred_Statement.executeUpdate();
			if( isSufficientPayment( connection , deb_accNo , deb_amount ) ) {
				connection.commit();
				System.out.println( "Transaction Successfull...!" );
			}
			else {
				connection.rollback();
				System.out.println( "Unsufficient Funds...!" );
			}
			
			
		}
		catch( Exception e ) {
			System.out.println( e );
		}
	}
	
	public static boolean isSufficientPayment( Connection connection , int accNo , double Amount ) {
		if( Amount < 0 ) return false;
		try {
			String query = "Select amount from accounts where ACCno = ?";
			PreparedStatement prepStr = connection.prepareStatement( query );
			prepStr.setInt(1, accNo);
			ResultSet resultset = prepStr.executeQuery();
			
//			System.out.println( resultset.getDouble( "Amount" ) + "  " + accNo + "  " + Amount );
			if( resultset.next()  ) {
				double curr_balance = resultset.getDouble( "Amount" );
				if( Amount > curr_balance ) {
					return false;
				}
				return true;
			}
			else {
				return false;
			}
		}
		catch( Exception e ) {
			System.out.println( e );
		}
		return false;
	}

}
