import React from "react";

import {
  MdBusiness,
} from "react-icons/md";
import Dashboard from "views/documents";

const routes = [
  {
    name: "Policy Center",
    layout: "/main",
    path: "nft-marketplace",
    icon: <MdBusiness className="h-6 w-6"/>,
    component: <Dashboard />,
    secondary: true,
  },
  {
    name: "Claim Center",
    layout: "/main",
    icon: <MdBusiness className="h-6 w-6"/>,
    path: "data-tables",
    component: <Dashboard />,
  },
  {
    name: "Billing Center",
    layout: "/main",
    path: "profile",
    icon: <MdBusiness className="h-6 w-6"/>,
    component: <Dashboard />,
  }
];
export default routes;
