import React, { useEffect, useState } from "react";
import APIOrdenes, {obtenerProductosPorIds} from "../api/apiOrden";
import "./OrdenesList.css";

const OrdenesList = () => {
  const [ordenes, setOrdenes] = useState([]);
  const [detalleSeleccionado, setDetalleSeleccionado] = useState(null);
  const [productosDetalle, setProductosDetalle] = useState([]);


  useEffect(() => {
    cargarOrdenes();
  }, []);

  const cargarOrdenes = async () => {
    try {
      const res = await APIOrdenes.get("/ordenes/buscarOrdenes");
      setOrdenes(res.data);
    } catch (err) {
      console.error("Error al obtener órdenes:", err);
    }
  };

  const abrirDetalle = async (orden) => {
    try {
      const resProductos = await obtenerProductosPorIds(orden.idsProductos);
      setProductosDetalle(resProductos.data);
      setDetalleSeleccionado(orden);
    } catch (err) {
      console.error("Error al obtener productos:", err);
    }
  };

  const eliminarOrden = async (idOrden) => {
    if (window.confirm("¿Deseas eliminar esta orden?")) {
      try {
        await APIOrdenes.delete(`/ordenes/eliminarOrden/${idOrden}`);
        cargarOrdenes(); // recargar lista
      } catch (err) {
        console.error("Error al eliminar la orden:", err);
      }
    }
  };

  return (
    <div className="ordenes-container">
      <h2>Órdenes registradas</h2>

      <div className="ordenes-listado">
        {ordenes.map((orden) => (
          <div key={orden.idOrden} className="orden-card">
            <h3>Orden #{orden.idOrden}</h3>
            <p><strong>Fecha entrega:</strong> {orden.fechaEntrega}</p>
            <p><strong>Cliente:</strong> {orden.persona?.nombrePersona}</p>

            <div className="botones-orden">
              <button onClick={() => abrirDetalle(orden)}>Ver detalle</button>
              <button onClick={() => eliminarOrden(orden.idOrden)}>Eliminar</button>
            </div>
          </div>
        ))}
      </div>

      {/* Modal simple para detalle */}
      {detalleSeleccionado && (
        <div className="modal-overlay">
          <div className="modal-content">
            <h3>Detalle de la orden #{detalleSeleccionado.idOrden}</h3>
            <p><strong>Medio de pago:</strong> {detalleSeleccionado.medioPago?.nombreMedio}</p>
            <p><strong>Persona:</strong> {detalleSeleccionado.persona?.nombrePersona}</p>
            <p><strong>Correo:</strong> {detalleSeleccionado.persona?.correo}</p>
            <p><strong>Dirección:</strong> {detalleSeleccionado.persona?.direccion}</p>
            <p><strong>Productos:</strong></p>
            <ul>
              {productosDetalle.map((producto) => (
                <li key={producto.idProducto}>
                    {producto.nombreProducto} - $ {producto.precio}</li>
              ))}
            </ul>
            <p><strong>Valor total:</strong> $ {detalleSeleccionado.valorTotal}</p>
            <button onClick={() => setDetalleSeleccionado(null)}>Cerrar</button>
          </div>
        </div>
      )}
    </div>
  );
};

export default OrdenesList;
