let contadorBoletos = 24; // para simular nuevos boletos

function confirmarAccion(accion) {
  const modal = document.getElementById("modal");
  const mensaje = document.getElementById("modalMensaje");

  if (accion === "reservar") {
    mensaje.innerText = "Reserva realizada con éxito";
    agregarAlHistorial(); 
} else if (accion === "vender") {
    mensaje.innerText = "Venta realizada con éxito";
    agregarAlHistorial();
  }

  modal.style.display = "flex";
}


function agregarAlHistorial() {
  const tabla = document.getElementById("tablaHistorial").querySelector("tbody");

  const origen = document.getElementById("origen").value;
  const destino = document.getElementById("destino").value;
  const actividad =document.getElementById("actividad").value;
  const fecha = document.getElementById("fecha").value;
  const hora = document.getElementById("hora").value;
  const fila = document.createElement("tr");
  fila.innerHTML = `
    <td>${contadorBoletos++}</td>
    <td>${origen}</td>
    <td>${destino}</td>
    <td>${actividad}</td>
    <td>${fecha} ${hora}</td>
    <td><span class="precio">$800.00</span><br>Boleto Sencillo</td>
  `;
  tabla.appendChild(fila);
}
