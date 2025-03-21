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
    icon: <AiIcons.AiFillHome size={20} color="black" />,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/"),
  },
  {
    title: "Exam",
    icon: <IoIcons.IoIosPaper size={20} color="black" />,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/exams"),
  },
  {
    title: "Quiz",
    icon: <MdQuiz size={20} color="black" />,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/quiz"),
  },
  {
    title: "Assignment",
    icon: <IoIcons.IoMdPeople size={20} color="black" />,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/assignments"),
  },
  {
    title: "Reports",
    icon: <FaIcons.FaEnvelopeOpenText size={20} color="black" />,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/reports"),
  },
  {
    title: "Notes",
    icon: <FaStickyNote size={20} color="black" />,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/notes"),
  },
  {
    title: "Complains",
    icon: <CgDanger size={20} color="black" />,
    cName: "nav-text home-bg",
    onClick: (navigate) => navigate("/complains"),
  },
];
