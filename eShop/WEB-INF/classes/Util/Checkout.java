package Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Cart;
public class Checkout extends Cart{
	

	private static final long serialVersionUID = 1L;

	String header_str = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"	<meta charset=\"UTF-8\">\r\n" + 
			"	<title>Womens Shirts</title>\r\n" + 
			"	<link rel =\"stylesheet\"  href=\"style.css\">\r\n" + 
			"	<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
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
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
//		PrintWriter pwriter = res.getWriter();
//		pwriter.println(header_str);
//		System.out.println("In do POST  ");
//		
//		pwriter.println(footer_str);
//		pwriter.close();
		String username = req.getParameter("username");
////		String sum = req.getParameter("sum");
//		
//		System.out.println("In GET METHOD");
		
		
		
		
		PrintWriter pwriter = res.getWriter();
		pwriter.println(header_str);
	
		/****************  START OF JDBC STUFF  *******************/
		String url = "jdbc:mysql://localhost:3306/eshopdb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String dbUser = "root";
		String dbPassword = "2421057837olicia!";
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection(url, dbUser, dbPassword);
			 String sql1 ="select distinct  pname,  price, quantity, image_source, quantity*price as subtotal\r\n" + 
			 		"from user u,  product p\r\n" + 
			 		"join cart c on c.idproduct_cart_FK = p.idproduct and c.username_FK=\"" + username+ "\";";
			 
			 String sql2 ="select distinct first_name, last_name, address, email, phone\r\n" + 
			 		"from user u, product p, cart c \r\n" + 
			 		"where c.idproduct_cart_FK = p.idproduct and u.username=\"" +username+ "\";";
		       
	        Statement stm = myConn.createStatement();
	        Statement stm2 = myConn.createStatement();
	        
	        
	     // Search DB for the user that they gave
			ResultSet searchResult = stm.executeQuery("select SUM(quantity) from cart where username_FK='" + username + "';"); 
			
			if(searchResult.next()) {
				//System.out.println("got in if block in index");
				System.out.println(searchResult.getInt("SUM(quantity)"));
			}

			pwriter.println(login_and_navbar(username, searchResult.getInt("SUM(quantity)")));
	     			
	        ResultSet result1 = stm.executeQuery(sql2);
	        System.out.println("Executed the query sql2");
			result1.next();
			pwriter.println("\r\n" + 
					"	<div class=\"container\">\r\n" + 
					"		<div class=\"main_body\">\r\n" + 
					"			<div class=\"page_title\">\r\n" + 
					"				<h2>CHECKOUT</h2>\r\n" + 
					"			</div>\r\n" + 
					"\r\n" + 
					"			<div class=\"payment_shpping_column\">\r\n" + 
					"				<div class=\"shipping_details_column\">\r\n" + 
					"					<h4>SHPPING DETAILS</h4>\r\n" + 
					"					<table>\r\n" + 
					"						<tr><td>"+result1.getString("first_name") +"</td>\r\n" + 
					"							<td>"+result1.getString("email")+"</td>\r\n" + 
					"						</tr>\r\n" + 
					"						<tr><td>"+result1.getString("address")+"</td></tr>\r\n" + 
					"						<tr><td>"+result1.getString("phone")+"</td></tr>\r\n" + 
					"						<tr><td>Greece</td></tr>\r\n" + 
					"					</table>\r\n" + 
					"				</div>\r\n" + 
					"				<div class=\"payment_table\">\r\n" + 
					"					<br><h4>PAYMENT DETAILS</h4>\r\n" + 
					"					<form class=\"pay_form\" action=\"ThankYou\" method=\"post\">\r\n"+
					"						<input name=\"username\" value=\""+ username + "\" type=\"hidden\">\r\n"+
					"					<table>\r\n" + 
					"						<tr><td colspan=\"2\"><input name=\"credit-number\" type=\" number\" class=\"creditCardText\"  maxlength=\"19\" placeholder=\"Card Number\" required></td></tr>\r\n" + 
					"\r\n" + 
					"						<tr><td><input name=\"credit-cvc\" class=\"cc-cvc\" type=\"tel\" pattern=\"\\d*\" maxlength=\"3\" placeholder=\"CVC\" required></td>\r\n" + 
					"						<td><input name=\"credit-expires\" class=\"cc-expires\" type=\"month\" maxlength=\"7\" required></td></tr>\r\n" + 
					"						<tr><td colspan=\"2\"><input type=\"submit\" class=\"form-submit\" value=\"Pay Now\"></td></tr>\r\n" + 
					"					</table></form>\r\n" + 
					"				</div>\r\n" + 
					"			</div>");
			
			pwriter.println("<div class=\"order_details_column\">\r\n" + 
					"				<h4>YOUR ORDER</h4>\r\n" + 
					"				<table>\r\n" + 
					"					<tr><th>Item</th>\r\n" + 
					"					<th>Name</th>\r\n" + 
					"					<th>Quantity</th>\r\n" + 
					"					<th>Subtotal</th></tr>");
			double sum=0;
			
			ResultSet result = stm.executeQuery(sql1);
	        System.out.println("Executed the query sql1");
			while (result.next()) {
				String image_src = result.getString("image_source");
	        	String pname = result.getString("pname");
	        	Integer quan = result.getInt("quantity");
	        	Float subtotal = result.getFloat("subtotal");
	        	sum =  sum + result.getFloat("subtotal");
	        	
	        	pwriter.println("	<tr><td><img src="+image_src+"></td>\r\n" + 
	        			"					<td>"+pname+"</td>\r\n" + 
	        			"					<td>"+quan+"</td>\r\n" + 
	        			"					<td>"+String.format("%.2f", result.getFloat("subtotal"))+"</td></tr>");
			}
				
			
			pwriter.println("				<tr><td></td>\r\n" + 
					"						<td></td>\r\n" + 
					"						<td>Shipping<br><br><b>Total</b></td>\r\n" + 
					"						<td>$0<br><br><b>" + String.format("%.2f", sum) + "</b></td>\r\n" + 
					"					</tr>" + 
					"				</table>\r\n" + 
					"			</div>\r\n" + 
					"		</div>\r\n" + 
					"	</div>");
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pwriter.println(footer_str);
		pwriter.close();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
	}
}