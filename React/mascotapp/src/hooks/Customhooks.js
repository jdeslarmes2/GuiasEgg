import { useState } from "react";

export const useUserForm = (initialState = {}) => {
 
 
    const [form, setForm] = useState(initialState); //el setForm se encarga de modificar la variable form, acá voy a ir guardando los valores de los imput en el formulario form

  const handleChanges = ({ target }) => {
    //Esta funcion (handelChanges) escucha los cambios, desestructura el input del formulario que lo llama {target}
    const { name, value } = target; //obtengo el name y el value
    
    console.log("target", target);
    console.log("name", name);
    console.log("value", value);

    setForm({
      // con las llaves {} genero un objeto que va a tener todos los datos del formulario
      ...form, // el ... es un sprit que lo que hace es decir si el foprmulario tenía valores no te olvides de incluirlos (osea recupera los datos viejos), después aca genero un json que se va guardando en la variable form
      [name]: value, // mediante el name lo agrego si es necesario, no acepta elementos dupolicados
    });
  };

  return {
    form,
    setForm,
    handleChanges, //enviamos el form, la posibilidad de setear el formulario y handleChange cuando se llame a useUserForm
  };
};
