import React, { useState } from "react";
import ProductTabs from "../components/ProductTabs";
import "./Productos.css";

const Productos = () =>{

    return (
        <div className="pagina-productos">
            <ProductTabs />
        </div>
    );
};

export default Productos;