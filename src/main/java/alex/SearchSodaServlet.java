package alex;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import alex.thayn.SodaSearch;

@WebServlet(
		name="searchsodaservlet",
		urlPatterns = "/SearchSoda"
	)

public class SearchSodaServlet extends HttpServlet{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql:jacksonmysqldb.ck9qmzz9yyn6.us-west-2.rds.amazonaws.com";
	static final String USER = "alex";
	static final String PASS = "1234";
	
	java.sql.Connection conn = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	SodaSearch search = new SodaSearch();
	String query = req.getParameter("Query");
	List sodaResult = null; // = search.searchForSoda(query);

	//Connect to my db
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to a soda database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		System.out.println("Connected to database successfully...");
		
		String sqlquery = "SELECT * FROM alexdb.Sodas";
		PreparedStatement sqlstatement = conn.prepareStatement(sqlquery);
		ResultSet result = sqlstatement.executeQuery();
		
		while(result.next()) {
			String name =  result.getString("Name");
			sodaResult.add(name);
			System.out.println(name);
		}
			
		conn.close();
	} catch (ClassNotFoundException e) {
		// Handle errors class exceptions
	} catch (SQLException e) {
		// Handle erros for JDBC
	}
	
	req.setAttribute("results",sodaResult);
	RequestDispatcher view = req.getRequestDispatcher("searchresult.jsp");
	view.forward(req, resp);
	}
}
