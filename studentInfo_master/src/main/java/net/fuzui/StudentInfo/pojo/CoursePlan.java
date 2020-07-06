package net.fuzui.StudentInfo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.pojo
 * @ClassName: CoursePlan
 * @Description: 课程安排实体类
 * @Author: 王泽
 * @CreateDate: 2019-04-06 16:28
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-06 16:28
 * @UpdateRemark: 新建
 * @Version: 1.0
 */

@Data
@NoArgsConstructor
public class CoursePlan implements java.io.Serializable {
    /**
     *  序列化
     */
    private static final long serialVersionUID = 1L;
    //开课班级
    private String courseclass;
    //上课时间
    private String coursetime;
    //上课周
    private String courseweek;
    //课程编号
    private String cid;
    //教师编号
    private String tid;
    //上课教室
    private String classroom;
    //学分
    private String credits;
    //学时
    private String period;
    //总人数
    private String totalnum;

}

