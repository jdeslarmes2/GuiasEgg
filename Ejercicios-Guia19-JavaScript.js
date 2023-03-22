//Ejercicio 1
//var consulta = prompt("Como esya el día de hoy? (soleado, nublado o lloviendo) ");
//alert("El día de hoy esta " + consulta);


// Ejercicio 2
//var radio = parseInt(prompt("¿Cual es el valor del radio? (en cms) "));
//var perimetro = 2*3.14*radio;
//var area = 3.14*radio*radio;

//alert("El perímetro de su circunferencia es:  " + perimetro + " cm, y el área es de: "+area+" cm2");


//Ejercicio 3
//var edad =  parseInt(prompt("Cual es su edad?"));

//if(edad<18){
//    alert("Usted es menor de edad");
//} else {
//    alert("Usted es mayor de edad");
//}


//Ejercicio 4
//var solicitud =  (prompt("Escriba S o N"));

//if(solicitud == "S" || solicitud == "N"){
//    alert("CORRECTO");
//} else {
//    alert("INCORRECTO");
//}



//Ejercicio 5
//ar num1 =  parseInt(prompt("Cual es el primer valor a operar?"));
//var num2 =  parseInt(prompt("Cual es el segundo valor a operar?"));
//var consulta =  prompt("Cual es la operación que desea realizar? para suma escriba S, R para resta, M para multiplicación y D para división?");
//var operacion = consulta.toUpperCase();

//switch (operacion){
//    case 'S' :
//        var suma = num1 + num2;
//        alert("La suma de los números es: " + suma);
//        break;
//    case 'R':
//        var resta = num1 - num2;
//        alert("La resta de los números es: " + resta);
//        break;
//    case 'M':
//            var multiplicación = num1 * num2;
//            alert("La multiplicación de los números es: " + multiplicación);
//            break;
//    case 'D':
//            var división = num1 / num2;
//            alert("La división de los números es: " + división);
//            break;
//    default: alert("Lo lamentamos no podemos hacer la operación " + operación + " seleccionada."); 
                
//}

//Ejercicio 6
//var numero =  parseInt(prompt("Cual es el número a verificar?"));

//if(numero == 0){
//    alert("el número no es par ni impar");
//    } else {
//            if (numero%2 == 0){
//            alert("Su número es par");
//          } else {
//            alert("Su número es impar");
//           }
//    }

//Ejercicio 7
 //var limite =  parseInt(prompt("Cual es el límite positivo de la suma a realizar?"));
 //var suma = 0;

 //do {
 //   var num1 =  parseInt(prompt("Ingrese un valor a sumar"));
 //       suma = suma + num1;
 //       if (suma>limite){
 //           alert("Usted a pasado el limite positivo : " +limite+ " con la suma de valores igual a " + suma);
 //           break;
 //       }
 //}while(suma<limite);

//Ejercicio 8
//var suma = 0;
//var cantidad = 0;
//var max = 0;
//var min = 1000;

//do {
//    var numero =  parseInt(prompt("Ingrese un número entero menor a 1000"));
//    suma = numero + suma;
//    cantidad++;
//    if (numero> max){
//        max = numero;
//    }if (numero !== 0) {
//        if (numero<min){
//        min = numero;
//       }  
//       var promedio = suma / cantidad;
//    }
//   
//}while(numero !== 0);

//alert("El número máximo fue: " + max + ", su número mínimo fue :"+ min +", el promedio fue: "+ promedio);

//Ejercicio 9

 //   var palabra =  prompt("Ingrese la palabra a separar las letras");
 //   var pal = [];
    
//    for(let i = 0; i < palabra.length; i++){
//        pal[i] = palabra.substring(i,i+1);
//    }

//    var palabraSeparada = pal.join(" ");

//    console.log(palabraSeparada);


//Ejercicio 10

    // var palabra =  prompt("Ingrese la palabra a dar vuelta");
    // var pal = [];
    
    // for(let i = 0; i < palabra.length; i++){
    //     pal[i] = palabra.substring(i,i+1);
    // }

    // var vectorAlReves = [];
    
    // let invertir = (vector) => vector.reverse();

    // vectorAlReves = invertir(pal);

    // var palabraAlReves = vectorAlReves.join("");

    // console.log(palabraAlReves);

// //Ejercicio 11

// var frase =  prompt("Ingrese la frase a devolver la palabra más larga");
// var fraseArray = frase.split(' ');

// var longMaxPalabra = 0;
// for(let palabra of fraseArray){
//     if (longMaxPalabra < palabra.length){
//         longMaxPalabra = palabra.length;
//     }
// }
// for(let palabra of fraseArray){
//     if(palabra.length == longMaxPalabra){
//         console.log(`La palabra de mayor longitud es: ${palabra}.`);
//         break;
//     }
// }

//Ejercicio 12

// var frase =  prompt("Ingrese el argumento a verificar su tipo");

//     if (frase !== "true" || frase !== "false") {
//     var fraseFinal = frase;
//     }

//     if (frase == "true") {
//     var fraseFinal = true; 
//     }
//      if  (frase == "false") {
//             var fraseFinal = false;
//     }      

