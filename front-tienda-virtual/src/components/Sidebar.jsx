import React, {useState} from "react";
import {Link} from 'react-router-dom';
import { FaHome, FaBox, FaShoppingCart, FaBars, FaTimes, FaPhone, FaArchive, FaHeart, FaPhoneAlt } from 'react-icons/fa';
import './Sidebar.css';

const Sidebar = () =>{
    const [isOpen, setIsOpen] = useState(true); // Permitira abrir y cerrar el menu

    const toogleSidebar = () =>{
        setIsOpen(!isOpen);
    };
    

    return (

        <div className={`sidebar ${isOpen ? 'open': 'closed'}`}>
            <div className="toggle-btn" onClick={toogleSidebar}>
            <FaBars />
            </div>

            {isOpen && <h2 className="titulo">Tienda virtual</h2>}

            <ul className="menu-tienda">
                <li title= {!isOpen ? "Inicio" : ""}>
                    <Link to = "/">
                        <FaHome />
                        {isOpen && <span> Inicio</span>}
                    </Link>
                </li>
                <li title= {!isOpen ? "Productos" : ""}>
                    <Link to = "/productos">
                        <FaArchive />
                        {isOpen && <span>Productos</span>}
                    </Link>
                </li>
                <li title= {!isOpen ? "Carrito" :""}>
                    <Link to = "/carrito">
                        <FaShoppingCart />
                        {isOpen && <span>Carrito</span>}
                    </Link>
                </li>
                <li title= {!isOpen ? "Mis ordenes" :""}>
                    <Link to = "/ordenes">
                        <FaHeart  />
                        {isOpen && <span>Mis ordenes</span>}
                    </Link>
                </li>
                <li title= {!isOpen ? "Contacto" :""}>
                    <Link to = "/contacto">
                        <FaPhoneAlt />
                        {isOpen && <span>Contacto</span>}
                    </Link>
                </li>
            </ul>
            
        </div>
      
    );

};

export default Sidebar;