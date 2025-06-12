import React, { useState } from "react";
import ProductList from "../components/ProductList";
import ProductFormCreate from "../components/ProductFormCreate";
import "./Productos.css";

const Productos = () =>{
    const [abrirModal, setAbrirModal] = useState(false);
    const [productos, setProductos] = useState([]);

    const toggleModal = () => {
        setAbrirModal(!abrirModal);
    };

    const handleProductoCreado = (nuevoProducto) => {
        setProductos((prev) => [...prev, nuevoProducto]);
        toggleModal();
    };

    return (
        <div className="pagina-productos">
            <div className="productos-header">
                <h3>Gestor de Productos</h3>
                <button className="boton-nuevo-producto" onClick={toggleModal}>
                    {abrirModal ? "Cerrar formulario": "Nuevo producto"}
                </button>
            </div>

            <ProductList productos = {productos} setProductos= {setProductos} />

            {abrirModal && (<ProductFormCreate onClose= {toggleModal}
            onProductoCreado={handleProductoCreado}
            /> )}
        </div>
    );
};

export default Productos;