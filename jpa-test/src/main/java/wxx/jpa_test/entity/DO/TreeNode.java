package wxx.jpa_test.entity.DO;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Setter
@Getter
public class TreeNode<T> {
 
    @ApiModelProperty(value = "id", notes = "id")
    public Long id;
 
    @ApiModelProperty(value = "父ID", notes = "父ID")
    private Long parentId;
 
    @ApiModelProperty(value = "子节点", notes = "子节点")
    private List<T> children = new ArrayList<>();
 
}