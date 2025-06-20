import React from "react";
import { FaShoppingCart } from 'react-icons/fa';
import './Topbar.css';

const Topbar = ({ onSearch }) => {
    return(
        <div className="topbar">
            <input
                type="text"
                placeholder="Busca productos por nombre"
                className="search-input"
                onChange={(e) => onSearch(e.target.value)}
            />
            
        </div>

    );
};

export default Topbar;