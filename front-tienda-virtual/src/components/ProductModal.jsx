import React from "react";
import "./ProductModal.css";
import { FaEye } from "react-icons/fa";

const ProductModal = ({producto, onClose}) => {
    if(!producto) return null;

    return (
        <div className="modal-overlay" onClick={onClose}>
            <div className="modal-content" onClick={(e) => e.stopPropagation()}>
                <h2>{producto.nombreProducto}</h2>
                <p>Precio: ${producto.precio}</p>
                <p>Estado: {producto.nombreEstado}</p>
                <button onClick={onClose} className="boton-cerrar">Cerrar</button>
                
            </div>

        </div>
    );

};

export default ProductModal;