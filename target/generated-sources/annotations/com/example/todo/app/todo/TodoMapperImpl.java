package com.example.todo.app.todo;

import com.example.todo.domain.model.Todo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-24T16:25:38+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class TodoMapperImpl implements TodoMapper {

    @Override
    public Todo map(TodoForm form) {
        if ( form == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setTodoId( form.getTodoId() );
        todo.setTodoTitle( form.getTodoTitle() );

        return todo;
    }
}
