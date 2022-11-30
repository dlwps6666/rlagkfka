package hr.abc.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.abc.Handler.CERARequestHandlerAdapter;

public interface Controller {
	
	public CERARequestHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response);

}
