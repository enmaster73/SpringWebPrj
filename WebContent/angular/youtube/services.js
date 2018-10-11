angular.module('todo').factory('todoStorage', function() {
	TODO_DATA = 'TODO_DATA';
    var storage ={
        todos:[],

        _saveToLocalStorage:function(data) {
            localStorage.setItem(TODO_DATA, JSON.stringify(data));
        },

        _getFormLocalStorage:function() {            
            return JSON.parse(localStorage.getItem(TODO_DATA)) || [];
        },

        get:function() {
            angular.copy(storage._getFormLocalStorage(), storage.todos);
            return storage.todos;
        },
        remove:function(todo) {
            var idx = storage.todos.findIndex(function(item) {
                return item.id == todo.id
              });
              
              if (idx > -1) {
                storage.todos.splice(idx, 1)
              }
        },
        add:function(newTodoTitle){
            var newTodo = {
                title:newTodoTitle,
                completed:false,
                createdAt:Date.now()
              }
              // push into todos
              storage.todos.push(newTodo);
              storage._saveToLocalStorage(storage.todos);   
        }

    }
    return storage;
})