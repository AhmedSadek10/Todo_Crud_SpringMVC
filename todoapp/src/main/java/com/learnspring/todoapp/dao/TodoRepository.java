package com.learnspring.todoapp.dao;

import com.learnspring.todoapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo , Integer> {
  // empty
}
