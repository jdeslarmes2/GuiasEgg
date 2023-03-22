
var numeros = [1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8];

console.log(numeros[0]);


var personas = [
    {
    apellido : "Deslarmes",
    nombre : "Javier",

    }, {
        apellido: "Leodin",
        nombre: "Juan",

    }, {
        apellido: "Perez",
        nombre: "José",
    }
   ];


   console.log(personas[personas.length-1]);



var persona = {
    apellido : "Deslarmes",
    nombre : "Javier",
    nacimiento : new Date ("01-02-1980"),
    dni: 34555675,
    mascotas : [ {
        apodo: "Dalmo",
        numeroIdentificatorio : 1224432,
        nacimiento : new Date("01-02-2006"),  
      }, {
        apodo: "Chiquito",
        numeroIdentificatorio : 1224443,
        nacimiento : new Date("01-02-2007"),  
      }
   ]
};

class Mascota {
    apodo;
    numeroIdentificatorio;
}

var m = new Mascota();

m.apodo = "Filomena";
m.numeroIdentificatorio = 3435434;

console.log(m.apodo);