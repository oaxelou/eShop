package Util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Cart extends HttpServlet{
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
	
	private String get_login_and_navbar() {
		return("<div class=\"main\">\r\n" + 
		"			<div class=\"topbar\"></div>\r\n" + 
		"			<div class=\"social_icon\">\r\n" + 
		"				<div class=\"container\">\r\n" + 
		"					<div class=\"header_right\">\r\n" + 
		"						<div class=\"login_register_btn\">\r\n" + 
		"							<form action=\"login_register.html\" method=\"get\">\r\n" + 
		"								<input type=\"submit\" value=\" Login / Register \" style=\"padding:2px; margin-top: 10px;cursor: pointer;font-size:15px;line-height: 30px;color:white;background-color:#353c42;font-weight:bold;border-color:#4d565f;border-width: 3px;border-radius:5px;\">\r\n" +
		"							</form>\r\n" +
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
	}
	
	/* This method is called when a product is added to the cart */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		String username=req.getParameter("username");
		String pid=req.getParameter("pid");
		String quantity=req.getParameter("quantity");
		PrintWriter pwriter = res.getWriter();
		pwriter.println(header_str);
				
		if( username != null && pid == null) {
			System.out.println("Going to see what's in the cart of " + username);
			
			String url="jdbc:mysql://localhost:3306/eshopdb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String dbUser = "root";
			String dbPassword = "2421057837olicia!";
//			String sql = "select * from cart;";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection myConn = DriverManager.getConnection(url, dbUser, dbPassword);
				
				String sql1 ="select distinct  pname, description, price, stock, quantity, image_source, quantity*price as subtotal\r\n" + 
			        		"from user u,  product p\r\n" + 
			        		"join cart c on c.idproduct_cart_FK = p.idproduct and c.username_FK=\"" + username + "\";";
			    
				/* Query gia to navigation bar */
				Statement myStmt = myConn.createStatement();  
				ResultSet searchResult = myStmt.executeQuery("select SUM(quantity) from cart where username_FK='" + username + "';");
				if(searchResult.next()) {
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
		        

		        Statement stm = myConn.createStatement();
		        ResultSet result = stm.executeQuery(sql1);
		   
		        double sum = 0;
		        while (result.next()) {
		        	String image_src = result.getString("image_source");
		        	String pname = result.getString("pname");
		        	Float price = result.getFloat("price");
		        	Integer quan = result.getInt("quantity");
			   
					sum =  sum + result.getFloat("subtotal");
					
		        	pwriter.println("			<tr>\r\n" + 
			        	"						<td><img src=" + image_src + "></td>\r\n" + 
			        	"						<td>"  +result.getString("pname") + "</td>\r\n" + 
			        	"						<!-- <td>Leathered black pants.</td> -->\r\n" + 
			        	"						<td>$"+ result.getFloat("price") +"</td>\r\n" + 
			        	"						<td>"+ result.getInt("quantity")  + "</td>\r\n" + 
			        	"						<td><b>$"+ String.format("%.2f", result.getFloat("subtotal")) +"</b></td>\r\n" + 
		        		"					</tr>\n"  );	 
		        }
		            
		        pwriter.println("				<tr>\r\n" + 
		        		"						<th></th>\r\n" + 
		        		"						<th></th>\r\n" + 
		        		"						<!-- <th></th> -->\r\n" + 
		        		"						<th></th>\r\n" + 
		        		"						<th>Total:</th>\r\n" + 
		        		"						<th>$ "+String.format("%.2f", sum)+" </th>\r\n" + 
		        		"					</tr>\r\n" + 
		        		"				</tbody>\r\n" + 
		        		"			</table>\r\n" + 
		        		"");
		        
		        pwriter.println("		<div class=\"options_area\">\r\n" + 
		        		"					<form action=\"index\" method=\"post\" class=\"continue_shopping_btn\">\r\n" + 
					    "						<input name=\"username\" value=\""+ username + "\" type=\"hidden\">\r\n" + 
					    "						<div class = \"button\">\r\n" + 
					    "							<img src=\"images/cart/continue_shopping.png\"><input type=\"submit\" value=\"CONTINUE SHOPPING\" class=\"cart_options_btn\">\r\n" + 
					    "						</div>\r\n" + 
					    "					</form>" +

		        		"					<form action=\"Cart\" method=\"post\" class=\"update_cart_btn\">\r\n" + 
					    "						<input name=\"username\" value=\""+ username + "\" type=\"hidden\">\r\n" + 
					    "						<div class = \"button\">\r\n" + 
					    "							<img src=\"images/cart/update_cart.png\"><input type=\"submit\" value=\"UPDATE CART\" class=\"cart_options_btn\">\r\n" + 
					    "						</div>\r\n" + 
					    "					</form>" +

		        		"					<form action=\"ClearCart\" method=\"post\" class=\"clear_cart_btn\">\r\n" + 
					    "						<input name=\"username\" value=\""+ username + "\" type=\"hidden\">\r\n" + 
					    "						<div class = \"button\">\r\n" + 
					    "							<img src=\"images/cart/clear_cart.png\"><input type=\"submit\" value=\"CLEAR CART\" class=\"cart_options_btn\">\r\n" + 
					    "						</div>\r\n" + 
					    "					</form>" +

		        		"					<form action=\"Checkout\" method=\"post\" class=\"checkout_btn\">\r\n" + 
					    "						<input name=\"username\" value=\""+ username + "\" type=\"hidden\">\r\n" + 
					    "						<div class = \"button\">\r\n" + 
					    "							<img src=\"images/cart/checkout.png\"><input type=\"submit\" value=\"CHECKOUT\" class=\"cart_options_btn\">\r\n" + 
					    "						</div>\r\n" + 
					    "					</form>" +
		        		"			</div>\r\n" + 
		        		"		</div>\r\n" + 
		        		"	</div>\r\n" + 
		        		"");
		        
		    	pwriter.println(footer_str);
				pwriter.close();		        

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		else if (username == null && pid != null){
			System.out.println("You want me to add sth in WHO's cart??");
			res.sendRedirect("/login");
		}
		else { // username != null && pid != null
			System.out.println("Going to add to " + username + "'s cart " + quantity + " " + pid + "s.");
			
			String url="jdbc:mysql://localhost:3306/eshopdb?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String dbUser = "root";
			String dbPassword = "2421057837olicia!";
			String sql = "Insert into cart(username_FK, idproduct_cart_FK, quantity) values (?,?,?)";
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection myConn = DriverManager.getConnection(url, dbUser, dbPassword);
		        Statement stm0 = myConn.createStatement();
		        ResultSet result0 = stm0.executeQuery(String.format("Select p.stock, p.pname \r\n" + 
						"from product p \r\n" + 
						"where p.idproduct = '%d'",Integer.parseInt(pid))); //geting stock, product name for product with pid
		        
		        
		        // at each request the user sends, check if the stock number is larger than the requested quantity
		        //if not, the user can't add the product to the cart
		        
//		        if (result0.getInt("stock") >= Integer.parseInt(req.getParameter("quantity")) ) {
		        
			        Statement st1 = myConn.createStatement();
			        
			        //checking if a product with pid is already in the cart and returning the quantity
			        
			        ResultSet rs = st1.executeQuery(String.format("select quantity as q\r\n" + 
			        		"from cart c\r\n" + 
			        		"where c.idproduct_cart_FK = '%d';", Integer.parseInt(pid)));
			        
			        PreparedStatement pstm = myConn.prepareStatement(sql); //creating connection
			        //product already exists in cart 
			        if (rs.first()) {
			        	  
					       
					        //change the quantity 
					       
					       String quantity_update = String.format("update cart c\r\n" + 
					       		"set c.quantity = c.quantity + '%d'\r\n" + 
					       		"where c.idproduct_cart_FK = '%d';", Integer.parseInt(req.getParameter("quantity")), Integer.parseInt(pid));
					       pstm.executeUpdate(quantity_update);
			        }
			        else {
			        	  pstm.setString(1, username);
					      pstm.setString(2, pid);
					      pstm.setString(3, quantity); //getting username, pid, and quantity 
					      pstm.executeUpdate();
			        	
			        }
			        
			        pstm.close();
			        stm0.close();
	        
		        //update the stock on the table product
		        String update_stock = String.format( "UPDATE product p, cart c\r\n" + 
		        		"set stock = stock - '%d'\r\n" + 
		        		"where p.idproduct  = c.idproduct_cart_FK;", Integer.parseInt(quantity));
		        
		        Statement stmt = myConn.createStatement();
		        stmt.executeUpdate(update_stock);
		        stmt.close();
		        
//		      } 
//		      else {
//	        		
//	        		System.out.println("im here in else ");
//	        		pwriter.println("We're sorry, the product " +result0.getString("pname")+ "has only " +result0.getInt("stock")+ "pieces left");
//		      }
//	        
		        
//		        stm0.close();
		        
		        String sql1 ="select distinct  pname, description, price, quantity, image_source, quantity*price as subtotal\r\n" + 
		        		"from user u,  product p\r\n" + 
		        		"join cart c on c.idproduct_cart_FK = p.idproduct and c.username_FK=\"" + username + "\";";
		       
		        Statement stm = myConn.createStatement();
		        ResultSet result = stm.executeQuery(sql1);
		   
		        pwriter.println(header_str);
		        Statement myStmt = myConn.createStatement();  
		        ResultSet searchResult = myStmt.executeQuery("select SUM(quantity) from cart where username_FK='" + username + "';");
				if(searchResult.next()) {
					System.out.println("got in if block in shirts");
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
		        
		 
		        double sum = 0;
		        while (result.next()) {
		        	String image_src = result.getString("image_source");
		        	sum =  sum + result.getFloat("subtotal");
		        	
		        		pwriter.println(
			        		
			        	
			        		"					<tr>\r\n" + 
			        		"						<td><img src=" + image_src + "></td>\r\n" + 
			        		"						<td>"  +result.getString("pname") + "</td>\r\n" + 
			        		"						<!-- <td>Leathered black pants.</td> -->\r\n" + 
			        		"						<td>$"+ result.getFloat("price") +"</td>\r\n" + 
			        		"						<td>"+ result.getInt("quantity")  + "</td>\r\n" + 
			        		"						<td><b>$"+ String.format("%.2f", result.getFloat("subtotal")) +"</b></td>\r\n" + 
			        		"					</tr>\n"  );
		        	 
		        }
		       
		        pwriter.println("				<tr>\r\n" + 
		        		"						<th></th>\r\n" + 
		        		"						<th></th>\r\n" + 
		        		"						<!-- <th></th> -->\r\n" + 
		        		"						<th></th>\r\n" + 
		        		"						<th>Total:</th>\r\n" + 
		        		"						<th>$ "+String.format("%.2f", sum)+" </th>\r\n" + 
		        		"					</tr>\r\n" + 
		        		"				</tbody>\r\n" + 
		        		"			</table>\r\n" + 
		        		"");
		        
		        pwriter.println("		<div class=\"options_area\">\r\n" + 
		        		"					<form action=\"index\" method=\"post\" class=\"continue_shopping_btn\">\r\n" + 
					    "						<input name=\"username\" value=\""+ username + "\" type=\"hidden\">\r\n" + 
					    "						<div class = \"button\">\r\n" + 
					    "							<img src=\"images/cart/continue_shopping.png\"><input type=\"submit\" value=\"CONTINUE SHOPPING\" class=\"cart_options_btn\">\r\n" + 
					    "						</div>\r\n" + 
					    "					</form>" +

		        		"					<form action=\"Cart\" method=\"post\" class=\"update_cart_btn\">\r\n" + 
					    "						<input name=\"username\" value=\""+ username + "\" type=\"hidden\">\r\n" + 
					    "						<div class = \"button\">\r\n" + 
					    "							<img src=\"images/cart/update_cart.png\"><input type=\"submit\" value=\"UPDATE CART\" class=\"cart_options_btn\">\r\n" + 
					    "						</div>\r\n" + 
					    "					</form>" +

		        		"					<form action=\"ClearCart\" method=\"post\" class=\"clear_cart_btn\">\r\n" + 
					    "						<input name=\"username\" value=\""+ username + "\" type=\"hidden\">\r\n" + 
					    "						<div class = \"button\">\r\n" + 
					    "							<img src=\"images/cart/clear_cart.png\"><input type=\"submit\" value=\"CLEAR CART\" class=\"cart_options_btn\">\r\n" + 
					    "						</div>\r\n" + 
					    "					</form>" +

		        		"					<form action=\"Checkout\" method=\"post\" class=\"checkout_btn\">\r\n" + 
					    "						<input name=\"username\" value=\""+ username + "\" type=\"hidden\">\r\n" + 
					    "						<div class = \"button\">\r\n" + 
					    "							<img src=\"images/cart/checkout.png\"><input type=\"submit\" value=\"CHECKOUT\" class=\"cart_options_btn\">\r\n" + 
					    "						</div>\r\n" + 
					    "					</form>" +
		        		"			</div>\r\n" + 
		        		"		</div>\r\n" + 
		        		"	</div>\r\n" + 
		        		"");
		        stm.close();
		    	pwriter.println(footer_str);
				pwriter.close();		        
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
	}
	/* This method is called from the topbar */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		PrintWriter pwriter = res.getWriter();
		pwriter.println(header_str);
		
		pwriter.println(get_login_and_navbar());
		
		pwriter.println("<div class=\"container\"><div class=\"page_title\"><b> You have to log in first in order to view your cart. </b></div>");
		
		pwriter.println("<form action=\"index.html\" method=\"get\">\r\n" + 
				"			<div class = \"button\">\r\n" + 
				"				<input type=\"submit\" value=\"Return to Home\" class=\"add_to_cart_btn\">\r\n" + 
				"			</div>\r\n" + 
				"		</form>\r\n" + 
				"		<form action=\"login_register.html\" method=\"get\">\r\n" + 
				"			<input type=\"submit\" value=\"Login/Register\" class=\"add_to_cart_btn\">\r\n" + 
				"		</form></div>");
		

		
		//pwriter.println();
		pwriter.println(footer_str);
		pwriter.close();
	}
	
 
 
    public static void deleteProduct(Connection conn, String code) throws SQLException {
        String sql = String.format("Delete From product p where p.idproduct = '%d'", Integer.parseInt(code));
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
 
        pstm.executeUpdate(sql);
    }
    
}
