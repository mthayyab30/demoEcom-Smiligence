import React, { use, useEffect } from "react";
import Cards from "../components/Cards";
import "../css/home.css";
export default function Home({ products }) {
  return (
    <div className="home">
      {products.map((product, index) => (
        <Cards
          key={index}
          product={product}
        ></Cards>
      ))}
    </div>
  );
}
