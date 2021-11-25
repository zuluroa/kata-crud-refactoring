package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.ListTodoDto;
import co.com.sofka.crud.mapper.ListTodoMapper;
import co.com.sofka.crud.model.ListTodo;
import co.com.sofka.crud.repository.ListTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListTodoService {

    @Autowired
    ListTodoRepository repository;

    @Autowired
    ListTodoMapper mapper;

    public Iterable<ListTodoDto> list(){
         return mapper.toListTodoDtos(repository.findAll());
    }

    public ListTodoDto save(ListTodoDto todoListDto){
        ListTodo listTodo = mapper.toListTodo(todoListDto);
        return mapper.toListTodoDto(repository.save(listTodo));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
