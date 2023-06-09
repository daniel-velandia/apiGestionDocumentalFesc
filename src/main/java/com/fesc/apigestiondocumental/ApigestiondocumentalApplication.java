package com.fesc.apigestiondocumental;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fesc.apigestiondocumental.data.entidades.InfoArchivoEntity;
import com.fesc.apigestiondocumental.models.peticiones.ArchivoRequestModel;
import com.fesc.apigestiondocumental.shared.InfoArchivoDto;
import com.fesc.apigestiondocumental.utils.AppContexto;
import com.fesc.apigestiondocumental.utils.FiltroArchivo;
import com.fesc.apigestiondocumental.utils.Validaciones;

@SpringBootApplication
@EnableJpaAuditing
public class ApigestiondocumentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigestiondocumentalApplication.class, args);
		System.out.println("Api corriendo...");
	}

	@Bean
	public ModelMapper modelMapper() {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		modelMapper.typeMap(ArchivoRequestModel.class, InfoArchivoDto.class)
                .addMapping(ArchivoRequestModel::getNombre, InfoArchivoDto::setNombre)
                .addMapping(ArchivoRequestModel::getNumRadicado, InfoArchivoDto::setNumRadicado)
                .addMapping(ArchivoRequestModel::isTipoRadicado, InfoArchivoDto::setTipoRadicado)
                .addMapping(ArchivoRequestModel::getTipoDocumento, InfoArchivoDto::setTipoDocumento)
                .addMapping(ArchivoRequestModel::getAsunto, InfoArchivoDto::setAsunto)
                .addMapping(ArchivoRequestModel::getAnexos, InfoArchivoDto::setAnexos)
                .addMapping(ArchivoRequestModel::isReqRespuesta, InfoArchivoDto::setReqRespuesta)
                .addMapping(ArchivoRequestModel::getEstudiante, InfoArchivoDto::setEstudiante)
                .addMapping(ArchivoRequestModel::getEmpresa, InfoArchivoDto::setEmpresa)
                .addMapping(ArchivoRequestModel::getEncargado, InfoArchivoDto::setEncargado)
                .addMapping(ArchivoRequestModel::getEntrega, InfoArchivoDto::setEntrega)
                .addMapping(ArchivoRequestModel::isInformarEncargado, InfoArchivoDto::setInformarEncargado)
                .addMapping(src -> src.getDatos(), (dest, value) -> dest.getArchivoEntity().setDatos((byte[]) value));

		// Configuración personalizada para omitir el mapeo del atributo 'archivoEntity'
		PropertyMap<InfoArchivoEntity, InfoArchivoDto> propertyMap = new PropertyMap<>() {
			protected void configure() {
				skip().setArchivoEntity(null); // Omitir el mapeo del atributo 'archivoEntity'
			}
		};

		// Registra la configuración personalizada en el modelMapper
		modelMapper.addMappings(propertyMap);

		return modelMapper;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public Validaciones validaciones() {
		return new Validaciones();
	}

	@Bean
	public FiltroArchivo filtroArchivo() {
		return new FiltroArchivo();
	}

	@Bean
	public AppContexto appContexto() {
		return new AppContexto();
	}

}
