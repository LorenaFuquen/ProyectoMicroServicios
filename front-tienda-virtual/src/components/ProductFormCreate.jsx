import React, { useEffect, useState } from 'react';
import './ProductFormCreate.css';
import API from '../api/api';

const ProductFormCreate = ({onClose, onProductoCreado}) =>{

    const[form, setForm] = useState({
        nombreProducto: '',
        descripcion: '',
        idCategoria: '',
        idTipo: '',
        idMarca: '',
        color: '',
        precio: '',
        idEstado: '',
        imageBase64: '',

    });
    const [errors, setErrors] = useState({});
    const [mensaje, setMensaje] = useState('');
    const [tipoMensaje, setTipoMensaje] = useState('');

    const [categorias, setCategorias] = useState([]);
    const [marca, setMarca] = useState ([]);
    const [tipoProducto, setTipoProducto] = useState ([]);
    const [estado, setEstado] = useState([]);

    useEffect (() =>
        {
        API.get('/productos/buscarCategorias').then(res => {
            console.log('Categorías cargadas:', res.data);
            setCategorias(res.data);
        });
        API.get('/productos/buscarMarcas').then(res => {
            console.log('Marcas cargadas:', res.data);
            setMarca(res.data);
        });
        API.get('/productos/buscarTipoProducto').then(res=> {
            console.log('Tipos cargados:', res.data);
            setTipoProducto(res.data);
        });
        API.get('/productos/buscarEstado').then(res => {
            console.log('Estados cargados:', res.data);
            setEstado(res.data);
        }); 
    }, []);

    const handleInputChange= (e) => { 
        const {name, value} = e.target;
        console.log (`Campo cambiado: ${name} = ${value}`)
        setForm(prev => ({ ...prev, [name]: value}));
    };

    const handleImageChange = (e) => {
        const file = e.target.files[0];
        console.log('Imagen seleccionada:', file);
        const reader  = new FileReader();
        reader.onloadend= () => {
            console.log('Imagen convertida a Base64');
            setForm(prev => ({ ...prev, imageBase64: reader.result}));
        };
        if (file) reader.readAsDataURL(file);
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        const newErrors = {};

        if (!form.nombreProducto) newErrors.nombreProducto = "El nombre es obligatorio";
        if (!form.descripcion) newErrors.descripcion = "La descripción es obligatoria";
        if (!form.idCategoria) newErrors.idCategoria = "Selecciona una categoría";
        if (!form.idTipo) newErrors.idTipo = "Selecciona un tipo";
        if (!form.idMarca) newErrors.idMarca = "Selecciona una marca";
        if (!form.color) newErrors.color = "El color es obligatorio";
        if (!form.precio || form.precio <= 0) newErrors.precio = "El precio debe ser mayor a 0";
        if (!form.idEstado) newErrors.idEstado = "Selecciona un estado";

        if (Object.keys(newErrors).length > 0) {
            setErrors(newErrors);
            return;
        }

        console.log('Datos a enviar al backend:', form);
        API.post('/productos/crearProducto', form)
        .then(() => {
            setMensaje('Producto creado correctamente');
            setTipoMensaje('success');
            onProductoCreado();
            setTimeout(() => {
                setMensaje('');
                onClose(); 
            }, 2000);
        })
        .catch(err =>{
            console.error('Error en el envío:', err);
            setMensaje('Error al crear el producto');
            setTipoMensaje('error');
            setTimeout(() => setMensaje(''), 3000);
        });
    };

    return (
        <div className= "modal-overlay">
            <div className= "modal-content">
                <h2>Nuevo Producto</h2>
                {mensaje && ( <div className={`mensaje-alerta ${tipoMensaje}`}> {mensaje}</div>)}
                <form onSubmit= {handleSubmit} className= "form-producto">

                    <div className= "form-group">
                        <label>Nombre del producto</label>
                        <input 
                            type= "text"
                            name= "nombreProducto" 
                            placeholder= "Escribe el nombre del producto" 
                            onChange={handleInputChange} 
                            className={errors.nombreProducto ? "input-error" : ""}
                        />
                        {errors.nombreProducto && <div className="error-message">{errors.nombreProducto}</div>}
                    </div>

                    <div className= "form-group">
                        <label>Descripción del producto</label>
                        <input 
                            type= "text" 
                            name= "descripcion" 
                            placeholder= "Escribe la descripcion del producto" 
                            onChange={handleInputChange} 
                            className={errors.descripcion ? "input-error" : ""}
                        />
                        {errors.descripcion && <div className="error-message">{errors.descripcion}</div>}
                    </div>

                    <div className= "form-group">
                        <label>Categoria del producto</label>
                        <select name= "idCategoria" onChange={handleInputChange} required>
                            <option value= "">Selecciona una categoria</option>
                            {categorias.map(c => <option key= {c.idCategoria} value={c.idCategoria}>{c.nombreCategoria}</option> )}
                        </select>
                    </div>

                    <div className= "form-group">
                        <label>Tipo del producto</label>
                        <select name= "idTipo" onChange={handleInputChange} required>
                            <option value= "">Selecciona un tipo</option>
                            {tipoProducto.map(t => <option key= {t.idTipo} value={t.idTipo}>{t.nombreTipo}</option> )}
                        </select>
                    </div>

                    <div className= "form-group">
                        <label>Marca del producto</label>
                        <select name= "idMarca" onChange={handleInputChange} required>
                            <option value= "">Selecciona una marca</option>
                            {marca.map(m => <option key= {m.idMarca} value={m.idMarca}>{m.nombreMarca}</option> )}
                        </select>
                    </div>

                    <div className= "form-group">
                        <label>Color del producto</label>
                        <input 
                            type= "text" 
                            name= "color" 
                            placeholder= "Escribe el color" 
                            onChange={handleInputChange} 
                            className={errors.color ? "input-error" : ""}
                        />
                        {errors.color && <div className="error-message">{errors.color}</div>}
                    </div>

                    <div className= "form-group">
                        <label>Precio del producto</label>
                        <input 
                            type= "number"
                            name= "precio" 
                            placeholder= "Escribe el precio" 
                            onChange={handleInputChange} 
                            className={errors.precio ? "input-error" : ""}
                        />
                        {errors.precio && <div className="error-message">{errors.precio}</div>}
                    </div>

                    <div className= "form-group">
                        <label>Categoria del producto</label>
                        <select name= "idEstado" onChange={handleInputChange} required>
                            <option value= "">Selecciona un estado</option>
                            {estado.map(es => <option key= {es.idEstado} value={es.idEstado}>{es.nombreEstado}</option> )}
                        </select>
                    </div>

                    <div className= "form-group">
                        <label>Imagen del producto</label>
                        <input type= "file" accept= "image/*" onChange={handleImageChange}/>
                    </div>

                    <div className= "form-buttons">
                        <button type = "submit"  className="btn-submit">Crear producto</button>
                        <button type = "button" className="btn-cancel" onClick={onClose}>Cancelar</button>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default ProductFormCreate;