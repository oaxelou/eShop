package Util;

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
			"				�2019 All Rights Reserved\r\n" + 
			"				<!-- <p>�2019 Musica Store by Helen & Olympia | All Rights Reserved</p> -->\r\n" + 
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
		
		/****************  START OF JDBC STUFF  *******************/
		String url = "jdbc:mysql://localhost:3306/eshopdb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String dbUser = "root";
		String dbPassword = "1997";
		String mystr = "select password from user where username='" + user + "';";
		System.out.println(mystr);
		
		try {
			System.out.println("1");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("2");
			Connection myConn = DriverManager.getConnection(url, dbUser, dbPassword);
			System.out.println("3");
			Statement myStmt = myConn.createStatement();  
			System.out.println("4");									
			
			// Search DB for the user that they gave
			ResultSet searchResult = myStmt.executeQuery(mystr); 
			
			if(searchResult.next()) {
				if(pass.equals(searchResult.getString("password"))) {
/*************************************** YAAAAAAAAAAAAAAAAAS QUEEEEEEEEEEEEEEN YAAAAAAAAAAAAAAAAAAAAAAAAAAAS ********************************/
					pwriter.println("Successfully logged in as " + user);
					pwriter.println("<form action=\"index\" method=\"post\">\r\n" + 
							"			<input name=\"username\" value=\""+ user + "\" type=\"hidden\">\r\n" + 
							"			<div class = \"button\">\r\n" + 
							"				<input type=\"submit\" value=\"Return to Home\" class=\"login_register_btn\">\r\n" + 
							"			</div>\r\n" + 
							"		</form>");
					
				}
				else {
					/*************************************** YAAAAAAAAAAAAAAAAAS QUEEEEEEEEEEEEEEN YAAAAAAAAAAAAAAAAAAAAAAAAAAAS ********************************/
					pwriter.println("Wrong password for user " + user);
					pwriter.println("<form action=\"index.html\" method=\"get\">\r\n" + 
							"			<input name=\"username\" value=\""+ user + "\" type=\"hidden\">\r\n" + 
							"			<div class = \"button\">\r\n" + 
							"				<input type=\"submit\" value=\"Return to Home\" class=\"login_register_btn\">\r\n" + 
							"			</div>\r\n" + 
							"		</form>");
					}
			}
			else {
				/*************************************** YAAAAAAAAAAAAAAAAAS QUEEEEEEEEEEEEEEN YAAAAAAAAAAAAAAAAAAAAAAAAAAAS ********************************/
				pwriter.println("There is no user in db with username " + user);
				pwriter.println("<form action=\"index.html\" method=\"get\">\r\n" + 
						"			<input name=\"username\" value=\""+ user + "\" type=\"hidden\">\r\n" + 
						"			<div class = \"button\">\r\n" + 
						"				<input type=\"submit\" value=\"Return to Home\" class=\"login_register_btn\">\r\n" + 
						"			</div>\r\n" + 
						"		</form>");
				}
				

		}catch(Exception exc) {
			System.out.println("An error occurred while connecting MySQL databse: demo");
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