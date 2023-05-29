import { ConsultarDatosFormulario } from "../components/ConsultarDatosFormulario.js"
import { DatoCardConsulta } from "../components/DatoCardConsulta.js"


const ConsultarDatos= ()=> 

    `
    <div class="jumbotron py-4 text-center mt-5 mb-5"></div>
    <div class="container mt-5 mb-5">
        <div class="row justify-content-center">
            <div>
                <h3 class="text-center text-uppercase fw-bold">Consultar datos de entidades</h3>
                ${ConsultarDatosFormulario()}
                <div class="mt-4">
                </div>
            </div>
        </div>
    </div>

    <div class="container mt-5 mb-5">
        <div class="row justify-content-center">
            <div>
                <h3 class="text-center fw-bold mt-4">Datos encontrados</h3>
                ${DatoCardConsulta()}
                <div class="mt-4">
                </div>
            </div>
        </div>
    </div>

    `
export { ConsultarDatos }