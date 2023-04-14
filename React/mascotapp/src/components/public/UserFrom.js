import React, { useEffect, useState } from "react";
import { useUserForm } from "../../hooks/Customhooks";

const UserFrom = () => {

  const { form, setForm, handleChanges } = useUserForm();     //Acá desestructuro con {} por que lo que viene como return de mi hook es un objeto {}

  const[areEquals, setAreEquals] = useState(true);                    //El hook areequal se encarga de ver i las contraseñas son iguales, pongo true por que por default supongo iguales los pass

  const[passwordConfirmation, setpasswordConfirmation] = useState();   //Aca controlo que sea igual al primer password, no mando a ningun lado el password2


 const handlePasswordConfirmation = (e) =>{
   setpasswordConfirmation(e.target.value)                             //con target atrapo el input y con value atrapor el valor que tenga en ese momento el segundo input
 }

 useEffect(() => {                                                       //Acá evaluo cualquier cambio, en este caso la variable del password confirmation que necesito saber si cambia
     const { password} = form;                                           //aca le saco el password del json que armamos
     setAreEquals( password === passwordConfirmation);                    //se setea si es exactamente igual al password confirmation
 
    }, [passwordConfirmation])

  const handleSubmit = (e) => {                                       //agregar la variable e es para que no recargue el formulario con el preventDefault
         e.preventDefault() ;                                          //Esta función atrapa lo que se va a enviar a la api
       // UserService.save (form);                                       //acá pasamos el formulario al servicio que se encarga de enviarlo
         console.log(form);                                           
  }

  return (
    <div className="w-25 mx-auto mt-5">
      <h4 className="mb-3">Humano Registratate!</h4>
      <form className="needs-validation" noValidate>
        <div className="row g-3">
          <div className="col-12">
            <label htmlFor="email" className="form-label">
              Email
            </label>
            <input
              type="email"
              className="form-control"
              placeholder="you@example.com"
              name="email"
              onChange={handleChanges}
            />
          </div>

          <div className="col-12">
            <label htmlFor="password" className="form-label">
              Clave
            </label>
            <input type="clave" 
            className="form-control" 
            placeholder="Clave" 
             name="password"
             onChange={handleChanges}
             />
          </div>
          <div className="col-12">
            <label htmlFor="password2" className="form-label">
              Repetir Clave
            </label>
            <input
              type="clave"
              className="form-control"
              placeholder="Repetir clave"
              onChange={handlePasswordConfirmation}
            />

           { !areEquals && (
           
             <div className="form-text list-group-item-danger">
              Las claves no son iguales.
            </div>
            
            )}

          </div>

          <hr className="my-4" />

          <button 
          disabled={!areEquals}      //con esto dejo grisado el boton de registro hasta que son iguales los pass
          className="w-100 btn btn-primary btn-lg" 
          type="submit"
          onClick={handleSubmit}>
            Registrarme
          </button>
        </div>
      </form>
    </div>
  );
};

export default UserFrom;
