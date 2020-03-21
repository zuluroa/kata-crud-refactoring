package co.com.sofka.crud.list;

import co.com.sofka.crud.todo.ToDo;
import co.com.sofka.crud.todo.ToDoDTO;
import co.com.sofka.crud.todo.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ListToDoService {

    public static final String NO_FAULT_ID = "No existe el id de la lista";
    private ListToDoRepository listToDoRepository;
    private ToDoRepository toDoRepository;

    @Autowired
    public ListToDoService(ListToDoRepository listToDoRepository, ToDoRepository toDoRepository) {
        this.listToDoRepository = listToDoRepository;
        this.toDoRepository = toDoRepository;
    }

    public Set<ToDoDTO> getToDosByListId(Long id) {
        return listToDoRepository.findById(id)
                .orElseThrow(() -> new NotFoundIdException(NO_FAULT_ID))
                .getToDos().stream()
                .map(item -> new ToDoDTO(item.getId(), item.getName(), item.isCompleted(), id))
                .collect(Collectors.toSet());
    }

    public ToDoDTO addNewToDoByListId(Long listId, ToDoDTO aToDoDTO) {
        var listToDo = listToDoRepository.findById(listId)
                .orElseThrow(() -> new NotFoundIdException(NO_FAULT_ID));
        var toDo = new ToDo();


        toDo.setCompleted(aToDoDTO.isCompleted());
        toDo.setName(Objects.requireNonNull(aToDoDTO.getName()));
        toDo.setId(aToDoDTO.getId());

        if(toDo.getName().isEmpty() || toDo.getName().length() < 3){
            throw new ToDoBusinessException("No valid entity To-Do to be save");
        }

        //addition new to-do
        listToDo.getToDos().add(toDo);

        var listUpdated = listToDoRepository.save(listToDo);
        //last item
        var lastToDo = listUpdated.getToDos()
                .stream()
                .max(Comparator.comparingInt(item -> item.getId().intValue()))
                .orElseThrow();
        aToDoDTO.setId(lastToDo.getId());
        aToDoDTO.setListId(listId);
        return aToDoDTO;
    }

    public ToDoDTO updateAToDoByListId(Long listId, ToDoDTO aToDoDTO) {
        var listToDo = listToDoRepository.findById(listId)
                .orElseThrow(() -> new NotFoundIdException(NO_FAULT_ID));

        //edit to-do
        for(var item : listToDo.getToDos()){
            if(item.getId().equals(aToDoDTO.getId())){
                item.setCompleted(aToDoDTO.isCompleted());
                item.setName(Objects.requireNonNull(aToDoDTO.getName()));
                item.setId(Objects.requireNonNull(aToDoDTO.getId()));
            }
        }

       listToDoRepository.save(listToDo);

        return aToDoDTO;
    }


    public ListToDoDTO newListToDo(ListToDoDTO aListToDoDTO) {
        var listToDo = new ListToDo();
        listToDo.setName(Objects.requireNonNull(aListToDoDTO.getName()));
        if(listToDo.getName().isEmpty() || listToDo.getName().length() < 3){
            throw new ToDoBusinessException("No valid entity List To-Do to be save");
        }
        var id = listToDoRepository.save(listToDo).getId();
        aListToDoDTO.setId(id);
        return aListToDoDTO;
    }

    public Set<ListToDoDTO> getAllListToDos() {
        return StreamSupport
                .stream(listToDoRepository.findAll().spliterator(), false)
                .map(toDoList -> {
                    var listDto = toDoList.getToDos()
                            .stream()
                            .map(item -> new ToDoDTO(item.getId(), item.getName(), item.isCompleted(), toDoList.getId()))
                            .collect(Collectors.toSet());
                    return new ListToDoDTO(toDoList.getId(), toDoList.getName(), listDto);
                })
                .collect(Collectors.toSet());
    }

    public void deleteListById(Long listId){
        var listToDo = listToDoRepository.findById(listId)
                .orElseThrow(() -> new NotFoundIdException(NO_FAULT_ID));
        listToDoRepository.delete(listToDo);
    }

    public void deleteAToDoById(Long id) {
        var toDo = toDoRepository.findById(id).orElseThrow();
        toDoRepository.delete(toDo);
    }

    public ToDoDTO getAToDoById(Long id) {
        return toDoRepository.findById(id)
                .map(item -> new ToDoDTO(item.getId(), item.getName(), item.isCompleted(), null))
                .orElseThrow();
    }
}
