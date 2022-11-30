package hr.abc.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hr.abc.control.Controller;
import hr.abc.controller.CERARequestDeleteController;
import hr.abc.controller.CERARequestInsertController;
import hr.abc.controller.CERARequestSelectController;
import hr.abc.controller.CERARequestSelectDetailController;
import hr.abc.controller.CERARequestUpdateController;
import hr.abc.controller.CERARequestUpdateViewController;
import hr.abc.Handler.CERARequestHandlerAdapter;

public class CERARequestDispatcherServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(CERARequestDispatcherServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURL = requestURI.substring(contextPath.length());
		log.info("매핑명 조회 - " + pathURL);
		CERARequestHandlerAdapter ceraRequestHandlerAdapter = null;
		Controller controller = null;
		
		if (pathURL.equals("/CERARequestSelect.do")) {
			controller = new CERARequestSelectController();
			ceraRequestHandlerAdapter = controller.execute(request, response);
			log.info("부서 조회 확인 - " + ceraRequestHandlerAdapter);
		} else if(pathURL.equals("/CERARequestSelectDetail.do")) {
			controller = new CERARequestSelectDetailController();
			ceraRequestHandlerAdapter = controller.execute(request, response);
			log.info("상세 부서 조회 확인 - " + ceraRequestHandlerAdapter);
		} else if(pathURL.equals("/CERARequestInsertView.do")) {
			ceraRequestHandlerAdapter = new CERARequestHandlerAdapter();
			ceraRequestHandlerAdapter.setPath("/WEB-INF/view/dept/dept_insert.jsp");
			log.info("부서 등록 화면 뷰 확인 - " + ceraRequestHandlerAdapter);
		} else if(pathURL.equals("/CERARequestInsert.do")) {
			controller = new CERARequestInsertController();
			ceraRequestHandlerAdapter = controller.execute(request, response);
			log.info("부서 등록 확인 - " + ceraRequestHandlerAdapter);
		} else if(pathURL.equals("/CERARequestUpdateView.do")) {
			controller = new CERARequestUpdateViewController();
			ceraRequestHandlerAdapter = controller.execute(request, response);
			log.info("부서 수정 화면 뷰 확인 - " + ceraRequestHandlerAdapter);
		} else if(pathURL.equals("/CERARequestUpdate.do")) {
			controller = new CERARequestUpdateController();
			ceraRequestHandlerAdapter = controller.execute(request, response);
			log.info("부서 수정 확인 - " + ceraRequestHandlerAdapter);
		} else if(pathURL.equals("CERARequestDeleteView.do")) {
			ceraRequestHandlerAdapter = new CERARequestHandlerAdapter();
			ceraRequestHandlerAdapter.setPath("/WEB-INF/view/dept/dept_delete.jsp");
			log.info("부서 삭제 화면 뷰 확인 - " + ceraRequestHandlerAdapter);
		} else if(pathURL.equals("CERARequestDelete.do")) {
			controller = new CERARequestDeleteController();
			ceraRequestHandlerAdapter = controller.execute(request, response);
			log.info("부서 삭제 확인 - " + ceraRequestHandlerAdapter);
		}
		if (ceraRequestHandlerAdapter != null) {
			if (ceraRequestHandlerAdapter.isRedirect()) {
				response.sendRedirect(ceraRequestHandlerAdapter.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(ceraRequestHandlerAdapter.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

}
