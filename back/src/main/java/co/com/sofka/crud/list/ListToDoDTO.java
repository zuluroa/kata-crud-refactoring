package co.com.sofka.crud.list;

import co.com.sofka.crud.todo.ToDoDTO;


import java.util.HashSet;
import java.util.Set;

public class ListToDoDTO {
    private Long id;
    private String name;
    private Set<ToDoDTO> items = new HashSet<>();

    public ListToDoDTO(){
        super();
    }
    public ListToDoDTO(Long id, String name, Set<ToDoDTO> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ToDoDTO> getItems() {
        return items;
    }

    public void setItems(Set<ToDoDTO> items) {
        this.items = items;
    }
}
