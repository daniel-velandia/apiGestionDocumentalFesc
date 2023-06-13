import React, {useState} from "react";
import { Form, Button, Row, Col } from "react-bootstrap";

const CrearEmpresaFormulario=({errores, callback}) => {

        const [nomEmpresa, setNomEmpresa]= useState("");
        const [nit, setNit]= useState("");
        const [correo, setCorreo]= useState("");
        const [telefono, setTelefono]= useState("");
        const [nombreAsistente, setNombreAsistente]= useState("");

        const enviarEmpresa = (e) => {
            e.preventDefault();
            callback({nomEmpresa, nit, correo, telefono, nombreAsistente})
        }

        return (
            <Form onSubmit={enviarEmpresa}>
                <Row>
                    <Col md="6" xs="6">
                        <Form.Group className="mt-4 mb-4" controlId="nomEmpresa">
                            <Form.Label className="fs-5 fw-semibold">Nombre empresa</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Ingrese el nombre de la empresa"
                                value={nomEmpresa}
                                onChange={e=>setNomEmpresa(e.target.value)}
                                isInvalid={errores.nomEmpresa}
                            >
                            </Form.Control>

                            <Form.Control.Feedback type="invalid">
                                {errores.nomEmpresa}
                            </Form.Control.Feedback>
                        </Form.Group>

                        <Form.Group className="mt-4 mb-4" controlId="nit">
                            <Form.Label className="fs-5 fw-semibold">NIT empresa</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Ingrese el nit de la empresa"
                                value={nit}
                                onChange={e=>setNit(e.target.value)}
                                isInvalid={errores.nit}
                            >
                            </Form.Control>

                            <Form.Control.Feedback type="invalid">
                                {errores.nit}
                            </Form.Control.Feedback>
                        </Form.Group>

                        <Form.Group className="mt-4 mb-4" controlId="correo">
                            <Form.Label className="fs-5 fw-semibold">Correo</Form.Label>
                            <Form.Control
                                type="email"
                                placeholder="Ingrese el correo de la empresa"
                                value={correo}
                                onChange={e=>setCorreo(e.target.value)}
                                isInvalid={errores.correo}
                            >
                            </Form.Control>

                            <Form.Control.Feedback type="invalid">
                                {errores.correo}
                            </Form.Control.Feedback>
                        </Form.Group>
                    </Col>
                    <Col md="6" xs="6">
                        <Form.Group className="mt-4 mb-4" controlId="telefono">
                            <Form.Label className="fs-5 fw-semibold">Teléfono</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Ingrese el telefono"
                                value={telefono}
                                onChange={e=>setTelefono(e.target.value)}
                                isInvalid={errores.telefono}
                            >
                            </Form.Control>

                            <Form.Control.Feedback type="invalid">
                                {errores.telefono}
                            </Form.Control.Feedback>
                        </Form.Group>

                        <Form.Group className="mt-4 mb-4" controlId="nombreAsistente">
                            <Form.Label className="fs-5 fw-semibold">Nombre encargado</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Ingrese el nombre de la persona dirigida"
                                value={nombreAsistente}
                                onChange={e=>setNombreAsistente(e.target.value)}
                                isInvalid={errores.nombreAsistente}
                            >
                            </Form.Control>

                            <Form.Control.Feedback type="invalid">
                                {errores.nombreAsistente}
                            </Form.Control.Feedback>
                        </Form.Group>
                    </Col>
                </Row>
                <div className="text-center">
                    <Button type="submit" variant="danger" className="mt-4">
                        Crear empresa
                    </Button>
                </div>
            </Form>
        )
    }

export {CrearEmpresaFormulario}