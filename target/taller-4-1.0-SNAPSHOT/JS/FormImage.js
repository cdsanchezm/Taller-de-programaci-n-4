// let btnIngreso = document.querySelector("#btn-ingreso");
//
// btnIngreso.addEventListener("click", () => {
//
//     var getNombre = document.getElementById("nombreUsuario").value;
//     console.log(getNombre);
//
//     if (getNombre.length != 0) {
//
//     } else {
//         alert("Ingrese su nombre de usuario");
//     }
//
// })


//___________________________

// const ubicacion = 'https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json';
//
//
// async function getData() {
//
//     const response = await fetch(ubicacion);
//     const data = await response.json();
//
//
//     crearCards(data);
//
// }
//
//
// getData();
//
// function crearCards(data) {
//
//     for (i = 0; i < 50 ; i++) {
//
//         let contenedor = document.getElementById('IngresarFoto');
//
//         let col = document.createElement('div');
//         let div = document.createElement('div');
//         let description = document.createElement('p');
//         let date = document.createElement('h6');
//         let image = document.createElement('img');
//         let button = document.createElement('button');
//
//         div.className = 'cardImage';
//         col.className = 'col';
//         button.className = 'btn btn-warning';
//         button.innerHTML = 'Descargar'
//         button.id = 'btnDescarga';
//
//         description.innerHTML = data.description[i];
//         image.src = data.image[i];
//         date.innerHTML = data.fecha[i];
//
//         div.appendChild(image);
//         div.appendChild(description);
//         div.appendChild(date);
//         div.appendChild(button);
//         col.appendChild(div);
//         contenedor.appendChild(col);
//
//     }
//
// }




// prueba


// const ubicacion = 'https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json';
//
// async function getData() {
//
//     const response = await fetch(ubicacion);
//     const data = await response.json();
//
//     crearCards(data);
//
// }
//
// getData();
//
// function crearCards(data) {
//
//     for (i = 0; i < 50; i++) {
//
//         let contenedor = document.getElementById('IngresarFoto');
//         let col = document.createElement('div');
//         let div = document.createElement('div');
//         let description = document.createElement('p');
//         let date = document.createElement('h6');
//         let image = document.createElement('img');
//         let button = document.createElement('button');
//
//         div.className = 'cardImage';
//         col.className = 'col';
//         button.className = 'btn btn-warning';
//         button.innerHTML = 'Descargar'
//         button.id = 'btnDescarga';
//
//         description.innerHTML = data.members[i].name;
//         image.src = data.members[i].age;
//         date.innerHTML = data.members[i].secretIdentity;
//
//         div.appendChild(image);
//         div.appendChild(description);
//         div.appendChild(date);
//         div.appendChild(button);
//         col.appendChild(div);
//         contenedor.appendChild(col);
//
//
//     }
//
// }
//
//
//
//
//
//
