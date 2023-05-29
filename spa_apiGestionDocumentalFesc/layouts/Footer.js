
const Footer= ()=> {

    const vista=

        `
        <div class="jumbotron py-3 text-center mt-5 mb-5"></div>
        <footer class="footer-cliente text-white text-center text-lg-start mt-5">
    <!-- Grid container -->
    <div class="container p-4">
      <!--Grid row-->
      <div class="row mt-4">
        <!--Grid column-->
        <div class="col-lg-4 col-md-12 mb-4 mb-md-0">
          <h5 class="text-uppercase text-black mb-4">Acerca de nosotros</h5>
  
          <p class="text-black">
            Somos estudiantes de ingeniería de software del semestre 5°.
          </p>
  
          <p class="text-black">
            Este proyecto trata sobre un servicio web para la oficina de gestión documental de la fesc para
            la materia arquitectura diseño del software.
          </p>
  
          <div class="mt-5 mb-5">

            <a type="button" class="btn btn-floating btn-dark btn-lg bg-dark" href="https://www.facebook.com/" target="_blank"><i class="bi bi-facebook"></i></a>

            <a type="button" class="btn btn-floating btn-dark btn-lg" href="https://www.linkedin.com/" target="_blank"><i class="bi bi-linkedin"></i></a>

            <a type="button" class="btn btn-floating btn-dark btn-lg" href="https://twitter.com/" target="_blank"><i class="bi bi-twitter"></i></a>

            <a type="button" class="btn btn-floating btn-dark btn-lg" href="https://gmail.com/" target="_blank"><i class="bi bi-google"></i></a>

          </div>
        </div>

  
        <div class="col-lg-4 col-md-6 mb-5 mb-md-0">
          <h5 class="text-uppercase text-black mb-4 pb-1">Contacto de los programadores</h5>
  
          <ul class="fa-ul text-black" style="margin-left: 1.65em;">
            <li class="mb-3">
              <span class="fa-li"><i class="fas fa-home"></i></span><span class="ms-2 text-black">Colombia, N.S de Santander, Cúcuta</span>
            </li>
            <li class="mb-3">
              <span class="fa-li"><i class="fas fa-envelope"></i></span><span class="ms-2 text-black">est_da_velandia@fesc.edu.co</span>
            </li>
            <li class="mb-3">
              <span class="fa-li"><i class="fas fa-envelope"></i></span><span class="ms-2 text-black">est_ja.rodriguez@fesc.edu.co</span>
            </li>
            <li class="mb-3">
              <span class="fa-li"><i class="fas fa-phone"></i></span><span class="ms-2 text-black">+ 57 313 8846250</span>
            </li>
            <li class="mb-3">
              <span class="fa-li"><i class="fas fa-print"></i></span><span class="ms-2 text-black">+ 57 320 8802219</span>
            </li>
          </ul>
        </div>

        <div class="col-lg-4 col-md-6 mb-4 mb-md-0">
          <h5 class="text-uppercase text-black mb-4 text-center">Director de proyecto</h5>
  
          <table class="table text-center text-white">
            <tbody class="font-weight-normal text-black">
              <tr>
                <td>Rodolfo Ortega Niño</td>
              </tr>
            </tbody>
          </table>
        </div>

      </div>

    </div>

  
    <!-- Copyright -->
    <div class="text-center p-3 bg-dark">
      © 2023 Copyright:
      <p class="text-white">Todos los derechos reservados</p>
    </div>

  </footer>
        `
    return vista
}

export { Footer }