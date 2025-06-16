import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:9090", // Llamado de la URL del servicio de productos
});

export const crearProducto = (productoData) => {
  return API.post("/productos/crearProducto", productoData);
};

export const fetchProductosPorNombre = async (nombreProducto) => {
  try {
    const response = await API.get(`/productos/buscarPorNombre`,{
      params: {nombreProducto: nombreProducto}
    });
    return response.data;
  } catch (error) {
    console.error("Error al buscar productos", error);
    throw error;
  }

};



export default API;
