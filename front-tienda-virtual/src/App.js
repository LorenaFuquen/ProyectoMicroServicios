import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';
import Home from './pages/Home';
import Productos from './pages/Productos';
import Carrito from './pages/Carrito';
import Ordenes from './pages/Ordenes';
import Contacto from './pages/Contacto';
import Layout from './components/Layout';
import { CarritoProvider } from './context/CarritoContext'; 



function App() {
  return (
    <Router>
      <CarritoProvider>
        <Layout>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/productos" element={<Productos />} />
            <Route path="/carrito" element={<Carrito />} />
            <Route path="/ordenes" element={<Ordenes />} />
            <Route path="/contacto" element={<Contacto />} />
          </Routes>
        </Layout>
      </CarritoProvider>
    </Router>
  );
}

export default App;
