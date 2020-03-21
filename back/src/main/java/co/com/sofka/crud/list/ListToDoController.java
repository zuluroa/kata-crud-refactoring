package co.com.sofka.crud.list;

import co.com.sofka.crud.todo.ToDoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ListToDoController {

    private ListToDoService listToDoService;

    @Autowired
    public ListToDoController(ListToDoService listToDoService) {
        this.listToDoService = listToDoService;
    }

    @GetMapping(value = "api/list")
    public Iterable<ListToDoDTO> getAllListToDos(){
        return listToDoService.getAllListToDos();
    }

    @GetMapping(value = "api/{listId}/todos")
    public Iterable<ToDoDTO> getToDosByListId(@PathVariable("listId") Long listId){
        return listToDoService.getToDosByListId(listId);
    }
    
    @PostMapping(value = "api/listtodo")
    public ListToDoDTO newListToDo(@RequestBody ListToDoDTO todo){
        return listToDoService.newListToDo(todo);
    }

    @DeleteMapping(value = "api/{id}/listtodo")
    public void deleteListById(@PathVariable("id") Long id){
         listToDoService.deleteListById(id);
    }

    @PutMapping(value = "api/{listId}/todo")
    public ToDoDTO updateAToDoByListId(@PathVariable("listId") Long listId, @RequestBody ToDoDTO todo){
        if(todo.getId() != null){
            return listToDoService.updateAToDoByListId(listId, todo);
        }
        throw new NotFoundIdException("No existe el id para actualizar");
    }

    @PostMapping(value = "api/{listId}/todo")
    public ToDoDTO addNewToDoByListId(@PathVariable("listId") Long listId, @RequestBody ToDoDTO todo){
        return listToDoService.addNewToDoByListId(listId, todo);
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void deleteAToDoById(@PathVariable("id")Long id){
        listToDoService.deleteAToDoById(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public ToDoDTO getAToDoById(@PathVariable("id") Long id){
        return listToDoService.getAToDoById(id);
    }

}
