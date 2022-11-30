package hr.abc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hr.abc.Handler.CERARequestHandlerAdapter;
import hr.abc.control.Controller;
import hr.abc.dao.CERARequestDAO;
import hr.abc.dto.CERARequestDTO;

public class CERARequestSelectController implements Controller {
	private static Log log = LogFactory.getLog(CERARequestSelectController.class);

	@Override
	public CERARequestHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		CERARequestDAO ceraRequestDAO = new CERARequestDAO();
		CERARequestDTO ceraRequestDTO = new CERARequestDTO();
		
		ArrayList<CERARequestDTO> arrayList = new ArrayList<CERARequestDTO>();
		
		arrayList = ceraRequestDAO.ceraRequestSelectAll();
		
		CERARequestHandlerAdapter ceraRequestHandlerAdapter = new CERARequestHandlerAdapter();
		ceraRequestHandlerAdapter.setPath("/WEB-INF/view/ceraRequest/ceraRequest_select_view.jsp");
		
		return ceraRequestHandlerAdapter;
	}

}
