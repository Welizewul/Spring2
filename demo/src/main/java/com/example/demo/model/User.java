package com.example.demo.model;

import lombok.Data;

/**
 * User - класс, определяющий свойства пользователя.
 */
@Data
public class User {
    private int id;            // Уникальный идентификатор.
    private String firstName;  // Имя пользователя.
    private String lastName;   // Фамилия пользователя.

}