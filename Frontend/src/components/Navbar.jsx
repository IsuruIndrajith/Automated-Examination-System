import React, { useState, useEffect } from 'react';
import * as FaIcons from 'react-icons/fa';
import { Link, useNavigate } from 'react-router-dom';
import { SidebarData } from './Sidebar';
import './Navbar.css';
import { IconContext } from 'react-icons';

function Navbar() {
  const [sidebar, setSidebar] = useState(false);
  const [username, setUsername] = useState("Guest");
  const [activeSubMenu, setActiveSubMenu] = useState(null); 
  const navigate = useNavigate();

  const showSubMenu = (index) => {
    setActiveSubMenu(activeSubMenu === index ? null : index); // Toggle submenu
  };

  useEffect(() => {
    const storedUser = localStorage.getItem("username");
    if (storedUser) {
      setUsername(storedUser);
    }
  }, []);

  const showSidebar = () => setSidebar(!sidebar); 

  const handleLogout = () => { 
    const isConfirmed = window.confirm("Do you want to continue? ");
    if (isConfirmed) {
      localStorage.removeItem("username");
      navigate("/"); // Redirect to login or home
    }
  };

  return ( 
    <>
      <IconContext.Provider value={{ color: '#fff' }}>
        {/* Navbar */}
        <div className='navbar'>
          <Link to='#' className='menu-bars'>
            <div className="icon-text">
              <FaIcons.FaBars onClick={showSidebar} size={25} style={{ marginRight: "10px" }}  />
              <span>Menu</span>
            </div>
          </Link> 
          <div className="navbar-center">
            <span className="user"> {username} </span>
          </div>
          <div className="navbar-right">
            <button className='logout-btn' onClick={handleLogout}>Logout</button>
          </div>
        </div>

        {/* Sidebar */}
        <nav className={sidebar ? 'nav-menu active' : 'nav-menu'}>
          <ul className='nav-menu-items' onClick={showSidebar}>
            <li className='navbar-toggle'>
              <Link to='#' className='menu-bars'></Link>
            </li>

            {SidebarData.map((item, index) => {
              return (
                <div key={index}>
                  <li 
                    className={item.cName}  
                    onClick={() => {
                      if (item.hasSubmenu) {
                        showSubMenu(index); // Toggle submenu visibility
                      } else {
                        setActiveSubMenu(null);
                        item.onClick?.(navigate); // Navigate if no submenu
                      }
                    }} 
                    style={{ backgroundColor: item.bgColor }} 
                  >
                    <Link to={item.path} className="icon-text">
                      {item.icon}
                      <span>{item.title}</span>
                    </Link>
                  </li>

                  {/* Render submenu if it exists and is active */}
                  {item.hasSubmenu && activeSubMenu === index && (
                    <ul className="submenu">
                      {item.subMenu.map((subItem, subIndex) => (
                        <li key={subIndex} onClick={() => subItem.onClick?.(navigate)}>
                          <span>{subItem.title}</span>
                        </li>
                      ))}
                    </ul>
                  )}
                </div>
              );
            })}
          </ul>
        </nav>
      </IconContext.Provider>
    </>
  );
}

export default Navbar;