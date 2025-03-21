import React from 'react';
import * as FaIcons from 'react-icons/fa';
import * as AiIcons from 'react-icons/ai';
import * as IoIcons from 'react-icons/io';
import { MdQuiz } from "react-icons/md";
import { FaStickyNote } from "react-icons/fa";
import { CgDanger } from "react-icons/cg";

export const SidebarData = [
  {
    title: 'Home',
    path: '/',
    icon: <AiIcons.AiFillHome size={20}  color='black' />,
    cName: 'nav-text home-bg',
  },
  {
    title: 'Exam',
    path: '/exams',
    icon: <IoIcons.IoIosPaper size={20} color='black' />,
    cName: 'nav-text home-bg',
  },
  {
    title: 'Quiz',
    path: '/quiz',
    icon: <MdQuiz size={20} color='black' />,
    cName: 'nav-text home-bg',
  },
  {
    title: 'Assignment',
    path: '/assignments',
    icon: <IoIcons.IoMdPeople size={20} color='black' />,
    cName: 'nav-text home-bg',
  },
  {
    title: 'Reports',
    path: '/reports',
    icon: <FaIcons.FaEnvelopeOpenText size={20} color='black' />,
    cName: 'nav-text home-bg',
  },
  {
    title: 'Notes',
    path: '/notes',
    icon: <FaStickyNote size={20} color='black'/>,
    cName: 'nav-text home-bg',
  },
  {
    title: 'Complains',
    path: '/complains',
    icon: <CgDanger size={20} color='black' />,
    cName: 'nav-text home-bg',
  }
];
