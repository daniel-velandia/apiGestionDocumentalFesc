
const CrearEncargadoFormulario= ()=> {

    const vista= 

    `
    <div class="jumbotron py-1 text-center mt-5 mb-5"></div>
        <form>
            <div class="container mt-5">
            <div class="row">
                <div class="col-md-4">
                <div class="mb-5">
                    <label for="documento" class="form-label fw-semibold fs-5">Documento</label>
                    <input type="text" class="form-control py-2" id="documento" name="documento" placeholder="Ingrese el documento de identidad" pattern="[0-9]+" required>
                </div>
                </div>

                <div class="col-md-4">
                <div class="mb-5">
                    <label for="nombre" class="form-label fw-semibold fs-5">Nombres</label>
                    <input type="text" class="form-control py-2" id="nombre" name="nombre" placeholder="Ingrese los nombres" pattern="[A-Z a-z]+" required>
                </div>
                </div>

                <div class="col-md-4">
                <div class="mb-5">
                    <label for="apellido" class="form-label fw-semibold fs-5">Apellidos</label>
                    <input type="text" class="form-control py-2" id="apellido" name="apellido"  placeholder="Ingrese los apellidos" pattern="[A-Z a-z]+" required>
                </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                <div class="mb-5">
                    <label for="correo" class="form-label fw-semibold fs-5">Correo</label>
                    <input type="email" class="form-control py-2" id="correo" name="correo" placeholder="Ingrese el correo electrónico" required>
                </div>
                </div>
                <div class="col-md-4">
                    <div class="mb-5">
                        <label for="telefono" class="form-label fw-semibold fs-5">Teléfono</label>
                        <input type="text" class="form-control py-2" id="telefono" name="telefono" placeholder="Ingrese el teléfono" pattern="[0-9]+" required>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="mb-5">
                        <label for="cargo" class="form-label fw-semibold fs-5">Cargo</label>
                        <input type="text" class="form-control py-2" id="cargo" name="cargo" placeholder="Ingrese el cargo de la persona" pattern="[A-Z a-z]+" required>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <div class="mb-5">
                        <label for="area" class="form-label fw-semibold fs-5">Area</label>
                        <input type="text" class="form-control py-2" id="area" name="area" placeholder="Ingrese el area de la persona" pattern="[A-Z a-z]+" required>
                    </div>
                </div>
            </div>

            <div class="container">
                 <div class="row text-center">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-danger py-2 px-3">Crear destinatario</button>
                    </div>
                </div>
            </div>
            </div>
        </form>
    `

    return vista

}

export { CrearEncargadoFormulario }