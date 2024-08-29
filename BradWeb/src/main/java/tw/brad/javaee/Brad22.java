package tw.brad.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad22")
@MultipartConfig
public class Brad22 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 處理 Part
		byte[] buf = request.getPart("icon").getInputStream().readAllBytes();
		request.setAttribute("icon", buf);
		
		// 2. 其他交給 jsp 處理
		request.getRequestDispatcher("insertMember.jsp").forward(request, response);
	
	
	}
}
