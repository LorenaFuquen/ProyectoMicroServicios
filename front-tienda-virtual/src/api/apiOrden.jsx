import axios from "axios";

const APIOrdenes = axios.create({
  baseURL: "http://localhost:8090", 
});

const APIProductos = axios.create({
  baseURL: "http://localhost:9090", 
});

export const obtenerProductosPorIds = (ids) => {
  return APIProductos.post("/productos/obtenerIdsProductos", ids); // asegúrate que esta ruta existe en el backend
};

export const crearOrden = (ordenData) => {
    console.log("Datos que se enviarán a la API:", ordenData);
    return APIOrdenes.post("/ordenes/crearOrden", ordenData);
};

export const obtenerOrdenes = () => {
  return APIOrdenes.get("/ordenes/buscarOrdenes"); 
}

export const obtenerMedioPago = () => {
  return APIOrdenes.get("/ordenes/buscarMedioPago");
};

export const obtenerTipoDocumento = () => {
  return APIOrdenes.get("/ordenes/buscarTipoDocumento");
};

export default APIOrdenes;
