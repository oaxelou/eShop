package Util;

import java.io.IOException;
import java.io.PrintWriter;

import Bean.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	String header_str = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"	<meta charset=\"UTF-8\">\r\n" + 
			"	<title>Register Page</title>\r\n" + 
			"	<link type=\"text/css\" rel=\"stylesheet\" href=\"style.css\">\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n";
	
	String footer_str = "	<div class=\"footer\">\r\n" + 
			"		<div class=\"container\">\r\n" + 
			"			<div class=\"column3\">\r\n" + 
			"				<h4>About Us</h4>\r\n" + 
			"				<p>We are undergraduate students\r\n" + 
			"				at the University of Thessaly, in\r\n" + 
			"				particular in the department of\r\n" + 
			"				Electrical and Computer Engineering.</p>\r\n" + 
			"				<br><h4>Follow us on social media!</h4>\r\n" + 
			"				<p> <img src=\"images/media/facebook_icon.png\">\r\n" + 
			"					<img src=\"images/media/twitter_icon.png\">\r\n" + 
			"					<img src=\"images/media/instagram_icon.png\">\r\n" + 
			"				</p>\r\n" + 
			"			</div>\r\n" + 
			"\r\n" + 
			"			<div class=\"column3 second-column\">\r\n" + 
			"				<h4>Location</h4>\r\n" + 
			"				<div class=\"mapouter\">\r\n" + 
			"					<div class=\"gmap_canvas\">\r\n" + 
			"						<iframe width=\"201\" height=\"159\" id=\"gmap_canvas\" src=\"https://maps.google.com/maps?q=volos&t=&z=13&ie=UTF8&iwloc=&output=embed\" frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\">\r\n" + 
			"						</iframe>\r\n" + 
			"					</div>\r\n" + 
			"				</div>\r\n" + 
			"			</div>\r\n" + 
			"\r\n" + 
			"			<div class=\"column3 third-column\">\r\n" + 
			"				<h4>Contact Us</h4>\r\n" + 
			"				<p> We provide 24hr phone support </p>\r\n" + 
			"				<br>\r\n" + 
			"				<ul class=\"contact_info_list\">\r\n" + 
			"					<li>Eshop, Helen & Olympia</li>\r\n" + 
			"					<li>Volos, Magnesia, Greece</li>\r\n" + 
			"					<li><img src=\"images/contact/phone_icon.png\">+30 24210 56666</li>\r\n" + 
			"					<li><img src=\"images/contact/email_icon.png\"><a href=mailto:eshop@gmail.com>eshop@gmail.com</a></li>\r\n" + 
			"				</ul>\r\n" + 
			"			</div>\r\n" + 
			"\r\n" + 
			"		</div>\r\n" + 
			"	</div>\r\n" + 
			"\r\n" + 
			"	<div class=\"bottom\">\r\n" + 
			"	<div class=\"container\">\r\n" + 
			"			<div class=\"copyrights\">\r\n" + 
			"				©2019 All Rights Reserved\r\n" + 
			"				<!-- <p>©2019 Musica Store by Helen & Olympia | All Rights Reserved</p> -->\r\n" + 
			"			</div>\r\n" + 
			"		</div>\r\n" + 
			"	</div>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"</div> <!--main-->\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n" + 
			"<script src=\"js/jquery.cycle.all.js\"></script>\r\n" + 
			"<script>\r\n" + 
			"	$('.slideshow').cycle({\r\n" + 
			"		next:'#next',\r\n" + 
			"		prev: '#prev'\r\n" + 
			"	})\r\n" + 
			"\r\n" + 
			"</script>\r\n" + 
			"</body>\r\n" + 
			"</html>\r\n" + 
			"";
	
	private String login_and_navbar(String username, int cart_sum) {
		return("<div class=\"main\">\r\n" + 
		"			<div class=\"topbar\"></div>\r\n" + 
		"			<div class=\"social_icon\">\r\n" + 
		"				<div class=\"container\">\r\n" + 
		"					<div class=\"header_right\">\r\n" + 
		"						<div class=\"login_register_btn\">\r\n" + 
		"							<form action=\"UserInfo\" method=\"post\">\r\n" + 
		"								<input name=\"username\" type=\"hidden\" value=\"" + username + "\">\r\n" + 
		"								<i><input type=\"submit\" value=\" " + username + " \" style=\"padding:2px; margin-top: 10px;cursor: pointer;font-size:15px;line-height: 30px;color:white;background-color:#353c42;font-weight:bold;border-color:#4d565f;border-width: 3px;border-radius:5px;\"></i>\r\n" +
		"							</form>\r\n" +
		"						</div>\r\n" + 
		"						<div class=\"cart_btn\">\r\n" + 
		"							<form action=\"Cart\" method=\"post\">\r\n" + 
		"								<input name=\"username\" value=\""+username + "\" type=\"hidden\">\r\n" +
		"								<img src=\"images/cart.png\">\r\n" +
		"								<span><input type=\"submit\" value=\"Kxart("+cart_sum+")\" class=\"cart_submit\"></span>\r\n" +
		"							</form>\r\n" +
		"						</div>\r\n" +
		"					</div>\r\n" + 
		"				</div>\r\n" + 
		"			</div>\r\n" + 
		"			<div class=\"header\">\r\n" + 
		"				<div class=\"container\">\r\n" + 
		"					<div class=\"navbar\">\r\n" + 
		"						<div class=\"nav_background\">\r\n" + 
		"							<div class=\"home_btn\">"+ 
		"								<form action=\"index\" method=\"post\">\r\n" + 
		"									<input type=\"hidden\" name=\"username\" value=\"" + username + "\">\r\n" +
		"									<input type=\"submit\" value=\"HOME\" class=\"home_btn\">\r\n" +
		"								</form>\r\n" +
		"							</div>\r\n" + 
		"							<div class=\"dropdown\">\r\n" + 
		"								<button class=\"dropbtn\">WOMEN</button>\r\n" + 
		"								<div class=\"dropdown-content\">\r\n" + 
		"									<form action=\"Shirts\" method=\"post\"  >\r\n" + 
		"  											<input type=\"hidden\" name=\"username\" value=\"" + username + "\">\r\n" + 
		"											<input type=\"submit\"  class=\"categories_btn\" value=\"SHIRTS\">\r\n" + 
		"									</form>\r\n" + 
		"									<form action=\"Trousers\" method=\"post\" >\r\n" + 
		"										<input type=\"hidden\" name=\"username\" value=\"" + username + "\"/>\r\n" + 
		"										<input type=\"submit\" class=\"categories_btn\" value=\"TROUSERS\"/>\r\n" + 
		"									</form>\r\n" + 
		"									<form action=\"Shoes\" method=\"post\" >\r\n" + 
		"										<input type=\"hidden\" name=\"username\" value=\"" + username + "\"/>\r\n" + 
		"										<input type=\"submit\" class=\"categories_btn\" value=\"SHOES\"/>\r\n" + 
		"									</form>\r\n" + 
		"								</div>\r\n" + 
		"							</div>\r\n" + 
		"							<div class=\"home_btn\">"+ 
		"								<form action=\"AboutUs\" method=\"post\">\r\n" + 
		"									<input type=\"hidden\" name=\"username\" value=\"" + username + "\">\r\n" +
		"									<input type=\"submit\" value=\"ABOUT US\" class=\"home_btn\">\r\n" +
		"								</form>\r\n" +
		"							</div>\r\n" + 
		"						</div>\r\n" + 
		"					</div>\r\n" + 
		"				</div>\r\n");
	}
	
	public int registerUser(User user) throws ClassNotFoundException {
		 //insert parameters in the database
		String url = "jdbc:mysql://localhost:3306/eshopdb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
	    String INSERT_USERS_SQL = "INSERT INTO user" +
	            "  (username, password, first_name, last_name, email, address, phone, gender, birthdate) VALUES " +" (?, ?, ?, ?, ?, ?, ? ,?, ?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager.getConnection(url, "root", "2421057837olicia!"); //connect to db

	            // create statement 
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	        	preparedStatement.setString(1, user.getUsername());
		        preparedStatement.setString(2, user.getPassword());
	            preparedStatement.setString(3, user.getFirstName());
	            preparedStatement.setString(4, user.getLastName());           	
	        	preparedStatement.setString(5, user.getEmail());
	        	preparedStatement.setString(6, user.getAddress());
	        	preparedStatement.setString(7, user.getPhone());
	        	preparedStatement.setString(8, user.getGender());
	        	preparedStatement.setString(9, user.getBirthdate());
	            

	            System.out.println(preparedStatement);
	            // Execute the query or update query
	            //returns the number of affected rows 
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process SQL exception
	        	
	            printSQLException(e);
	        }
	        return result;
	    }

	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//get the users info
	    	
	    	PrintWriter pwriter = response.getWriter();
	    	pwriter.println(header_str);
	    	
			String username = request.getParameter("username");
	        String password = request.getParameter("password");
			String firstName = request.getParameter("first_name");
	        String lastName = request.getParameter("last_name");
	        String email = request.getParameter("email");
	        String address = request.getParameter("address");
	        String phone = request.getParameter("phone");
	        String gender = request.getParameter("gender");
	        String birthdate = request.getParameter("birthdate");
	        
	        
	        // create a user of type RegisterBean from the info given above
	        User user = new User();
	        user.setUsername(username);
	        user.setPassword(password);
	        user.setFirstName(firstName);
	        user.setLastName(lastName);
	        user.setEmail(email);
	        user.setAddress(address);
	        user.setPhone(phone);
	        user.setGender(gender);
	        user.setBirthdate(birthdate);

	        try {
	           int res = registerUser(user);
	           
	           //no affected rows 
	           if (res == 0) {
	        	   pwriter.println(login_and_navbar("Login / Register", 0));
	        	   pwriter.println("	<div class=\"main_body\">\r\n" + 
	        	   "						<div class=\"container\">\r\n" +
	        	   "							<div class=\"page_title\"> <h2>" + "Username already exists: " +user.getUsername() + "</h2></div>" + 
				   "							<form action=\"login_register.html\" method=\"get\">\r\n" + 
				   "								<div class = \"button\">\r\n" + 
				   "									<input type=\"submit\" value=\"Return to Registration page\" class=\"login_register_btn\">\r\n" + 
				   "								</div>\r\n" + 
				   "							</form>" +
				   "						</div>\r\n" +
				   "					</div>\r\n");
	           }
	           else {
	        	   pwriter.println(login_and_navbar(username, 0));
	        	   pwriter.println("	<div class=\"main_body\">\r\n" + 
	        	   "						<div class=\"container\">\r\n" +
	    	       "							<div class=\"page_title\"> <h2>" + "Sucessfully registered as " +user.getUsername() + "</h2></div>" +
	        	   "							<form action=\"index\" method=\"post\">\r\n" + 
				   "								<input name=\"username\" value=\""+ user.getUsername() + "\" type=\"hidden\">\r\n" + 
				   "								<div class = \"button\">\r\n" + 
				   "									<input type=\"submit\" value=\"Return to Home\" class=\"login_register_btn\">\r\n" + 
				   "								</div>\r\n" + 
				   "							</form>" +
				   "						</div>\r\n" +
				   "					</div>\r\n");
	           }

	           
	        
	        } catch (Exception e) {
	        	
	            
	            e.printStackTrace();
	        }
	        pwriter.println(footer_str);
	        pwriter.close();

	    }
	}
