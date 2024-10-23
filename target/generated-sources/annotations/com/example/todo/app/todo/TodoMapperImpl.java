package com.example.todo.app.todo;

import com.example.todo.domain.model.Todo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-22T17:05:53+0900",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.50.v20240912-1419_BETA_JAVA23, environment: Java 21.0.4 (Eclipse Adoptium)"
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
