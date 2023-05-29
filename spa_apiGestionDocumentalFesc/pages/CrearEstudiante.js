import { CrearEstudianteFormulario } from "../components/CrearEstudianteFormulario.js"

const CrearEstudiante= ()=>

    `
    <div class="jumbotron py-4 text-center mt-5 mb-5"></div>
    <div class="container mt-5 mb-5">
        <div class="row justify-content-center">
            <div>
                <h3 class="text-center text-uppercase fw-bold">Crear estudiante</h3>
                ${CrearEstudianteFormulario()}
                <div class="mt-4">
                </div>
            </div>
        </div>
    </div>
    `

export { CrearEstudiante }