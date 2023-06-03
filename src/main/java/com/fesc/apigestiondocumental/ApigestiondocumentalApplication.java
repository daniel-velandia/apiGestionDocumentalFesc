package com.fesc.apigestiondocumental;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fesc.apigestiondocumental.utils.AppContexto;
import com.fesc.apigestiondocumental.utils.FiltroArchivo;
import com.fesc.apigestiondocumental.utils.MapperArchivo;
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

		return modelMapper;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public MapperArchivo mapperArchivo() {
		return new MapperArchivo();
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
