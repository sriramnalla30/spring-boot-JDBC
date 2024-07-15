package com.javatpoint;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

@RestController  
public class SpringBootJdbcController {  

    @Autowired  
    JdbcTemplate jdbc;    

    @RequestMapping(value = "/insert", method = { RequestMethod.POST })
    public void index(@RequestParam("name") String name, @RequestParam("email") String email, HttpServletResponse response) throws IOException {
        try {
        	 if (name == null || name.isEmpty() || email == null || email.isEmpty()) {
        	        response.getWriter().println("Name and Email are required.");
        	        return;
        	    }
        	 else {
            String sql = "INSERT INTO user(name, email) VALUES('" + name + "', '" + email + "')";
            jdbc.execute(sql);
            response.getWriter().println("Data inserted Successfully");
        	 	}
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error inserting data: " + e.getMessage());
        }
    }

    @RequestMapping(value = "/show", method = { RequestMethod.GET})
    public void show(HttpServletResponse response) throws IOException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = jdbc.getDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM user");

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>User Details:</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + email + "</td></tr>");
            }

            out.println("</table>");
            out.println("</body></html>");

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error retrieving data: " + e.getMessage());
        }
        
    } 
    
    @RequestMapping(value = "/edit", method = { RequestMethod.POST })
    public void edit(@RequestParam("name") String name, @RequestParam("emailID") String emailID, HttpServletResponse response) throws IOException {
        
        try {
        	 if (name == null || name.isEmpty() || emailID == null || emailID.isEmpty()) {
        	        response.getWriter().println("Name and Email are required.");
        	        return;
        	    }
        	 else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            Connection con= jdbc.getDataSource().getConnection();
            Statement stmt = con.createStatement();

            stmt.executeUpdate("UPDATE user SET email='" + emailID + "' WHERE name='" + name + "'");
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE name='" + name + "'");

            out.println("<html><body>");
            out.println("<h2>User Details:</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");

            while (rs.next()) {
                int id = rs.getInt("id");
                String names = rs.getString("name");
                String emails = rs.getString("email");
                out.println("<tr><td>" + id + "</td><td>" + names + "</td><td>" + emails + "</td></tr>");
            }

            out.println("</table>");
            out.println("</body></html>");}
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error retrieving data: " + e.getMessage());
        } 
    }
    
    @RequestMapping(value = "/delete", method = { RequestMethod.POST })
    public void delete(@RequestParam("name") String name, HttpServletResponse response) throws IOException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
        	 if (name == null || name.isEmpty() ) {
        	        response.getWriter().println("Name is required to delete.");
        	        return;
        	    }
        	 else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();            
            con = jdbc.getDataSource().getConnection();
            stmt = con.createStatement();

            String deleteSql = "DELETE FROM user WHERE name='" + name + "'";
            stmt.executeUpdate(deleteSql);

            String selectSql = "SELECT * FROM user";
            rs = stmt.executeQuery(selectSql);

            out.println("<html><body>");
            out.println("<h2>User Details:</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");

            while (rs.next()) {
                int id = rs.getInt("id");
                String names = rs.getString("name");
                String emails = rs.getString("email");
                out.println("<tr><td>" + id + "</td><td>" + names + "</td><td>" + emails + "</td></tr>");
                }

            out.println("</table>");
            out.println("</body></html>");}
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error retrieving data: " + e.getMessage());
        }
    }


}  
