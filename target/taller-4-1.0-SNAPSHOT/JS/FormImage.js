let panelIngreso = document.querySelector(".ingreso");
let panelCarga = document.querySelector(".cargarImagen");
let btnIngreso = document.querySelector("#btn-ingreso");
let btnCarga = document.querySelector("#btncargarImagen")

btnIngreso.addEventListener("click", () => {

    var getNombre = document.getElementById("nombreUsuario").value;
    console.log(location)
    if (getNombre.length != 0) {
        location.href  ="Formimage.html";
    } else {
        alert("Ingrese su nombre de usuario");
    }

})


