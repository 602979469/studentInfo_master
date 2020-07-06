package net.fuzui.StudentInfo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.pojo
 * @ClassName: Course
 * @Description: 课程实体类
 * @Author: 王泽
 * @CreateDate: 2019-04-06 16:34
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-06 16:34
 * @UpdateRemark: 新建
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class Course implements java.io.Serializable{
    /**
     *  序列化
     */
    private static final long serialVersionUID = 1L;
    //课程编号
    private String cid;
    //课程名称
    private String cname;
    //课程介绍
    private String cintroduction;
    //类型
    private String type;
    //所属学院
    private String belongcoll;
    //所属专业
    private String belongpro;

}

