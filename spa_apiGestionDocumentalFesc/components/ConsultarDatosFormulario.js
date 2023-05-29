
const ConsultarDatosFormulario= ()=> {

    const vista=

        `
        <div class="jumbotron py-1 text-center mt-5 mb-5"></div>
        <form>
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group mb-5">
                            <label for="tipoEntidad" class="form-label fw-semibold fs-5">Entidad</label>
                            <select name="tipoEntidad" class="form-select py-2" id="tipoEntidad" required>
                                <option value="">Seleccione</option>
                                <option value="1">Empresa</option>
                                <option value="2">Estudiante</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group mb-5">
                            <label for="filtro" class="form-label fw-semibold fs-5">Filtrar por</label>
                            <select name="filtro" class="form-select py-2" id="filtro" required>
                                <option value="">Seleccione</option>
                                <option value="1">Todos los radicados</option>
                                <option value="2">Radicados de entrega con respuesta</option>
                                <option value="3">Solo radicados de entrega</option>
                                <option value="4">Solo radicados de respuesta</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group mb-5">
                            <label for="identificacion" class="form-label fw-semibold fs-5">Identificación</label>
                            <input type="text" class="form-control py-2" id="identificacion" name="identificacion" placeholder="Ingrese la identificación" required>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group mb-5">
                            <label for="fecha" class="form-label fw-semibold fs-5">Fecha</label>
                            <input type="number" min="1900" max="2099" step="1" class="form-control py-2" id="fecha" name="fecha" placeholder="Ingrese el año que se creó el documento" required>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row text-center">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-danger px-3 py-2 mt-3">Consultar datos</button>
                    </div>
                </div>
            </div>
        </form>

        `
        
    return vista

}

export { ConsultarDatosFormulario }