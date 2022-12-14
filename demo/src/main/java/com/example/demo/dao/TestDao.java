package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public void insert(String data) {
		
		String sql = "insert into testtable (test1) values (?)";
		jdbcTemplate.update(sql,data);
	
		
	}  

}
