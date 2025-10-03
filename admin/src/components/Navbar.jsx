import { UserRound } from 'lucide-react';

const Navbar = () => {
  return (
    <div className='flex items-center justify-between gap-3 py-4
     shadow'>
      <h1 className='text-xl font-semibold'>Fashion</h1>
      <UserRound size={20} className='text-gray-600 hover:text-gray-300 transition duration-300 cursor-pointer' />
    </div>
  )
}

export default Navbar