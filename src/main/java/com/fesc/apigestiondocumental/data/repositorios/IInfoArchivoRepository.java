package com.fesc.apigestiondocumental.data.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fesc.apigestiondocumental.data.entidades.InfoArchivoEntity;

public interface IInfoArchivoRepository extends CrudRepository<InfoArchivoEntity, Long>{
    
    public List<InfoArchivoEntity> getByEstudianteEntityDocumentoOrderByCreadoDesc(String documento);
    public List<InfoArchivoEntity> getByEstudianteEntityNombreAndEstudianteEntityApellidoOrderByCreadoDesc(String nombre, String apellido);
    
    public List<InfoArchivoEntity> getByEmpresaEntityNitOrderByCreadoDesc(String nit);
    public List<InfoArchivoEntity> getByEmpresaEntityNomEmpresaOrderByCreadoDesc(String nomEmpresa);

    public List<InfoArchivoEntity> getByUsuarioEntityUsernameOrderByCreadoDesc(String username);

    public InfoArchivoEntity findByIdInfoArchivo(String idInfoArchivo);

    public List<InfoArchivoEntity> findByNumRadicado(String numRadicado);
}
