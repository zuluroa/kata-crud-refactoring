package co.com.sofka.crud.list;

import co.com.sofka.crud.todo.ToDo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ListToDo {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ToDo> items = new HashSet<>();

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

    public Set<ToDo> getItems() {
        return items;
    }

    public void setItems(Set<ToDo> items) {
        this.items = items;
    }
}
