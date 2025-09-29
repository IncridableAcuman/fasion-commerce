import "./Contact.css";
import Navbar from '../../components/Navbar'
import Footer from '../../components/Footer'
import { Mail, UserRound } from "lucide-react";

const Contact = () => {
  return (
    <>
    <Navbar/>
    <div className="w-full min-h-screen">
      <div className="flex flex-col md:flex-row items-center justify-between gap-5 pdg">
        <img src="./b573809c-1996-4a52-a9df-afa2060bbf4d.jpg"
         alt="b573809c-1996-4a52-a9df-afa2060bbf4d.jpg" 
         className="w-full md:w-[50%]"
         />
         <div className="w-full max-w-lg">
          <h1 className="text-2xl font-semibold pb-4">Contact Us</h1>
          <form className="space-y-4">
                <div className="flex flex-col md:flex-row items-center justify-between gap-3 ">
                      <div className=" flex items-center gap-3 border border-gray-600 p-3 rounded-md w-full">
                            <UserRound size={20} />
                            <input type="text" placeholder="First Name" className="outline-none w-full bg-transparent" />
                      </div>
                        <div className="flex items-center gap-3 border border-gray-600 p-3 rounded-md w-full">
                          <UserRound size={20} />
                          <input type="text" placeholder="Last Name" className="outline-none w-full bg-transparent" />
                        </div>
                </div>
                <div className=" flex items-center gap-3 border border-gray-600 p-3 rounded-md">
                  <Mail size={20} />
                  <input type="email" placeholder="Email" className="outline-none w-full bg-transparent" />
                </div>
                <div className="border border-gray-600 p-3 rounded-md">
                  <textarea name="message" id="message" placeholder="Message" className="outline-none w-full bg-transparent"></textarea>
                </div>
                <input type="submit" value="Send Message"
                 className="bg-black text-white p-3 rounded-md shadow-md cursor-pointer hover:bg-gray-800 transition duration-300" />
          </form>
         </div>
      </div>
    </div>
    <Footer/>
    </>
  )
}

export default Contact