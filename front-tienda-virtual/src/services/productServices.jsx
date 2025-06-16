import { fetchProductosPorNombre } from "../api/api";

export const buscarProductoPorNombre = async (nombreProducto) => {

    try {
        const response = await fetchProductosPorNombre(nombreProducto);
        return response.data;
    } catch (error) {
        console.error("Error al buscar productos:", error);
        return [];
    }
    
};
