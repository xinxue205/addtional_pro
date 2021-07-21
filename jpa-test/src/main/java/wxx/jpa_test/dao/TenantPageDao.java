package wxx.jpa_test.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import wxx.jpa_test.entity.DO.TenantEntity;

public interface  TenantPageDao extends PagingAndSortingRepository<TenantEntity, Integer> {
	 
}
