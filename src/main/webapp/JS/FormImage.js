var botonIngreso = document.getElementById("update-table");

botonIngreso.addEventListener("click", () => {
   console.log("jfasofjsaoj")
   let foto = document.getElementById("image");
   let descrip = document.getElementById("descripcion");

   console.log(descrip.value);

   if (foto.value == "" || foto.value == null) {

      alert("Primero carga la foto :) ");

   } else if (descrip.value == false || descrip.value == null) {

      alert("Dale una descripcion a tu imagen");

   } else {

      alert("Se ha guardado tu foto existosamente :)");


      const fecha = new Date();
      let contenedor = document.getElementById('IngresarFoto');

      let col = document.createElement('div');
      let div = document.createElement('div');
      let description = document.createElement('p');
      let date = document.createElement('h6');
      let image = document.createElement('img');
      let atag = document.createElement('a');
      let button = document.createElement('button');

      let urlImage = document.getElementById('image').files[0].name;


      date.innerHTML = fecha.getDate() + '/' + fecha.getMonth() + "/" + fecha.getFullYear();
      div.className = 'cardImage';
      col.className = 'col';
      button.className = 'btn btn-warning';
      button.innerHTML = 'Descargar'
      button.id = 'btnDescarga';
      description.innerHTML = descrip.value;
      image.src = ".//" + "urlImage";

      div.appendChild(image);
      div.appendChild(description);
      div.appendChild(date);
      div.appendChild(button);
      col.appendChild(div);
      contenedor.appendChild(col);



      innerHTML(contenedor);


   }

})

