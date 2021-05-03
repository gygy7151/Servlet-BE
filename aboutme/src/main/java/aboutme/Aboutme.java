package aboutme;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Aboutme
 */
@WebServlet(name = "aboutme", urlPatterns = { "/today" })
public class Aboutme extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @param cal 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("euc-kr");
		
		
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String result = df.format(today);
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		PrintWriter out = response.getWriter();
		//Java에서 \'작은 따옴표 (작은 따옴표) 문자를 \"나타내고 큰 따옴표 (큰 따옴표) 문자를 나타냄.
		// ".."".." -> 그냥이렇게 입력시 에러발생 -> 아래와같이 "...\"\"..."이런식으로 작성해야됨. (이스케이프문자)
		out.write("<a href=\"http://localhost:8080/aboutme/index.html\">메인화면</a> <br><br><br><br><br><br>");
		out.write("<h3>현재시간 : " + result + " " + hour + ":" + minute + "<h3>" );
		

  		
		out.close();
	}

}
