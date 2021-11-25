package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.ListTodoDto;
import co.com.sofka.crud.model.ListTodo;
import co.com.sofka.crud.service.ListTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/listTodo")
@CrossOrigin()
public class ListController {

    @Autowired
    private ListTodoService service;

    @GetMapping(value = "/lists")
    public Iterable<ListTodoDto> list(){
        return service.list();
    }

    @PostMapping(value = "/list")
    public ListTodoDto save(@RequestBody ListTodoDto listTodo){
        return service.save(listTodo);
    }

    @DeleteMapping(value = "/{id}/list")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }
}
