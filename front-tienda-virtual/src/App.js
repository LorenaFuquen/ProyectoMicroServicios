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
          <Routes>
            <Route path="/" element={<Layout><Home /></Layout>} />
            <Route path="/productos" element={<Layout><Productos /></Layout>} />
            <Route path="/carrito" element={<Layout><Carrito /></Layout> } />
            <Route path="/ordenes" element={<Layout><Ordenes /></Layout>} />
            <Route path="/contacto" element={<Layout><Contacto /></Layout>} />
          </Routes>
      </CarritoProvider>
    </Router>
  );
}

export default App;
