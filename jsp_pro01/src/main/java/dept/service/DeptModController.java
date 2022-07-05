package dept.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.model.DeptDTO;


@WebServlet("/depts/mod")
public class DeptModController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DeptService service = new DeptService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		DeptDTO data = service.getDeptId(id);
		
		request.setAttribute("data", data);
		
		String view = "/WEB-INF/jsp/dept/mod.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		String mngId = request.getParameter("mngId");
		String locId = request.getParameter("locId");
		
		DeptDTO data = new DeptDTO();
		data.setDeptId(Integer.parseInt(deptId));
		data.setDeptName(deptName);
		data.setMngId(Integer.parseInt(mngId));
		data.setLocId(Integer.parseInt(locId));
		
		DEPT_SERVICE_STATUS status = service.modifyDept(data);
		
		String view = "/WEB-INF/jsp/dept/mod.jsp";
		
		switch(status) {
		case SUCCESS :
			response.sendRedirect("/jsp01/depts?search=" + data.getDeptId());
			return;
		case MNG_ID_NOT_EXISTS :
			request.setAttribute("errorMsg", "관리자 ID가 존재하지 않습니다.");
			break;
		case LOC_ID_NOT_EXISTS :
			request.setAttribute("errorMsg", "지역 ID가 존재하지 않습니다.");
			break;
		case FAILED :
			request.setAttribute("errorMsg", "알 수 없는 오류가 발생하였습니다.");
			break;
		}
		
		request.setAttribute("data", data);
		request.setAttribute("error", true);
		request.getRequestDispatcher(view).forward(request, response);
	}

}
