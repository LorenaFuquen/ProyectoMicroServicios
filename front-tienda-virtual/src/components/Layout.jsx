import React, { useState } from "react";
import Sidebar from "./Sidebar";
import Topbar from "./Topbar";
import './Layout.css';

const Layout = ({ children }) => {
  const [isSidebarOpen, setIsSidebarOpen] = useState(true);
  const [searchQuery, setSearchQuery] = useState("");

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };

  return (
    <div className="layout">
      <Sidebar isOpen={isSidebarOpen} toggleSidebar={toggleSidebar} />
      <div className={`main ${isSidebarOpen ? "expanded" : "collapsed"}`}>
        <Topbar onSearch={setSearchQuery} isSidebarOpen={isSidebarOpen} />
        <div className="content">
          {children}
        </div>
      </div>
    </div>
  );
};

export default Layout;
