package net.fuzui.StudentInfo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 成绩实体类
 * @author wangze
 *
 */

@Data
@NoArgsConstructor
@ToString
public class Grade {
	private String cid;
	private String cname;
	private String sid;
	private Integer grade;
	private Integer credits;

}
