package wxx.jpa_test.entity.VO;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import wxx.jpa_test.entity.DO.TreeNode;

@Getter
@Setter
@ApiModel(value = "部门VO")
public class DepartmentVO extends TreeNode<DepartmentVO> implements Serializable {
 
    @ApiModelProperty(value = "部门名称", notes = "部门名称")
    public String departmentName;
 
    @ApiModelProperty(value = "部门描述", notes = "部门描述")
    private String departmentDesc;
}
