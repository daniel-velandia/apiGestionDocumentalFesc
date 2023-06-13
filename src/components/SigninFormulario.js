import { useState } from "react";
import { Button, Form } from "react-bootstrap";

function SigninFormulario({errores, callback}) {

    const [username, setUsername]= useState("");
    const [password, setPassword]= useState("");

    const enviarFormulario = (e) => {
        e.preventDefault();
        callback({username, password});
    }

    return (
        <Form onSubmit={enviarFormulario}>
            <Form.Group className="my-3" controlId="userName">
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

            <Form.Group className="mb-3" controlId="password">
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

            <div class="text-center mt-3">
                <Button type="submit" variant="danger" className="mt-4">
                    Iniciar sesión
                </Button>
            </div>
        </Form>
    )
}

export {SigninFormulario}