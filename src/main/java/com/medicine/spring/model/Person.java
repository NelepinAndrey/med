package com.medicine.spring.model;


import lombok.Data;

import javax.persistence.*;

@Data //Применяет сразу несколько аннотаций Lombok.
@Entity //указываем что данный бин является сущностью
@Table(name = "person") //указываем таблицу которая будет отображаться в сущности
public class Person {
    @Id //id колонки
    @GeneratedValue(strategy = GenerationType.IDENTITY) //указываем стратегию
    private Long id;

    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
}
