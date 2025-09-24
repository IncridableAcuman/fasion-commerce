import { useState } from "react";
import "./Auth.css"
import { Lock, Mail, Send } from 'lucide-react';

const Auth = () => {
  const [email,setEmail]=useState('');
  const [password,setPassword]=useState('');
  return (
    <>
    <div className="w-full h-screen bg_image">
      <div className="w-full h-screen bg-gray-900 opacity-80 text-white flex flex-col items-center justify-center">
        <div className="bg-black text-white w-full max-w-md p-6 rounded-md shadow-md">
          <h1 className="text_color text-3xl font-semibold pb-4">Sign In</h1>
          <form className="space-y-4">
            <div className="form_input border p-3 rounded-md">
              <Mail size={20} />
              <input type="email" name="email" id="email"
               placeholder="Email"
               className="w-full outline-none bg-transparent"
               value={email}
               onChange={(e)=>setEmail(e.target.value)}
               required
               />
            </div>
            <div className="form_input border p-3 rounded-md">
              <Lock size={20} />
              <input type="password" name="password" id="password"
              placeholder="********"
              className="outline-none w-full bg-transparent"
              value={password}
              onChange={(e)=>setPassword(e.target.value)}
              required
               />
            </div>
            <div className="flex items-center justify-center gap-3 bg_color p-3 rounded-md shadow-md cursor-pointer">
              <Send size={20} />
              <input type="submit" value="Sign In" />
            </div>
          </form>
        </div>
      </div>
    </div>
    </>
  )
}

export default Auth