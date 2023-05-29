import { CrearArchivoFormulario } from "../components/CrearArchivoFormulario.js"

const CrearArchivo= ()=>

    `
    <div class="jumbotron py-4 text-center mt-5 mb-5"></div>
    <div class="container mt-5 mb-5">
        <div class="row justify-content-center">
            <div>
                <h3 class="text-center text-uppercase fw-bold">Crear archivo</h3>
                ${CrearArchivoFormulario()}
                <div class="mt-4">
                </div>
            </div>
        </div>
    </div>
    `

export { CrearArchivo }