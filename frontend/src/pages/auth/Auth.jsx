import "./Auth.css";
import { Lock, Mail, Send, UserRound } from 'lucide-react';
import { useState } from "react";
import { Link } from 'react-router-dom';
// eslint-disable-next-line no-unused-vars
import {motion} from 'framer-motion';

const Auth = () => {
  const [state,setState]=useState(false);

  const [username,setUsername]=useState('');
  const [email,setEmail]=useState('');
  const [password,setPassword]=useState('');

  return (
    <>
    <div className="bg_image h-screen w-full">
      <div className="w-full h-screen bg-gray-900 opacity-80 text-white mx-auto flex flex-col items-center justify-center">
        <motion.div className="w-full"
        initial={{opacity:0,y:-50}}
        animate={{opacity:1,y:0}}
        transition={{duration:1}}
        >
            <div className="w-full max-w-md p-6 rounded-md shadow-md bg-black mx-auto text-white">
          <h1 className="text-3xl font-semibold pb-5 text_color">{state ? "Sign Up": "Sign In"}</h1>
          <form className="space-y-4">
            {state && (
              <motion.div className="w-full"
              initial={{opacity:0,y:-50}}
              animate={{opacity:1,y:0}}
              transition={{duration:0.5}}
              >
                <div className="form_input border p-3 rounded-md">
                      <UserRound size={20} />
                      <input type="text" name="username"
                      id="username" className="outline-none w-full bg-transparent"
                      placeholder="Izzatbek"
                      value={username}
                      onChange={(e)=>setUsername(e.target.value)}
                      required
                      />
                </div>
              </motion.div>
            )}
            <motion.div className="w-full"
              initial={{opacity:0,y:-50}}
              animate={{opacity:1,y:0}}
              transition={{duration:0.5}}
            >
                  <div className="form_input border p-3 rounded-md">
                  <Mail size={20} />
                  <input type="email" name="email" id="email"
                  placeholder="examplw@gmail.com" className="outline-none w-full bg-transparent"
                  value={email}
                  onChange={(e)=>setEmail(e.target.value)}
                    required />
                  </div>
            </motion.div>
            <motion.div className="w-full"
            initial={{opacity:0,y:-50}}
            animate={{opacity:1,y:0}}
            transition={{duration:0.5}}
            >
                <div className="form_input border p-3 rounded-md">
                    <Lock size={20} />
                    <input type="password" name="password" id="password"
                    placeholder="********" className="outline-none w-full bg-transparent"
                    value={password}
                    onChange={(e)=>setPassword(e.target.value)}
                      required />
                </div>
            </motion.div>
            <motion.button
             initial={{ opacity: 0, y: -50 }}
             animate={{ opacity: 1, y: 0 }}
             transition={{ duration: 0.5 }}
             className="w-full"
             
            >
              <div className="flex items-center justify-center mx-auto gap-3
                 bg_color text-black p-3 rounded-md shadow-md cursor-pointer hover:bg-gray-300 transition duration-300">
                <Send size={20} />
                <input type="submit" value={"Sign Up"} />
              </div>
            </motion.button>
          </form>
          <div className="flex items-center justify-between py-4 text-sm">
            {
              !state ? (
                              <p>Don't have an accound?{" "} <span className="cursor-pointer font-semibold hover:underline transition duration-300" onClick={()=>setState(true)}>Sign Up</span></p>
              ) : (
                              <p>Already have an accound?{" "} <span className="cursor-pointer font-semibold hover:underline transition duration-300" onClick={()=>setState(false)}>Sign In</span></p>
              )
            }
              <Link to={"#"} className="text-sm cursor-pointer hover:underline transition duration-300">Forgot Password</Link>
          </div>
          <p className="text-center">or</p>
          <div className="flex items-center justify-center gap-3 pt-2">
            <motion.div whileHover={{scale:1.2}}
            whileTap={{transition:1}}
            >
              <img src="./google-brands-solid-full (1).svg" alt="google-brands-solid-full (1).svg" className="w-8 h-8 cursor-pointer
               hover:bg-white rounded-full  transition duration-300" />
            </motion.div>
            <motion.div whileHover={{scale:1.2}}
            whileTap={{transition:1}}
            >
                <img src="./github-brands-solid-full.svg" alt="github-brands-solid-full.svg" className="w-8 h-8 cursor-pointer
              hover:bg-white rounded-full  transition duration-300" />
            </motion.div>
          </div>
        </div>
        </motion.div>
      </div>
    </div>
    </>
  )
}

export default Auth