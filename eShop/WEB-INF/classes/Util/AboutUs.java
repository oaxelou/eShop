package Util;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AboutUs  extends HttpServlet {
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
	
	private String About_Us_String() {
		return("<div class=\"container\">\r\n" + 
				"			<div class=\"page_title\">\r\n" + 
				"				<h2>ABOUT US</h2>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"\r\n" + 
				"		<div class=\"wallpaper\">\r\n" + 
				"			<div class=\"container\">\r\n" + 
				"\r\n" + 
				"				<img src=\"https://www.solodev.com/assets/hero/hero.jpg\">\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"\r\n" + 
				"		<div class=\"team-description\">\r\n" + 
				"			<div class=\"container\">\r\n" + 
				"				<h4> What drives us </h4>\r\n" + 
				"				<br>\r\n" + 
				"				<p>\r\n" + 
				"\r\n" + 
				"					Our Company was born in 2019. Its purpose, to serve everyone who loves fashion. With handpicked clothes and shoes from France and Italy we bring you the hottest trends and the most exclusive collections every season. We love fashion too so we make sure our collection is afforable yet exclusive enough to accomodate every sense of style. Our team works 24/7 to make online shopping an exquisite digital experience for you!\r\n" + 
				"\r\n" + 
				"					Feel free to contact us on social media or on the phone at any time!\r\n" + 
				"					<br><br>\r\n" + 
				"\r\n" + 
				"					<b>Address:</b> Glavani 23, Volos, Greece\r\n" + 
				"					<br>\r\n" + 
				"					<b>Tel</b>: 24210 56666\r\n" + 
				"					<br>\r\n" + 
				"				</p>\r\n" + 
				"				<br><br><br>\r\n" + 
				"\r\n" + 
				"				<h4> FIND US ON SOCIAL MEDIA AND GET A SHOUTOUT! </h4>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"\r\n" + 
				"		<div class=\"bottom_image\">\r\n" + 
				"			<div class=\"container\">\r\n" + 
				"				<img src=\"images/bottom_image.jpg\">\r\n" + 
				"			</div>\r\n" + 
				"		</div>");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			  throws IOException, ServletException{
		System.out.println("HEREEEEEEEEEEEEEEEEEEEEE POST.");
		
		String username = req.getParameter("username");
		
		
		PrintWriter pwriter = res.getWriter();
		pwriter.println(header_str);
	
		/****************  START OF JDBC STUFF  *******************/
		String url = "jdbc:mysql://localhost:3306/eshopdb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String dbUser = "root";
		String dbPassword = "2421057837olicia";
		
		try {
			System.out.println("1");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("2");
			Connection myConn = DriverManager.getConnection(url, dbUser, dbPassword);
			System.out.println("3");// 1. Get a connection to database
			Statement myStmt = myConn.createStatement();  
			System.out.println("4");													// 2. Create a statement
			
			
			ResultSet searchResult = myStmt.executeQuery("select SUM(quantity) from cart where username_FK='" + username + "';");
			if(searchResult.next()) {
				System.out.println("got in if block in shirts");
				System.out.println(searchResult.getInt("SUM(quantity)"));
			}
			
			pwriter.println(login_and_navbar(username, searchResult.getInt("SUM(quantity)")));
		}catch(Exception exc) {
			System.out.println("An error occurred while connecting MySQL databse: demo");
			exc.printStackTrace();
			System.out.println("\nError again my friend...");
		}
		
		pwriter.println(About_Us_String());
		pwriter.println(footer_str);
		pwriter.close();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			  throws IOException, ServletException{
		PrintWriter pwriter = res.getWriter();
		pwriter.println(header_str);
		pwriter.println("<div class=\"main\">\r\n" + 
				"			<div class=\"topbar\"></div>\r\n" + 
				"			<div class=\"social_icon\">\r\n" + 
				"				<div class=\"container\">\r\n" + 
				"					<div class=\"header_right\">\r\n" + 
				"						<div class=\"login_register_btn\">\r\n" + 
				"							<form action=\"login_register.html\" method=\"get\">\r\n" + 
				"			            		<input type=\"submit\" value=\" Login / Register \" style=\"padding:2px; margin-top: 10px;cursor: pointer;font-size:15px;line-height: 30px;color:white;background-color:#353c42;font-weight:bold;border-color:#4d565f;border-width: 3px;border-radius:5px;\">\r\n" + 
				"			            	</form>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"cart_btn\">\r\n" + 
				"							<form action=\"Cart\" method=\"get\">\r\n" + 
				"								<img src=\"images/cart.png\">\r\n" +
				"								<span><input type=\"submit\" value=\"Cart\" class=\"cart_submit\"></span>\r\n" +
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
				"								<form action=\"index\" method=\"get\">\r\n" + 
				"									<input type=\"submit\" value=\"HOME\" class=\"home_btn\">\r\n" +
				"								</form>\r\n" +
				"							</div>\r\n" + 
				"							<div class=\"dropdown\">\r\n" + 
				"								<button class=\"dropbtn\">WOMEN</button>\r\n" + 
				"								<div class=\"dropdown-content\">\r\n" + 
				"									<form action=\"Shirts\" method=\"get\"  >\r\n" + 
				"											<input type=\"submit\"  class=\"categories_btn\" value=\"SHIRTS\">\r\n" + 
				"									</form>\r\n" + 
				"									<form action=\"Trousers\" method=\"get\" >\r\n" + 
				"										<input type=\"submit\" class=\"categories_btn\" value=\"TROUSERS\"/>\r\n" + 
				"									</form>\r\n" + 
				"									<form action=\"Shoes\" method=\"get\" >\r\n" + 
				"										<input type=\"submit\" class=\"categories_btn\" value=\"SHOES\"/>\r\n" + 
				"									</form>\r\n" + 
				"								</div>\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"home_btn\">"+ 
				"								<form action=\"AboutUs\" method=\"get\">\r\n" + 
				"									<input type=\"submit\" value=\"ABOUT US\" class=\"home_btn\">\r\n" +
				"								</form>\r\n" +
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n");
		pwriter.println(About_Us_String());
		pwriter.println(footer_str);
		pwriter.close();
	}
}
