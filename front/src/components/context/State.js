import React, { useReducer } from "react";
import Reducer from "./Reducer";
import Store from "./Context";

const StoreProvider = (props) => {

    const initialState = {
        todo: { list: [], item: {} },
        listTodo: { list: [], item: {} }
    };

    const [state, dispatch] = useReducer(Reducer, initialState);

    return (
        <Store.Provider value={{
            state,
            dispatch
        }}>
            {props.children}
        </Store.Provider>
    );

}

export default StoreProvider;