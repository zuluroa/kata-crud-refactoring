package co.com.sofka.crud.list;

import co.com.sofka.crud.todo.ToDo;
import co.com.sofka.crud.todo.ToDoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ListToDoService {
    @Autowired
    private ListToDoRepository listToDoRepository;


    public Set<ToDoDTO> getItemsByListId(Long id){
        return listToDoRepository.findById(id)
                .orElseThrow(() -> new NotFoundIdException("No existe el id de la lista"))
                .getToDos().stream()
                .map(item -> new ToDoDTO(item.getId(), item.getName(), item.isCompleted()))
                .collect(Collectors.toSet());
    }

    public ToDoDTO addNewItem(Long listId, ToDoDTO aToDoDTO){
        var listToDo = listToDoRepository.findById(listId)
                .orElseThrow(() -> new NotFoundIdException("No existe el id de la lista"));
        var toDo = new ToDo();

        toDo.setCompleted(aToDoDTO.isCompleted());
        toDo.setName(aToDoDTO.getName());
        toDo.setId(aToDoDTO.getId());
        toDo.setListToDo(listToDo);

        //addition new to-do
        listToDo.getToDos().add(toDo);

        var listUpdated = listToDoRepository.save(listToDo);

        //last to-do saved given of the max value by id
        setIdForNewItem(aToDoDTO, listUpdated);

        return aToDoDTO;
    }

    public ToDoDTO updateItem(Long listId, ToDoDTO aToDoDTO){
        var listToDo = listToDoRepository.findById(listId)
                .orElseThrow(() -> new NotFoundIdException("No existe el id de la lista"));

        //edit to-do
        for(var item : listToDo.getToDos()){
            if(item.getId().equals(aToDoDTO.getId())){
                item.setCompleted(aToDoDTO.isCompleted());
                item.setName(aToDoDTO.getName());
                item.setId(aToDoDTO.getId());
                item.setListToDo(listToDo);
            }
        }

       listToDoRepository.save(listToDo);

        return aToDoDTO;
    }

    private void setIdForNewItem(ToDoDTO aToDoDTO, ListToDo listUpdated) {
        var lastToDo = listUpdated.getToDos()
                .stream()
                .max(Comparator.comparingInt(item -> item.getId().intValue()))
                .orElseThrow();
        aToDoDTO.setId(lastToDo.getId());
    }

    public ListToDoDTO saveList(ListToDoDTO aListToDoDTO){
        var listToDo = new ListToDo();
        listToDo.setName(aListToDoDTO.getName());
        listToDo.setId(aListToDoDTO.getId());
        var id = listToDoRepository.save(listToDo).getId();
        aListToDoDTO.setId(id);
        return aListToDoDTO;
    }

    public Set<ListToDoDTO> getListToDoAll(){
        return StreamSupport
                .stream(listToDoRepository.findAll().spliterator(), false)
                .map(toDo -> {
                    var listDto = toDo.getToDos()
                            .stream()
                            .map(item -> new ToDoDTO(item.getId(), item.getName(), item.isCompleted()))
                            .collect(Collectors.toSet());
                    return new ListToDoDTO(toDo.getId(), toDo.getName(), listDto);
                })
                .collect(Collectors.toSet());
    }

    public void delete(Long id) {

    }

    public ToDoDTO get(Long id) {
        return StreamSupport
                .stream(listToDoRepository.findAllToDosById(id).spliterator(), false)
                .filter(toDo -> id.equals(toDo.getId()))
                .findFirst()
                .map(toDo -> new ToDoDTO(toDo.getId(), toDo.getName(), toDo.isCompleted()))
                .orElseThrow();
    }
}
