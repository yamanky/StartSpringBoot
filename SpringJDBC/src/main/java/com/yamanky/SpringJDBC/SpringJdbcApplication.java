package com.yamanky.SpringJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) {
		String sql = "SELECT 1";
		SqlParameterSource param = new MapSqlParameterSource();
		Integer result = jdbcTemplate.queryForObject(sql, param, Integer.class);

		System.out.println("result = " + result);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}
}
