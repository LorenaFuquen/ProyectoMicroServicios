import React, { useEffect, useState } from "react";
import API from "../api/api";
import AdminProductEditModal from "./AdminProductEditModal"
import ProductFormCreate from "./ProductFormCreate"; 
import './AdminProductTable.css';   

function AdminProductTable(){
    const [productos, setProductos] = useState([]);
    const [categorias, setCategorias] = useState([]);
    const [marca, setMarca] = useState([]);
    const [tipoProducto, setTipoProducto] = useState([]);
    const [estado, setEstado] = useState([]);
    const [abrirModal, setAbrirModal] = useState(false);
    const [productoSeleccionado, setProductoSeleccionado] = useState(null);

    useEffect(() =>{
        cargarProductos();
        cargarCategorias();
        cargarMarcas();
        cargarTipoProducto();
        cargarEstado();
    },[]);

    const toggleModal = () => {
        setAbrirModal(!abrirModal);
    };

    const handleProductoCreado = (nuevoProducto) => {
        setProductos((prev) => [...prev, nuevoProducto]);
        toggleModal();
    };

    const cargarProductos = () => {
        API.get("productos/buscarProductos")
           .then(response => setProductos(response.data))
           .catch(error => console.error ("Error al cargar los productos", error));
    };

    const cargarCategorias = () => {
        API.get("productos/buscarCategorias")
           .then(response => {
            const mapa = {};
            response.data.forEach(cat => {
                mapa[cat.idCategoria] = cat.nombreCategoria;
            });
            setCategorias(mapa);
           })
           .catch(error => console.error("Error al cargar las categorias", error));
    };

    const cargarMarcas = () => {
        API.get("productos/buscarMarcas")
           .then(response => {
            const mapa = {};
            response.data.forEach(mar => {
                mapa[mar.idMarca] = mar.nombreMarca;
            });
            setMarca(mapa);
           })
           .catch(error => console.error("Error al cargar las marcas", error));
    };

    const cargarTipoProducto = () => {
        API.get("productos/buscarTipoProducto")
           .then(response => {
            const mapa = {};
            response.data.forEach(tipo => {
                mapa[tipo.idTipo] = tipo.nombreTipo;
            });
            setTipoProducto(mapa);
           })
           .catch(error => console.error("Error al cargar los tipos de productos", error));
    };

    const cargarEstado = () => {
        API.get("productos/buscarEstado")
           .then(response => {
            const mapa = {};
            response.data.forEach(estado => {
                mapa[estado.idEstado] = estado.nombreEstado;
            });
            setEstado(mapa);
           })
           .catch(error => console.error("Error al cargar los estados", error));
    };

    const handleEditarProducto = (producto) => {
        setProductoSeleccionado(producto);
        console.log ("Actualizar producto",producto);
    };

    const handleEliminarProducto = (idProducto) =>{
        if(window.confirm ("¿Estas seguro de eliminar este producto?")){
            API.delete(`/productos/eliminarProducto/${idProducto}`)
              .then(() => {
                alert ("Producto eliminado correctamente");
                cargarProductos();
              })
              .catch(error => console.error("Error al eliminar el producto",error));
        }
    };

    const cerrarModal = () => {
        setProductoSeleccionado(null);
    };

    const guardarActualizacion = (productoActualizado) => {
        API.put(`/productos/actualizarProducto/${productoActualizado.idProducto}`, productoActualizado)
          .then(() => {
            alert("Producto actualizado correctamente");
            cargarProductos();
            cerrarModal();
          })
          .catch(error => console.error("Error al actualizar el producto", error));
    };

    console.log("Productos que se van a renderizar:", productos);

    return(
        <div className="product-admin-table-container">
            <div className="productos-header">
                <h3>Administración de productos</h3>
                <button className="boton-nuevo-producto" onClick={toggleModal}>
                    {abrirModal ? "Cerrar formulario" : "Nuevo producto"}
                </button>
            </div>
            {abrirModal && ( <ProductFormCreate onClose={toggleModal}
                 onProductoCreado={handleProductoCreado}
                />
            )}

            <table className="product-admin-table">
                <thead>
                    <tr>
                        <th>ID Producto</th>
                        <th>Nombre del Producto</th>
                        <th>Descripción del producto</th>
                        <th>Categoria del producto</th>
                        <th>Tipo de producto</th>
                        <th>Marca de producto</th>
                        <th>Color</th>
                        <th>Precio</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    {productos.map((producto, index) => (
                     producto ? (   
                        <tr key={producto.idProducto}>
                            <td>{producto.idProducto}</td>
                            <td>{producto.nombreProducto}</td>
                            <td>{producto.descripcion}</td>
                            <td>{categorias[producto.idCategoria] || "Cargando..."}</td>
                            <td>{tipoProducto[producto.idTipo] || "Cargando..."}</td>
                            <td>{marca[producto.idMarca] || "Cargando..."}</td>
                            <td>{producto.color}</td>
                            <td>{producto.precio}</td>
                            <td>{estado[producto.idEstado] || "Cargando..."}</td>
                            <td>
                                <button className= "boton-editar" onClick = {() => handleEditarProducto(producto)}>Editar</button>
                                <button className= "boton-elimina" onClick = {() => handleEliminarProducto(producto.idProducto)}>Eliminar</button>
                            </td>
                        </tr>
                     ):null
                    ))}
                </tbody>
            </table>
            {productoSeleccionado && (
                <AdminProductEditModal
                    producto={productoSeleccionado}
                    onClose={cerrarModal}
                    onSave={guardarActualizacion}
                    categorias={categorias}
                    marca={marca}
                    tipoProducto={tipoProducto}
                    estado={estado}
                />
            )}
        </div>
    );
}

export default AdminProductTable;
