package com.learnspring.todoapp.service;

import com.learnspring.todoapp.entity.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> findAll();

    Todo findById(int theId);

    void save(Todo theTodo);

    void deleteById(int theId);
}
