

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsServlet () {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String s = request.getParameter("url");
			UserDetails.setCurrentUrl(s);
			response.setContentType("text/html");  	          
	        List<UserDetails> list=User.getDetails(s);
	        List<CountryDetails> list1=User.getCountryData(s);
	        List<DateDetails> list2=User.getDateData(s);
	        List<BrowserDetails> list3=User.getBrowserData(s);
	        request.setAttribute("list", list);
	        request.setAttribute("list1", list1);
	        request.setAttribute("list2", list2);
	        request.setAttribute("list3", list3);
		    request.getRequestDispatcher("site_analytics.jsp").forward(request, response);
	}



}
