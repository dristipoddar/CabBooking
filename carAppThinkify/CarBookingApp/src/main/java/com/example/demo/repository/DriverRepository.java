package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Driver;
@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{
	@Query("FROM Driver WHERE driver_name = ?1")
	Driver findbyName(String driver_name);
	
	@Query("FROM Driver WHERE driver_available = ?1")
	List<Driver> findbyAvailable(Boolean driver_available);
	
	
}
