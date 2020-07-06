package net.fuzui.StudentInfo.pojo;

import lombok.Data;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.pojo
 * @ClassName: StuExitSelect
 * @Description: 选课退选实体类
 * @Author: 王泽
 * @CreateDate: 2019-04-06 16:43
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-06 16:43
 * @UpdateRemark: 新建
 * @Version: 1.0
 */

@Data
public class StuExitSelect implements java.io.Serializable {


    /**
     *  序列化
     */
    private static final long serialVersionUID = 1L;
    //课程编号
    private String cid;
    //课程名称
    private String Cname;
    //学号
    private String sid;
    //总人数
    private Integer totalNum;
    //学生总数
    private Integer stuSum;


}

