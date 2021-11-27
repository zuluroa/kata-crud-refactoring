package co.com.sofka.crud.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "list")
public class ListTodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    private String listname;

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
        return listname;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    public Set<Todo> getTodos() {
        return todos;
    }

    public void setTodos(Set<Todo> todos) {
        this.todos = todos;
    }

    @Override
    public String toString() {
        return "ListTodo{" +
                "id=" + id +
                ", Listname='" + listname + '\'' +
                ", todos=" + todos +
                '}';
    }
}
