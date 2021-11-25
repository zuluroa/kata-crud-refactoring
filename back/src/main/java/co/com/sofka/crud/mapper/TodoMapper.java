package co.com.sofka.crud.mapper;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.model.Todo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    TodoDto toTodoDto(Todo todo);
    Iterable<TodoDto> toTodoDtos (Iterable<Todo> todos);
    Todo toTodo(TodoDto todoDto);
}
