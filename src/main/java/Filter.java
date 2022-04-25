

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Filter
 */
@WebServlet("/Filter")
public class Filter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String browser = request.getParameter("browser");
		String location = request.getParameter("location");
	    if(!from.isEmpty()&& !to.isEmpty()&& browser.isEmpty()&& location.isEmpty()) {
	    	 List<UserDetails> list = User.filterByDate(from,to);
	    	 request.setAttribute("from", from);
	    	 request.setAttribute("to", to);
	    	 request.setAttribute("browser", "");
	    	 request.setAttribute("location", "");
		    request.setAttribute("list", list);
		    request.getRequestDispatcher("filterby.jsp").forward(request, response);
	    }
	    else if(from.isEmpty()&& to.isEmpty()&& !browser.isEmpty()&& location.isEmpty()) {
	        List<UserDetails> list = User.filterByBrowser(browser);
	        request.setAttribute("from", "");
	    	 request.setAttribute("to", "");
	        request.setAttribute("browser", browser);
	        request.setAttribute("location", "");
		    request.setAttribute("list", list);
		    request.getRequestDispatcher("filterby.jsp").forward(request, response);
	    }
	    else if(from.isEmpty()&& to.isEmpty()&& browser.isEmpty()&& !location.isEmpty()) {
	        List<UserDetails> list = User.filterByCountry(location);
	        request.setAttribute("from", "");
	    	 request.setAttribute("to", "");
	        request.setAttribute("browser", "");
	        request.setAttribute("location", location);
		    request.setAttribute("list", list);
		    request.getRequestDispatcher("filterby.jsp").forward(request, response);
	    }
	    else if(!from.isEmpty()&& !to.isEmpty()&& !browser.isEmpty()&& location.isEmpty()) {
	        List<UserDetails> list = User.filterByDate_Browser(from,to,browser);
	        request.setAttribute("from", from);
	    	 request.setAttribute("to", to);
	    	 request.setAttribute("browser", browser);
	    	 request.setAttribute("location", "");
		    request.setAttribute("list", list);
		    request.getRequestDispatcher("filterby.jsp").forward(request, response);
	    }
	    else if(from.isEmpty()&& to.isEmpty()&& !browser.isEmpty()&& !location.isEmpty()) {
	        List<UserDetails> list = User.filterByBrowser_Country(browser,location);
	        request.setAttribute("from",  "");
	    	 request.setAttribute("to", "");
	        request.setAttribute("browser", browser);
	        request.setAttribute("location", location);
		    request.setAttribute("list", list);
		    request.getRequestDispatcher("filterby.jsp").forward(request, response);
	    }
	    else if(!from.isEmpty()&& !to.isEmpty()&& browser.isEmpty()&& !location.isEmpty()) {
	        List<UserDetails> list = User.filterByDate_Country(from,to,location);
		    request.setAttribute("from", from);
		    request.setAttribute("to", to);
		    request.setAttribute("browser", "");
		    request.setAttribute("location", location);
		    request.setAttribute("list", list);
		    request.getRequestDispatcher("filterby.jsp").forward(request, response);
	    }
	    else if(!from.isEmpty()&& !to.isEmpty()&& !browser.isEmpty()&& !location.isEmpty()) {
	        List<UserDetails> list = User.filterByDate_Browser_Country(from,to,browser,location);
	        request.setAttribute("from", from);
		    request.setAttribute("location", location);
	    	 request.setAttribute("to", to);
	    	 request.setAttribute("browser", browser);
	    	 request.setAttribute("list", list);
		    request.getRequestDispatcher("filterby.jsp").forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
