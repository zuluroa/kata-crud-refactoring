import React from 'react';
import StoreProvider from './components/context/State';
import ListTodo from './components/list/listTodo';

function App() {
  return <StoreProvider>
    <div className="container text-center">
    <h1>Dashboard</h1>
      <br />
      <div className="row border rounded">
      <ListTodo />
      </div>
      <br />

    </div>
  </StoreProvider>
}

export default App;
