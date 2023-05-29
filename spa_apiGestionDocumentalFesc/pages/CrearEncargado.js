import { CrearEncargadoFormulario } from "../components/CrearEncargadoFormulario.js"

const CrearEncargado= ()=> 

    `
    <div class="jumbotron py-4 text-center mt-5 mb-5"></div>
    <div class="container mt-5 mb-5">
        <div class="row justify-content-center">
            <div>
                <h3 class="text-center text-uppercase fw-bold">Crear destinatario</h3>
                ${CrearEncargadoFormulario()}
                <div class="mt-4">
                </div>
            </div>
        </div>
    </div>
    `

export { CrearEncargado }