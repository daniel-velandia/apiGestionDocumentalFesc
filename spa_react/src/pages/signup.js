import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import { SIGNUP_POST_ENDPOINT } from '../connections/helpers/endpoints.js';
import { Alert, Card, Col, Container, Row } from "react-bootstrap";
import { SignupFormulario } from '../components/SignupFormulario.js';

const Signup= ()=> {

    const [errores, setErrores]= useState({});
    const navegar = useNavigate();

    const registro = async ({documento, username, nombre, apellido, correo, telefono, cargo, password}) => {

        const error= {};
        setErrores(error);

        axios.post(SIGNUP_POST_ENDPOINT, {documento, username, nombre, apellido, correo, telefono, cargo, password},
                {headers: { 'Accept': 'application/json', 'Content-Type': 'application/json'}}
            ).then(respuesta => {
                console.log(respuesta)
                navegar("/signin")
            }).catch(err => {
                setErrores({ crear: err.respuesta.data.message })
            })
    }

    return (
        <Container className="mt-5 mb-3">
            <Row className="justify-content-center">
                <Col sm="12" md="8" xs="10">
                    <h3 className="text-center text-uppercase fw-bold">Registro de usuario</h3>
                    <Card.Body>
                        {errores.crear && <Alert variant="danger">{errores.crear}</Alert>}
                        <SignupFormulario errores={errores} callback={registro}></SignupFormulario>
                        <div className="mt-4 text-center">
                            <Link to={'/signin'}>¿Ya tienes una cuenta? Iniciar sesión aquí</Link>
                        </div>
                    </Card.Body>
                </Col>
            </Row>
        </Container>
    )
}

export {Signup}