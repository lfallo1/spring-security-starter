package com.lancefallon.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import com.lancefallon.mapper.UserRowMapper;
import com.lancefallon.model.User;

@Component
public class UserDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    public void addUser(User user) throws Exception {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        jdbcInsert.setTableName("user");
        jdbcInsert.setColumnNames(Arrays.asList("username", "password", "email"));

        // set the values to be inserted
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("username", user.getUsername());
        parameters.put("password", user.getPassword());
        parameters.put("email", user.getEmail());

        try {
            // perform the insert
            jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        } catch (Exception ex) {
            throw ex;
        }
    }

	public User findByUsername(String username) {
		try{
			return this.jdbcTemplate.queryForObject("SELECT * FROM public.user WHERE username = ?", new Object[]{username}, new UserRowMapper());
		} catch(DataAccessException ex){
			return null;
		}
		
	}
}

