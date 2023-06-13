import { useState } from "react";
import { Alert, Card, Col, Container, Row } from "react-bootstrap";
import axios from "axios";
import { CREAREMPRESA_POST_ENDPOINT } from '../connections/helpers/endpoints';
import {CrearEmpresaFormulario} from '../components/CrearEmpresaFormulario';

const CrearEmpresa= ()=> {

    const [errores, setErrores]= useState({});

    const crearEmpresa= async({nomEmpresa, nit, correo, telefono, nombreAsistente}) => {

       const error= {};
       setErrores(error);
       
       axios.post(CREAREMPRESA_POST_ENDPOINT, {nomEmpresa, nit, correo, telefono, nombreAsistente},
        {headers: { 'Accept': 'application/json', 'Content-Type': 'application/json'}}
            ).then(respuesta => {
                console.log(respuesta)
                alert("Empresa creada.")
            }).catch(err => {
                setErrores({ crear: err.respuesta.data.message })
            })
    }

    return (
        <Container className="mt-5 mb-3">
            <Row className="justify-content-center">
                <Col>
                    <h3 className="text-center text-uppercase fw-bold">Crear empresa</h3>
                    <Card.Body>
                        {errores.crear && <Alert variant="danger">{errores.crear}</Alert>}
                        
                        <CrearEmpresaFormulario errores={errores} callback={crearEmpresa}></CrearEmpresaFormulario>
                    </Card.Body>
                </Col>
            </Row>
        </Container>
    )
}

export {CrearEmpresa}