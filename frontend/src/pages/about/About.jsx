import "./About.css";
import Navbar from '../../components/Navbar'
import Footer from '../../components/Footer'

const About = () => {
  return (
    <>
    <Navbar/>      
    <div className="w-full min-h-screen pdg">
      <h1 className="text-2xl font-semibold text-center uppercase">About Us</h1>
      <div className="flex flex-col md:flex-row items-center justify-between gap-5 pt-20">
        <img src="./mike-petrucci-c9FQyqIECds-unsplash.jpg" alt="mike-petrucci-c9FQyqIECds-unsplash.jpg"
         className="w-full md:w-1/2 rounded-md" />
        <div className="space-y-4">
          <p>Forever was born out of a passion for innovation and a desire to revolutionize the way people shop online. 
            Our journey began with a simple idea: to provide a platform where customers can easily discover, 
            explore, and purchase a wide range of products from the comfort of their homes.</p>
          <p>Since our inception, we've worked tirelessly to curate a diverse selection of high-quality products that cater to every taste and preference.
             From fashion and beauty to electronics and home essentials, we offer an extensive collection sourced from trusted brands and suppliers.</p>
             <h4>Our Mission</h4>
          <p>Our mission at Forever is to empower customers with choice, convenience, and confidence. 
            We're dedicated to providing a seamless shopping experience that exceeds expectations, from browsing and ordering to delivery and beyond.</p>
        </div>
      </div>
        {/* why choose us */}
      <div className="pt-5 md:py-10">
        <h2 className="upperce text-2xl font-semibold uppercase pb-4">why choose us</h2>
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 text-center">
          <div className="border border-gray-400 p-6">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium, at.
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Reprehenderit, adipisci.
          </div>
          <div className="border border-gray-400 p-6">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium, at.
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Reprehenderit, adipisci.
          </div>
          <div className="border border-gray-400 p-6">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium, at.
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Reprehenderit, adipisci.
          </div>
        </div>
      </div>
    </div>
    
    <Footer/>
    </>
  )
}

export default About