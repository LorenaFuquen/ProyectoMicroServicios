import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import './ProductList.css';
import API from "../api/api";
import ProductCard from "./ProductCard";
import ProductModal from "./ProductModal";

function ProductList(){
    const [productos, setProductos] = useState([]);
    const [productoSeleccionado, setProductoSeleccionado] = useState(null);

    useEffect(() => {
        API.get("/productos/buscarProductos")
        .then((response) => setProductos(response.data))
        .catch((error) => console.error("Error al cargar los productos ", error))
    },[]);

    const handleVerDetalle = (productos) => {
        setProductoSeleccionado(productos);
    };

    const handleAnadirCarrito = (productos) =>{
        alert(`Producto añadido al carrito: ${productos.nombreProducto}`);
    };

    const cerrarModal = () => {
        setProductoSeleccionado(null);
    }; 


    return(
        <div className="relative"> 
            <div className="contenedor-productos">
                {productos.map((producto) => (
                    <ProductCard 
                    key={producto.idProducto} 
                    producto = {producto}
                    onVerDetalle={handleVerDetalle}
                    onAgregarCarrito={handleAnadirCarrito}/>       
            ))}
            </div>

            {productoSeleccionado && (
                <ProductModal producto={productoSeleccionado} onClose={cerrarModal}/>
            )}
        </div>

    );

}

export default ProductList;