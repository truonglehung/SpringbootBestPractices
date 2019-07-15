package com.vsolu.restfuljpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vsolu.restfuljpa.model.Blog;
import com.vsolu.restfuljpa.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
//	  List<Employee> findByNameContainingOrContentContaining(String text, String textAgain);
}
