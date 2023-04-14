import React from 'react'
import { Link } from 'react-router-dom'

const Card = ({mascota}) => {
  return (
    <div className="col">
    <div className="card shadow-sm">

      <img  height="100%" src={mascota.image} alt="imagen"/>

      <div className="card-body ">
            <strong className="d-inline-block mb-2 text-success">
              {mascota.species}
            </strong> 
      <h4  className="mb-0 text-dark">{mascota.name}</h4> 

        <p className="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
        <div className="d-flex justify-content-between align-items-center">

            <button type="button" className="btn btn-sm btn-outline-secondary">
              <Link to={`/details/${mascota.id}`} className='nav-link'>
                Detail
              </Link>
            </button>


          <small className="text-body-secondary">9 mins</small>
        </div>
      </div>
    </div>
  </div>
  )
}

export default Card
