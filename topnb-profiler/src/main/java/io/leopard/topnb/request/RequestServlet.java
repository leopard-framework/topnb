package io.leopard.topnb.request;

import io.leopard.topnb.TopnbBeanFactory;
import io.leopard.topnb.web.Menu;
import io.leopard.topnb.web.freemarker.TemplateView;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求耗时.
 * 
 * @author 阿海
 *
 */
// @WebServlet(name = "topnbRequestServlet", urlPatterns = "/topnb/request.leo")
public class RequestServlet extends HttpServlet implements Menu {

	private static final long serialVersionUID = 1L;
	private static RequestService requestService = TopnbBeanFactory.getRequestService();

	@Override
	public String getName() {
		return "请求耗时";
	}

	@Override
	public String getUrl() {
		return "/topnb/request.leo";
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<RequestDto> paging = requestService.list();
		TemplateView view = new TemplateView("/topnb/ftl/", "request");
		view.addObject("paging", paging);
		view.render(request, response);
	}

}
