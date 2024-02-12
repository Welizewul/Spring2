package com.example.demo.repositories;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Класс SqlQuery реализует инкапсуляцию SQL-запросов к базе данных из application.properties.
 */

@Component                              // Класс является компонентом Spring и управляется контейнером Spring.
@ConfigurationProperties("sql.query")   // Свойства настраиваются с помощью приложения префикса "sql.query"
@Data                                   // Генерирует геттеры, сеттеры, а также методы toString, hashCode и equals.
public class SqlQuery {
    private String findUserById;        // Получение пользователя по его уникальному идентификатору.
    private String findAllUsers;        // Получение всех пользователей.
    private String saveUser;            // Сохранение пользователя.
    private String deleteUser;          // Удаление пользователя.
    private String updateUser;          // Обновление данных пользователя.
}