package co.com.sofka.crud.list;

import co.com.sofka.crud.todo.ToDo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "list_to_do")
public class ListToDo {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,  orphanRemoval = true)
    @JoinColumn(name = "list_to_do_id")
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
