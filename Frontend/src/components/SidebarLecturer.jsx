import React from "react";
import * as FaIcons from "react-icons/fa";
import * as AiIcons from "react-icons/ai";
import * as IoIcons from "react-icons/io";
import { MdQuiz } from "react-icons/md";
import { FaStickyNote } from "react-icons/fa";
import { CgDanger } from "react-icons/cg";
import { IoCreateSharp } from "react-icons/io5";
import { MdNotificationsActive } from "react-icons/md";

export const SidebarData = [
  {
    title: "Home",
    icon: <AiIcons.AiFillHome size={20} color="black" style={{ marginRight: "10px" }} />,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/lecturer"),
  }, 
  {
    title: "Create Event", 
    icon: <IoCreateSharp size={20} color="black" style={{ marginRight: "10px" }} />,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/create-event"),
  },
  {
    title:"Notify",
    icon: <MdNotificationsActive size={20} color="black" style={{ marginRight: "10px" }}/>,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/notify"),
  },
  {
    title: "Reports",
    icon: <FaIcons.FaEnvelopeOpenText size={20} color="black" style={{ marginRight: "10px" }}/>,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/lecturer-report"),
  },
  {
    title: "Notes",
    icon: <FaStickyNote size={20} color="black" style={{ marginRight: "10px" }}/>,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/lecturer-note"),
  },
  {
    title: "Complains",
    icon: <CgDanger size={20} color="black" style={{ marginRight: "10px" }}/>,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/lecturer-complain"),
  },
];