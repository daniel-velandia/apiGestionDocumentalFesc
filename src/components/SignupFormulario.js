import { useState } from "react";
import { Form, Button, Row, Col } from "react-bootstrap";

const SignupFormulario= ({errores, callback}) => {

    const [documento, setDocumento] = useState("");
    const [username, setUsername] = useState("");
    const [nombre, setNombre] = useState("");
    const [apellido, setApellido] = useState("");
    const [correo, setCorreo] = useState("");
    const [telefono, setTelefono] = useState("");
    const [cargo, setCargo] = useState("");
    const [password, setPassword] = useState("");

    const enviarFormulario = (e) => {
        e.preventDefault();
        callback({documento, username, nombre, apellido, correo, telefono, cargo, password});
    }

    return (
        <Form onSubmit={enviarFormulario}>
            <Row>
                <Col md="6" xs="6">
                    <Form.Group className="mt-3 mb-3" controlId="documento">
                        <Form.Label className="fs-5 fw-semibold">Documento</Form.Label>
                        <Form.Control
                        type="number"
                        placeholder="Ingrese su documento"
                        value={documento}
                        onChange={e=>setDocumento(e.target.value)}
                        isInvalid={errores.documento} />

                        <Form.Control.Feedback type="invalid">
                            {errores.documento}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group className="mt-3 mb-3" controlId="userName">
                        <Form.Label className="fs-5 fw-semibold">Usuario</Form.Label>
                        <Form.Control
                        type="text"
                        placeholder="Ingrese su nombre de usuario"
                        value={username}
                        onChange={e=>setUsername(e.target.value)}
                        isInvalid={errores.username} />

                        <Form.Control.Feedback type="invalid">
                            {errores.username}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group className="mt-3 mb-3" controlId="nombre">
                        <Form.Label className="fs-5 fw-semibold">Nombres</Form.Label>
                        <Form.Control
                        type="text"
                        placeholder="Ingrese sus nombres"
                        value={nombre}
                        onChange={e=>setNombre(e.target.value)}
                        isInvalid={errores.nombre} />

                        <Form.Control.Feedback type="invalid">
                            {errores.nombre}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group className="mt-3 mb-3" controlId="apellido">
                        <Form.Label className="fs-5 fw-semibold">Apellidos</Form.Label>
                        <Form.Control
                        type="text"
                        placeholder="Ingrese sus apellidos"
                        value={apellido}
                        onChange={e=>setApellido(e.target.value)}
                        isInvalid={errores.apellido} />

                        <Form.Control.Feedback type="invalid">
                            {errores.apellido}
                        </Form.Control.Feedback>
                    </Form.Group>
                </Col>
                <Col md="6" xs="6">
                    <Form.Group className="mt-3 mb-3" controlId="correo">
                        <Form.Label className="fs-5 fw-semibold">Correo</Form.Label>
                        <Form.Control
                        type="email"
                        placeholder="Ingrese su correo"
                        value={correo}
                        onChange={e=>setCorreo(e.target.value)}
                        isInvalid={errores.correo} />

                        <Form.Control.Feedback type="invalid">
                            {errores.correo}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group className="mt-3 mb-3" controlId="telefono">
                        <Form.Label className="fs-5 fw-semibold">Telefono</Form.Label>
                        <Form.Control
                        type="number"
                        placeholder="Ingrese su telefono"
                        value={telefono}
                        onChange={e=>setTelefono(e.target.value)}
                        isInvalid={errores.telefono} />

                        <Form.Control.Feedback type="invalid">
                            {errores.telefono}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group className="mt-3 mb-3" controlId="cargo">
                        <Form.Label className="fs-5 fw-semibold">Cargo</Form.Label>
                        <Form.Control
                        type="text"
                        placeholder="Ingrese su cargo"
                        value={cargo}
                        onChange={e=>setCargo(e.target.value)}
                        isInvalid={errores.cargo} />

                        <Form.Control.Feedback type="invalid">
                            {errores.cargo}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group className="mt-3 mb-3" controlId="password">
                        <Form.Label className="fs-5 fw-semibold">Contraseña</Form.Label>
                        <Form.Control
                        type="password"
                        placeholder="Ingrese su contraseña"
                        value={password}
                        onChange={e=>setPassword(e.target.value)}
                        isInvalid={errores.password} />

                        <Form.Control.Feedback type="invalid">
                            {errores.password}
                        </Form.Control.Feedback>
                    </Form.Group>
                </Col>
            </Row>
            <div className="text-center mt-3">
                <Button type="submit" variant="danger" className="mt-3">
                    Crear usuario
                </Button>
            </div>
        </Form>
    )
}

export {SignupFormulario}