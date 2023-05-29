import { CrearEmpresaFormulario } from "../components/CrearEmpresaFormulario.js"

const CrearEmpresa= ()=> 

    `
    <div class="jumbotron py-4 text-center mt-5 mb-5"></div>
    <div class="container mt-5 mb-5">
        <div class="row justify-content-center">
            <div>
                <h3 class="text-center fs-3 text-uppercase fw-bold">Crear empresa</h3>
                ${CrearEmpresaFormulario()}
                <div class="mt-4">
                </div>
            </div>
        </div>
    </div>
    `

export { CrearEmpresa }