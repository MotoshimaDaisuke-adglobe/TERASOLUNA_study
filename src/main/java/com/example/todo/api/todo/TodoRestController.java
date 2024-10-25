package com.example.todo.api.todo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.domain.model.Todo;
import com.example.todo.domain.service.todo.TodoService;

@RestController
@RequestMapping("todos")
public class TodoRestController {

    @Inject
    TodoService todoService;

    @Inject
    TodoMapper beanMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TodoResource> getTodos() {
        Collection<Todo> todos = todoService.findAll();
        List<TodoResource> todoResources = new ArrayList<>();
        for (Todo todo : todos) {
            todoResources.add(beanMapper.map(todo));
        }
        return todoResources;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoResource postTodos(
            @RequestBody @Validated TodoResource todoResource) {
        Todo createdTodo = todoService.create(beanMapper.map(todoResource));
        TodoResource createdTodoResponse = beanMapper.map(createdTodo);
        return createdTodoResponse;
    }

    @GetMapping("{todoId}") // (1)
    @ResponseStatus(HttpStatus.OK)
    public TodoResource getTodo(@PathVariable("todoId") String todoId) { // (2)
        Todo todo = todoService.findOne(todoId); // (3)
        TodoResource todoResource = beanMapper.map(todo);
        return todoResource;
    }
    
    @PutMapping("{todoId}") // (1)
    @ResponseStatus(HttpStatus.OK)
    public TodoResource putTodo(@PathVariable("todoId") String todoId) { // (2)
        Todo finishedTodo = todoService.finish(todoId); // (3)
        TodoResource finishedTodoResource = beanMapper.map(finishedTodo);
        return finishedTodoResource;
    }
    
    @DeleteMapping("{todoId}") // (1)
    @ResponseStatus(HttpStatus.NO_CONTENT) // (2)
    public void deleteTodo(@PathVariable("todoId") String todoId) { // (3)
        todoService.delete(todoId); // (4)
    }

}