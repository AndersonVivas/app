function cambiar() {
	document.getElementById("formEvento:registrarJ").value = "disabled";
	var tabla = document.getElementById('tablajornada');
	var jornadas = document.getElementById('jornadasEvento');
	var butonregistrar = document.getElementById('formEvento:registrarJ');

	if (tabla.style.display == "none") {
		jornadas.style.display = "none";
		tabla.style.display = "block"
		butonregistrar.disabled = "false";
	} else {
		jornadas.style.display = "block";
		tabla.style.display = "none"
		butonregistrar.disabled = "false";
	}
}
function hora() {
	var hora = document.getElementById('formEvento:fechainicio_Input');
	documente.getElementById('formEvento:fechajornada_Input').value = hora;
}