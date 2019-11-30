package Util;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index  extends HttpServlet {
	String header_str = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"	<meta charset=\"UTF-8\">\r\n" + 
			"	<title>Ecommerce Website Design</title>\r\n" + 
			"	<link type=\"text/css\" rel=\"stylesheet\" href=\"style.css\">\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"<div class=\"main\">\r\n" + 
			"\r\n" + 
			"	<div class=\"topbar\"></div>\r\n" + 
			"		<div class=\"social_icon\">\r\n" + 
			"			<div class=\"container\">";
	
	String footer_str = "</div>\r\n" + 
			"		</div>\r\n" + 
			"\r\n" + 
			"		<div class=\"header\">\r\n" + 
			"			<div class=\"container\">\r\n" + 
			"				<div class=\"navbar\">\r\n" + 
			"					<div class=\"nav_background\">\r\n" + 
			"						<div class=\"home_btn\"><a href=\"index.html\">HOME</a></div>\r\n" + 
			"\r\n" + 
			"						<div class=\"dropdown\">\r\n" + 
			"							<button class=\"dropbtn\">WOMEN</button>\r\n" + 
			"							<div class=\"dropdown-content\">\r\n" + 
			"								<form action=\"Shirts\" method=\"post\"  >" +
			"    								<input type=\"hidden\" name=\"username\" value=\"eleni\">\r\n" + 
			"     								<input type=\"submit\"  class=\"categories_btn\" value=\"SHIRTS\">\r\n" + 
			"								</form>" +
			"								<form action=\"Trousers\" method=\"post\" >\r\n" + 
			"									<input type=\"hidden\" name=\"username\" value=\"eleni\"/>\r\n" + 
			"									<input type=\"submit\" class=\"categories_btn\" value=\"TROUSERS\"/>\r\n" + 
			"								</form>\r\n" + 
			" 								<form action=\"Shoes\" method=\"post\" >\r\n" + 
			"									<input type=\"hidden\" name=\"username\" value=\"eleni\"/>\r\n" + 
			"									<input type=\"submit\" class=\"categories_btn\" value=\"SHOES\"/>\r\n" + 
			" 								</form>\r\n" + 
			"							</div>\r\n" + 
			"						</div>\r\n" + 
			"\r\n" + 
			"						<div class=\"about_us_btn\"><a href=\"about.html\">ABOUT US</a></div>\r\n" + 
			"					</div>\r\n" + 
			"				</div>\r\n" + 
			"			</div>\r\n" + 
			"		</div>\r\n" + 
			"	<!----------------------------------------------->\r\n" + 
			"\r\n" + 
			"	<div class=\"main_body\">\r\n" + 
			"\r\n" + 
			"		<div class=\"slider\">\r\n" + 
			"			<div class=\"container\">\r\n" + 
			"				<div class=\"slideshow\">\r\n" + 
			"					<img src=\"images/slideshow/1.png\">\r\n" + 
			"					<img src=\"images/slideshow/2.png\">\r\n" + 
			"					<img src=\"images/slideshow/3.png\">\r\n" + 
			"				</div>\r\n" + 
			"				<div class=\"arrows\">\r\n" + 
			"					<a href=\"#\" id=\"prev\"> <img src=\"images/slideshow/arrows/circular_prev.png\"></a>\r\n" + 
			"					<a href=\"#\" id=\"next\"> <img src=\"images/slideshow/arrows/circular_next.png\"></a>\r\n" + 
			"				</div>\r\n" + 
			"			</div>\r\n" + 
			"		</div>\r\n" + 
			"\r\n" + 
			"		<div class=\"container\">\r\n" + 
			"			<div class=\"welcome_text\">\r\n" + 
			"				<h1>WELCOME TO <span> OUR ESHOP </span></h1>\r\n" + 
			"				<!-- <h3> Check out our latest products</h3> -->\r\n" + 
			"			</div>\r\n" + 
			"		</div>\r\n" + 
			"\r\n" + 
			"		<div class=\"container\">\r\n" + 
			"			<div class=\"products\">\r\n" + 
			"				<div class=\"product_section_tile\">LATEST ARRIVALS </div>\r\n" + 
			"				<div class=\"product_one\">\r\n" + 
			"					<div class=\"product_img\"><img src=\"images/products/1.png\"></div>\r\n" + 
			"					<div class=\"product_text\">\r\n" + 
			"						<div class=\"product_title\">\r\n" + 
			"							<h4>Grey Shirt</h4>\r\n" + 
			"						</div>\r\n" + 
			"						<div class=\"star_rating\">\r\n" + 
			"								<img src=\"images/rating/golden-star.png\">\r\n" + 
			"								<img src=\"images/rating/golden-star.png\">\r\n" + 
			"								<img src=\"images/rating/black-star.png\">\r\n" + 
			"								<img src=\"images/rating/black-star.png\">\r\n" + 
			"								<img src=\"images/rating/black-star.png\">\r\n" + 
			"						</div>\r\n" + 
			"						<div class=\"product_description\">\r\n" + 
			"							A beautiful grey shirt with open shoulders.\r\n" + 
			"						</div>\r\n" + 
			"\r\n" + 
			"						<div class=\"price_buy_section\">\r\n" + 
			"							<div class=\"price\">\r\n" + 
			"								<h4>$14.99</h4>\r\n" + 
			"							</div>\r\n" + 
			"							<div class=\"buy_btn\">\r\n" + 
			"								<a href=\"#\">ADD TO CART</a>\r\n" + 
			"							</div>\r\n" + 
			"						</div>\r\n" + 
			"					</div>\r\n" + 
			"				</div>\r\n" + 
			"\r\n" + 
			"				<div class=\"product_one\">\r\n" + 
			"					<div class=\"product_img\"><img src=\"images/products/2.png\"></div>\r\n" + 
			"					<div class=\"product_text\">\r\n" + 
			"						<div class=\"product_title\">\r\n" + 
			"							<h4>Black Shirt</h4>\r\n" + 
			"						</div>\r\n" + 
			"						<div class=\"star_rating\">\r\n" + 
			"								<img src=\"images/rating/golden-star.png\">\r\n" + 
			"								<img src=\"images/rating/golden-star.png\">\r\n" + 
			"								<img src=\"images/rating/golden-star.png\">\r\n" + 
			"								<img src=\"images/rating/black-star.png\">\r\n" + 
			"								<img src=\"images/rating/black-star.png\">\r\n" + 
			"						</div>\r\n" + 
			"						<div class=\"product_description\">\r\n" + 
			"							A formal black shirt with transparencies.\r\n" + 
			"						</div>\r\n" + 
			"\r\n" + 
			"						<div class=\"price_buy_section\">\r\n" + 
			"							<div class=\"price\">\r\n" + 
			"								<h4>$34.90</h4>\r\n" + 
			"							</div>\r\n" + 
			"							<div class=\"buy_btn\">\r\n" + 
			"								<a href=\"#\">ADD TO CART</a>\r\n" + 
			"							</div>\r\n" + 
			"						</div>\r\n" + 
			"					</div>\r\n" + 
			"				</div>\r\n" + 
			"\r\n" + 
			"				<div class=\"product_one\">\r\n" + 
			"					<div class=\"product_img\"><img src=\"images/products/3.png\"></div>\r\n" + 
			"					<div class=\"product_text\">\r\n" + 
			"						<div class=\"product_title\">\r\n" + 
			"							<h4>Long sleeve shirt</h4>\r\n" + 
			"						</div>\r\n" + 
			"						<div class=\"star_rating\">\r\n" + 
			"								<img src=\"images/rating/golden-star.png\">\r\n" + 
			"								<img src=\"images/rating/golden-star.png\">\r\n" + 
			"								<img src=\"images/rating/golden-star.png\">\r\n" + 
			"								<img src=\"images/rating/black-star.png\">\r\n" + 
			"								<img src=\"images/rating/black-star.png\">\r\n" + 
			"						</div>\r\n" + 
			"						<div class=\"product_description\">\r\n" + 
			"							Long sleeve shirt in beige color\r\n" + 
			"						</div>\r\n" + 
			"\r\n" + 
			"						<div class=\"price_buy_section\">\r\n" + 
			"							<div class=\"price\">\r\n" + 
			"								<h4>$16.86</h4>\r\n" + 
			"							</div>\r\n" + 
			"							<div class=\"buy_btn\">\r\n" + 
			"								<a href=\"#\">ADD TO CART</a>\r\n" + 
			"							</div>\r\n" + 
			"						</div>\r\n" + 
			"					</div>\r\n" + 
			"				</div>\r\n" + 
			"\r\n" + 
			"				<div class=\"product_one\">\r\n" + 
			"					<div class=\"product_img\"><img src=\"images/products/4.png\"></div>\r\n" + 
			"					<div class=\"product_text\">\r\n" + 
			"						<div class=\"product_title\">\r\n" + 
			"							<h4>Shirt</h4>\r\n" + 
			"						</div>\r\n" + 
			"						<div class=\"star_rating\">\r\n" + 
			"								<img src=\"images/rating/golden-star.png\">\r\n" + 
			"								<img src=\"images/rating/golden-star.png\">\r\n" + 
			"								<img src=\"images/rating/golden-star.png\">\r\n" + 
			"								<img src=\"images/rating/black-star.png\">\r\n" + 
			"								<img src=\"images/rating/black-star.png\">\r\n" + 
			"						</div>\r\n" + 
			"						<div class=\"product_description\">\r\n" + 
			"							Winter long sleeve shirt with open shoulders.\r\n" + 
			"						</div>\r\n" + 
			"\r\n" + 
			"						<div class=\"price_buy_section\">\r\n" + 
			"							<div class=\"price\">\r\n" + 
			"								<h4>$18.99</h4>\r\n" + 
			"							</div>\r\n" + 
			"							<div class=\"buy_btn\">\r\n" + 
			"								<a href=\"#\">ADD TO CART</a>\r\n" + 
			"							</div>\r\n" + 
			"						</div>\r\n" + 
			"					</div>\r\n" + 
			"				</div>\r\n" + 
			"			</div>\r\n" + 
			"		</div>\r\n" + 
			"\r\n" + 
			"	</div>\r\n" + 
			"\r\n" + 
			"	<!----------------------------------------------->\r\n" + 
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
			"\r\n" + 
			"		</div>\r\n" + 
			"	</div>\r\n" + 
			"\r\n" + 
			"	<div class=\"bottom\">\r\n" + 
			"	<div class=\"container\">\r\n" + 
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
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			  throws IOException, ServletException{
		String username=req.getParameter("username");
		System.out.println("AT HOME AS " + username);
		PrintWriter pwriter = res.getWriter();
		pwriter.println(header_str);
		
		// get how many products where in cart
		// select count(*) from user as u, cart as c where (u.username = c.username_FK); 
		/****************  START OF JDBC STUFF  *******************/
		String url = "jdbc:mysql://localhost:3306/eshopdb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String dbUser = "root";
		String dbPassword = "1997";
		String mystr = "select count(*) from user as u, cart as c where (u.username = c.username_FK) and u.username='" + username + "';";
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
				System.out.println("got in if block in index");
				System.out.println(searchResult.getInt("count(*)"));
			}
//			else {pwriter.println("There is no user in db with username " + user);
//			}
		}catch(Exception exc) {
			System.out.println("An error occurred while connecting MySQL databse: demo");
			exc.printStackTrace();
			System.out.println("\nError again my friend...");
		}
		/*******************************************************/
		
		pwriter.println("<div class=\"header_right\">\r\n" + 
				"			<div class=\"login_register_btn\">\r\n" + 
				"				<a href=\"login_register.html\"><i>"+ username + "</i></a>\r\n" + 
				"			</div>\r\n" + 
				"			<div class=\"cart_btn\">\r\n" + 
				"				<form action=\"Cart\" method=\"post\">\r\n" + 
				"					<input name=\"username\" value=\""+ username + "\" type=\"hidden\">\r\n" + 
				"					<img src=\"images/cart.png\">\r\n" + 
				"					<span><input type=\"submit\" value=\"Kxart(0)\" class=\"cart_submit\"></span>\r\n" + 
				"				</form>\r\n" + 
				"			</div>\r\n" + 
				"		</div>");
		
		pwriter.println(footer_str);
		pwriter.close();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			  throws IOException, ServletException{
		
	}
}
