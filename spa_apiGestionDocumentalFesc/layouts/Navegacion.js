const Nav = ()=> {

    const vista=

    `
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container-fluid">
          <a class="navbar-brand m-3" href="/">Gestión Documental FESC</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="container collapse navbar-collapse ms-4" id="navbarNav">
            <ul class="navbar-nav ml-auto ms-5">
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="#/creararchivo/">Crear archivo</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="#/crearestudiante/">Crear estudiante</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#/crearempresa/">Crear empresa</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#/crearencargado/">Crear destinatario</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#/">Cerrar sesion</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
    `
    return vista
}

export { Nav }