import React, {useState, useRef} from 'react';
import TodoTable from './TodoTable'
import { AgGridReact } from'ag-grid-react'
import'ag-grid-community/dist/styles/ag-grid.css'
import'ag-grid-community/dist/styles/ag-theme-material.css';

function Todolist() {
    const [todo, setTodo] = useState({
        desc: '',
        date: '',
        priority: ''})
    const [todos, setTodos] = useState([])
    const [columnDefs]=useState([
        {field:'date', sortable: true, filter:true, floatingFilter: true},
        {field:'desc', sortable: true, filter:true, floatingFilter: true},
        {field:'priority', sortable: true, filter:true, floatingFilter: true, 
        cellStyle: params => params.value === "High" ? {color: 'red'} : {color: 'black'} }
    ])
   
    const gridRef = useRef()
    const addTodo = () => {
        setTodos([...todos, todo]);
        
    }
    const inputChanged=(event)=>{
        setTodo({...todo,[event.target.name]:event.target.value})
    }

    const deleteTodo = () => {
        if (gridRef.current.getSelectedNodes().length > 0){
        setTodos(todos.filter((todo,index) => index !== 
      gridRef.current.getSelectedNodes()[0].childIndex))
    }
    else {
        alert('Select row first')
    }
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
            placeholder='description'
            value={todo.desc}
            onChange={inputChanged}/>
            <input
            type="text"
            name="priority"
            placeholder='priority'
            value={todo.priority} 
            onChange={inputChanged}/> 
            <button onClick={addTodo}>Add</button>
            <button onClick={deleteTodo}>Delete</button>
            <div className='ag-theme-material' style={{width:'60%', height:500, margin:'auto'}}>
        <AgGridReact
            ref={gridRef}
            onGridReady={ params => gridRef.current = params.api}
            rowSelection='single'
            rowData={todos}
            columnDefs={columnDefs}
            animateRows={true}>
            

       </AgGridReact>
    </div>
        </div>
    )
}

export default Todolist;