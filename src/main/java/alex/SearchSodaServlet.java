package alex;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alex.thayn.SodaSearch;

@WebServlet(
		name="searchsodaservlet",
		urlPatterns = "/SearchSoda"
	)

public class SearchSodaServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	SodaSearch search = new SodaSearch();
	String query = req.getParameter("mySearch");

	List sodaResult = search.searchForSoda(query);

	req.setAttribute("results",sodaResult);
	RequestDispatcher view = req.getRequestDispatcher("searchresult.jsp");
	view.forward(req, resp);
	}
}
