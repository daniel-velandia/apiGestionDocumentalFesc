// import { useState } from "react";
// import axios from "axios";
// import { SIGNUP_POST_ENDPOINT } from '../connections/helpers/endpoints.js';
// import { Alert, Card, Col, Container, Row } from "react-bootstrap";
// import { ConsultarDatosFormulario } from '../components/ConsultarDatosFormulario.js';

// const ConsultarDatos= ()=> {

//     const [errores, setErrores]= useState({});

//     const consultar = async ({entidad, filtro, documento, fecha}) => {

//         const error= {};
//         setErrores(error);

//         axios.post(SIGNUP_POST_ENDPOINT, {entidad, filtro, documento, fecha},
//                 {headers: { 'Accept': 'application/json', 'Content-Type': 'application/json'}}
//             ).then(respuesta => {
//                 console.log(respuesta)
//             }).catch(err => {
//                 setErrores({ crear: err.respuesta.data.message })
//             })
//     }

//     return (
//         <Container className="mt-5 mb-3">
//             <Row className="justify-content-center">
//                 <Col sm="12" md="8">
//                     <h3 className="text-center text-uppercase fw-bold">Consultar datos</h3>
//                     <Card.Body>
//                         {errores.crear && <Alert variant="danger">{errores.crear}</Alert>}
//                         <ConsultarDatosFormulario errores={errores} callback={consultar}></ConsultarDatosFormulario>
//                     </Card.Body>
//                 </Col>
//             </Row>
//         </Container>
//     )
// }

// export {ConsultarDatos}