package com.zohoschool.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getZSStudentList")

public class GetStudentListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		try {
			res.setContentType("application/json");
			List<Student> studentList = StudentJDBC.getStudentList();
			JSONArray jsonResponse = new JSONArray();

			for (Student student : studentList) {
				JSONObject obj = new JSONObject();
				obj.put("firstName", student.getFirstName());
				obj.put("lastName", student.getLastName());
				obj.put("dateOfBirth", student.getDateOfBirth());
				obj.put("gender", student.getGender());
				obj.put("mobileNumber", student.getMobileNumber());
				obj.put("emailID", student.getEmailId());
				obj.put("department", student.getDepartment());
				obj.put("yearOfPassout", student.getYearOfPassout());
				obj.put("location", student.getLocation());

				jsonResponse.put(obj);
			}
			res.getWriter().write(jsonResponse.toString());

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
