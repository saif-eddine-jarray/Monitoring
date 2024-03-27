import React from "react";
import { Routes, Route, Navigate } from "react-router-dom";

import Main from "main";
const App = () => {
  return (
    <Routes>
      <Route path="main/*" element={<Main />} />
      <Route path="/" element={<Navigate to="/documents" replace />} />
    </Routes>
  );
};

export default App;
