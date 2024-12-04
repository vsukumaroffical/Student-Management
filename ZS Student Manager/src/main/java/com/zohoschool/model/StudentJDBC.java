package com.zohoschool.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentJDBC {
	private static String url = "jdbc:mysql://localhost:3306/utildb";
	private static String uname = "root";
	private static String password = "mysql";

	public static boolean add(Student student) throws SQLException {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		String sql = "INSERT INTO student_details(first_name,last_name,date_of_birth,gender,"
				+ "mobile_number,emailID,department,yearOfPassout,location)" + " VALUES(?,?,?,?,?,?,?,?,?)";

		Connection con = DriverManager.getConnection(url, uname, password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, student.getFirstName());
		st.setString(2, student.getLastName());
		st.setString(3, student.getDateOfBirth());
		st.setString(4, student.getGender());
		st.setString(5, student.getMobileNumber());
		st.setString(6, student.getEmailId());
		st.setString(7, student.getDepartment());
		st.setString(8, student.getYearOfPassout());
		st.setString(9, student.getLocation());
		return st.executeUpdate() > 0;
	}
	public static List<Student> getStudentList() throws SQLException{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Connection con = DriverManager.getConnection(url, uname, password);
		String sql = "SELECT * FROM student_details";	
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery(sql);
		
		List<Student> list = new ArrayList<>();
		while(result.next()) 
		{
			Student student = new Student();
			student.setFirstName(result.getString(1));
			student.setLastName(result.getString(2));
			student.setDateOfBirth(result.getString(3));
			student.setGender(result.getString(4));
			student.setMobileNumber(result.getString(5));
			student.setEmailId(result.getString(6));
			student.setDepartment(result.getString(7));
			student.setYearOfPassout(result.getString(8));
			student.setLocation(result.getString(9));
			list.add(student);
		}
		return list;
		
	}
	
}
