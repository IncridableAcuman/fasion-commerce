import {Facebook,Twitter,Instagram,Youtube} from 'lucide-react';

const Footer = () => {
  return (
    <>
    <div className='grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 p-6 space-y-4'>
      <div className="space-y-4">
        <h3 className='text-xl font-semibold'>Fashion</h3>
        <div className="space-y-2">
          <div className="flex items-center gap-3">
            <Facebook/>
            Facebook
          </div>
          <div className="flex items-center gap-3">
            <Twitter/>
            Twitter
          </div>
          <div className="flex items-center gap-3">
            <Instagram/>
            Instagram
          </div>
          <div className="flex items-center gap-3">
            <Youtube/>
            Youtube
          </div>
        </div>
      </div>
      <div className="space-y-2">
        <h3 className='text-xl font-semibold'>Privacy & Policy</h3>
        <ul>
          <li>Home</li>
          <li>Collection</li>
          <li>About</li>
          <li>Contact</li>
        </ul>
      </div>
      <div className="space-y-2">
        <h3 className='text-xl font-semibold'>About Me</h3>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
           A, porro! Odit culpa quod eveniet autem eos iure eum 
           iusto quasi error? Esse laborum tempore nam.</p>
      </div>
    </div>
    <div className="text-center border-t pdg">Created by Izzatbek Abdusharipov</div>
    </>
  )
}

export default Footer