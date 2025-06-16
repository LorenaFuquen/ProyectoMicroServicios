import React from "react";
import { useCarrito } from "../context/UseCarrito";
import "./Carrito.css";

const Carrito = () => {
    const { cartItems, removeFromCart, clearCart } = useCarrito();

    const total = cartItems.reduce(
        (acc, item) => acc + item.precio * item.cantidad,0
    );

    if (cartItems.length === 0) {
        return <p style={{ textAlign: "center", marginTop: "2rem" }}>El carrito está vacío.</p>;
    }

    return (
        <div className="carrito-container">
        <h2>Tu carrito</h2>
        <ul className="carrito-lista">
            {cartItems.map((producto, index) => (
            <li className="carrito-item" key={index}>
                <img src={producto.imageBase64} alt={producto.nombreProducto} />
                <div className="carrito-info">{producto.nombreProducto}</div>
                <div className="carrito-precio">${producto.precio}</div>
                <button className="boton-eliminar" onClick={() => removeFromCart(producto.id)}>
                Eliminar
                </button>
            </li>
            ))}
        </ul>
        <button className="boton-vaciar" onClick={clearCart}>
            Vaciar carrito
        </button>
        </div>
    );
};

export default Carrito;
