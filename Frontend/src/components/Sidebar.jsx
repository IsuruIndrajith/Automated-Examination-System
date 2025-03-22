import React from "react";
import * as FaIcons from "react-icons/fa";
import * as AiIcons from "react-icons/ai";
import * as IoIcons from "react-icons/io";
import { MdQuiz } from "react-icons/md";
import { FaStickyNote } from "react-icons/fa";
import { CgDanger } from "react-icons/cg";

export const SidebarData = [
  {
    title: "Home",
    icon: <AiIcons.AiFillHome size={20} color="black" style={{ marginRight: "10px" }} />,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/student"),
  },
  {
    title: "Exam",
    icon: <IoIcons.IoIosPaper size={20} color="black" style={{ marginRight: "10px" }} />,
    cName: "nav-text home-bg",
    hasSubmenu: true, // Indicates it has a submenu
    subMenu: [
      {
        title: "Register Exam",
        onClick: (navigate) => navigate("/student-exam"),
      },
      {
        title: "Take Exam",
        onClick: (navigate) => navigate("/student-exam"),
      },
    ],
  },
  {
    title: "Quiz",
    icon: <MdQuiz size={20} color="black" style={{ marginRight: "10px" }}/>,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/student-quiz"),
  },
  {
    title: "Assignment",
    icon: <IoIcons.IoMdPeople size={20} color="black" style={{ marginRight: "10px" }}/>,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/student-assign"),
  },
  {
    title: "Reports",
    icon: <FaIcons.FaEnvelopeOpenText size={20} color="black" style={{ marginRight: "10px" }}/>,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/student-report"),
  },
  {
    title: "Notes",
    icon: <FaStickyNote size={20} color="black" style={{ marginRight: "10px" }}/>,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/student-note"),
  },
  {
    title: "Complains",
    icon: <CgDanger size={20} color="black" style={{ marginRight: "10px" }}/>,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/student-complain"),
  },
];
