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

    return <form ref={formRef}>
        <div className="input-group">
            <input
                className="form-control"
                type="text"
                name="name"
                placeholder="Lista de TO-DO"
                required
                onChange={(event) => {
                    setState({ ...state, listname: event.target.value })
                }} />
            <span className="input-group-btn">
                <button onClick={onAdd} className="btn btn-primary btn-lg" >Nueva lista</button>
            </span>
        </div>
    </form>
}

export default ListTodoForm;