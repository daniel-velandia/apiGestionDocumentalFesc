import { useState } from "react";
import { Alert, Card, Col, Container, Row } from "react-bootstrap";
import axios from "axios";
import { CREARENCARGADO_POST_ENDPOINT } from '../connections/helpers/endpoints';
import {CrearEncargadoFormulario} from '../components/CrearEncargadoFormulario';

const CrearEncargado= ()=> {

    const [errores, setErrores]= useState({});

    const crearEncargado= async({documento, nombre, apellido, correo, telefono, cargo, area}) => {

       const error= {};
       setErrores(error);
       
       axios.post(CREARENCARGADO_POST_ENDPOINT, {documento, nombre, apellido, correo, telefono, cargo, area},
        {headers: { 'Accept': 'application/json', 'Content-Type': 'application/json'}}
            ).then(respuesta => {
                console.log(respuesta)
                alert("Encargado creado.")
            }).catch(err => {
                setErrores({ crear: err.respuesta.data.message })
            })
    }

    return (
        <Container className="mt-5 mb-3">
            <Row className="justify-content-center">
                <Col>
                    <h3 className="text-center text-uppercase fw-bold">Crear encargado</h3>
                    <Card.Body>
                        {errores.crear && <Alert variant="danger">{errores.crear}</Alert>}
                        
                        <CrearEncargadoFormulario errores={errores} callback={crearEncargado}></CrearEncargadoFormulario>
                    </Card.Body>
                </Col>
            </Row>
        </Container>
    )
}

export {CrearEncargado}