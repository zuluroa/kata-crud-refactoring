import React from 'react';
import StoreProvider from './components/context/State';
import TodoForm from './components/todo/TodoForm';
import TodoList from './components/todo/TodoList';

function App() {
  return <StoreProvider>
    <h3>To-Do List</h3>
    <TodoForm />
    <TodoList />
  </StoreProvider>
}

export default App;
