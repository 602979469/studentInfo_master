package net.fuzui.StudentInfo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登录拦截器，会拦截任何"/AdminHandler/**"，“/CourseHandler/**”，"/admin/**"的请求
 * 
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.interceptor
 * @ClassName: LoginInterceptor
 * @Description: 登录拦截器
 * @Author: 王泽
 * @CreateDate: 2019年4月12日 下午3:37:19
 * @UpdateUser: 王泽
 * @UpdateDate: 2019年4月12日 下午3:37:19
 * @UpdateRemark: 新建
 * @Version: 1.0
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    /**
     * 当拦截器执行时，如果在session域中没有找到aname，说明没有管理员登录过系统，跳转到登录界面
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Object admin = request.getSession().getAttribute("aname");
        if (admin == null) {
            System.out.println("尚未登录，调到登录页面");
            response.sendRedirect("/StudentInfo/index.jsp");
            return false;
        }
        return true;
	}

}
