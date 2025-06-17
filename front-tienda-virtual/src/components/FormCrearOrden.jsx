import React, { useState } from "react";
import { crearOrden } from "../api/apiOrden"; 
import "./FormCrearOrden.css";

const FormCrearOrden = ({ productosEnCarrito, limpiarCarrito, onOrdenCreada, onCancel }) => {
    const [formData, setFormData] = useState({
        idMedioPago: "3",
        idTipoDocumento: "1",
        numeroDocumento: "",
        nombrePersona: "",
        correo: "",
        telefono: "",
        direccion: "",
        fechaEntrega: "",
    });

    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData(prev => ({ ...prev, [name]: value }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError(null);
        setLoading(true);

        if (productosEnCarrito.length === 0) {
            alert("No hay productos en el carrito para crear la orden");
            setLoading(false);
            return;
        }

        console.log("Contenido del carrito:", productosEnCarrito);

        const ordenPayload = {
            idMedioPago: formData.idMedioPago,
            personas: {
                idTipoDocumento: formData.idTipoDocumento,
                numeroDocumento: formData.numeroDocumento,
                nombrePersona: formData.nombrePersona,
                correo: formData.correo,
                telefono: formData.telefono,
                direccion: formData.direccion,
            },
            idsProductos: productosEnCarrito.map(p => p.idProducto),
            fechaEntrega: formData.fechaEntrega,
        };

        console.log("Datos que se enviarán a la API:", JSON.stringify(ordenPayload, null, 2));

        try {
            await crearOrden(ordenPayload);
                alert("Orden creada con éxito");
                limpiarCarrito();
            if (onOrdenCreada) onOrdenCreada();
                setFormData({
                    idMedioPago: "3",
                    idTipoDocumento: "1",
                    numeroDocumento: "",
                    nombrePersona: "",
                    correo: "",
                    telefono: "",
                    direccion: "",
                    fechaEntrega: "",
            });
            onCancel();
        } catch (err) {
            console.error(err);
            setError("Error al crear la orden, intenta nuevamente.");
        } finally {
            setLoading(false);
        }
    };

  return (

    <div className= "modal-overlay">
        <div className= "modal-content">
            <h2>Finalizar orden </h2>

            <form className="formulario-orden" onSubmit={handleSubmit}>
             <h3>Datos de la persona</h3>

            <div className="form-group">
                <label htmlFor="nombrePersona">Nombre completo</label>
                <input
                    id="nombrePersona"
                    name="nombrePersona"
                    type="text"
                    required
                    value={formData.nombrePersona}
                    onChange={handleChange}
                    disabled={loading}
                />
            </div>

            <div className="form-group">
                <label htmlFor="numeroDocumento">Número de documento</label>
                <input
                    id="numeroDocumento"
                    name="numeroDocumento"
                    type="text"
                    required
                    value={formData.numeroDocumento}
                    onChange={handleChange}
                    disabled={loading}
                />
            </div>

            <div className="form-group">
                <label htmlFor="correo">Correo electrónico</label>
                <input
                    id="correo"
                    name="correo"
                    type="email"
                    required
                    value={formData.correo}
                    onChange={handleChange}
                    disabled={loading}
                />
            </div>

            <div className="form-group">
                <label htmlFor="telefono">Teléfono</label>
                <input
                    id="telefono"
                    name="telefono"
                    type="number"
                    required
                    value={formData.telefono}
                    onChange={handleChange}
                    disabled={loading}
                />
            </div>

            <div className="form-group">
                <label htmlFor="direccion">Dirección</label>
                <input
                    id="direccion"
                    name="direccion"
                    type="text"
                    required
                    value={formData.direccion}
                    onChange={handleChange}
                    disabled={loading}
                />
            </div>

            <div className="form-group">
                <label htmlFor="fechaEntrega">Fecha de entrega</label>
                <input
                    id="fechaEntrega"
                    name="fechaEntrega"
                    type="date"
                    required
                    value={formData.fechaEntrega}
                    onChange={handleChange}
                    disabled={loading}
                />
            </div>
            </form>
            {error && <p className="error">{error}</p>}

            <div className="form-buttons">   
                <button type="button" className="boton-enviar-orden" disabled={loading}>
                    {loading ? "Enviando..." : "Finalizar orden"}
                </button>

                <button type="button" className="boton-cancelar" onClick={onCancel}>
                    Cancelar
                </button>
            </div> 
        </div>
    </div>
    );
};

export default FormCrearOrden;
