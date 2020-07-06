package net.fuzui.StudentInfo.handler;

import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.pojo.Teacher;
import net.fuzui.StudentInfo.service.AdminService;
import net.fuzui.StudentInfo.service.CoursePlanService;
import net.fuzui.StudentInfo.service.CourseService;
import net.fuzui.StudentInfo.service.SelectCourseService;
import net.fuzui.StudentInfo.service.StudentService;
import net.fuzui.StudentInfo.service.TeacherService;
import net.fuzui.StudentInfo.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 	负责处理登录请求的处理器，分别包含教师，学生，管理员的登录和登出请求
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.handler
 * @ClassName: AdminHandler
 * @Description: admin的handler层（servlet）
 * @Author: 王泽
 * @CreateDate: 2019-04-10 22:50
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-10 22:50
 * @UpdateRemark: 新建
 * @Version: 1.0
 */

@Controller
@RequestMapping("/LoginHandler")
public class LoginHandler {
    @Autowired
    AdminService adminServiceImpl;
    @Autowired
	StudentService studentService;
    @Autowired
	TeacherService teacherService;

	/**
	 * 处理管理员登录请求，如果账号密码吻合，会将用户名以 key为“aname”，value为用户名的键值对存入session中
	 * @param aname 账号用户名
	 * @param apassword 账号密码
	 * @param model model
	 * @param httpSession session
	 * @return
	 */
    @RequestMapping("/adminlogin")
    public String loginStudent(@RequestParam("aname") String aname, @RequestParam("apassword") String apassword,
                               Model model, HttpSession httpSession) {
        String n = null;
        n = adminServiceImpl.queryByNamePwd(aname,apassword);

        if (n != null && !"".equals(n)) {
            httpSession.setAttribute("aname", aname);
            return "admin/adminFace";
        } else {
            return "login";
        }

    }

	/**
	 * 处理管理员的登出请求，将session中的key为“aname”和“couList”的键值对移除，并且跳转回登录界面
	 * @param httpSession session
	 * @return
	 */
	@RequestMapping("/adminlogout")
    public ModelAndView adminLogout(HttpSession httpSession) {
        httpSession.removeAttribute("aname");
        httpSession.removeAttribute("couList");
        return new ModelAndView(new RedirectView("/StudentInfo/index.jsp"));
    }


	/**
	 * 处理学生的登录请求，如果账号密码吻合，会将用户名以 key为“sid”，value为学生的sid属性的属性值，key为“sname” value为学生的”sname“属性的属性值的键值对存入session中
	 * @param sid 学生的sid属性
	 * @param spassword 学生的spassword属性
	 * @param model model
	 * @param httpSession session
	 * @param httpRequest request
	 * @return
	 */
	@RequestMapping("/studentlogin")
 	public ModelAndView loginStudent(@RequestParam("sid") String sid, @RequestParam("spassword") String spassword,
 			Model model, HttpSession httpSession, HttpServletRequest httpRequest) {

 		Student student = new Student();
 		student = studentService.getByStuSid(sid);
 		if (studentService.queryByNamePwd(sid, spassword) != null) {
 			httpSession.setAttribute("sid", sid);
 			httpSession.setAttribute("sname", student.getSname());
 			return new ModelAndView(new RedirectView("../student/studentFace.jsp"));
 		} else {
 			httpRequest.setAttribute("msg","账号或密码不正确，登录失败!");
 			return new ModelAndView(new RedirectView("../fail.jsp"));
 		}

 	}

	/**
	 * 处理学生的登出请求，移除session中key为“sid”，“sname”，“courseList”，“ssrList”，“sesList”的属性值
	 * @param httpSession session
	 * @return
	 */
 	@RequestMapping("/studentlogout")
 	public ModelAndView studentLogout(HttpSession httpSession) {

 		httpSession.removeAttribute("sid");
 		httpSession.removeAttribute("sname");
 		httpSession.removeAttribute("courseList");
 		httpSession.removeAttribute("ssrList");
 		httpSession.removeAttribute("sesList");
 		return new ModelAndView(new RedirectView("/StudentInfo/index.jsp"));
 	}


	/**
	 * 处理教师的登录请求，会将用户名以 key为“tid”，value为教师的tid属性的属性值，key为“sname” ，value为 学生的“sname”姓名属性的属性值的键值对存入session中
	 * @param tid
	 * @param tpassword
	 * @param model
	 * @param httpSession
	 * @return
	 */
	@RequestMapping("/teacherlogin")
 	public ModelAndView loginTeacher(@RequestParam("tid") String tid, @RequestParam("tpassword") String tpassword,
 			Model model, HttpSession httpSession) {

 		if (teacherService.queryByNamePwd(tid, tpassword) != null) {

 			Teacher teacher = new Teacher();
 			teacher = teacherService.getByTeaTid(tid);
 			// model.addAttribute("tid", tid);
 			httpSession.setAttribute("tid", tid);
 			httpSession.setAttribute("tname", teacher.getTname());
 			// httpSession.setAttribute("teachername", teacher.getTname());
 			return new ModelAndView(new RedirectView("../teacher/teacherFace.jsp"));

 		} else {
 			return new ModelAndView(new RedirectView("../fail.jsp"));
 		}

 	}

	/**
	 * 处理教师的登出请求，移除session中key为“tid”，“tname”，“courseList”，“sesList”，“lookList”的属性值
	 * @param httpSession
	 * @return
	 */
 	@RequestMapping("/teacherlogout")
 	public ModelAndView teacherLogout(HttpSession httpSession) {

 		httpSession.removeAttribute("tid");
 		httpSession.removeAttribute("tname");
 		httpSession.removeAttribute("couList");
 		httpSession.removeAttribute("sesList");
 		httpSession.removeAttribute("lookList");
 		return new ModelAndView(new RedirectView("/StudentInfo/index.jsp"));
 	}
}
