package alex;

import alex.thayn.SodaSelect;
import alex.thayn.SodaType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
	name="selectsodaservlet",
	urlPatterns = "/SelectSoda"
)

public class SelectSodaServlet extends HttpServlet{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://jacksonmysqldb.ck9qmzz9yyn6.us-west-2.rds.amazonaws.com";
	static final String USER = "alex";
	static final String PASS = "1234";
	
	java.sql.Connection conn = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	String sodaType = req.getParameter("Type");
	System.out.println("Soda Company Requested: " + sodaType);
	List<String> sodas = new ArrayList<String>();

	//Connect to my db
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a soda database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected to database successfully...");
			
			String sqlquery = "SELECT * FROM alexdb.Sodas Inner Join alexdb.SodaCompanies on Sodas.SodaCompanyId = SodaCompanies.Id Where SodaCompanies.Name = " + sodaType;
			PreparedStatement sqlstatement = conn.prepareStatement(sqlquery);
			ResultSet result = sqlstatement.executeQuery();
			
			while(result.next()) {
				String name =  result.getString(1);
				sodas.add(name);
				System.out.println(name);
			}
				
			conn.close();
		} catch (ClassNotFoundException e) {
			// Handle errors class exceptions
		} catch (SQLException e) {
			// Handle errors for JDBC
		}
	

	req.setAttribute("brands",sodas);
	RequestDispatcher view = req.getRequestDispatcher("result.jsp");
	view.forward(req, resp);
	}
}

