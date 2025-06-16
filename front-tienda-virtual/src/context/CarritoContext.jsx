import { createContext, useState } from "react";

export const CarritoContext = createContext();

export const CarritoProvider = ({ children }) => {

  const [cartItems, setCartItems] = useState([]);

  const onAgregarCarrito = (producto) => {
    setCartItems((prev) => [...prev, producto]);
  };

  const removeFromCart = (id) => {
    setCartItems(prev => {
        return prev
            .map(item => {
             if (item.id === id) {
                 return { ...item, cantidad: item.cantidad - 1 };
            }
        return item;
      })
      .filter(item => item.cantidad > 0); 
     });
    };

  const clearCart = () => {
    setCartItems([]);
  };

  return (
    <CarritoContext.Provider value={{ cartItems, onAgregarCarrito, removeFromCart, clearCart }}>
      {children}
    </CarritoContext.Provider>
  );
};
