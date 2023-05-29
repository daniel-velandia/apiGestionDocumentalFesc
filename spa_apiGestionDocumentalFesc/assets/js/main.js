
function validarCorreo() {
  
  var correo = document.getElementById("correo").value;
  var dominioExp = /@(.+)/;
  var dominio = correo.match(dominioExp)[1];

  if (dominio.includes(".") && dominio.length > 2) {

  } else {
    
    alert("El correo electrónico no es válido.");

  }
  
}


function validarNIT() {
  
  var nit = document.getElementById("nit").value;
  nit = nit.replace(/[-\s]/g, '');
  var patron = /^\d{9}-\d{1}$/;

}

function showConfirmation() {
  
    Swal.fire({
    title: 'Confirmación',
    text: '¿Estás seguro de que deseas continuar?',
    icon: 'question',
    showCancelButton: true,
    confirmButtonText: 'Sí',
    cancelButtonText: 'Cancelar'
    }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire('¡Enviado!', 'Acabaste de enviar el pedido. No puedes realizar otro hasta que este esté listo.', 'success');
      alert("Pendiente...");
    } else if (result.dismiss === Swal.DismissReason.cancel) {
      Swal.fire('Cancelado', 'Has cancelado el pedido.', 'error');
    }
    });
}
