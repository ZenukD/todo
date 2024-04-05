import './App.css'
import ListTodoComponent from "./components/ListTodoComponent.jsx";
import HeaderComponent from "./components/HeaderComponent.jsx";
import FooterComponent from "./components/FooterComponent.jsx";
import {BrowserRouter, Routes, Route} from "react-router-dom";
import TodoComponent from "./components/TodoComponent.jsx";
import RegisterComponent from "./components/RegisterComponent.jsx";
import LoginComponent from "./components/LoginComponent.jsx";

function App() {

    return (
        <>
            <BrowserRouter>
                <HeaderComponent/>
                <Routes>
                    {/* http://localhost:8080 */}
                    <Route path='/' element={<ListTodoComponent/>}></Route>
                    {/*http://localhost:8080/todos */}
                    <Route path='/todos' element={<ListTodoComponent/>}></Route>
                    {/*http://localhost:8080/add-todo */}
                    <Route path='/add-todo' element={<TodoComponent/>}></Route>
                    {/* http://localhost:8080/add-todo/1 */}
                    <Route path='/update-todo/:id' element={ <TodoComponent />}></Route>
                    {/* http://localhost:8080/register */}
                    <Route path='/register' element={<RegisterComponent />}></Route>
                    {/* http://localhost:8080/login */}
                    <Route path='/login' element={<LoginComponent />}></Route>
                </Routes>
                <FooterComponent/>
            </BrowserRouter>
        </>
    )
}

export default App
