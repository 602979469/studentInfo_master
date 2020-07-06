package net.fuzui.StudentInfo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.pojo
 * @ClassName: SC
 * @Description: 选课实体类
 * @Author: 王泽
 * @CreateDate: 2019-04-06 16:39
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-06 16:39
 * @UpdateRemark: 新建
 * @Version: 1.0
 */

@Data
@NoArgsConstructor
public class SC implements java.io.Serializable {
    /**
     *  序列化
     */
    private static final long serialVersionUID = 1L;
    //id主键
    private Integer id;
    //学号
    private String sid;
    //课程编号
    private String cid;

}


