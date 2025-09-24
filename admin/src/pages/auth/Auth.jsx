import "./Auth.css"
import { Mail } from 'lucide-react';

const Auth = () => {
  return (
    <>
    <div className="w-full h-screen bg_image">
      <div className="w-full h-screen bg-gray-900 opacity-80 text-white flex flex-col items-center justify-center">
        <div className="bg-black text-white w-full max-w-md p-6 rounded-md shadow-md">
          <h1 className="text_color text-3xl font-semibold pb-4">Sign In</h1>
          <form className="space-y-4">
            <div className="">
              <Mail size={20} />
              <input type="email" name="email" id="email" placeholder="Email" />
            </div>
          </form>
        </div>
      </div>
    </div>
    </>
  )
}

export default Auth