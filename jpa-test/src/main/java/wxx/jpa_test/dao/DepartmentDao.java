package wxx.jpa_test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import wxx.jpa_test.entity.DO.Department;

public interface DepartmentDao extends CrudRepository<Department, String> {
	
	List<Department> findByUserIdAndStatus(long id, int status);
	
}
