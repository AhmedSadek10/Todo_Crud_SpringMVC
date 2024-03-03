package com.learnspring.todoapp.controller;

import com.learnspring.todoapp.entity.Todo;
import com.learnspring.todoapp.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/todos")
@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController (TodoService theTodoService){
        todoService = theTodoService;
    }
    @GetMapping("/list")
    public String listTodos(Model theModel) {
        List<Todo> theTodos = todoService.findAll();
        // add to the spring model
        theModel.addAttribute("todos", theTodos);

        return "list-todos";
    }

    @GetMapping("showFormForAdd")
    public String showFormForAdd (Model theModel){
        Todo theTodo = new Todo();
        theModel.addAttribute("todo" , theTodo);
        return "todos/showFormForAdd";
    }
    @PostMapping("/save")
    public String saveTodo(@ModelAttribute("todo")  Todo theTodo){
        todoService.save(theTodo);
        return "redirect:/todos/list" ;
    }

    @GetMapping("/delete")
    public String deleteTodo(@RequestParam("todoId") int id){
        todoService.deleteById(id);
        return "redirect:/todos/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateTodo (@RequestParam("todoId") int id , Model theModel){

        Todo todo = todoService.findById(id);
        theModel.addAttribute("todo" ,todo);
        return "todos/showFormForAdd";
    }
}
