package co.com.sofka.crud.list;

import co.com.sofka.crud.todo.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListToDoRepository extends CrudRepository<ListToDo, Long> {
    Iterable<ToDo> findAllToDosById(Long id);
}
