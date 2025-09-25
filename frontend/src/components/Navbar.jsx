// eslint-disable-next-line no-unused-vars
import {motion} from 'framer-motion';
import { Link, useNavigate } from "react-router-dom";
import { Search, ShoppingBasket, UserRound } from 'lucide-react';

const Navbar = () => {
  const navigate=useNavigate();
  const navLink=[
    {name:"Home",to:"/"},
    {name:"Collection",to:"/collection"},
    {name:"About",to:"/about"},
    {name:"Contact",to:"/contact"},
  ]
  return (
    <>
    <motion.nav 
    initial={{y:-80, opacity:0}}
    animate={{y:0,opacity:1}}
    transition={{duration:0.5}}
    className=' fiex top-0 left-0 w-full  flex items-center justify-between p-4 pdg shadow-lg text_color z-50 opacity-80'>
      <motion.h1 
      whileHover={{scale:1.2}}
      whileTap={{transition:0.5}}
      className='cursor-pointer text-xl font-semibold'>Fashion</motion.h1>
      <div className="hidden md:block">
        <motion.div className='flex items-center gap-4'>
        {
          navLink.map((link,index)=>(
            <motion.li key={index} 
            whileHover={{scale:1.2}}
            whileTap={{transition:1}}
            className='list-none text-sm'>
                <Link to={link.to} className=' transition duration-300'>{link.name}</Link>
            </motion.li>
          ))
        }
      </motion.div>
      </div>
      {/* icons */}
      <motion.div className='flex items-center gap-4'>
        <Search size={20} className='cursor-pointer ' />
        <UserRound size={20} className='cursor-pointer ' />
        <ShoppingBasket size={20} className='cursor-pointer' onClick={()=>navigate("/cart")} />
      </motion.div>
    </motion.nav>
    </>
  )
}

export default Navbar