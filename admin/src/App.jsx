import { Route, Routes } from 'react-router-dom';
import Home from "./pages/home/Home";
import Auth from './pages/auth/Auth';
import {Toaster} from 'react-hot-toast';
const App = () => {
  return (
    <>
    <Toaster position='bottom-right' />
    <Routes>
      <Route path='/' element={<Home/>} />
     <Route path='/auth' element={<Auth/>} />
    </Routes>
    </>
  )
}

export default App