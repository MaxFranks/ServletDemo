import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	public LoginServlet() {
		System.out.println("LoginServlet构造方法被调用");
	}
	public void init(ServletConfig config) {
		System.out.println("init(ServletConfig)");
	}
	protected void service(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
				request.setCharacterEncoding("UTF-8");//对每一个提交的数据进行编码和解码处理，使用utf-8
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				System.out.println("浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有): " + request.getRequestURL());
		        System.out.println("浏览器发出请求的资源名部分，去掉了协议和主机名: " + request.getRequestURI());
		        System.out.println("请求行中的参数部分: " + request.getQueryString());
		        System.out.println("浏览器所处于的客户机的IP地址: " + request.getRemoteAddr());
		        System.out.println("浏览器所处于的客户机的主机名: " + request.getRemoteHost());
		        System.out.println("浏览器所处于的客户机使用的网络端口: " + request.getRemotePort());
		        System.out.println("服务器的IP地址: " + request.getLocalAddr());
		        System.out.println("服务器的主机名: " + request.getLocalName());
		        System.out.println("得到客户机请求方式: " + request.getMethod());
//				System.out.println("name:" + name);
//				System.out.println("password:" + password);
				String html = null;
				if("admin".equals(name) && "123".equals(password)) {
					request.getRequestDispatcher("success.html").forward(request, response);//服务端跳转，客户的url不会变。这个转换服务器完成然后直接发给浏览器显示。
				}else {
		            response.sendRedirect("failed.html");//客户端跳转，客户会看到url的地址会变，这个页面是服务器告诉浏览器到这个地址来打开页面然后显示。
				}
				response.setContentType("text/html;charset=UTF-8");//返回浏览器的响应中使用utf-8编码
				PrintWriter pw = response.getWriter();
				pw.println(html);
			}
//	protected void doGet(HttpServletRequest request,HttpServletResponse response)
//			throws ServletException,IOException{
//		
//	}
	}