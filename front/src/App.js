import React from 'react';
import StoreProvider from './components/context/listTodo/State';
import ListTodo from './components/list/listTodo';
import ListTodoForm from './components/list/listTodoFrom';

function App() {
  return <StoreProvider>
     <div className="shadow-sm p-3 rounded text-center">
      <h1>Dashboard</h1>
      </div>
      <br></br>
      <div className="shadow p-3 mb-5 bg-white rounded">
        <ListTodoForm />
        <br></br>
      <ListTodo />
    </div>
  </StoreProvider>
}

export default App;
