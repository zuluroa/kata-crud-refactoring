package co.com.sofka.crud.mapper;

import co.com.sofka.crud.dto.ListTodoDto;
import co.com.sofka.crud.model.ListTodo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListTodoMapper {

    ListTodoDto toListTodoDto(ListTodo listTodo);
    Iterable<ListTodoDto> toListTodoDtos(Iterable<ListTodo> todoList);
    ListTodo toListTodo(ListTodoDto todoDto);

}
