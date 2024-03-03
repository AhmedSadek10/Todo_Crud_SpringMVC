package com.learnspring.todoapp.service;

import com.learnspring.todoapp.dao.TodoRepository;
import com.learnspring.todoapp.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TodoServiceimpl implements TodoService {

    private TodoRepository todoRepository;

    public TodoServiceimpl(TodoRepository theTodoRepository) {
        todoRepository = theTodoRepository;
    }
    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(int theId) {
        Optional<Todo> result = todoRepository.findById(theId);

        Todo theTodo = null;

        if (result.isPresent()) {
            theTodo = result.get();
        }
        else {
            // we didn't find the todo
            throw new RuntimeException("Did not find todo id - " + theId);
        }

        return theTodo;
    }

    @Override
    public void save(Todo theTodo) {
        todoRepository.save(theTodo);
    }

    @Override
    public void deleteById(int theId) {
        todoRepository.deleteById(theId);
    }
}
