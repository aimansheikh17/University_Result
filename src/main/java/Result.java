

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Result extends HttpServlet {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	PrintWriter pw =null;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/University_Result";
	String username = "root";
    String password = "Aiman";
	String sql="select * from result2 where rollno=?";
	
	
	 public void init() {
		 try {
			 Class.forName(driver);
			 connection=DriverManager.getConnection(url,username,password);
			 ps=connection.prepareStatement(sql);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	 public void service(HttpServletRequest req,HttpServletResponse res) {
		 try {
			 String rollno = req.getParameter("rollno");
			 ps.setString(1, rollno);
			 rs=ps.executeQuery();
			 pw=res.getWriter();
			 pw.println("<!DOCTYPE html>");
	            pw.println("<html><head><title>Student Result</title>");
	            pw.println("<link rel='stylesheet' type='text/css' href='result.css'>");
	            pw.println("</head><body>");

	            if (rs.next()) {
	                // Display Student Information
	                pw.println("<div class='result-container'>");
	                pw.println("<h2>University Seat Number: " + rs.getString("rollno") + "</h2>");
	                pw.println("<h2>Student Name: " + rs.getString("student_name") + "</h2>");
	                pw.println("<h3>Semester: " + rs.getInt("semester") + "</h3>");

	                // Table Header
	                pw.println("<table border='1'>");
	                pw.println("<tr>");
	                pw.println("<th>Subject Code</th>");
	                pw.println("<th>Subject Name</th>");
	                pw.println("<th>Internal Marks</th>");
	                pw.println("<th>External Marks</th>");
	                pw.println("<th>Total</th>");
	                pw.println("<th>Result</th>");
	                pw.println("</tr>");

	                do {
	                    // Table Rows (Fetching each subject's data)
	                    pw.println("<tr>");
	                    pw.println("<td>" + rs.getString("subject_code") + "</td>");
	                    pw.println("<td>" + rs.getString("subject_name") + "</td>");
	                    pw.println("<td>" + rs.getInt("internal_marks") + "</td>");
	                    pw.println("<td>" + rs.getInt("external_marks") + "</td>");
	                    pw.println("<td>" + rs.getInt("total_marks") + "</td>");
	                    pw.println("<td>" + rs.getString("result") + "</td>");
	                    pw.println("</tr>");
	                } while (rs.next());

	                pw.println("</table>");
	                pw.println("</div>");
	            } else {
	                pw.println("<h3 class='error-message'>No record found for Roll Number: '</h3>");
	            }

	            pw.println("</body></html>");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 public void destroy() {
		 try {
			 connection.close();
			 ps.close();
			 rs.close();
		 }
		 catch(Exception e) {
			e.printStackTrace(); 
		 }
	 }
}
