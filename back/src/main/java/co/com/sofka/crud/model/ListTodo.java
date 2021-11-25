package co.com.sofka.crud.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "list")
public class ListTodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Listname;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "groupListId")
    private Set<Todo> todos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListname() {
        return Listname;
    }

    public void setListname(String listname) {
        Listname = listname;
    }

    public Set<Todo> getTodos() {
        return todos;
    }

    public void setTodos(Set<Todo> todos) {
        this.todos = todos;
    }
}
