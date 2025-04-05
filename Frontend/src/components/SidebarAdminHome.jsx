import React from 'react';
import * as FaIcons from 'react-icons/fa';
import * as AiIcons from 'react-icons/ai';
import * as IoIcons from 'react-icons/io';
import { MdQuiz } from "react-icons/md";
import { FaStickyNote } from "react-icons/fa";
import { CgDanger } from "react-icons/cg";
import { MdMapsHomeWork } from "react-icons/md";

export const SidebarData = [
  {
    title: 'Home',
    path: '/admin',
    icon: <AiIcons.AiFillHome size={20}  color='black' />,
    cName: 'nav-text home-bg',
  },
  {
    title: 'Manage',
    path: '/manage',
    icon: <IoIcons.IoIosPaper size={20} color='black' />,
    cName: 'nav-text home-bg',
  },
  {
    title: 'Department',
    path: '/department',
    icon: <MdMapsHomeWork size={20}  color='black' />,
    cName: 'nav-text home-bg',
  },
  {
      title: 'Reports',
      path: '/Reports',
      icon: <FaStickyNote size={20} color='black'/>,
      cName: 'nav-text home-bg',
  },
  
];
