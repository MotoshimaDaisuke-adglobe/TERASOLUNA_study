package com.example.todo.api.todo;

import org.mapstruct.Mapper;

import com.example.todo.domain.model.Todo;

@Mapper
public interface TodoMapper {

    TodoResource map(Todo todo);

    Todo map(TodoResource todoResource);
}