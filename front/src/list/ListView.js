import React, { useState, useContext, useEffect } from 'react';
import ToDoForm from "../todo/FormView";
import ToDoList from "../todo/ListView";
import consumer from "./consumer";
import events from "./events";
import Store from "../store"

export default () => {
    const { state: { list, todo }, dispatch } = useContext(Store);
    const [isLoaded, setLoaded] = useState(false);
    useEffect(() => {
        consumer.findAll().then((list) => {
            console.log("successful list");
            setLoaded(true);
            dispatch(events.finded(list));
        })
    }, [dispatch]);
    return <ul>
        {isLoaded && list.elements.map((element, index) => {
            return <div key={index}>
                <fieldset>
                    <legend>{element.name}</legend>
                    <ToDoForm listId={element.id} todo={todo} />
                    <ToDoList listId={element.id} todo={todo} />
                </fieldset>
            </div>
        })}
    </ul>
}