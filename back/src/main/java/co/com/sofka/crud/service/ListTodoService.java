package co.com.sofka.crud.service;

import co.com.sofka.crud.model.ListTodo;
import co.com.sofka.crud.repository.ListTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListTodoService {

    @Autowired
    ListTodoRepository repository;

    public Iterable<ListTodo> list(){
        return repository.findAll();
    }

    public ListTodo save(ListTodo todo){
        return repository.save(todo);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
