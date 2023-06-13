import { Table, Container, Row, Col } from 'react-bootstrap';

const Footer= ()=> {

    return (

        <footer className="footer-cliente text-white text-center text-lg-start mt-5">
            <Container className='p-4'>
                <Row className='mt-4'>
                    <Col lg="4" md="12" className='mb-5 mb-md-0'>
                        <h5 className='text-uppercase text-black mb-4'>Acerca de nosotros</h5>

                        <p className='text-black'>
                            Somos estudiantes de ingeniería de software del 5° semestre.
                        </p>

                        <p className='text-black'>
                        Este proyecto trata sobre un servicio web para la oficina de gestión documental de la FESC
                        para la asignatura arquitectura y diseño del software.
                        </p>

                    </Col>
                    <Col lg="4" md="6" className='mb-5 mb-md-0'>
                        <h5 class="text-uppercase text-black mb-4 pb-1">Contacto de los programadores</h5>
  
                        <ul class="fa-ul text-black">
                            <li class="mb-3">
                                <span class="fa-li"><i class="fas fa-home"></i></span><span class="ms-2 text-black">Colombia, N.S de Santander, Cúcuta</span>
                            </li>
                            <li class="mb-3">
                                <span class="fa-li"><i class="fas fa-envelope"></i></span><span class="ms-2 text-black">est_da_velandia@fesc.edu.co</span>
                            </li>
                            <li class="mb-3">
                                <span class="fa-li"><i class="fas fa-envelope"></i></span><span class="ms-2 text-black">est_ja.rodriguez@fesc.edu.co</span>
                            </li>
                            <li class="mb-3">
                                <span class="fa-li"><i class="fas fa-phone"></i></span><span class="ms-2 text-black">+ 57 313 8846250</span>
                            </li>
                            <li class="mb-3">
                                <span class="fa-li"><i class="fas fa-print"></i></span><span class="ms-2 text-black">+ 57 320 8802219</span>
                            </li>
                        </ul>
                    </Col>
                    <Col lg="4" md="6" className='mb-4 mb-md-0'>
                        <h5 className='text-uppercase text-black mb-4 text-center'>Desarrollado por:</h5>

                        <Table className='text-center text-white'>
                            <tbody className='font-weight-normal text-black'>
                                <tr>
                                    <td>Daniel Alejandro Velandia González</td>
                                </tr>
                                <tr>
                                    <td>Jhon Alexander Rodríguez Zapata</td>
                                </tr>
                            </tbody>
                        </Table>
                    </Col>
                </Row>
            </Container>
            <div className='text-center p-3 bg-dark'>
                © 2023 Copyright:
                <p className='text-white'>Todos los derechos reservados</p>
            </div>
        </footer>
    )
}

export {Footer}