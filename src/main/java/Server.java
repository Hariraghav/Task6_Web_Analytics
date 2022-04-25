

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class server
 */
@WebServlet("/server")
public class Server extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Server() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String ip = request.getRemoteAddr();
    String website = request.getHeader("referer");
    String browser = request.getHeader("user-agent");
    Location l = new Location();
    String country =  l.getLoc(ip);
	UserDetails ub = new  UserDetails();
	ub.setIp(ip);
	ub.setUrl(website);
	ub.setBrowser(browser);
	ub.setCountry(country);
	User u  = new User();
	u.save(ub);
	}

	
}
