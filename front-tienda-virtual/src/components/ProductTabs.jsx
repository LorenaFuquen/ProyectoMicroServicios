import React, { useState } from "react";
import ProductList from "./ProductList";
import AdminProductTable from "./AdminProductTable";
import "./ProductTabs.css";

const ProductTabs = ({searchQuery}) => {
  const [activeTab, setActiveTab] = useState("productos"); // 'productos' o 'admin'

  return (
    <div>
      <div className="tabs-header">
        <button
            className={activeTab === "productos" ? "active" : ""}onClick={() => setActiveTab("productos")}>
            Productos
        </button>
        <button
            className={activeTab === "admin" ? "active" : ""} onClick={() => setActiveTab("admin")}>
            Administrar Productos
        </button>
      </div>

      <div className="tabs-content">
            {activeTab === "productos" && (
            <div>
                <ProductList searchQuery = {searchQuery}/>
          </div>
        )}

            {activeTab === "admin" && (
            <div>
                <AdminProductTable />
            </div>
        )}
      </div>
    </div>
  );
};

export default ProductTabs;
