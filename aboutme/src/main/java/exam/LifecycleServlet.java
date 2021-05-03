package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 생명주기 
// 아래 url로 서버가 요청을 보냈겠죠?
// 서버는 이 url을 받아서 이Url매핑은 LifecycleServlet이라는 정보를 알아냈을 거임 -> 해당클래스가 메모리에 존재할까라는 것을 체크함
// 만약 메모리에 존재하지 않는다면 이 객체를 생성해야됨 = 즉 메모리에 올려주는 일을 해야됨
// 우리는 최초로 LifecycleServlet을 호출했기 때문에 서버는 이게 메모리에 없어라는 판단을 했을 거임
// 그래서 LifecycleServlet이 생성이되고 "LifecycleServlet 생성 !!"이 출력된거임
@WebServlet("/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Servlet 클래스 
    public LifecycleServlet() {
    	// 아래는 콘솔을 의미 : response객체로부터 얻어온 PrintWriter 객체 out하고는 목적지가 다름을 기억해야
    	// 응답결과로 보내줘는 아님. 콘솔에 보내주는 것.
       System.out.println("LifecycleServlet 생성 !!");
    }


	public void init(ServletConfig config) throws ServletException {
		// init이라는 메서드가 호출되면 호출되었다고 아래와 같이 콘솔에 보내줌
		System.out.println("init 호출 !!");

	}

	// destroy 이건 각 메소드의 내용을 변경하고 저장했을때, 즉 애플리케이션이 갱신 되거나 또는 WAS가 종료 
	// 기존 객체는 무쓸모이므로 기존객체를 메모리에 없앨때 호출되는 메소드. -> 반드시 새로고침 해야 생성자 메소드 호출됨  
	public void destroy() {
		System.out.println("destroy 호출 !!");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/firstweb/LifecycleServlet'>");
		out.println("name : <input type ='text' name='name'><br>");
		out.println("<input type='submit' value='ok'><br>");
		out.println("<form>");
		out.println("</body>");
		out.println("<html>");
		out.close();
		
	}

	// 요청 결과에서 파라미터 name을 응답결과에 hello name으로 출력해
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		out.println("<h1> hello " + name + "</h1>");
		out.close();
	}

	// 초기 호출한 이후에 화면을 새로고침하면 service만 호출되는것을 볼 수 있음.
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service 호출 !!");
//	}

}
