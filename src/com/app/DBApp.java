package com.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBApp {
	static Connection con;
	static PreparedStatement ps;
	DBApp(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/dbapp";
			String user="root";
			String password="";
			try {
				con=DriverManager.getConnection(url,user,password);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	public static void readAllRecords() throws SQLException {
		String query="select * from busBooking"; 
		//Create statement
		ps=con.prepareStatement(query);
		//Execute Query
		ResultSet rs= ps.executeQuery();
		System.out.println("ID\tName\tEmail\t\tDate\t\tMobileNo\t\tSource\t\tDestination\t\tSeat");
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		while(rs.next()) {
			System.out.print(rs.getInt("id"));
			System.out.print("\t"+rs.getString("name"));
			System.out.print("\t"+rs.getString("email"));
			System.out.print("\t"+rs.getString("date"));
			System.out.print("\t\t"+rs.getString("mobileno"));
			System.out.print("\t\t"+rs.getString("source"));
			System.out.print("\t\t"+rs.getString("destination"));
			System.out.println("\t\t"+rs.getInt("seat"));
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
	}
	public static void insertRecords(int id,String name,String email,String date,String mobileno,
		String source,String destination,int seat) throws SQLException {
		String query="insert into busBooking values(?,?,?,?,?,?,?,?)";
		ps=con.prepareStatement(query);
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.setString(3,email);
		ps.setString(4,date);
		ps.setString(5,mobileno);
		ps.setString(6,source);
		ps.setString(7,destination);
		ps.setInt(8,seat);
		int i=ps.executeUpdate();
		System.out.println(i+"Records Inserted");
		readAllRecords();
		
	}
	public static void deleteRecords(int id) throws SQLException {
		String query="delete from busBooking where id=? ";
		ps=con.prepareStatement(query);
		ps.setInt(1, id);
		int i=ps.executeUpdate();
		System.out.println(i+"deleted the records");
		readAllRecords();
	}
	public static void readOneRecord(int id) throws SQLException{
        String query = "select * from busbooking where id=?";
        ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        System.out.println("Name: " + rs.getString("name"));
        System.out.println("Email: " + rs.getString("email"));
        System.out.println("Date: " + rs.getString("date"));
        System.out.println("MobileNo: " + rs.getString("mobileno"));
        System.out.println("Source: " + rs.getString("source"));
        System.out.println("Destination: " + rs.getString("destination"));
        System.out.println("Seat: " + rs.getInt("seat"));
    }
	 public static void updateName(int id, String name) throws SQLException{
	        String query = "update busbooking set name=? where id=?";
	        ps = con.prepareStatement(query);
	        ps.setString(1, name);
	        ps.setInt(2, id);   
	        int i = ps.executeUpdate();
	        System.out.println(i + " Records Updated");
	        readAllRecords();     
	    }
	 public static void updateEmail(int id, String email) throws SQLException{
	        String query = "update busbooking set email=? where id=?";
	        ps = con.prepareStatement(query);
	        ps.setString(1, email);
	        ps.setInt(2, id);   
	        int i = ps.executeUpdate();
	        System.out.println(i + " Records Updated");
	        readAllRecords();     
	    }
	 public static void updateDate(int id, String date) throws SQLException{
	        String query = "update busbooking set date=? where id=?";
	        ps = con.prepareStatement(query);
	        ps.setString(1, date);
	        ps.setInt(2, id);   
	        int i = ps.executeUpdate();
	        System.out.println(i + " Records Updated");
	        readAllRecords();     
	    }
	 public static void updateMobileNo(int id, String mobileno) throws SQLException{
	        String query = "update busbooking set mobileno=? where id=?";
	        ps = con.prepareStatement(query);
	        ps.setString(1, mobileno);
	        ps.setInt(2, id);   
	        int i = ps.executeUpdate();
	        System.out.println(i + " Records Updated");
	        readAllRecords();     
	    }
	 public static void updateSource(int id, String source) throws SQLException{
	        String query = "update busbooking set source=? where id=?";
	        ps = con.prepareStatement(query);
	        ps.setString(1, source);
	        ps.setInt(2, id);   
	        int i = ps.executeUpdate();
	        System.out.println(i + " Records Updated");
	        readAllRecords();     
	    }
	 public static void updateDestination(int id, String destination) throws SQLException{
	        String query = "update busbooking set destination=? where id=?";
	        ps = con.prepareStatement(query);
	        ps.setString(1, destination);
	        ps.setInt(2, id);   
	        int i = ps.executeUpdate();
	        System.out.println(i + " Records Updated");
	        readAllRecords();     
	    }
	 public static void updateSeat(int id, int seat) throws SQLException{
	        String query = "update busbooking set seat=? where id=?";
	        ps = con.prepareStatement(query);
	        ps.setInt(1, seat);
	        ps.setInt(2, id);   
	        int i = ps.executeUpdate();
	        System.out.println(i + " Records Updated");
	        readAllRecords();     
	    }
	public static void main(String [] args) throws SQLException {
		new DBApp(); 
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1) Insert Records");
			System.out.println("2) Update Records");
			System.out.println("3) Delete Records");
			System.out.println("4) Read Records");
			System.out.println("5) Exit");
			System.out.println("Select the options :");
			int choice=sc.nextInt();
			int id;
			if(choice==5)
				break;
			try {
			switch(choice) {
			case 1:System.out.println("Enter the ID : ");
					id=sc.nextInt();
					System.out.println("Enter the Name : ");
					String name=sc.next();
					System.out.println("Enter the Email : ");
					String email=sc.next();
					System.out.println("Enter the Date");
					String date=sc.next();
					System.out.println("Enter your Contact Number : ");
					String mobileno=sc.next();
					System.out.println("Enter source");
					String source=sc.next();
					System.out.println("Enter Destination");
					String destination=sc.next();
					System.out.println("Enter Seat Number");
					int seat=sc.nextInt();
					insertRecords(id, name, email, date, mobileno, source, destination, seat);
					
			break;
			case 2:System.out.print("Enter the id whose records are to be updated: ");
            id = sc.nextInt();
            readOneRecord(id);
            System.out.println("What do you want to update?");
            System.out.println("a. Name");
            System.out.println("b. Email");
            System.out.println("c. Date");
            System.out.println("d. MobileNo");
            System.out.println("e. Source");
            System.out.println("f. Destination");
            System.out.println("g. Seat");
            System.out.print("Enter Your Choice: ");
            String ch = sc.next();

            switch(ch){
                case "a":   System.out.print("Enter New Name: ");
                            name = sc.next();
                            updateName(id, name);
                            break;
                case "b":   System.out.print("Enter New Email: ");
                            email = sc.next();
                            updateEmail(id, email);
                            break;
                case "c":   System.out.print("Enter New Date: ");
                            date = sc.next();
                            updateDate(id, date);
                            break;
                case "d":   System.out.print("Enter New MobileNo: ");
			                mobileno = sc.next();
			                updateMobileNo(id, mobileno);
			                break;
                case "e":   System.out.print("Enter New Sourde: ");
			                source = sc.next();
			                updateSource(id, source);
			                break;
                case "f":   System.out.print("Enter New Destination: ");
			                destination = sc.next();
			                updateDestination(id, destination);
			                break;
                case "g":   System.out.print("Enter New Seat: ");
			                seat = sc.nextInt();
			                updateSeat(id, seat);
			                break;
            }
            break;
			case 3:System.out.println("Enter the Id whoes record to be deleted");
					id=sc.nextInt();
					deleteRecords(id);
					break;
			case 4:readAllRecords();
			break;
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
			
	}
}