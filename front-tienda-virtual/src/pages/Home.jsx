import React, { useState, useEffect } from "react";
import Topbar from '../components/Topbar';
import API from "../api/api";
import { fetchProductosPorNombre } from "../api/api";
import ProductList from '../components/ProductList';
import './Home.css';

const Home = ({ searchQuery }) => {
    const [productos, setProductos] = useState([]);

    useEffect(() => {
        const buscar = async () => {
            try {
                if (searchQuery && searchQuery.length >=2){
                    const resultados = await fetchProductosPorNombre(searchQuery);
                    setProductos(resultados);           
                } else {
                    const response = await API.get("/productos/buscarProductos")
                    setProductos(response.data);
                }

            } catch (error) {
                console.error("Error obteniendo los productos", error);
            }
        };

        buscar();
    }, [searchQuery]);

    return (
        <div className="container">
            <div className="main-content"></div>
                <ProductList productos = {productos} searchQuery={searchQuery}/>
        </ div>
    );
};

export default Home;