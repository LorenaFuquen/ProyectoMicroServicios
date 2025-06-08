import React from "react";
import ProductList from '../components/ProductList';
import './Home.css';

const Home = () => {
    return (
        <div className="container">
            <div className="main-content"></div>
                <h1 className="title">Tienda Virtual de Órdenes</h1>
                <ProductList />
                <button className="order-button">Ver Carrito</button>
        </ div>
    );
};

export default Home;