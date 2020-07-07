package net.fuzui.StudentInfo.config;

import net.fuzui.StudentInfo.interceptor.LoginInterceptor;
import net.fuzui.StudentInfo.interceptor.StudentLoginInterceptor;
import net.fuzui.StudentInfo.interceptor.TeacherLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Autowired
    private StudentLoginInterceptor studentLoginInterceptor;
    @Autowired
    private TeacherLoginInterceptor teacherLoginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        registry.addInterceptor(loginInterceptor).addPathPatterns("/AdminHandler/**","/CourseHandler/**","/admin/**");
        registry.addInterceptor(studentLoginInterceptor).addPathPatterns("/StudentHandler/**","/student/**");
        registry.addInterceptor(teacherLoginInterceptor).addPathPatterns("/CoursePlanHandler/**","/TeacherHandler/**","/teacher/**");
    }
}
