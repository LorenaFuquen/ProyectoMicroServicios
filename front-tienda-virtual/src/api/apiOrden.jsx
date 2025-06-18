// ordenesApi.js

import axios from "axios";

const APIOrdenes = axios.create({
  baseURL: "http://localhost:8090", 
});

export const crearOrden = (ordenData) => {
    console.log("Datos que se enviarán a la API:", ordenData);
    return APIOrdenes.post("/ordenes/crearOrden", ordenData);
};

export const obtenerMedioPago = () => {
  return APIOrdenes.get("/ordenes/buscarMedioPago");
};

export const obtenerTipoDocumento = () => {
  return APIOrdenes.get("/ordenes/buscarTipoDocumento");
};

export default APIOrdenes;
