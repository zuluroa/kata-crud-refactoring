package co.com.sofka.crud.list;

import co.com.sofka.crud.todo.ToDo;
import co.com.sofka.crud.todo.ToDoDTO;
import co.com.sofka.crud.todo.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ListToDoService {
    @Autowired
    private ListToDoRepository listToDoRepository;
    @Autowired
    private ToDoRepository toDoRepository;


    public Set<ToDoDTO> getToDosByListToDoId(Long id){
        return listToDoRepository.findById(id)
                .orElseThrow(() -> new NotFoundIdException("No existe el id de la lista"))
                .getItems().stream()
                .map(item -> new ToDoDTO(item.getId(), item.getName(), item.isCompleted()))
                .collect(Collectors.toSet());
    }

    public ToDoDTO saveToDo(Long listId, ToDoDTO toDoDTO){
        var toDo = new ToDo();
        toDo.setCompleted(toDoDTO.isCompleted());
        toDo.setName(toDoDTO.getName());
        toDo.setId(toDoDTO.getId());
        toDo.setTodo(listToDoRepository.findById(listId)
                .orElseThrow(() -> new NotFoundIdException("No existe el id de la lista")));
        var id = toDoRepository.save(toDo).getId();
        toDoDTO.setId(id);
        return toDoDTO;
    }

    public ListToDoDTO saveListToDo(ListToDoDTO listToDoDTO){
        var listToDo = new ListToDo();
        listToDo.setName(listToDoDTO.getName());
        listToDo.setId(listToDoDTO.getId());
        var id = listToDoRepository.save(listToDo).getId();
        listToDoDTO.setId(id);
        return listToDoDTO;
    }

    public Set<ListToDoDTO> getListToDoAll(){
        return StreamSupport
                .stream(listToDoRepository.findAll().spliterator(), false)
                .map(toDo -> {
                    var listDto = toDo.getItems()
                            .stream()
                            .map(item -> new ToDoDTO(item.getId(), item.getName(), item.isCompleted()))
                            .collect(Collectors.toSet());
                    return new ListToDoDTO(toDo.getId(), toDo.getName(), listDto);
                })
                .collect(Collectors.toSet());

    }

    public void delete(Long id) {
        var toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new NotFoundIdException("No existe el id del item"));
        toDoRepository.delete(toDo);
    }

    public ToDoDTO get(Long id) {
        return toDoRepository.findById(id)
                .map(todo -> new ToDoDTO(todo.getId(), todo.getName(), todo.isCompleted()))
                .orElseThrow(() -> new NotFoundIdException("No existe el id del To Do"));
    }
}
