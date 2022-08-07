package emps.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emps.model.EmpsDTO;
import emps.service.EmpsService;


@WebServlet("/emps")
public class EmpsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpsService service = new EmpsService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		String page = request.getParameter("page");
		String sort = "empId";
		int count = 5;
		
		
		HttpSession session = request.getSession();
		if(session.getAttribute("pgc") != null) {
			count = Integer.parseInt(session.getAttribute("pgc").toString());
		}
		if(session.getAttribute("sort") != null) {
			sort = (String)session.getAttribute("sort");
		}
		
		if(request.getParameter("pgc") != null) {
			count = Integer.parseInt(request.getParameter("pgc"));
		}
		if(request.getParameter("sort") != null) {
			sort = request.getParameter("sort");
		}
		
		session.setAttribute("pgc", count);
		session.setAttribute("sort", sort);
		request.setAttribute("pgc", count);
		request.setAttribute("menuLocation", "emps");
		
		/*
		Cookie cookies[] = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals("pgc")) {
				count = Integer.parseInt(c.getValue());
			}
		}
		
		Cookie cookie = null;
		if(request.getParameter("pgc") != null) {
			count = Integer.parseInt(request.getParameter("pgc"));
			cookie = new Cookie("pgc", request.getParameter("pgc"));
		} else {
			cookie = new Cookie("pgc", String.valueOf(count));
		}

		cookie.setMaxAge(60*60*24);
		cookie.setPath("/depts");

		response.addCookie(cookie);
		*/
		List<EmpsDTO> datas = null;
		if(search == null) {
			int pageNum = 1;
			if(page != null) {
				if(!page.isEmpty() && page.matches("\\d+")) {
					pageNum = Integer.parseInt(page);
				}
			}
			datas = service.getPage(pageNum, count);
			request.setAttribute("page", pageNum);
			request.setAttribute("pageList", service.getPageNumberList(count));
		} else {
			EmpsDTO data = service.getId(search);
			if(data != null) {
				datas = new ArrayList<EmpsDTO>();
				datas.add(data);
			}
		}
		request.setAttribute("datas", datas);
		
		String view = "/WEB-INF/jsp/emps/index.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

}
