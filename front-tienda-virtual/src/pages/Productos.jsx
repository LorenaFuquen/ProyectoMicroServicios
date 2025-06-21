import React, { useState } from "react";
import ProductTabs  from "../components/ProductTabs";
import "./Productos.css";

const Productos = ( {searchQuery} ) =>{

    return (
        <div className="pagina-productos">
            <ProductTabs searchQuery = {searchQuery}/>
        </div>
    );
};

export default Productos;