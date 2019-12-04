package Util;

import java.io.*;
import java.sql.*;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInfo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	String header_str = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"	<meta charset=\"UTF-8\">\r\n" + 
			"	<title>Login Page</title>\r\n" + 
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
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			  throws IOException, ServletException{
		String username=req.getParameter("username");
		
		PrintWriter pwriter = res.getWriter();
		pwriter.println(header_str);

		/****************  START OF JDBC STUFF  *******************/
		String url = "jdbc:mysql://localhost:3306/eshopdb";
		String dbUser = "root";
		String dbPassword = "2421057837olicia";
		String mystr = "select SUM(quantity) from cart where username_FK='" + username + "';";
		System.out.println(mystr);
		
		try {
			System.out.println("1");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("2");
			Connection myConn = DriverManager.getConnection(url, dbUser, dbPassword);
			System.out.println("3");
			Statement myStmt = myConn.createStatement();  
			System.out.println("4");									
			
			// Search DB for the user that they gave
			ResultSet searchResult = myStmt.executeQuery(mystr); 
			
			if(searchResult.next()) {
				pwriter.println(login_and_navbar(username, searchResult.getInt("SUM(quantity)")));
			}
			
			searchResult = myStmt.executeQuery("select * from user where username=\"" + username +"\";");
			if(searchResult.next()) {
	        	pwriter.println("	<div class=\"main_body\">\r\n" + 
	        	   "					<div class=\"container\">\r\n" +
	    	       "						<div class=\"page_title\"> <h2>" + "Info & Order History of " +username + "</h2></div>" +
	        	   "						<div class=\"payment_shpping_column\">\r\n" + 
	        	   "				<div class=\"shipping_details_column\">\r\n" + 
	        	   "					<h4> USER INFO </h4>\r\n" + 
	        	   "					<table>\r\n" + 
	        	   "						<tr><td>Username:</td><td>" + username + "</td></tr>\r\n" + 
	        	   "						<tr><td></td></tr>\r\n" + 
	        	   "						<tr><td>First Name:</td><td> " + searchResult.getString("first_name") + " </td></tr>\r\n" + 
	        	   "						<tr><td>Last Name:</td><td> " + searchResult.getString("last_name") + " </td></tr>\r\n" + 
	        	   "						<tr><td></td></tr>\r\n" + 
	        	   "						<tr><td>Address:</td><td>" + searchResult.getString("address") + "</td></tr>\r\n" + 
	        	   "						<tr><td>Email:</td><td>" + searchResult.getString("email") + "</td></tr>\r\n" + 
	        	   "						<tr><td>Phone:</td><td>" + searchResult.getString("phone") + "</td></tr>\r\n" + 
	        	   "						<tr><td></td></tr>\r\n" + 
	        	   "						<tr><td>Gender:</td><td>" + searchResult.getString("gender") + "</td></tr>\r\n" + 
	        	   "						<tr><td>Birth Date:</td><td>" + searchResult.getString("birthdate") + "</td></tr>\r\n" + 
	        	   "					</table>\r\n" + 
	        	   "				</div>\r\n" + 
	        	   "				\r\n" + 
	        	   "			</div>\r\n"); 
	        	    
	        	pwriter.println("	<div class=\"order_details_column\">\r\n" + 
	 	        	   "				<h4>ORDER HISTOYRY</h4>\r\n" +
	 	        	  "					<table>\r\n");

	        	
	        	Statement stmt_history = myConn.createStatement();
	        	Statement stmt_product = myConn.createStatement();
	        	ResultSet result_history = stmt_history.executeQuery("select * from history where username_history_FK=\"" + username + "\";");
	        	ResultSet result_product;
	        	java.util.Calendar cal = Calendar.getInstance();
	        	cal.setTimeZone(TimeZone.getTimeZone("GMT+2:00"));
	        	
	        	if(result_history.next()) {
	 	        	   pwriter.println( 
		 	        	   "					<tr><th>Order ID</th>\r\n" + 
		 	        	   "					<th>Date</th>\r\n" + 
		 	        	   "					<th>Product</th>\r\n" + 
		 	        	   "					<th>Quantity</th></tr>\r\n");
	 	        	   do {
		        		//java.sql.Timestamp ts = result_history.getTimestamp("order_date", cal)
		        		String ts = result_history.getTimestamp("order_date", cal).toString();
		        		ts = ts.substring(0, ts.indexOf('.'));
			        	pwriter.println("<tr><td><b>" + result_history.getInt("order_id") + "</td></b>\r\n" + 
			        	   "					<td><b>" + ts + "</b></td>\r\n" + 
			        	   "					<td></td>\r\n" + 
			        	   "					<td></td></tr>\r\n" + 
			        	   "\r\n");
			        	
			        	result_product = stmt_product.executeQuery("select p.pname, o.quantity from `order` as o, product as p where o.idproduct_order_FK = p.idproduct and o.order_id_FK="+result_history.getInt("order_id")+";");
			        	while(result_product.next()) {
				        	pwriter.println("<tr><td></td>\r\n" + 
									   "					<td></td>\r\n" + 
									   "					<td>" + result_product.getString("p.pname") + "</td>\r\n" + 
									   "					<td>" + result_product.getInt("o.quantity") + "</td></tr>\r\n");
			        	}
	        		}while(result_history.next());
	        	}
	        	else {
	        		pwriter.println("<br><br><br><br><p><b>No orders yet.</b></p>");
	        	}
        		pwriter.println("</table>\r\n" + 
	        	   "			</div>\r\n" + 
	        	   "			<div class=\"options_area\">\r\n" + 
	        	   "				<div class=\"continue_shopping_btn\" style=\"background-color: red;border-color:red;\">\r\n" + 
	        	   "					<form action=\"DeleteUser\" method=\"post\">\r\n" +
	        	   "						<input name=\"username\" value=\"" + username + "\" type=\"hidden\">\r\n" +
	        	   "						<input type=\"submit\" value=\"DELETE ACCOUNT\" style=\"color:white;background-color:red;border:none;font-weight:bold;cursor:pointer\">\r\n" +
	        	   "					</form>\r\n" +
	        	   "				</div>\r\n" + 
	        	   "				<div class=\"checkout_btn\">\r\n" + 
	        	   "					<a href=\"index.html\">LOG OUT</a>\r\n" + 
	        	   "				</div>\r\n" + 
	        	   "			</div>\r\n" + 
	        	   "		</div>\r\n" + 
	        	   "	</div>");	
			}else {
				System.out.println("Something's gone terribly wrong! User does not exist!");
			}
		}catch(Exception exc) {
			System.out.println("An error occurred while connecting MySQL database");
			exc.printStackTrace();
			System.out.println("\nError again my friend...");
		}
		
		
		pwriter.println(footer_str);
		pwriter.close();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			  throws IOException, ServletException{
		System.out.println("HEREEEEEEEEEEEEEEEEEEEEE.");
	}
}