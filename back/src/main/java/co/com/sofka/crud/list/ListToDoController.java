package co.com.sofka.crud.list;

import co.com.sofka.crud.todo.ToDoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ListToDoController {

    @Autowired
    private ListToDoService listToDoService;

    @GetMapping(value = "api/list")
    public Iterable<ListToDoDTO> list(){
        return listToDoService.getListToDoAll();
    }

    @GetMapping(value = "api/{listId}/todos")
    public Iterable<ToDoDTO> listToDo(@PathVariable("listId") Long listId){
        return listToDoService.getToDosByListToDoId(listId);
    }
    
    @PostMapping(value = "api/listtodo")
    public ListToDoDTO saveList(@RequestBody ListToDoDTO todo){
        return listToDoService.saveListToDo(todo);
    }

    @PutMapping(value = "api/{listId}/todos")
    public ToDoDTO update(@PathVariable("listId") Long listId, @RequestBody ToDoDTO todo){
        if(todo.getId() != null){
            return listToDoService.saveToDo(listId, todo);
        }
        throw new NotFoundIdException("No existe el id para actualizar");
    }


    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        listToDoService.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public ToDoDTO get(@PathVariable("id") Long id){
        return listToDoService.get(id);
    }

}
