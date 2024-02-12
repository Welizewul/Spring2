package com.example.demo.repositories;

import com.example.demo.model.User;
import com.example.demo.utils.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserRepository - класс, реализующий запросы к базе данных пользоватей.
 */
@Repository
@AllArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbc;     // Объект подключения к базе данных.
    private final SqlQuery query;        // Объект инкапсуляции SQL-запросов.

    /**
     * findUserById - метод получения данных о пользователи по id.
     *
     * @param id - уникальный идентификатор пользователя.
     * @return - объект пользователя или null в случае его отсутствия в БД.
     */
    public User findUserById(Integer id) {
        return jdbc.query(query.getFindUserById(), new Object[]{id}, new UserMapper())
                .stream().findFirst().orElse(null);
    }

    /**
     * Получение всех пользователей из БД.
     *
     * @return список пользователей.
     */
    public List<User> findAll() {
        return jdbc.query(query.getFindAllUsers(), new UserMapper());
    }

    /**
     * save - метод сохранения данных о пользователе в БД.
     *
     * @param user объект пользователя.
     * @return объект пользователя с id.
     */
    public User save(User user) {
        jdbc.update(query.getSaveUser(), user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * deleteById - метод удаления данных о пользователе из БД по его id.
     *
     * @param id идентификатор пользователя.
     */
    public void deleteById(int id) {
        jdbc.update(query.getDeleteUser(), id);
    }

    /**
     * update - метод обновления данных пользователя в БД.
     *
     * @param user - объект пользователя с измененными данными.
     */
    public void update(User user) {
        jdbc.update(query.getUpdateUser(), user.getFirstName(), user.getLastName(), user.getId());
    }
}