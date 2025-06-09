import React, { useState } from "react";
import Topbar from '../components/Topbar';
import ProductList from '../components/ProductList';
import './Home.css';

const Home = () => {
    const [searchTerm, setSearchTerm] = useState('');

    return (
        <div className="container">
            <div className="main-content"></div>
                <ProductList />
                <button className="order-button">Ver Carrito</button>
        </ div>
    );
};

export default Home;