package com.zohoschool.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONObject;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addZSStudentServlet")
public class AddStudentServlet extends HttpServlet {
/**	 

*/
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
		try(BufferedReader reader = req.getReader()){
			if(reader!=null) {
				String line = reader.readLine();
				JSONObject obj = parseStringToJSON(line);
				Student student = parseStudent(obj);
				if(addStudent(student)) {
					res.getWriter().write("true");
				}
			}	
		}
	}
	private JSONObject parseStringToJSON(String jsonString){
		JSONObject obj = new JSONObject(jsonString);
		return obj;
	}
	private Student parseStudent(JSONObject jsonObject) {
		    Student student = new Student();
		    student.setFirstName(jsonObject.getString("firstName"));
	        student.setLastName(jsonObject.getString("lastName"));
	        student.setDateOfBirth(jsonObject.getString("dateOfBirth"));
	        student.setGender(jsonObject.getString("gender"));
	        student.setMobileNumber(jsonObject.getString("mobileNumber"));
	        student.setEmailId(jsonObject.getString("emailId"));
	        student.setDepartment(jsonObject.getString("department"));
	        student.setYearOfPassout(jsonObject.getString("yearOfPassout").substring(0,4));
	        student.setLocation(jsonObject.getString("location"));
	        return student;
	}
	private boolean addStudent(Student student) {
		
		try {
			return StudentJDBC.add(student);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}

