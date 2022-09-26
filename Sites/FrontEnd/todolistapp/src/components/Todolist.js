import React, {useState} from 'react';
import TodoTable from './TodoTable'

function Todolist() {
    const [todo, setTodo] = useState({desc: '', date: ''})
    const [todos, setTodos] = useState([])
    
    const addTodo = () => {
        setTodos([...todos, todo]);
        
    }
    const inputChanged=(event)=>{
        setTodo({...todo,[event.target.name]:event.target.value})
    }

    const deleteTodo = (row) => {
        setTodos(todos.filter((todo, index)=> index !== row))
    }
    return(
        <div className="List">
            <h2>Todolist</h2>
            <input
            type="date"
            name="date"
            value={todo.date} 
            onChange={inputChanged}/> 
            <input
            type="text"
            name="desc"
            value={todo.desc}
            onChange={inputChanged}/>
            <button onClick={addTodo}>Add</button>
            <TodoTable todos={todos} deleteTodo={deleteTodo}/>
        </div>
    )
}

export default Todolist;