import { useState } from "react";
import { useCarrito } from "../context/UseCarrito";
import FormCrearOrden from "../components/FormCrearOrden";
import "./Carrito.css";


const Carrito = () => {
    const { cartItems, removeFromCart, clearCart } = useCarrito();
    const [mostrarFormulario, setMostrarFormulario] = useState(false);

    const total = cartItems.reduce(
        (acc, item) => acc + item.precio * item.cantidad,0
    );

    const limpiarCarrito = () => {
        clearCart();
    };

    if (cartItems.length === 0) {
        return <p style={{ textAlign: "center", marginTop: "2rem" }}>El carrito está vacío.</p>;
    }

    return (
        <div className="carrito-container">
            <h2>Tu carrito</h2>

            {cartItems.length === 0 ? (
                <p style={{ textAlign: "center", marginTop: "2rem" }}>
                    El carrito está vacío.
                </p>
            ) : (
                <>
                    <ul className="carrito-lista">
                        {cartItems.map((producto, index) => (
                            <li className="carrito-item" key={index}>
                                <img src={producto.imageBase64} alt={producto.nombreProducto} />
                                <div className="carrito-info">{producto.nombreProducto}</div>
                                <div className="carrito-precio">${producto.precio}</div>
                                <button
                                    className="boton-eliminar"
                                    onClick={() => removeFromCart(producto.id)}
                                >
                                    Eliminar
                                </button>
                            </li>
                        ))}
                    </ul>
                    
                    <div className="form-buttons">
                        <button className="boton-vaciar" onClick={clearCart}> Vaciar carrito </button>
                        <button className="boton-finalizar-orden" onClick={() => setMostrarFormulario(true)}> Finalizar Orden </button>
                    </div>
                </>
            )}

            {mostrarFormulario && (
                <FormCrearOrden
                    productosEnCarrito={cartItems}
                    limpiarCarrito={limpiarCarrito}
                    onOrdenCreada={() => alert("Gracias por su compra!")}
                    onCancel={() => setMostrarFormulario(false)}
                />
            )}
        </div>
    );
};

export default Carrito;
