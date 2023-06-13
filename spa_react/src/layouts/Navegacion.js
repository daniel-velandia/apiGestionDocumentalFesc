import Navbar from 'react-bootstrap/Navbar';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { NavLink } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import React from 'react';
import { cerrarSesion } from '../connections/usuarioAcciones'

function Navegacion() {

    const conectado = useSelector(estado => estado.conectado);
    const usuario = useSelector(estado => estado.usuario);
    const dispatch = useDispatch();


    return (
        <Navbar bg="dark" variant='dark' expand="lg">
            <Container>
                <Navbar.Brand as={NavLink} to={"/datos"}>GESTION DOCUMENTAL</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        {conectado &&
                            <Nav.Link as={NavLink} to={"/datos"}>Consultar datos</Nav.Link>
                        }
                        {conectado &&
                            <Nav.Link as={NavLink} to={"/archivo"}>Crear archivo</Nav.Link>
                        }
                        {conectado &&
                            <Nav.Link as={NavLink} to={"/estudiante"}>Crear estudiante</Nav.Link>
                        }
                        {conectado &&
                            <Nav.Link as={NavLink} to={"/empresa"}>Crear empresa</Nav.Link>
                        }
                        {conectado &&
                            <Nav.Link as={NavLink} to={"/encargado"}>Crear encargado</Nav.Link>
                        }
                    </Nav>
                    <Nav className="ms-auto">
                        {!conectado ? (
                            <React.Fragment>
                                <Nav.Link as={NavLink} to={"/signup"}>Registrarse</Nav.Link>
                                <Nav.Link as={NavLink} to={"/signin"}>Iniciar sesion</Nav.Link>
                            </React.Fragment>
                        ):(
                        <NavDropdown title={usuario.sub} id="basic-nav-dropdown" variant="dark">
                            <NavDropdown.Item onClick={() => dispatch(cerrarSesion())} className='fw-semibold'>Cerrar sesión</NavDropdown.Item>
                        </NavDropdown>
                        )}
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}
export {Navegacion};