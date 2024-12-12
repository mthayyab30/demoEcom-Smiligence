import React, { useEffect } from "react";
import "../css/card.css";
import axios from "axios";
export default function Cards({ product }) {
  const AddtoCart = async () => {
    await axios.post("http://localhost:8080/cart/create", product);
  };

  const onclick = () => {
    console.log("addtocart");
    AddtoCart();
  };
  return (
    <div className="card" style={{ width: "18rem;" }}>
      <div className="card-body">
        <h5 className="card-title">{product.product_name}</h5>
        <h6 className="card-subtitle mb-2 text-body-secondary">
          {product.quantity}
        </h6>
        <p className="card-text">₹{product.cost}.</p>
        <button onClick={onclick} type="button" class="btn btn-primary">
          Add to Cart
        </button>
      </div>
    </div>
  );
}
