package wxx.jpa_test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wxx.jpa_test.dao.DepartmentDao;
import wxx.jpa_test.entity.DO.Department;
import wxx.jpa_test.entity.DO.TenantEntity;
import wxx.jpa_test.entity.VO.DepartmentVO;


@Service
public class ServiceImpl1 {

	 @Autowired
	private DepartmentDao departmentDao;

	public List getDepartmentTree(long id, int status) {
		List<Department> list = departmentDao.findByUserIdAndStatus(id, status);
        //重写工具类实现，就是把数组从 对象-> 对象VO 数组
//        List<DepartmentVO> result = 
		List<DepartmentVO> destList=new ArrayList<DepartmentVO>(list.size());  
		for(Department p : list){  
			DepartmentVO vo = new DepartmentVO();
			BeanUtils.copyProperties(p, vo);
			destList.add(vo);  
		}  		
         List<DepartmentVO> tree = getTree(destList);
         return tree;
	}
	
	public Iterable<Department> findAll() {
        return departmentDao.findAll();
    }
	
	
	public Department save(Department entity) {
    	return departmentDao.save(entity);
    }
	
	
	
	private List<DepartmentVO> getTree(List<DepartmentVO> list) {
        Map<Long, DepartmentVO> dtoMap = new HashMap<>();
        for (DepartmentVO node : list) {
            dtoMap.put(node.getId(), node);
        }
        List<DepartmentVO> resultList = new ArrayList<>();
        for (Map.Entry<Long, DepartmentVO> entry : dtoMap.entrySet()) {
            DepartmentVO node = entry.getValue();
            if (node.getParentId() == null) {
                // 如果是顶层节点，直接添加到结果集合中
                resultList.add(node);
            } else {
                // 如果不是顶层节点，找其父节点，并且添加到父节点的子节点集合中
                if (dtoMap.get(Long.valueOf(node.getParentId())) != null) {
                    dtoMap.get(Long.valueOf(node.getParentId())).getChildren().add(node);
                }
            }
        }
        return resultList;
    }
}
