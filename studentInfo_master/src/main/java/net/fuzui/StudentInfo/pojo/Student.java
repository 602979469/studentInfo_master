package net.fuzui.StudentInfo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ProjectName:	StudentInfo
* @Package: net.fuzui.StudentInfo.pojo
* @ClassName: Student
* @Description: 学生实体类
* @Author: 王泽
* @CreateDate: 2019-04-06 16:11
* @UpdateUser: 王泽
* @UpdateDate: 2019-04-06 16:11
* @UpdateRemark: 新建
* @Version: 1.0
 */


@NoArgsConstructor
@Data
public class Student implements java.io.Serializable{

	//序列化
	private static final long serialVersionUID = 1L;
	//学号
	private String sid;
	//姓名
	private String sname;
	//身份证号
	private String sidcard;
	//性别
	private String ssex;
	//密码
	private String spassword;
	//年龄
	private String sage;
	//班级
	private String classr;
	//专业
	private String profession;
	//学院
	private String college;

}
