
    let panelIngreso = document.querySelector(".ingreso");
    let panelCarga = document.querySelector(".cargarImagen");
    let btnIngreso = document.querySelector("#btn-ingreso");
    let btnCarga = document.querySelector("#btncargarImagen")

    btnIngreso.addEventListener("click", () => {

    var getNombre = document.getElementById("nombreUsuario").value;
    console.log(getNombre);

    if (getNombre.length != 0) {

    panelCarga.style.display = "block";
    panelIngreso.style.display = "none";

} else {
    alert("Ingrese su nombre de usuario");
}

})


