import React, { useEffect, useState } from 'react'
import Card from './Card'
import { cleanup } from '@testing-library/react';
import RickAndMortyService from '../../services/RickAndMorty.service';

const Cards = () => {
 
  const [mascotas, setMascotas] = useState([]);

  useEffect(() => {                             //Hook use effect se encarga de escucha activa de cambios
       RickAndMortyService.getAllCharacters()     //Acá busca todos los personajes
       .then((data)=> setMascotas(data.results))   //Si los encuentra setea en mascotas los resultados (results) de la api
       .catch((error) => console.log(error));      

  },[mascotas])         //mascotas en este caso es el array que esta escuchando useEffect para ver si hay cambios

  const cardsList = mascotas.map((m) => <Card mascota={m} key={m.id}/>)
 

  return (
    <div className="album py-5 bg-body-tertiary">
    <div className="container">
  
      <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
      {cardsList}  

      
    
      </div>
    </div>
  </div>
  )
}

export default Cards
