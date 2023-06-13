import { useEffect, useState } from "react";
import { Alert, Card, Col, Container, Row } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { SigninFormulario } from "../components/SigninFormulario.js";
import { autenticacion } from "../connections/usuarioAcciones.js";

function Signin() {

    const [errores, setErrores]= useState({});
    const conectado= useSelector(estado => estado.conectado);
    const navegar= useNavigate();
    const enviarAccion= useDispatch();

    useEffect(() => {
        if(conectado) {
            navegar("/");
        }
    });

    const login= ({username, password}) => {

        const error={};
        setErrores(error);

        enviarAccion(autenticacion({username, password}))
        .then(respuesta=> {
            navegar("/");
        })
        .catch(err => {
            setErrores({ ingresar: "No se puede iniciar sesión con esas credenciales. Inténtelo otra vez." });
        });

    }

    return (
        <Container className="mt-5 mb-3">
            <Row className="justify-content-center">
                <Col sm="6" md="5" xs="8" className="mi-contenedor border border-1 rounded-4">
                    <h3 className="text-center text-uppercase fw-bold mt-5">Iniciar sesión</h3>
                    <Card.Body className="ms-3 mx-3">
                        {errores.ingresar && <Alert variant="danger">{errores.ingresar}</Alert>}
                        <SigninFormulario errores={errores} callback={login}></SigninFormulario>
                        <div className="mt-5 text-center mb-4">
                            <Link to={'/signup'}>¿No tienes una cuenta? Regístrate aquí.</Link>
                        </div>
                    </Card.Body>
                </Col>
            </Row>
        </Container>
    )
}

export {Signin}