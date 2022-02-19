package com.ibm.academia.respi.banco.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.respi.banco.excepciones.NotFoundException;
import com.ibm.academia.respi.banco.modelo.dto.TarjetaDTO;
import com.ibm.academia.respi.banco.modelo.entidades.Tarjeta;
import com.ibm.academia.respi.banco.modelo.mapper.TarjetaMapper;
import com.ibm.academia.respi.banco.servicios.TarjetaDAO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/restapi")
@Api(value = "Metodos relacionados con Tarjetas", tags = "Metodos sobre Tarjetas")
public class TarjetaController 
{
	private final static Logger logger = LoggerFactory.getLogger(TarjetaController.class);
	
	@Autowired
	private TarjetaDAO tarjetaDao;
	
	/**
	 * Endpoint para consultar todos los planes de tarjetas
	 * @return Retorna una lista de carreras.
	 * @author NDSC - 14-02-2022
	 */
	@ApiOperation(value = "Consultar todas las Tarjetas")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Endpoint ejecutado satisfactoriamente"),
		@ApiResponse(code = 404, message = "No hay elementos en la base de datos")
	})
	@GetMapping("/Tarjetas/lista")
	public List<Tarjeta> listarTodas()
	{
		List<Tarjeta> tarjetas = (List<Tarjeta>) tarjetaDao.buscarTodos();
		return tarjetas;
	}
	
	/**
	 * Endpoint para consultar una carrera por id
	 * @param carreraId Parámetro de búsqueda de la carrera
	 * @return Retorna un objeto de tipo carrera
	 * @NotFoundException En caso de que falle buscando la carrera
	 * @author NDSC - 14-02-2022
	 */
	@GetMapping("/tarjeta/taetaId/{tarjetaId}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long tarjetaId)
	{
		Optional<Tarjeta> oTarjeta = tarjetaDao.buscarPorId(tarjetaId);
		
		if(!oTarjeta.isPresent())
			throw new NotFoundException(String.format("El plan de tarjetas con id: %d no existe", tarjetaId));
		
		return new ResponseEntity<Tarjeta>(oTarjeta.get(), HttpStatus.OK);	
	}
	
	@PostMapping("/tarjeta")
	public ResponseEntity<?> guardar(@Valid @RequestBody Tarjeta tarjeta, BindingResult result)
	{
		Map<String, Object> validaciones = new HashMap<String, Object>();
		if(result.hasErrors())
		{
			List<String> listaErrores = result.getFieldErrors()
					.stream()
					.map(errores -> "Campo: '" + errores.getField() + "' " + errores.getDefaultMessage())
					.collect(Collectors.toList());
			validaciones.put("Lista Errores", listaErrores);
			return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
		}
		
		Tarjeta tarjetaGuardada = tarjetaDao.guardar(tarjeta);
		return new ResponseEntity<Tarjeta>(tarjetaGuardada, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/tarjeta/eliminar/tarjetaId/{tarjetaId}")
	public ResponseEntity<?> eliminar(@PathVariable Long tarjetaId)
	{
		Optional<Tarjeta> oTarjeta = tarjetaDao.buscarPorId(tarjetaId);
		
		if(!oTarjeta.isPresent())
			throw new NotFoundException(String.format("El plan de tarjeta con id: %d no existe", tarjetaId));
		
		tarjetaDao.eliminarPorId(tarjetaId);
		return new ResponseEntity<>("El plan de tarjeta con id: " + tarjetaId + " fue eliminada", HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/tarjeta/actualizar/tarjetaId/{tarjetaId}")
	public ResponseEntity<?> actualizar(@PathVariable Long tarjetaId, @Valid @RequestBody Tarjeta tarjeta, BindingResult result)
	{
		Map<String, Object> validaciones = new HashMap<String, Object>();
		if(result.hasErrors())
		{
			List<String> listaErrores = result.getFieldErrors()
					.stream()
					.map(errores -> "Campo: '" + errores.getField() + "' " + errores.getDefaultMessage())
					.collect(Collectors.toList());
			validaciones.put("Lista Errores", listaErrores);
			return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
		}
		
		Tarjeta tarjetaActualizada = null;
		
		try
		{
			tarjetaActualizada = tarjetaDao.actualizar(tarjetaId, tarjeta);
		}
		catch (Exception e) 
		{
			logger.info(e.getMessage());
			throw e;
		}
		
		return new ResponseEntity<Tarjeta>(tarjetaActualizada, HttpStatus.OK);
	}
	
	/**
	 * Endpoint para consultar todas los planes de tarjeta mediante un DTO
	 * @return Retorna un objeto de tipo tarjetaDTO
	 * @NotFoundException En caso de que no existan valores en la BD
	 * @author 16-02-2022
	 */
	@GetMapping("/tarjetas/lista/dto")
	public ResponseEntity<?> consultarTodasCarreras()
	{
		List<Tarjeta> tarjetas = (List<Tarjeta>) tarjetaDao.buscarTodos();
		
		if(tarjetas.isEmpty())
			throw new NotFoundException("No existen ese plan de tarjetas en la BD.");
		
		List<TarjetaDTO> listaTarjetas = tarjetas
				.stream()
				.map(TarjetaMapper::mapTarjeta)
				.collect(Collectors.toList());
		return new ResponseEntity<List<TarjetaDTO>>(listaTarjetas, HttpStatus.OK);
	}
}