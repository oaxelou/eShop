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
public class ClearCart extends Cart{

	
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
		"							<a href=\"login_register.html\"><i>" + username  + "</i></a>\r\n" + 
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
		String username=req.getParameter("username");
		
		PrintWriter pwriter = res.getWriter();
		pwriter.println(header_str);
		
		String url="jdbc:mysql://localhost:3306/eshopdb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String dbUser = "root";
		String dbPassword = "2421057837olicia";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection(url, dbUser, dbPassword);
			
			//find the pids in the cart
			String find_pid = "select c.idproduct_cart_FK as pid_to_delete, quantity \r\n" + 
					"from cart c;";
			Statement stmt = myConn.createStatement();
	        ResultSet rs = stmt.executeQuery(find_pid);	        
	        
	        if (!rs.next() ) {
	            System.out.println("no data"); //now cursor is positioned in the first row
	            res.sendRedirect(req.getContextPath() + "/Cart");
	        } 
	        rs.beforeFirst(); //position the cursor before the first row 
	        
	        while (rs.next()) {
	        	
	        	Integer pid_to_delete = Integer.parseInt(rs.getString("pid_to_delete"));
	        	Integer q = Integer.parseInt(rs.getString("quantity")) ;
	        	
	        	String sql = String.format( "delete from cart where idproduct_cart_FK = \"%d\";", pid_to_delete);		
		        
		        //if the user deletes the cart, the stock must be updated
		        
		        String update_stock = String.format( "UPDATE product p, cart c\r\n" + 
		        		"set stock = stock + '%d' \r\n" + 
		        		"where p.idproduct  = '%d';", q, pid_to_delete);
		        
		        Statement stmt2 = myConn.createStatement();
		        stmt2.executeUpdate(update_stock);
		        stmt2.close();
		        
		        Statement stmt1 = myConn.createStatement();
		        stmt1.executeUpdate(sql);
		        
		        stmt1.close();
	        }
	        // Search DB for the user that they gave
 			ResultSet searchResult = stmt.executeQuery("select SUM(quantity) from cart where username_FK='" + username + "';"); 
 			
 			if(searchResult.next()) {
 				//System.out.println("got in if block in index");
 				System.out.println(searchResult.getInt("SUM(quantity)"));
 			}

 			pwriter.println(login_and_navbar(username, searchResult.getInt("SUM(quantity)")));
 			pwriter.println("<div class=\"container\">\r\n" + 
	        		"		<div class=\"main_body\">\r\n" + 
	        		"			<div class=\"page_title\">\r\n" + 
	        		"				<h2>SHOPPING CART</h2>\r\n" + 
	        		"			</div>\r\n" + 
	        		"\r\n" + 
	        		"			<table class=\"shopping_list\">\r\n" + 
	        		"				<tbody>\r\n" + 
	        		"					<tr>\r\n" + 
	        		"						<th>Item</th>\r\n" + 
	        		"						<th>Name</th>\r\n" + 
	        		"						<!-- <th></th> -->\r\n" + 
	        		"						<th>Price</th>\r\n" + 
	        		"						<th>Quantity</th>\r\n" + 
	        		"						<th>Total</th>\r\n" + 
	        		"					</tr>");
	        
	        		pwriter.println("				<tr>\r\n" + 
	        		"						<th></th>\r\n" + 
	        		"						<th></th>\r\n" + 
	        		"						<!-- <th></th> -->\r\n" + 
	        		"						<th></th>\r\n" + 
	        		"						<th>Total:</th>\r\n" + 
	        		"						<th>$0</th>\r\n" + 
	        		"					</tr>\r\n" + 
	        		"				</tbody>\r\n" + 
	        		"			</table>\r\n" +
	        		"		</div>\r\n" +
	        		"	</div>\r\n" + 
	        		"");
	        stmt.close();					
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
		System.out.println("GET METHOD IS NOT USED. SHOULD NEVER REACH THIS.");
	}
	

}
