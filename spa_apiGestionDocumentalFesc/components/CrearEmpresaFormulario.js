const CrearEmpresaFormulario= ()=> {
    
    const vista=

        `
        <div class="jumbotron py-1 text-center mt-5 mb-5"></div>
            <form>
                <div class="container mt-5">
                <div class="row">
                    <div class="col-md-4">
                    <div class="mb-5">
                        <label for="nomEmpresa" class="form-label fw-semibold fs-5">Nombre de empresa</label>
                        <input type="text" class="form-control py-2" id="nomEmpresa" name="nomEmpresa" placeholder="Ingrese el nombre de la empresa" pattern="[A-Z a-z]+" required>
                    </div>
                    </div>
                    <div class="col-md-4">
                    <div class="mb-5">
                        <label for="nit" class="form-label fw-semibold fs-5">NIT</label>
                        <input type="text" class="form-control py-2" id="nit" name="nit" placeholder="Ingrese el NIT" required>
                    </div>
                    </div>
                    <div class="col-md-4">
                        <div class="mb-5">
                            <label for="correo" class="form-label fw-semibold fs-5">Correo</label>
                            <input type="email" class="form-control py-2" id="correo" name="correo" placeholder="Ingrese el correo electrónico" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                    <div class="mb-5">
                        <label for="telefono" class="form-label fw-semibold fs-5">Teléfono</label>
                        <input type="text" class="form-control py-2" id="telefono" name="telefono" placeholder="Ingrese el teléfono" pattern="[0-9]+" required>
                    </div>
                    </div>
                    <div class="col-md-4">
                    <div class="mb-5">
                        <label for="nombreAsistente" class="form-label fw-semibold fs-5">Nombre de la persona</label>
                        <input type="text" class="form-control py-2" id="nombreAsistente" name="nombreAsistente" placeholder="Nombre de la persona dirigida" pattern="[0-9]+" required>
                    </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row text-center">
                        <div class="col-md-12">
                            <button type="submit" class="btn btn-danger py-2 px-3">Crear empresa</button>
                        </div>
                    </div>
                </div>
            </div>
            </form>

        `

    return vista
}

export { CrearEmpresaFormulario }