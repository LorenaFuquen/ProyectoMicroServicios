import React from "react";
import "./Contacto.css";

const Contacto = () => {
  return (
    <div className="contacto-container">
      <h2>Contáctanos</h2>
      <p>Si tienes dudas, comentarios o deseas comunicarte con nosotros:</p>

      <div className="contacto-info">
        <p> Leidy Lorena Fuquen Calderón</p>
        <p><strong>📍 Dirección:</strong> Calle 123 # 45 - 67, Bogotá, Colombia</p>
        <p><strong>📞 Teléfono:</strong> +57 320 123 4567</p>
        <p><strong>📧 Correo:</strong> contacto@mitienda.com</p>
        <p><strong>🕒 Horario:</strong> Lunes a Viernes de 8:00 a.m. a 6:00 p.m.</p>
      </div>
    </div>
  );
};

export default Contacto;
