package co.com.sofka.crud.list;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListToDoRepository extends CrudRepository<ListToDo, Long> {
}
