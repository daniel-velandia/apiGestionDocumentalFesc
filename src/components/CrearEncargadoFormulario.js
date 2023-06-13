import React, {useState} from "react";
import { Form, Button, Row, Col } from "react-bootstrap";


const CrearEncargadoFormulario= ({errores, callback}) => {

    const [documento, setDocumento]= useState("");
    const [nombre, setNombre]= useState("");
    const [apellido, setApellido]= useState("");
    const [correo, setCorreo]= useState("");
    const [telefono, setTelefono]= useState("");
    const [cargo, setCargo]= useState("");
    const [area, setArea]= useState("");

    const enviarEncargado = (e) => {
        e.preventDefault();
        callback({documento, nombre, apellido, correo, telefono, cargo, area})
    }

        return (
            <Form onSubmit={enviarEncargado}>
                <Row>
                    <Col md="4" xs="6">
                        <Form.Group className="mt-4 mb-4" controlId="documento">
                            <Form.Label className="fs-5 fw-semibold">Documento</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Ingrese el documento"
                                value={documento}
                                onChange={e=>setDocumento(e.target.value)}
                                isInvalid={errores.documento}
                            >
                            </Form.Control>

                            <Form.Control.Feedback type="invalid">
                                {errores.documento}
                            </Form.Control.Feedback>
                        </Form.Group>

                        <Form.Group className="mt-4 mb-4" controlId="nombre">
                            <Form.Label className="fs-5 fw-semibold">Nombres</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Ingrese los nombres"
                                value={nombre}
                                onChange={e=>setNombre(e.target.value)}
                                isInvalid={errores.nombre}
                            >
                            </Form.Control>

                            <Form.Control.Feedback type="invalid">
                                {errores.nombre}
                            </Form.Control.Feedback>
                        </Form.Group>

                        <Form.Group className="mt-4 mb-4" controlId="apellido">
                            <Form.Label className="fs-5 fw-semibold">Apellidos</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Ingrese los apellidos"
                                value={apellido}
                                onChange={e=>setApellido(e.target.value)}
                                isInvalid={errores.apellido}
                            >
                            </Form.Control>

                            <Form.Control.Feedback type="invalid">
                                {errores.apellido}
                            </Form.Control.Feedback>
                        </Form.Group>
                    </Col>
                    <Col md="4" xs="6">
                        <Form.Group className="mt-4 mb-4" controlId="correo">
                            <Form.Label className="fs-5 fw-semibold">Correo</Form.Label>
                            <Form.Control
                                type="email"
                                placeholder="Ingrese el correo"
                                value={correo}
                                onChange={e=>setCorreo(e.target.value)}
                                isInvalid={errores.correo}
                            >
                            </Form.Control>

                            <Form.Control.Feedback type="invalid">
                                {errores.correo}
                            </Form.Control.Feedback>
                        </Form.Group>

                        <Form.Group className="mt-4 mb-4" controlId="telefono">
                            <Form.Label className="fs-5 fw-semibold">Telefono</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Ingrese el teléfono"
                                value={telefono}
                                onChange={e=>setTelefono(e.target.value)}
                                isInvalid={errores.telefono}
                            >
                            </Form.Control>

                            <Form.Control.Feedback type="invalid">
                                {errores.telefono}
                            </Form.Control.Feedback>
                        </Form.Group>

                        <Form.Group className="mt-4 mb-4" controlId="cargo">
                            <Form.Label className="fs-5 fw-semibold">Cargo</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Ingrese el cargo de la persona"
                                value={cargo}
                                onChange={e=>setCargo(e.target.value)}
                                isInvalid={errores.cargo}
                            >
                            </Form.Control>

                            <Form.Control.Feedback type="invalid">
                                {errores.cargo}
                            </Form.Control.Feedback>
                        </Form.Group>
                    </Col>
                    <Col md="4" xs="6">
                        <Form.Group className="mt-4 mb-4" controlId="area">
                            <Form.Label className="fs-5 fw-semibold">Area</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Ingrese el area de la persona"
                                value={area}
                                onChange={e=>setArea(e.target.value)}
                                isInvalid={errores.area}
                            >
                            </Form.Control>

                            <Form.Control.Feedback type="invalid">
                                {errores.area}
                            </Form.Control.Feedback>
                        </Form.Group>
                    </Col>
                </Row>
                <div className="text-center">
                    <Button type="submit" variant="danger" className="mt-4">
                        Crear encargado
                    </Button>
                </div>
            </Form>
        )
    }

export {CrearEncargadoFormulario}