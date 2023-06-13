import React, { useState } from 'react';
import axios from 'axios';
import { Form, Button, Row, Col, Container } from "react-bootstrap";

const ConsultarDatosFormulario = () => {
  const [entidad, setEntidad] = useState('');
  const [filtro, setFiltro] = useState('');
  const [identificacion, setIdentificacion] = useState('');
  const [fecha, setFecha] = useState('');
  const [datosObtenidos, setDatosObtenidos] = useState([]);

  const handleEntidadChange = (e) => {
    setEntidad(e.target.value);
  };

  const handleFiltroChange = (e) => {
    setFiltro(e.target.value);
  };

  const handleIdentificacionChange = (e) => {
    setIdentificacion(e.target.value);
  };

  const handleFechaChange = (e) => {
    setFecha(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      let endpoint = '';

      if (entidad === 'estudiante') {
        if (filtro === 'todos') {
          endpoint = `http://localhost:8080/usuario/misEstudiantes`;
        } else if (filtro === 'entrega') {
          endpoint = `http://localhost:8080/usuario/misArchivos?tipo_radicado=true`;
        } else if (filtro === 'respuesta') {
          endpoint = `http://localhost:8080/usuario/misArchivos?tipo_radicado=false`;
        }
      } else if (entidad === 'empresa') {
        if (filtro === 'todos') {
          endpoint = `http://localhost:8080/usuario/misEmpresas`;
        } else if (filtro === 'entrega') {
          endpoint = `http://localhost:8080/usuario/misArchivos?tipo_radicado=true`;
        } else if (filtro === 'respuesta') {
          endpoint = `http://localhost:8080/usuario/misArchivos?tipo_radicado=false`;
        }
      }

      if (identificacion) {
        endpoint += `&busqueda=${identificacion}`;
      }

      if (fecha) {
        endpoint += `&fecha=${fecha}`;
      }

      const response = await axios.get(endpoint);
      const data = response.data;

      // Aquí puedes realizar alguna acción con los datos obtenidos del servidor
      console.log('Datos obtenidos:', data);

      // Almacenar los datos obtenidos en el estado
      setDatosObtenidos(data);

      // Luego, puedes restablecer los valores del formulario
      setEntidad('');
      setFiltro('');
      setIdentificacion('');
      setFecha('');
    } catch (error) {
      // Manejo de errores
      console.error('Error al obtener los datos:', error);
    }
  };

  return (
    <Form onSubmit={handleSubmit}>
      <h3 className='text-center text-uppercase fw-bold mt-5'>Consultar datos</h3>
      <Container>
        <Row className='justify-content-center'>
            <Col md="6" xs="6">
                <Form.Group className="mt-4 mb-4" controlId="entidad">
                    <Form.Label className="fs-5 fw-semibold">Entidad</Form.Label>
                    <Form.Select
                        value={entidad}
                        onChange={handleEntidadChange}
                    >
                        <option value="estudiante">Estudiante</option>
                        <option value="empresa">Empresa</option>
                    </Form.Select>
                </Form.Group>

                <Form.Group className="mt-4 mb-4" controlId="filtro">
                    <Form.Label className="fs-5 fw-semibold">Filtrar por:</Form.Label>
                    <Form.Select

                        value={filtro}
                        onChange={handleFiltroChange}
                    >
                        <option value="todos">Todos los radicados</option>
                        <option value="entrega">Solo radicados de entrega</option>
                        <option value="respuesta">Solo radicados de respuesta</option>
                    </Form.Select>
                </Form.Group>
            </Col>
            <Col md="6">
                <Form.Group className="mt-4 mb-4" controlId="documento">
                    <Form.Label className="fs-5 fw-semibold">Documento</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Ingrese el documento"
                        value={identificacion}
                        onChange={handleIdentificacionChange}
                    >
                    </Form.Control>
                </Form.Group>

                <Form.Group className="mt-4 mb-4" controlId="fecha">
                    <Form.Label className="fs-5 fw-semibold">Fecha</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Ingrese la fecha en que se creó"
                        value={fecha}
                        onChange={handleFechaChange}
                    >
                    </Form.Control>

                </Form.Group>
            </Col>
        </Row>
      <div className="text-center">
          <Button type="submit" variant="danger" className="mt-4">
              Consultar datos
          </Button>
      </div>
      </Container>
      <div>
        {/* Mostrar los datos obtenidos en tarjetas */}
        {datosObtenidos.map((dato) => (
          <div key={dato.id} className="card">
            <div className="card-body">
              <h5 className="card-title">{dato.nombre}</h5>
              <p className="card-text">{dato.descripcion}</p>
            </div>
          </div>
        ))}
      </div>
    </Form>
  );
};

export default ConsultarDatosFormulario;