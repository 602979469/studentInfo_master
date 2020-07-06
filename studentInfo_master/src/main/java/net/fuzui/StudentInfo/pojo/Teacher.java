package net.fuzui.StudentInfo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.pojo
 * @ClassName: Teacher
 * @Description: 教师实体类
 * @Author: 王泽
 * @CreateDate: 2019-04-06 16:15
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-06 16:15
 * @UpdateRemark: 新建
 * @Version: 1.0
 */

@Data
@NoArgsConstructor
public class Teacher implements java.io.Serializable{
    //序列化
    private static final long serialVersionUID = 1L;
    //教师编号
    private String tid;
    //教师姓名
    private String tname;
    //教师密码
    private String tpassword;
    //教师性别
    private String tsex;
    //教师简介
    private String introduction;

}
