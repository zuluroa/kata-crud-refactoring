import React, { useReducer } from "react";
import Reducer from "../Reducer";
import StoreFrom from "./Context"

const StoreFromProvider = (props) => {

    const initialState = {
        todo: { list: [], item: {} },
        listTodo: { list: [], item: {} }
    };

    const [state, dispatch] = useReducer(Reducer, initialState);

    return (
        <StoreFrom.Provider value={{
            state,
            dispatch
        }}>
            {props.children}
        </StoreFrom.Provider>
    );

}

export default StoreFromProvider;