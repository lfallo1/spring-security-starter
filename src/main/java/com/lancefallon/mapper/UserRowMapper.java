package com.lancefallon.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lancefallon.model.User;

public class UserRowMapper implements RowMapper<User> {

    public static final String USERNAME_COL = "username";
    public static final String PASSWORD_COL = "password";
    public static final String EMAIL_COL = "email";

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
    	return new User(rs.getString(USERNAME_COL), rs.getString(PASSWORD_COL), rs.getString(EMAIL_COL));
    }
}
