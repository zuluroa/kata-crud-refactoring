export default (state, action) => {
    switch (action.type) {
        case 'updateListTodo-list':
            const updateListTodo = state.listTodo;
            updateListTodo.list = action.list;
            return { ...state, listTodo: updateListTodo }
        case 'deleteListTodo-list':
            const deleteListTodo = state.listTodo;
            const listTodoIsUpdate = deleteListTodo.list.filter((item) => {
                return item.id !== action.id;
            });
            deleteListTodo.list = listTodoIsUpdate;
            return { ...state, listTodo: deleteListTodo }
        case 'update-item':
            const todoUpItem = state.todo;
            const listUpdateEdit = todoUpItem.list.map((item) => {
                if (item.id === action.item.id) {
                    return action.item;
                }
                return item;
            });
            todoUpItem.list = listUpdateEdit;
            todoUpItem.item = {};
            return { ...state, todo: todoUpItem }
        case 'delete-item':
            const todoUpDelete = state.todo;
            const listUpdate = todoUpDelete.list.filter((item) => {
                return item.id !== action.id;
            });
            todoUpDelete.list = listUpdate;
            return { ...state, todo: todoUpDelete }
        case 'update-list':
            const todoUpList = state.todo;
            todoUpList.list = action.list;
            return { ...state, todo: todoUpList }
        case 'edit-item':
            const todoUpEdit = state.todo;
            todoUpEdit.item = action.item;
            return { ...state, todo: todoUpEdit }
        case 'add-item':
            const todoUp = state.todo.list;
            todoUp.push(action.item);
            return { ...state, todo: { list: todoUp, item: {} } }
        default:
            return state;
    }
}
