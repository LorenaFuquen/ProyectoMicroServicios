import React from "react";
import { FaShoppingCart } from 'react-icons/fa';
import './Topbar.css';

const Topbar = ({ onSearch }) => {
    return(
        <div className="topbar">
            <input
                type="text"
                placeholder="Buscar productos"
                className="search-input"
                onChange={(e) => onSearch(e.target.value)}
            />
            
            <FaShoppingCart className= "icono-compras"/>
        </div>

    );
};

export default Topbar;