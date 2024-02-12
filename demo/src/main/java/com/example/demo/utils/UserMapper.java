package com.example.demo.utils;

import com.example.demo.model.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserMapper - класс UserMapper, реализующий интерфейс RowMapper, предназначен
 * для маппинга строк из базы данных на объекты типа User.
 */
public class UserMapper implements RowMapper<User> {
    /**
     * mapRow - метод, выполняющий преобразование данных из ResultSet в объект User.
     */
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        return user;
    }
}