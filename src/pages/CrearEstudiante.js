import { useState } from "react";
import { Alert, Card, Col, Container, Row } from "react-bootstrap";
import axios from "axios";
import { CREARESTUDIANTE_POST_ENDPOINT } from '../connections/helpers/endpoints';
import {CrearEstudianteFormulario} from '../components/CrearEstudianteFormulario';

const CrearEstudiante= ()=> {

    const [errores, setErrores]= useState({});

    const crearEstudiante = async ({documento, nombre, apellido, correo, telefono, carrera, semestre}) => {

        const error= {};
        setErrores(error);

        axios.post(CREARESTUDIANTE_POST_ENDPOINT, {documento, nombre, apellido, correo, telefono, carrera, semestre},
                {headers: { 'Accept': 'application/json', 'Content-Type': 'application/json'}}
            ).then(respuesta => {
                console.log(respuesta)
                alert("Estudiante creado.")
            }).catch(err => {
                setErrores({ crear: err.respuesta.data.message })
            })
    }

    return (
        <Container className="mt-5 mb-3">
            <Row className="justify-content-center">
                <Col>
                    <h3 className="text-center text-uppercase fw-bold">Crear estudiante</h3>
                    <Card.Body>
                        {errores.crear && <Alert variant="danger">{errores.crear}</Alert>}
                        
                        <CrearEstudianteFormulario errores={errores} callback={crearEstudiante}></CrearEstudianteFormulario>
                    </Card.Body>
                </Col>
            </Row>
        </Container>
    )
}

export {CrearEstudiante}