package co.com.sofka.crud.repository;

import co.com.sofka.crud.model.ListTodo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListTodoRepository extends CrudRepository<ListTodo, Long> {
}
