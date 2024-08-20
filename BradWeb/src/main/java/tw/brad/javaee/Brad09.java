package tw.brad.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Brad09")
@MultipartConfig( location = "C:\\Users\\User\\git\\repository\\BradWeb\\src\\main\\webapp\\upload" )
public class Brad09 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF=8");
		PrintWriter out = response.getWriter();
		
		System.out.println(request.getRemoteAddr());
		Part part = request.getPart("upload");
		System.out.println(part.getName());
		System.out.println(part.getSize());
		System.out.println(part.getSubmittedFileName());
		String filename = request.getRemoteAddr() + "_" + part.getSubmittedFileName();

		System.out.println(filename);
		if (part.getSize() > 0) {
			part.write(filename);
			out.print("Upload Success");
		}else {
			out.print("Upload Failure");
		}
		
		
		
		
	}

}
