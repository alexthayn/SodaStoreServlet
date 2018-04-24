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
import java.util.List;

@WebServlet(
	name="selectsodaservlet",
	urlPatterns = "/SelectSoda"
)

public class SelectSodaServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	String sodaType = req.getParameter("Type");

	SodaSelect sodaSelect = new SodaSelect();
	SodaType l = SodaType.valueOf(sodaType);
	
	List sodaBrands = sodaSelect.getAvailableBrands(l);

	req.setAttribute("brands",sodaBrands);
	RequestDispatcher view = req.getRequestDispatcher("result.jsp");
	view.forward(req, resp);
	}
}

