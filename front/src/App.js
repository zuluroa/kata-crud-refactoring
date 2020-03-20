import React from 'react';
import {StoreProvider} from "./store";
import ListView from "./list/ListView";
import FormView from "./list/FormView";

function App() {
  return <StoreProvider>
    <FormView />
    <ListView />
  </StoreProvider>
}

export default App;