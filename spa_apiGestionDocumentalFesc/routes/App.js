import { Nav } from "../layouts/Navegacion.js"
import { Footer } from "../layouts/Footer.js"
import { ConsultarDatos } from "../pages/ConsultarDatos.js"
import { CrearArchivo } from "../pages/CrearArchivo.js"
import { CrearEstudiante } from "../pages/CrearEstudiante.js"
import { CrearEmpresa } from "../pages/CrearEmpresa.js"
import { CrearEncargado } from "../pages/CrearEncargado.js"
import { Error404 } from "../pages/Error404.js"
import getHash from "../connections/helpers/getHash.js"
import resolverRutas from "../connections/helpers/resolverRutas.js"


const Rutas= {

    "/": ConsultarDatos,
    "/creararchivo": CrearArchivo,
    "/crearestudiante": CrearEstudiante,
    "/crearempresa": CrearEmpresa,
    "/crearencargado": CrearEncargado
}

const App= async ()=> {

    const header= document.querySelector("header")
    const main= document.querySelector("main")
    const footer= document.querySelector("footer")

    header.innerHTML= await Nav()
    footer.innerHTML= await Footer()

    let ruta= await resolverRutas(getHash())

    let pagina= (Rutas[ruta]) ? Rutas[ruta] : Error404

    main.innerHTML= await pagina()

}

export {App}