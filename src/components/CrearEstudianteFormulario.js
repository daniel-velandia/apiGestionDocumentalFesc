import React, {useState} from "react";
import { Form, Button, Row, Col } from "react-bootstrap";

const CrearEstudianteFormulario= ({errores, callback}) => {

    const [documento, setDocumento]= useState("");
    const [nombre, setNombre]= useState("");
    const [apellido, setApellido]= useState("");
    const [correo, setCorreo]= useState("");
    const [telefono, setTelefono]= useState("");
    const [carrera, setCarrera]= useState("");
    const [semestre, setSemestre]= useState("");

    const enviar = (e) => {
        e.preventDefault();
        callback({documento, nombre, apellido, correo, telefono, carrera, semestre});
    }

        return (
            <Form onSubmit={enviar}>
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
                                required
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
                                required
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
                                required
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
                                required
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
                                required
                            >
                            </Form.Control>

                            <Form.Control.Feedback type="invalid">
                                {errores.telefono}
                            </Form.Control.Feedback>
                        </Form.Group>

                        <Form.Group className="mt-4 mb-4" controlId="carrera">
                            <Form.Label className="fs-5 fw-semibold">Carrera</Form.Label>
                            <Form.Select
                                as="select"
                                type="select"
                                value={carrera}
                                onChange={e=>setCarrera(e.target.value)}
                                required
                            >
                                <option value="">Seleccione</option>
                                <option value="1">Diseño grafico</option>
                                <option value="2">Ingenieria de software</option>
                                <option value="3">Administracion y diseño de modas</option>
                                <option value="4">Administracion turistica y hotelera</option>
                                <option value="5">Administracion financiera</option>
                                <option value="6">Logistica empresarial</option>
                                <option value="7">Administracion de negocios internacionales</option>
                            </Form.Select>

                            <Form.Control.Feedback type="invalid">
                                {errores.carrera}
                            </Form.Control.Feedback>
                        </Form.Group>
                    </Col>
                    <Col md="4" xs="6">
                        <Form.Group className="mt-4 mb-4" controlId="semestre">
                            <Form.Label className="fs-5 fw-semibold">Semestre</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Ingrese el semestre"
                                value={semestre}
                                onChange={e=>setSemestre(e.target.value)}
                                isInvalid={errores.semestre}
                                required
                            >
                            </Form.Control>

                            <Form.Control.Feedback type="invalid">
                                {errores.semestre}
                            </Form.Control.Feedback>
                        </Form.Group>
                    </Col>
                </Row>
                <div className="text-center">
                    <Button type="submit" variant="danger" className="mt-4">
                        Crear estudiante
                    </Button>
                </div>
            </Form>
        )
    }

export {CrearEstudianteFormulario}