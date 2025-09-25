import { Route, Routes } from 'react-router-dom';
import Home from './pages/home/Home';
import Auth from './pages/auth/Auth';
import {Toaster} from "react-hot-toast";
import Cart from "./pages/cart/Cart"
import About from './pages/about/About'
import Contact from "./pages/contact/Contact"
import Collection from './pages/collection/Collection';

const App = () => {
  return (
    <>
    <Toaster position='bottom-right' />
    <Routes>
      <Route path='/' element={<Home/>} />
      <Route path='/auth' element={<Auth/>} />
      <Route path='/contact' element={<Contact/>} />
      <Route path='/about' element={<About/>} />
      <Route path='/cart' element={<Cart/>} />
      <Route path='/collection' element={<Collection/>} />
    </Routes>
    </>
  )
}

export default App