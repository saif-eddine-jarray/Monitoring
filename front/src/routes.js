import React from "react";

import {
  MdHome,
} from "react-icons/md";
import Documents from "views/documents";

const routes = [
  {
    name: "Documents",
    layout: "/main",
    path: "documents",
    icon: <MdHome className="h-6 w-6" />,
    component: <Documents />,
  }
];
export default routes;
