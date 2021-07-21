package wxx.jpa_test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import wxx.jpa_test.entity.DO.Department;
import wxx.jpa_test.service.ServiceImpl1;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = {"classpath:application-test.properties"})
@SpringBootTest
public class JpaTest1 {
	
	/**
		CrudRepository提供CRUD的功能。
		PagingAndSortingRepository提供分页和排序功能, 继承自CrudRepository
		JpaRepository提供JPA相关的方法，如刷新持久化数据、批量删除。继承自PagingAndSortingRepository
		所以JpaRepository包含了CrudRepository和PagingAndSortingRepository所有的API。
		不需要JpaRepository和PagingAndSortingRepository提供的功能时，可直接使用CrudRepository。
	 */

    @Autowired
    protected ServiceImpl1 si;
   

    
    @Test
    public void tree() {
//    	Department d = Department.builder().departmentName("5").parentId(1L).id(5L).status(Department.STATUS_ENABLED).build();
//    	si.save(d);
    	
//    	List l = (List) si.findAll();
    	List l = si.getDepartmentTree(4, 1);
    	System.out.println(l.size());
    }
    
}