import React, { useContext, useRef, useState } from 'react';
import { HOST_API } from '../utils/hostApi';
import Store from "../context/Context";


const TodoForm = ({ listTodoId }) => {
  const formRef = useRef(null);
  const { state: { todo }, dispatch } = useContext(Store);
  const item = todo.item;
  const [state, setState] = useState(item);

  const onAdd = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: null,
      completed: false,
      groupListId: listTodoId
    };

    fetch(HOST_API + "/todo", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((todo) => {
        dispatch({ type: "add-item", item: todo });
        setState({ name: "" });
        formRef.current.reset();
      });
  }

  const onEdit = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: item.id,
      isCompleted: item.isCompleted,
      groupListId: item.groupListId
    };


    fetch(HOST_API + "/todo", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((todo) => {
        dispatch({ type: "update-item", item: todo });
        setState({ name: "" });
        formRef.current.reset();
      });
  }

  return <form className="form-inline" ref={formRef}>
    <div className="input-group mx-10">
      <input
        className="form-control"
        type="text"
        name="name"
        placeholder="¿Qué piensas hacer hoy?" 
        defaultValue={item.name}
        onChange={(event) => {
          setState({ ...state, name: event.target.value })
        }}  ></input>
      <span className="input-group-btn">
        {item.id && <button className="btn btn-primary btn-lg" onClick={onEdit}>Actualizar</button>}
        {!item.id && <button className="btn btn-primary btn-lg" onClick={onAdd}>Crear</button>}
      </span>
    </div>
    <br></br>
  </form>
}

export default TodoForm;
