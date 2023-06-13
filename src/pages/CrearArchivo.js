// import { useState } from "react";
// import { Alert, Card, Col, Container, Row } from "react-bootstrap";
// // import axios from "axios";
// // import { CREARARCHIVO_POST_ENDPOINT } from '../connections/helpers/endpoints';
// import {CrearArchivoFormulario} from '../components/CrearArchivoFormulario';

// const CrearArchivo= ()=> {

//     const [errores, setErrores]= useState({});

//     const crearArchivo = ()=> {

//        const errores= {};
//        setErrores(errores);
       
//     //    axios.post(CREARARCHIVO_POST_ENDPOINT, {nombre, datos, numRadicado, tipoRadicado, tipoDocumento, asunto, anexos, reqRespuesta, estudiante, empresa, encargado, respuesta, informarEncargado},
//     //     {headers: { 'Accept': 'application/json', 'Content-Type': 'application/json'}}
//     //     ).then(respuesta => {
//     //         console.log(respuesta)
//     //         alert("Archivo creado.")
//     //     }).catch(err => {
//     //         setErrores({ crear: err.respuesta.data.message })
//     //     })
//     }

//     return (
//         <Container className="mt-5 mb-3">
//             <Row className="justify-content-center">
//                 <Col>
//                     <h3 className="text-center text-uppercase fw-bold">Crear archivo</h3>
//                     <Card.Body>
//                         {errores.crear && <Alert variant="danger">{errores.crear}</Alert>}
                        
//                         <CrearArchivoFormulario errores={errores} callback={crearArchivo}></CrearArchivoFormulario>
//                     </Card.Body>
//                 </Col>
//             </Row>
//         </Container>
//     )
// }

// export {CrearArchivo}