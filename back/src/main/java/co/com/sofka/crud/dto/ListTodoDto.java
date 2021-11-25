package co.com.sofka.crud.dto;

import java.util.Set;

public class ListTodoDto {

    private Long id;
    private String listname;
    private Set<TodoDto> todos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListname() {
        return listname;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    public Set<TodoDto> getTodos() {
        return todos;
    }

    public void setTodos(Set<TodoDto> todos) {
        this.todos = todos;
    }
}
