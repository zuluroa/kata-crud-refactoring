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

    return <div >
        {currentList.map((listTodo) => {
            return <tr key={listTodo.id} >
                <div className="shadow p-4 mb-2 bg-white rounded" >
                    <div className="input-group">
                        <h3>LISTA: {listTodo.listname} </h3>
                        <span className="input-group-btn">
                            <button className="btn btn-primary" onClick={() => onDelete(listTodo.id)}>Eliminar</button>
                        </span>
                    </div>
                    <br></br>
                    <TodoForm listTodoId={listTodo.id} />
                    <TodoList listTodoId={listTodo.id} />
                </div>
            </tr>
        })}
    </div>
}

export default ListTodo;