import React, { useEffect, useState } from "react";
import "../css/card.css";
import axios from "axios";
import { Await } from "react-router-dom";
export default function CartCards({ cartItem ,loadFromCart}) {
  const AddtoCart = async () => {
    await axios.post("http://localhost:8080/cart/create", cartItem);
    loadFromCart()
  };

  const minusCartItem = async () => {
    const updatedItem = {
      ...cartItem,
      quantity: cartItem.quantity - 1,
    };
    if (cartItem.quantity === 0) {
      await axios.delete(`http://localhost:8080/cart/${cartItem.product_id}`);
    } else {
      await await axios.put(`http://localhost:8080/cart/${ cartItem.product_id}`, updatedItem);
    }
    loadFromCart()
  };
  return (
    <div>
      <div className="card" style={{ width: "18rem;" }}>
        <div className="card-body">
          <h5 className="card-title">{cartItem.product_name}</h5>

          <p className="card-text">₹{cartItem.cost}.</p>
          <p>Quantity</p>
          <div className="cartQuantity">
            <button
              type="button"
              class="btn btn-danger"
              onClick={minusCartItem}
            >
              -
            </button>

            <input type="numer" value={cartItem.quantity} />
            <button type="button" class="btn btn-success" onClick={AddtoCart}>
              +
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}
