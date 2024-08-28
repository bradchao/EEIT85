package tw.brad.javaee;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Brad21")
@MultipartConfig
public class Brad21 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Part icon = request.getPart("icon");
		
		InputStream in = icon.getInputStream();
		
		byte[] buf = in.readAllBytes();
		String base64String = Base64.getEncoder().encodeToString(buf);
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(String.format("<img src='data:image/png;base64, %s' />", base64String));
		
	
	}

}
