import React, { useContext, useEffect } from "react";
import { HOST_API_LIST } from "../utils/hostApi";
import Store from "../context/Context";
import TodoList from "../todo/TodoList";
import TodoForm from "../todo/TodoForm";

const ListTodo = () => {
    const { state: { listTodo }, dispatch } = useContext(Store);
    const currentList = listTodo.list;

    useEffect(() => {
        fetch(HOST_API_LIST + "/lists")
            .then(response => response.json())
            .then((list) => {
                dispatch({ type: "updateListTodo-list", list })
            })
    }, [dispatch]);


    const onDelete = (id) => {
        fetch(HOST_API_LIST + "/" + id + "/list", {
            method: "DELETE"
        }).then((list) => {
            dispatch({ type: "deleteListTodo-list", id })
        })
    };

    return <div className="container text-center">
        {currentList.map((listTodo) => {
            return <tr key={listTodo.id}>
                <div>
                    <td>{listTodo.listname}</td>
                    <td><button onClick={() => onDelete(listTodo.id)}>Eliminar</button></td>
                    <TodoForm listTodoId={listTodo.id} />
                    <TodoList listTodoId={listTodo.id} />
                </div>
            </tr>
        })}
    </div>
}

export default ListTodo;