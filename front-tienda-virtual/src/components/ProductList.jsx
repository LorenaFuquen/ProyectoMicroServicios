import React from "react";
import './ProductList.css';

const ProductList = () => {

    const productos = [
        {id: 1, nombreProducto: 'Producto 1', precio: 1500000},
        {id: 2, nombreProducto: 'Producto 2', precio: 500000}
    ];

    return (
        <div className= "product-list">
            {productos.map((producto) => (
                <div key={producto.id} className= "product-card">
                    <h3>{producto.nombreProducto}</h3>
                    <p>Precio: ${producto.precio}</p>
                    <button>Añadir al Carrito</button>
                </div>

            ))}

        </div>
    );
};

export default ProductList;