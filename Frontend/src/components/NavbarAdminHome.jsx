import React, { useState } from 'react';
import * as FaIcons from 'react-icons/fa';
import { Link , useNavigate } from 'react-router-dom';
import { SidebarData } from './SidebarAdminHome';
import './Navbar.css';
import { IconContext } from 'react-icons';


function Navbar() {
  const [sidebar, setSidebar] = useState(false);
  const navigate = useNavigate();
  const showSidebar = () => setSidebar(!sidebar); 

  const handleLogout = () => {
    const isConfirmed = window.confirm("Do you want to continue? ");
    if(isConfirmed){
      console.log("logout confirmed");
      navigate("/");
    }else{
      console.log("logout cancelled");
    }
    console.log('Logout clicked');
    
  };

  return (
    <>
      <IconContext.Provider value={{ color: '#fff' }}>
        {/* Navbar */}
        <div className='navbar'>Menu
          <Link to='#' className='menu-bars'>
          <div className="icon-text">
            <FaIcons.FaBars onClick={showSidebar} size={25} />
            <span>Menu</span>
          </div>
          </Link>
          <button className='logout-btn' onClick={handleLogout}>Logout</button>
        </div>
        

        {/* Sidebar */}
        <nav className={sidebar ? 'nav-menu active' : 'nav-menu'}>
          <ul className='nav-menu-items' onClick={showSidebar}>
            {/* Close Button */}
            <li className='navbar-toggle'>
              <Link to='#' className='menu-bars'>
                {/* <AiIcons.AiOutlineClose /> */}
              </Link>
            </li>

            {/* Sidebar Items */}
            {SidebarData.map((item, index) => {
              return (
                <li 
                  key={index} 
                  className={item.cName} 
                  style={{ backgroundColor: item.bgColor }} 
                >
                  <Link to={item.path} className="icon-text">
                  {item.icon}
                    <span>{item.title}</span>
                  </Link>
                </li>
              );
            })}
          </ul>
        </nav>
      </IconContext.Provider>
    </>
  );
}

export default Navbar;
