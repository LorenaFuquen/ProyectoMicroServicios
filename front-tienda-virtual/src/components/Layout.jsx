import React, { useState } from "react";
import Sidebar from "./Sidebar";
import Topbar from "./Topbar";
import './Layout.css';
import { useLocation } from "react-router-dom";

const Layout = ({ children }) => {
  const [isSidebarOpen, setIsSidebarOpen] = useState(true);
  const [searchQuery, setSearchQuery] = useState("");
  const location = useLocation();

  const passSearch = ['/home','/productos'].includes(location.pathname);

  const childrenWithProps = React.Children.map(children, chiild =>
    React.isValidElement(chiild) && passSearch
    ? React.cloneElement(chiild, {searchQuery})
    :chiild
  );

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };

  return (
    <div className="layout">
      <Sidebar isOpen={isSidebarOpen} toggleSidebar={toggleSidebar} />
      <div className={`main ${isSidebarOpen ? "expanded" : "collapsed"}`}>
        <Topbar onSearch={setSearchQuery} isSidebarOpen={isSidebarOpen} />
        <div className="content">
          {childrenWithProps}
        </div>
      </div>
    </div>
  );
};

export default Layout;
