import React, { useEffect, useState } from "react";
import axios from "axios";
import CartCards from "../components/CartCards";

export default function Cart() {
  const [cart, setCart] = useState([]);

  const loadFromCart = () => {
    loadCart();
  };
  const loadCart = async () => {
    const cartItems = await axios.get("http://localhost:8080/cart");
    setCart(cartItems.data);
  };
  useEffect(() => {
    loadCart();
  }, []);

  return (
    <div style={{ display: "flex", flexWrap: "wrap" }}>
      {cart.map((cartItem, index) => (
        <CartCards
          key={index}
          cartItem={cartItem}
          loadFromCart={loadFromCart}
        ></CartCards>
      ))}
    </div>
  );
}
