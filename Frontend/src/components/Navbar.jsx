import React, { useState , useEffect } from 'react';
import * as FaIcons from 'react-icons/fa';
import { Link , useNavigate } from 'react-router-dom';
import { SidebarData } from './Sidebar';
import './Navbar.css';
import { IconContext } from 'react-icons';

function Navbar() {
  const [sidebar, setSidebar] = useState(false);
  const [username, setUsername] = useState("Guest");
  const [activeSubMenu, setActiveSubMenu] = useState(null); 
  const navigate = useNavigate();

  useEffect(()=>{
    console.log(localStorage.getItem("username"));
    const storedUser = localStorage.getItem("username");
    if(storedUser){
      setUsername(storedUser);
    }
  },[]);

  const showSidebar = () => setSidebar(!sidebar); 

  const handleLogout = () => { 
    const isConfirmed = window.confirm("Do you want to continue? ");
    if(isConfirmed){
      console.log("logout confirmed");
      localStorage.removeItem("username");
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
        <div className='navbar'>
          <Link to='#' className='menu-bars'>
          <div className="icon-text">
            <FaIcons.FaBars onClick={showSidebar} size={25} />
            <span>Menu</span>
          </div>
          </Link>
          <div className="navbar-center">
            <span className="user">Welcome , {username} !</span>
          </div>
          <div className="navbar-right">
            <button className='logout-btn' onClick={handleLogout}>Logout</button>
          </div>
        </div>
        

        {/* Sidebar */}
        <nav className={sidebar ? 'nav-menu active' : 'nav-menu'}>
          <ul className='nav-menu-items' onClick={showSidebar}>
            <li className='navbar-toggle'>
              <Link to='#' className='menu-bars'>
              </Link>
            </li>
            {SidebarData.map((item, index) => {
              return (
                <li 
                  key={index} 
                  className={item.cName}  
                  onClick={() => {
                    if (item.hasSubmenu) {
                      setActiveSubMenu(activeSubMenu === index ? null : index);
                    } else {
                      setActiveSubMenu(null);
                      item.onClick?.(navigate);
                    }
                  }} 
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
