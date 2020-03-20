package co.com.sofka.crud.todo;

import co.com.sofka.crud.list.ListToDo;

import javax.persistence.*;

@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean completed;

    @ManyToOne
    private ListToDo listToDo;

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

    public ListToDo getListToDo() {
        return listToDo;
    }

    public void setListToDo(ListToDo listToDo) {
        this.listToDo = listToDo;
    }
}
