package co.com.sofka.crud.list;

import co.com.sofka.crud.todo.ToDo;

import javax.persistence.*;
import java.util.List;

@Entity
public class ListToDo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<ToDo> items;

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

    public List<ToDo> getItems() {
        return items;
    }

    public void setItems(List<ToDo> items) {
        this.items = items;
    }
}
