import React, { useContext, useRef, useState } from 'react';
import { HOST_API_LIST } from '../utils/hostApi';
import Store from "../context/Context";

const ListTodoForm = () => {
    const formRef = useRef(null);
    const { dispatch, state: { listTodo } } = useContext(Store);
    const item = listTodo.item;
    const [state, setState] = useState(item);

    const onAdd = (event) => {
        event.preventDefault();
        const request = {
            listname: state.listname,
            id: null
        };

        fetch(HOST_API_LIST + "/list", {
            method: "POST",
            body: JSON.stringify(request),
            headers: { 'Content-Type': 'application/json' }
        }).then(response => response.json())
            .then((listTodo) => {
                dispatch({ type: "listTodoAdd-list", item: listTodo });
                setState({ listname: "" });
                formRef.current.reset();
            });
    }

    return <form ref={formRef} className="form">
        <input
            className="form-control"
            type="text"
            name="name"
            placeholder="Lista de TO-DO"
            onChange={(event) => {
                setState({ ...state, listname: event.target.value })
            }}  ></input>
        <br />
        <button onClick={onAdd} >Nueva lista</button>
        <br />
    </form>
}

export default ListTodoForm;