import React, { useState } from "react";
import "../css/form.css";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function AddProducts() {
  const navigate = useNavigate();
  const [product, setProduct] = useState({
    product_name: "",
    quantity: 0,
    cost: 0,
  });
  const onsubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/products/create", product);
    navigate("/");
  };
  const onEventChange = (e) => {
    console.log(e.target);
    const { name, value } = e.target;
    setProduct({ ...product, [name]: value });
  };

  return (
    <div>
      <form
        className="form"
        onSubmit={(e) => {
          onsubmit(e);
        }}
      >
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">
            name
          </label>
          <input
            type="text"
            name="product_name"
            onChange={(e) => {
              onEventChange(e);
            }}
            class="form-control"
            id="name"
          />
          <label for="cost" class="form-label">
            Cost
          </label>
          <input
            type="number"
            id="cost"
            name="cost"
            onChange={(e) => {
              onEventChange(e);
            }}
            class="form-control"
          />
          <label for="quntity" class="form-label">
            quantity
          </label>
          <input
            type="number"
            id="quantity"
            name="quantity"
            onChange={(e) => {
              onEventChange(e);
            }}
            class="form-control"
          />
        </div>

        <button type="submit" class="btn btn-primary">
          Submit
        </button>
      </form>
    </div>
  );
}
