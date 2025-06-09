import React, { useState } from "react";
import ProductList from "../components/ProductList";
import ProductFormCreate from "../components/ProductFormCreate";
import "./Productos.css";

const Productos = () =>{
    const [abrirModal, setAbrirModal] = useState(false);

    const toggleModal = () => {
        setAbrirModal(!abrirModal);
    };

    return (
        <div className="pagina-productos">
            <div className="productos-header">
                <h3>Gestor de Productos</h3>
                <button className="boton-nuevo-producto" onClick={toggleModal}>
                    {abrirModal ? "Cerrar formulario": "Nuevo producto"}
                </button>
            </div>

            <ProductList />

            {abrirModal && <ProductFormCreate onClose= {toggleModal}/> }
        </div>
    );

};

export default Productos;