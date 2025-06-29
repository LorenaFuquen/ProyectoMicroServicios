import React from "react";
import "./ProductCard.css";
import { FaCartShopping, FaRegEye } from "react-icons/fa6";
import { useCarrito } from "../context/UseCarrito";

function ProductCard({ producto, onVerDetalle}){

    const {onAgregarCarrito} = useCarrito();

    return(
        <div className="card-producto">
            <img src={producto.imageBase64} 
                alt={producto.nombreProducto} 
                className="imagen-producto"/>
            <div className="info-producto">
                <h3 className="nombre-producto">{producto.nombreProducto}</h3>
                <p className="precio-producto">${producto.precio}</p>
            </div>

            <div className="botones-productos">
                <button className="boton-detalle" onClick={()=> onVerDetalle(producto)}>
                    <FaRegEye />
                    Ver Detalle
                </button>

                 <button className="boton-anadir" onClick={()=> onAgregarCarrito(producto)}>
                    <FaCartShopping />
                    Agregar al carrito
                </button>
            </div>
        </div>
    );
}

export default ProductCard;