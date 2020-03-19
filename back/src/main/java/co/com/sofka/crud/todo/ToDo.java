package co.com.sofka.crud.todo;

import co.com.sofka.crud.list.ListToDo;

import javax.persistence.*;

@Entity
public class ToDo {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    private ListToDo todo;

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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ListToDo getTodo() {
        return todo;
    }

    public void setTodo(ListToDo todo) {
        this.todo = todo;
    }
}
