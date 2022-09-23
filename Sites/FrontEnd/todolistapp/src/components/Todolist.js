import React, {useState} from 'react';

function Todolist() {
    const [todo, setTodo] = useState({desc: '', date: ''})
    const [todos, setTodos] = useState([])
    
    const addTodo = () => {
        setTodos([...todos, todo]);
        
    }
    const inputChanged=(event)=>{
        setTodo({...todo,[event.target.name]:event.target.value})
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
             <table>
                <tbody>
                <tr><th>Date</th><th>Description</th></tr>
                    {
                        todos.map((todo, index) => 
                            <tr key={index}>
                            <td>{todo.date}</td>
                            <td>{todo.desc}</td>
                            </tr>)
                    }
                </tbody>
            </table>
        </div>
    )
}

export default Todolist;