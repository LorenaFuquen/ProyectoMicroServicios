import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:9090", // Llamado de la URL del servicio de productos
});

export default API;
