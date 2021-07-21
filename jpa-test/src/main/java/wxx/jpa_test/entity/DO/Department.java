package wxx.jpa_test.entity.DO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = -4056705910921509455L;

	public static final int STATUS_DISABLED = 0;
 
    public static final int STATUS_ENABLED = 1;
 
 
    @Column(columnDefinition="bigint COMMENT '唯一标识'")
    @Id
    private Long id;
 
    @Column(columnDefinition = "varchar(255) COMMENT '部门名称'")
    private String departmentName;
 
    @Column(nullable = true, columnDefinition = "varchar(1000) COMMENT '部门描述'")
    private String departmentDesc;
 
    @Column(columnDefinition = "tinyint(1) DEFAULT 1 COMMENT '状态（1：可用，0：禁用）'")
    private Integer status;
 
    @Column(nullable = true, columnDefinition = "bigint(20) COMMENT '归属人ID'")
    private Long userId;
 
    @Column(columnDefinition = "bigint(20) COMMENT '父ID'")
    private Long parentId;

}