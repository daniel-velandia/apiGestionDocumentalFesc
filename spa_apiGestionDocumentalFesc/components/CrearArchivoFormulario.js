
const CrearArchivoFormulario= ()=> {

    const vista=

    `
    <div class="jumbotron py-1 text-center mt-5 mb-5"></div>
            <form>
                <div class="container mt-5">
                <div class="row">
                    <div class="col-md-4">
                    <div class="mb-5">
                        <label for="nombre" class="form-label fw-semibold fs-5">Nombre de archivo</label>
                        <input type="text" class="form-control py-2" id="nombre" name="nombre" placeholder="Ingrese el nombre del archivo" required>
                    </div>
                    </div>
                    <div class="col-md-4">
                    <div class="mb-5">
                        <label for="numRadicado" class="form-label fw-semibold fs-5">Número radicado</label>
                        <input type="text" class="form-control py-2" id="numRadicado" name="numRadicado"  placeholder="Ingrese el número de radicado" pattern="[0-9]+" required>
                    </div>
                    </div>
                    <div class="col-md-4">
                        <div class="mb-5">
                            <label for="tipoRadicado" class="form-label fw-semibold fs-5">Tipo de radicado</label>
                            <select name="tipoRadicado" id="tipoRadicado" class="form-select py-2" required>
                                <option value="">Seleccione</option>
                                <option value="1">Entrega</option>
                                <option value="2">Respuesta</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                    <div class="mb-5">
                        <label for="tipoDocumento" class="form-label fw-semibold fs-5">Tipo de documento</label>
                        <select name="tipoDocumento" id="tipoDocumento" class="form-select py-2" required>
                            <option value="">Seleccione</option>
                            <option value="1">Carta</option>
                            <option value="2">Solicitud</option>
                            <option value="3">Derecho de petición</option>
                            <option value="4">Citación</option>
                            <option value="5">Memorando</option>
                            <option value="6">Caja</option>
                            <option value="7">Factura</option>
                            <option value="8">Remisión</option>
                            <option value="9">Paquete</option>
                            <option value="10">Otro</option>
                        </select>
                    </div>
                    </div>
                    <div class="col-md-4">
                    <div class="mb-5">
                        <label for="asunto" class="form-label fw-semibold fs-5">Asunto</label>
                        <input type="text" class="form-control py-2" id="asunto" name="asunto" placeholder="Ingrese el asunto" pattern="[A-Z a-z]+" required>
                    </div>
                    </div>
                    <div class="col-md-4">
                        <div class="mb-5">
                            <label for="anexos" class="form-label fw-semibold fs-5">Anexos</label>
                            <input type="number" class="form-control py-2" id="anexos" name="anexos" placeholder="Ingrese el número de anexos" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="mb-5">
                            <label for="estudiante" class="form-label fw-semibold fs-5">Estudiante</label>
                            <select name="estudiante" id="estudiante" class="form-select py-2" required>
                                <option value="">Seleccione</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="mb-5">
                            <label for="empresa" class="form-label fw-semibold fs-5">Empresa</label>
                            <select name="empresa" id="empresa" class="form-select py-2" required>
                                <option value="">Seleccione</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="mb-5">
                            <div class="mb-5">
                                <label for="respuesta" class="form-label fw-semibold fs-5">Respuesta</label>
                                <select name="respuesta" id="respuesta" class="form-select py-2" required>
                                    <option value="">Seleccione</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <div class="mb-5">
                            <input class="form-check-input" type="checkbox" value="reqRespuesta" id="reqRespuesta">
                            <label class="form-check-label fw-semibold ms-2" for="reqRespuesta">Requiere respuesta</label>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="mb-5">
                            <button class="border rounded-3 btn" id="datos" style="background-color: rgb(253, 37, 37); color: white;">Seleccionar archivo</button>
                            <input type="file" id="datos" style="display: none;" accept=".pdf">
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row text-center">
                        <div class="col-md-12">
                            <button type="submit" class="btn btn-danger py-2 px-3 mt-5">Crear archivo</button>
                        </div>
                    </div>
                </div>
            </div>
            </form>
    `

    return vista

}

export { CrearArchivoFormulario }