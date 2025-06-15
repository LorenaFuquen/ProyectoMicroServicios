import React, { useState, useEffect } from "react";
import "./AdminProductEditModal.css";

function AdminProductEditModal({ producto, onClose, onSave, categorias, marcas, tipos, estados }) {
  const [formData, setFormData] = useState({ ...producto });

  useEffect(() => {
    if (producto) {
      setFormData({ ...producto });
    }
  }, [producto]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSave(formData);
  };

  return (
    <div className="modal-backdrop">
      <div className="modal-content">
        <h3>Editar Producto</h3>
        <form onSubmit={handleSubmit}>
          <label>Nombre:</label>
          <input name="nombreProducto" value={formData.nombreProducto} onChange={handleChange} required />

          <label>Descripción:</label>
          <input name="descripcion" value={formData.descripcion} onChange={handleChange} required />

          <label>Color:</label>
          <input name="color" value={formData.color} onChange={handleChange} required />

          <label>Precio:</label>
          <input type="number" name="precio" value={formData.precio} onChange={handleChange} required />

          <label>Categoría:</label>
          <select name="idCategoria" value={formData.idCategoria} onChange={handleChange}>
            {Object.entries(categorias).map(([id, nombre]) => (
              <option key={id} value={id}>{nombre}</option>
            ))}
          </select>

          <label>Tipo:</label>
          <select name="idTipo" value={formData.idTipo} onChange={handleChange}>
            {Object.entries(tipos).map(([id, nombre]) => (
              <option key={id} value={id}>{nombre}</option>
            ))}
          </select>

          <label>Marca:</label>
          <select name="idMarca" value={formData.idMarca} onChange={handleChange}>
            {Object.entries(marcas).map(([id, nombre]) => (
              <option key={id} value={id}>{nombre}</option>
            ))}
          </select>

          <label>Estado:</label>
          <select name="idEstado" value={formData.idEstado} onChange={handleChange}>
            {Object.entries(estados).map(([id, nombre]) => (
              <option key={id} value={id}>{nombre}</option>
            ))}
          </select>

          <div className="modal-buttons">
            <button type="submit">Guardar</button>
            <button type="button" onClick={onClose}>Cancelar</button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default AdminProductEditModal;
