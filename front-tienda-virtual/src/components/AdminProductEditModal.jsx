import React, { useState, useEffect } from "react";
import "./AdminProductEditModal.css";


function AdminProductEditModal({ producto, onClose, onSave, categorias, marca, tipoProducto, estado }) {    

    const [formData, setFormData] = useState({ ...producto });

    useEffect(() => {
        if (producto) {
          setFormData({ ...producto });
        }
    }, [producto]);

    const convertirBase64 = (archivo) => {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.readAsDataURL(archivo);
            reader.onload = () => resolve(reader.result);
            reader.onerror = error => reject(error);
        });
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
          setFormData((prev) => ({
           ...prev,[name]: value
      }));
    };

    const handleFileChange = async (e) => {
        const archivo = e.target.files[0];
        if (archivo) {
           try {
                const base64 = await convertirBase64(archivo);
                   setFormData((prev) => ({
                   ...prev,
                    imagenBase64: base64,  
                }));
          } catch (error) {
                console.error("Error al convertir imagen a base64", error);
             }
          }
      };

    const handleSubmit = (e) => {
        e.preventDefault();
        onSave(formData);
    };

  return (
    <div className="modal-backdrop">
        <div className="modal-content">
            <h2>Editar Producto</h2>
            <form onSubmit={handleSubmit} className= "form-editar-producto">

              <div className="form-group-editar">
                <label>Nombre del producto</label>
                <input name="nombreProducto" value={formData.nombreProducto} onChange={handleChange} required />
              </div>

              <div className="form-group-editar">
                <label>Descripción del producto</label>
                <input name="descripcion" value={formData.descripcion} onChange={handleChange} required />
              </div>  

              <div className="form-group-editar">
                <label>Categoría del producto</label>
                <select name="idCategoria" value={formData.idCategoria} onChange={handleChange}>
                    {Object.entries(categorias).map(([idCategoria, nombreCategoria]) => (
                    <option key={idCategoria} value={idCategoria}>{nombreCategoria}</option>
                    ))}
                </select>
              </div>

              <div className="form-group-editar">
                <label>Tipo de producto</label>
                <select name="idTipo" value={formData.idTipo} onChange={handleChange}>
                    {Object.entries(tipoProducto).map(([idTipo, nombreTipo]) => (
                    <option key={idTipo} value={idTipo}>{nombreTipo}</option>
                    ))}
                </select>
              </div>

              <div className="form-group-editar">
                <label>Marca del producto</label>
                <select name="idMarca" value={formData.idMarca} onChange={handleChange}>
                    {Object.entries(marca).map(([idMarca, nombreMarca]) => (
                    <option key={idMarca} value={idMarca}>{nombreMarca}</option>
                    ))}
                </select>
              </div>

              <div className="form-group-editar">
                <label>Color del producto</label>
                <input name="color" value={formData.color} onChange={handleChange} required />
              </div>

              <div className="form-group-editar">
                <label>Precio del producto</label>
                <input type="number" name="precio" value={formData.precio} onChange={handleChange} required />
              </div>

              <div className="form-group-editar">
                <label>Estado del producto</label>
                <select name="idEstado" value={formData.idEstado} onChange={handleChange}>
                    {Object.entries(estado).map(([idEstado, nombreEstado]) => (
                    <option key={idEstado} value={idEstado}>{nombreEstado}</option>
                  ))}
                </select>
              </div>

              {formData.imagenBase64 && ( <img src={formData.imagenBase64} alt="Preview"
              style={{ width: "150px", height: "auto", marginBottom: "1rem" }}
              /> )}

              <div className="form-group-editar">
                <label>Imagen del producto</label>
                <input type="file" accept="image/*"onChange={handleFileChange} />
              </div>


              <div className="form-buttons-editar">
                  <button type="submit" className="btn-submit">Guardar producto</button>
                  <button type="button" onClick={onClose} className="btn-cancel">Cancelar</button>
              </div>
            </form>
      </div>
    </div>
  );
}

export default AdminProductEditModal;
