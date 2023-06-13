import React, { useState } from 'react';
import { Container, Row, Col, Button } from "react-bootstrap";

const apiUrl= "http://localhost:8080/archivo";

const FileUploader = () => {
  const [nombre, setNombre] = useState('');
  const [numRadicado, setNumRadicado] = useState('');
  const [tipoRadicado, setTipoRadicado] = useState(false);
  const [tipoDocumento, setTipoDocumento] = useState('');
  const [asunto, setAsunto] = useState('');
  const [anexos, setAnexos] = useState('');
  const [reqRespuesta, setReqRespuesta] = useState(false);
  const [estudiante, setEstudiante] = useState('');
  const [empresa, setEmpresa] = useState('');
  const [encargado, setEncargado] = useState('');
  const [entrega, setEntrega] = useState('');
  const [informarEncargado, setInformarEncargado] = useState(false);
  const [file, setFile] = useState(null);

  const convertToByteArray = (file) => {
    return new Promise((resolve, reject) => {
      const reader = new FileReader();
      reader.onloadend = function() {
        const arrayBuffer = reader.result;
        const bytes = new Uint8Array(arrayBuffer);
        resolve(bytes);
      };
      reader.onerror = function() {
        reject(reader.error);
      };
      reader.readAsArrayBuffer(file);
    });
  }

  const handleInputChange = (event) => {
    const target = event.target;
    const value = target.type === 'checkbox' ? target.checked : target.value;
    const name = target.name;

    switch (name) {
      case 'nombre':
        setNombre(value);
        break;
      case 'numRadicado':
        setNumRadicado(value);
        break;
      case 'tipoRadicado':
        setTipoRadicado(value);
        break;
      case 'tipoDocumento':
        setTipoDocumento(value);
        break;
      case 'asunto':
        setAsunto(value);
        break;
      case 'anexos':
        setAnexos(value);
        break;
      case 'reqRespuesta':
        setReqRespuesta(value);
        break;
      case 'estudiante':
        setEstudiante(value);
        break;
      case 'empresa':
        setEmpresa(value);
        break;
      case 'encargado':
        setEncargado(value);
        break;
      case 'entrega':
        setEntrega(value);
        break;
      case 'informarEncargado':
        setInformarEncargado(value);
        break;
      default:
        break;
    }
  }

  const handleFileChange = (event) => {
    const file = event.target.files[0];
    setFile(file);
  }

  const handleSubmit = async (event) => {
    event.preventDefault();

    if (!file) {
      console.error('No se ha seleccionado ningún archivo.');
      return;
    }

    try {
      const bytes = await convertToByteArray(file);

      // Crear el objeto con los datos
      const dataObject = {
        nombre: nombre,
        datos: Array.from(bytes),
        numRadicado: numRadicado,
        tipoRadicado: tipoRadicado,
        tipoDocumento: tipoDocumento,
        asunto: asunto,
        anexos: anexos,
        reqRespuesta: reqRespuesta,
        estudiante: estudiante,
        empresa: empresa,
        encargado: encargado,
        entrega: entrega,
        informarEncargado: informarEncargado
      };

      // Realizar la solicitud con fetch
      const response = await fetch(apiUrl, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKaXJhaXlhIiwiZXhwIjoxNjg2NzAzNjUzfQ.C3Iu5mx2QYi3FJNRivOiCrZBJ0F8IPDWnhpxwRGdU3gZnz3800DaRPS8cOBLFrgOU0FRt3kpY-wK-8GXGBCSsQ'
        },
        body: JSON.stringify(dataObject)
      });

      // Manejar la respuesta de la solicitud
      if (response.ok) {
        // La solicitud fue exitosa
        console.log('Datos enviados correctamente.');
        alert("Archivo creado.")
      } else {
        // La solicitud falló
        console.error('Error al enviar los datos:', response.statusText);
      }
    } catch (error) {
      // Manejar errores
      console.error('Error al convertir el archivo a array de bytes:', error);
    }
  }

  return (
    <form onSubmit={handleSubmit}>
      <h3 className='text-center text-uppercase fw-bold mt-5'>Crear archivo</h3>
      <Container>
          <Row>
            <Col md="4" className='mt-4 mb-4'>
              <div className='mb-3'>
                <label htmlFor="nombre" className='form-label fs-5 fw-semibold'>Nombre:</label>
                <input type="text" id="nombre" name="nombre" className='form-control' placeholder="Nombre de archivo" value={nombre} onChange={handleInputChange} />
              </div>
              <div className='mb-3'>
                <label htmlFor="numRadicado" className='form-label fs-5 fw-semibold'>Numero radicado:</label>
                <input type="text" id="numRadicado" name="numRadicado" className='form-control' placeholder='Numero radicado' value={numRadicado} onChange={handleInputChange} />
              </div>
              <div className='mb-3'>
                <label htmlFor="encargado" className='form-label fs-5 fw-semibold'>Encargado:</label>
                <input type="text" id="encargado" className='form-control' name="encargado" placeholder='Encargado id' value={encargado} onChange={handleInputChange} />
              </div>
              <div className='mb-3'>
                <label htmlFor="tipoRadicado" className='form-label-check fw-semibold'>Tipo radicado:</label>
                <input type="checkbox" id="tipoRadicado" className='form-check-input ms-2' name="tipoRadicado" value={tipoRadicado} onChange={handleInputChange} />
              </div>
            </Col>
            <Col md="4" className='mt-4 mb-4'>
              <div className='mb-3'>
                <label htmlFor="tipoDocumento" className='form-label fs-5 fw-semibold'>Tipo documento:</label>
                <input type="text" id="tipoDocumento" className='form-control' name="tipoDocumento" placeholder='Tipo documento' value={tipoDocumento} onChange={handleInputChange} />
              </div>
              <div className='mb-3'>
                <label htmlFor="asunto" className='form-label fs-5 fw-semibold'>Asunto:</label>
                <input type="text" id="asunto" className='form-control' name="asunto" placeholder='Asunto' value={asunto} onChange={handleInputChange} />
              </div>
              <div className='mb-3'>
                <label htmlFor="anexos" className='form-label fs-5 fw-semibold'>Anexos:</label>
                <input type="text" id="anexos" className='form-control' name="anexos" placeholder='Anexos' value={anexos} onChange={handleInputChange} />
              </div>
              <div className='mb-3'>
                <label htmlFor="reqRespuesta" className='form-label-check fw-semibold'>Requiere respuesta:</label>
                <input type="checkbox" id="reqRespuesta"  className='form-check-input ms-2' name="reqRespuesta" value={reqRespuesta} onChange={handleInputChange} />
              </div>
            </Col>

            <Col md="4" className='mt-4 mb-4'>
              <div className='mb-3'>
                <label htmlFor="entrega" className='form-label fs-5 fw-semibold'>Entrega:</label>
                <input type="text" id="entrega" name="entrega" className='form-control' placeholder='Entrega id' value={entrega} onChange={handleInputChange} />
              </div>
              <div className='mb-3'>
                <label htmlFor="estudiante" className='form-label fs-5 fw-semibold'>Estudiante:</label>
                <input type="text" id="estudiante"  className='form-control' name="estudiante" placeholder='Estudiante id' value={estudiante} onChange={handleInputChange} />
              </div>
              <div className='mb-3'>
                <label htmlFor="empresa" className='form-label fs-5 fw-semibold'>Empresa:</label>
                <input type="text" id="empresa"  className='form-control' name="empresa" placeholder='Empresa id' value={empresa} onChange={handleInputChange} />
              </div>
              <div className='mb-3'>
                <label htmlFor="informarEncargado" className='form-label-check fw-semibold'>Informar encargado:</label>
                <input type="checkbox" id="informarEncargado" className='form-check-input ms-2' name="informarEncargado" value={informarEncargado} onChange={handleInputChange} />
              </div>
            </Col>

            <Row className='justify-content-center'>
              <Col md="6" className='mt-3 mb-3'>
                <div className='text-center'>
                  <label htmlFor="pdfFileInput" className='form-label fs-5 fw-semibold'>Seleccionar archivo PDF:</label>
                  <input type="file" id="pdfFileInput" className='form-control' onChange={handleFileChange} />
                </div>
              </Col> 
            </Row>         
            <div className="text-center">
              <Button type="submit" variant="danger" className="mt-4">
                Crear archivo
              </Button>
            </div>
            </Row>
      </Container>
      </form>
  );
}

export default FileUploader;
