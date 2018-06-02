package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cookie = request.getHeader("cookie");
		String email = request.getParameter("j_username");
		String pwd = request.getParameter("j_password");
		HttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://localhost:8080/BudgetBuddy/j_security_check");
//		post.setHeader("cookie", cookie);
//		post.setHeader("Cookie", cookie);
//		post.setHeader("Set-Cookie", cookie);
		post.addHeader("j_username", email);
		post.addHeader("j_password", pwd);
		HttpResponse httpResponse = client.execute(post);
		System.out.println(httpResponse.getStatusLine().getStatusCode());
		httpResponse.getHeaders("cookie");
		response.setHeader("Cookie", post.getLastHeader("cookie").getValue());
		//response.sendRedirect("http://localhost:8080/BudgetBuddy/");
		request.getRequestDispatcher("/").forward(request, response);
		
		
	}

}