//      let verifTipo = (argumento) => console.log("El tipo de argumento es: " + typeof(argumento));

//     verifTipo(fraseFinal);

//--------------------------------------EJEMPLOS FETCH GET Y POST---------------------------------------------

// //FETCH GET
// fetch("https://rickandmortyapi.com/api/character").then(response=>response.json()).then(data=>console.log(data));

// // FETCH POST
// async function peticion(){
//     let response = await fetch("https://rickandmortyapi.com/api/character"); let data = await response.json(); return data;} let r = await peticion(); console.log(r);

//-------------------------------------------------------------------------------------------------------------


// //Ejercicio 13

// let persona = { 
//     nombre : "Joaquín",
//     edad: 15,
//     sexo: "M",
//     peso: 75,
//     altura: 1.73,
// };

// let { nombre, edad, sexo, peso, altura} = persona;    //Así desestructuro el objeto persona y luego veo sus propiedades

// console.log(`El nombre de la persona es: ${nombre}, la edad es: ${edad}, el sexo es: ${sexo}, el peso es: ${peso}, la altura es: ${altura}.`);

//Ejercicio 14

// let libro = { 
//     ISBN : 1234,
//     Título: "Las hojas otoñales",
//     Autor: "Josef Muriel",
//     NúmeroDePaáginas: 344,
// };

// function crearLibro(){
//     let ISBN =  parseInt(prompt("Ingrese el ISBN: "));
//     let Título = prompt("Ingrese el Título: ");
//     let Autor = prompt("Ingrese el Autor: ");
//     let NumeroDePáginas =  parseInt(prompt("Ingrese el número de páginas: "));

//     return {ISBN, Título, Autor, NumeroDePáginas};
// }

// let nuevoLibro = crearLibro();

// console.log(nuevoLibro);



//let { ISBN, Título, Autor, NumeroDePáginas} = nuevoLibro;    //Acá no hace falta desestructurar el objeto libro ya que lo traigo desde la variable nuevoLibro



//console.log(`El ISBN del libro es: ${nuevoLibro.ISBN}, el título es: ${nuevoLibro.Título}, el autor es: ${nuevoLibro.Autor}, el número de páginas es: ${nuevoLibro.NumeroDePáginas}.`);

////-------otra forma------------------

// function Libro(ISBN, Título, Autor, NumeroDePáginas){
//     this.ISBN = ISBN;
//     this.Título = Título;
//     this.Autor = Autor;
//     this.NumeroDePáginas = NumeroDePáginas;
// }

// let miLibro = new Libro(1234, "Las hojas otoñales", "Josef Muriel", 344 );

// console.log(miLibro);

//-------------------------------------

//Ejercicio 15 

// function calcularArea(radio){
//   let area = 3.14*Math.pow(radio,2);
//   return area;
// }

// function calcularPerímetro(radio){
//     let perímetro = 2*3.14*radio;
//     return perímetro;
// }

// let radio =  parseInt(prompt("Ingrese el rádio del círculo en cms: "));

// console.log(`El área del círculo es: ${calcularArea(radio)} cms2, y el perímetro del círculo es: ${calcularPerímetro(radio)} cms.`);

//Ejercicio 16


// var vector1 = [1,2,3,4,5];
// let vector2 = [1,2,3,4,5];

// let vectorFinal = vector1.map((e)=> Math.round(Math.random() * 10));   //El map permite pisar valores, forEach y filter es para mostrar el contenido.
// let vectorFinal2 = vector2.map((e)=> Math.round(Math.random() * 10));

// console.log(vectorFinal);
// console.log(vectorFinal2);


//Ejercicio 17

// let indice =  parseInt(prompt("Ingrese el la cantidad de valores del vector, debe ser mayor a dos"));

// var vector = [];

// for (i=0; i<indice; i++){
//        vector[i] =  parseInt(prompt("Ingrese el valor del vector"));
// }

// let valorFinal = vector.length;
// let valorAnteúltimo = vector.length-1;


// console.log("Este es el vector inicial: " + vector);

// let vectorFinal = vector.filter(function (e) {
//            if(e !== valorFinal && e !== valorAnteúltimo)
//            return e;

//     }
// )

// console.log("El vector final luego de borrar vector final al eliminar los dos últimos valores es: " + vectorFinal);

// ---------otra opción para borrar desde un valor indicado---------------------------------------------------------------


//vector.splice(valorAnteúltimo, 2);


//------------------------------------------------------------------------------------------------------------------------

//Ejercicio 18


var vector = [true, 5, false, "hola", "adios", 2];


var longString = 0;

for (i=0; i<vector.length; i++){
        
       if(typeof vector[i] == "string")
       var long =  vector[i].length;

       if(long > longString)
       longString = long;

}

console.log(longString);
 

for (i=0; i<vector.length; i++){
        
    if(typeof vector[i] == "string" && vector[i].length == longString+1 )
    var palabra = vector[i];
    console.log(`La palabra con mayor cantidad de caracteres de los strings del vector es: ${palabra}`);
     break;
 }



