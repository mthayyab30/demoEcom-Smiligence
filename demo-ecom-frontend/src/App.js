import logo from "./logo.svg";
import "./App.css";
import { useEffect, useState } from "react";
import axios from "axios";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import NavBar from "./components/NavBar";
import "bootstrap/dist/css/bootstrap.css";
import AddProducts from "./pages/AddProducts";
import Cart from "./pages/Cart";

function App() {
  const [products, setProducts] = useState([]);
  const Loadporducts = async () => {
    const prods = await axios.get("http://localhost:8080/products");
    setProducts(prods.data);
    console.log(prods.data);
  };
  useEffect(() => {
    Loadporducts();
  },[]);

  return (
    <div className="App">
      <Router>
        <NavBar></NavBar>
        <Routes>
          <Route path="/" element={<Home products={products}></Home>}></Route>
          <Route
            path="/AddProducts"
            element={<AddProducts></AddProducts>}
          ></Route>
          <Route path="/cart" element={<Cart></Cart>}></Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
