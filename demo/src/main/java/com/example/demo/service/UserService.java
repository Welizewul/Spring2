package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервисный класс для работы с пользователями.
 */
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository; // Объект репозитория для работы с БД.

    /**
     * getUserById - метод получения данных о пользователе по его id.
     *
     * @param id - уникальный идентификатор.
     * @return - данные о пользователе.
     */
    public User getUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    /**
     * findAll - метод получения списка всех пользователей, имеющихся в БД.
     *
     * @return - список пользователей.
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * saveUser - метод создания нового пользователя.
     *
     * @param user объект пользователя.
     * @return объект пользователя с присвоенным id.
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * deleteById - метод удаления пользователя по его id.
     *
     * @param id - уникальный идентификатор пользователя.
     */
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    /**
     * updateUser - метод изменения данных о пользователе.
     *
     * @param user - объект пользователя с новыми данными.
     */
    public void updateUser(User user) {
        userRepository.update(user);
    }
}