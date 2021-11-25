package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.mapper.TodoMapper;
import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;
    @Autowired
    private TodoMapper todoMapper;

    public Iterable<TodoDto> list() {
        Iterable<Todo> todos = repository.findAll();
        return todoMapper.toTodoDtos(todos);
    }


    public TodoDto save(TodoDto todoDto) {
        Todo todo = todoMapper.toTodo(todoDto);
        return todoMapper.toTodoDto(repository.save(todo));
    }

    public void delete(Long id) {
        repository.delete(todoMapper.toTodo(get(id)));
    }

    public TodoDto get(Long id) {
        Todo todo = repository.findById(id).orElseThrow();
        return todoMapper.toTodoDto(todo);
    }

}
