package Util;


import java.util.Scanner;
import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	

	static String header_str = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"	<meta charset=\"UTF-8\">\r\n" + 
			"	<title>Thank you!</title>\r\n" + 
			"	<link type=\"text/css\" rel=\"stylesheet\" href=\"style.css\">\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"<div class=\"main\">\r\n" + 
			"<div class=\"topbar\"></div>\r\n" + 
			"	<div class=\"social_icon\">\r\n" + 
			"		<div class=\"container\">\r\n" + 
			"			<div class=\"header_right\">\r\n" + 
			"				<div class=\"login_register_btn\">\r\n" + 
			"					<a href=\"login_register.html\">Login / Register</a>\r\n" + 
			"				</div>\r\n" + 
			"				<div class=\"cart_btn\">\r\n" + 
			"					<a href=\"cart.html\">\r\n" + 
			"						<img src=\"images/cart.png\">\r\n" + 
			"						<span>Cart(0)</span></a>\r\n" + 
			"				</div>\r\n" + 
			"			</div>\r\n" + 
			"		</div>\r\n" + 
			"	</div>\r\n" + 
			"\r\n" + 
			"	<div class=\"header\">\r\n" + 
			"		<div class=\"container\">\r\n" + 
			"			<div class=\"navbar\">\r\n" + 
			"				<div class=\"nav_background\">\r\n" + 
			"					<div class=\"home_btn\"><a href=\"index.html\">HOME</a></div>\r\n" + 
			"\r\n" + 
			"					<div class=\"dropdown\">\r\n" + 
			"						<button class=\"dropbtn\">WOMEN</button>\r\n" + 
			"						<div class=\"dropdown-content\">\r\n" + 
			"							<a href = \"shirts.html\">SHIRTS</a>\r\n" + 
			"							<a href = \"trousers.html\">TROUSERS</a>\r\n" + 
			"							<a href = \"shoes.html\">SHOES</a>\r\n" + 
			"						</div>\r\n" + 
			"					</div>\r\n" + 
			"\r\n" + 
			"					<div class=\"about_us_btn\"><a href=\"about.html\">ABOUT US</a></div>\r\n" + 
			"				</div>\r\n" + 
			"			</div>\r\n" + 
			"		</div>\r\n" + 
			"	</div>\r\n" + 
			"\r\n" + 
			"	<!-- MAIN BODY OF THE HTML PAGE -->\r\n" + 
			"\r\n" + 
			"	<div class=\"container\">"
			+ "<div class=\"main_body\">";
	
	static String footer_str = "</div></div>\r\n" + 
			"\r\n" + 
			"	<!-- FOOTER AND BOTTOM PART -->\r\n" + 
			"\r\n" + 
			"	<div class=\"footer\">\r\n" + 
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
			"		</div>\r\n" + 
			"	</div>\r\n" + 
			"\r\n" + 
			"	<div class=\"bottom\">\r\n" + 
			"		<div class=\"container\">\r\n" + 
			"			<div class=\"bottom_nav_bar\">\r\n" + 
			"				<a href=\"index.html\">Home</a>\r\n" + 
			"				<a href=\"#\">Products</a>\r\n" + 
			"				<a href=\"shirts.html\">Women</a>\r\n" + 
			"\r\n" + 
			"			</div>\r\n" + 
			"			<div class=\"copyrights\">\r\n" + 
			"				©2019 All Rights Reserved\r\n" + 
			"				<!-- <p>©2019 Musica Store by Helen & Olympia | All Rights Reserved</p> -->\r\n" + 
			"			</div>\r\n" + 
			"		</div>\r\n" + 
			"	</div>\r\n" + 
			"\r\n" + 
			"</div> <!--main-->\r\n" + 
			"\r\n" + 
			"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>\r\n" + 
			"<script>\r\n" + 
			"$('.creditCardText').keyup(function() {\r\n" + 
			"  var foo = $(this).val().split(\"-\").join(\"\"); // remove hyphens\r\n" + 
			"  if (foo.length > 0) {\r\n" + 
			"    foo = foo.match(new RegExp('.{1,4}', 'g')).join(\"-\");\r\n" + 
			"  }\r\n" + 
			"  $(this).val(foo);\r\n" + 
			"});\r\n" + 
			"</script>\r\n" + 
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
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			  throws IOException, ServletException{
		String user=req.getParameter("username");
		String pass=req.getParameter("password");
		
		PrintWriter pwriter = res.getWriter();
		pwriter.println(header_str);
		
		pwriter.println("<div class=\"page_title\">\r\n" + 
				"				<h2>THANK YOU!</h2>\r\n" + 
				"			</div>\r\n" + 
				"");
		//System.out.println(header_str);
		
		
		/****************  START OF JDBC STUFF  *******************/
		String url = "jdbc:mysql://localhost:3306/eshopdb?allowPublicKeyRetrieval=TRUE&useSSL=false&seUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC ";
		String dbUser = "root";
		String dbPassword = "1997";
		String mystr = "select * from user " + " where username='" + user + "';";
		//String check_username = "select * from user;";
		System.out.println(mystr);
		
		try {
//			System.out.println("1");
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("2");
			Connection myConn = DriverManager.getConnection(url, dbUser, dbPassword);
//			System.out.println("3");// 1. Get a connection to database
			Statement myStmt = myConn.createStatement();  
//			System.out.println("4");													// 2. Create a statement
			
			// Search DB for the user that they gave
			ResultSet searchResult = myStmt.executeQuery(mystr);  // 3. Form the SQL Query
			
			if(searchResult.next()) {
				// Get user's password and compare it to the one the user gave.
				System.out.println(searchResult.getString("username") + ", " + searchResult.getString("password") + ", " + pass);
				if(searchResult.getString("password").equals(pass)) {
					pwriter.println("<h2>Successfully logged in as " + user + "</h2>");
				}
				else {pwriter.println("<h2>Wrong password for user  " + user + ".</h2>");}
			}
			else {
				pwriter.println("<h2>User " + user + " does not exist. Login failed.</h2>");
				}
		
		}catch(Exception exc) {
//			pwriter.println("<p>Error occured: " + exc.toString() + "</p>");
			System.out.println("An error occurred while connecting MySQL databse");
			exc.printStackTrace();
			System.out.println("\nError again my friend...");
		}
		
//		PrintWriter pwriter = res.getWriter();
		pwriter.println(footer_str);
	
		
		pwriter.close();
		
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			  throws IOException, ServletException{
		
		
		System.out.println("HEREEEEEEEEEEEEEEEEEEEEE.");
//		PrintWriter pwriter = res.getWriter();
//		try{
//			Scanner scanner = new Scanner( new File("/opt/tomcat/webapps/New_3rdAssignment/header.html"), "UTF-8" );
//			String text = scanner.useDelimiter("\\A").next();
//			scanner.close();
//			pwriter.println(text);
//		} catch(FileNotFoundException efnotf){
//			pwriter.println("<html><body><h2>File not found: "+ System.getProperty("user.dir") + " </h2></body></html>");
//			System.out.println(efnotf.toString());
//			System.out.println("Could not display html. File not found.");
//		} catch(Exception e){
//			pwriter.println("<html><body><h2>Exception?</h2></body></html>");
//			System.out.println("Unexpected exception occured: " + e.toString());
//		}
//		
//		pwriter.println("<html><body><h2>Page Not Found. <br> Return to <a href=\"index.html\" style=\"color: #2b7a78\">home</a></h2>");
//		
//		// Adding Footer
//		try{
//			Scanner scanner = new Scanner( new File("/opt/tomcat/webapps/New_3rdAssignment/footer.html"), "UTF-8" );
//			String text = scanner.useDelimiter("\\A").next();
//			scanner.close();
//			pwriter.println(text);
//		} catch(FileNotFoundException efnotf){
//			pwriter.println("<html><body><h2>File not found: "+ System.getProperty("user.dir") + " </h2></body></html>");
//			pwriter.close();
//			System.out.println(efnotf.toString());
//			System.out.println("Could not display html. File not found.");
//		} catch(Exception e){
//			pwriter.println("<html><body><h2>Exception?</h2></body></html>");
//			pwriter.close();
//			System.out.println("Unexpected exception occured: " + e.toString());
//		}
//		pwriter.close();
	}
}