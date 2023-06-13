const API_URL= "http://localhost:8080";

export const SIGNUP_POST_ENDPOINT= API_URL+"/usuario";
export const SIGNIN_POST_ENDPOINT= API_URL+"/usuario/login";
export const CREARESTUDIANTE_POST_ENDPOINT= API_URL+"/estudiante";
export const CREAREMPRESA_POST_ENDPOINT= API_URL+"/empresa";
export const CREARENCARGADO_POST_ENDPOINT= API_URL+"/encargado";
// export const CREARARCHIVO_POST_ENDPOINT= API_URL+"/archivo";
export const CONSULTARDATO_POST_ENDPOINT= API_URL+"/archivo/datos";
export const OBTENERESTUDIANTE_GET_ENDPOINT= API_URL+"/usuario/misEstudiantes";
export const OBTENEREMPRESA_GET_ENDPOINT= API_URL+"/usuario/misEmpresas";
export const OBTENERENCARGADO_GET_ENDPOINT= API_URL+"/usuario/misEncargados";
export const OBTENEENTREGA_GET_ENDPOINT= API_URL+"/usuario/misArchivos";