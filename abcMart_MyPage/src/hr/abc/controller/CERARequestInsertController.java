package hr.abc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import hr.abc.Handler.CERARequestHandlerAdapter;
import hr.abc.control.Controller;
import hr.abc.dao.CERARequestDAO;
import hr.abc.dto.CERARequestDTO;

public class CERARequestInsertController implements Controller {
	private static Log log = LogFactory.getLog(CERARequestInsertController.class);

	public CERARequestHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		CERARequestDAO ceraRequestDAO = new CERARequestDAO();
		CERARequestDTO ceraRequestDTO = new CERARequestDTO();
		CERARequestHandlerAdapter ceraRequestHandlerAdapter = new CERARequestHandlerAdapter();
		String realFolder = "";
		String saveFolder = ".ceraRequestUpload";
		realFolder = request.getSession().getServletContext().getRealPath(saveFolder);
		int fileSize = 10 * 1024 * 1024;
		boolean result = false;
		
		try {
			MultipartRequest multipartRequest = new MultipartRequest(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
			ceraRequestDTO.setId(multipartRequest.getParameter("id"));
			ceraRequestDTO.setProductName(multipartRequest.getParameter("productName"));
			ceraRequestDTO.setContents(multipartRequest.getParameter("contents"));
			ceraRequestDTO.setReasons(multipartRequest.getParameter("reasons"));
			result = ceraRequestDAO.ceraRequestInsert(ceraRequestDTO);
			log.info("DTO 확인 - " + ceraRequestDTO);
			log.info("게시글 등록 - " + result);
			ceraRequestHandlerAdapter.setRedirect(true);
			ceraRequestHandlerAdapter.setPath("./CeraRequestSelect.do");
			
			return ceraRequestHandlerAdapter;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
