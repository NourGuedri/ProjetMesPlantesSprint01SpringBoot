package com.nour.plantes.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nour.plantes.dto.PlanteDTO;
import com.nour.plantes.entities.Plante;
import com.nour.plantes.service.PlanteService;
@RestController
@RequestMapping("/api")
@CrossOrigin

public class PlanteRestController {
	@Autowired
	PlanteService planteService;
	@RequestMapping(method = RequestMethod.GET)
	public List<PlanteDTO> getAllPlantes() {
	return planteService.getAllPlantes();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public PlanteDTO getPlanteById(@PathVariable("id") Long id) {
	return planteService.getPlante(id);
	 }	
	@RequestMapping(method = RequestMethod.POST)
	public PlanteDTO createPlante(@RequestBody PlanteDTO planteDTO) {
	return planteService.savePlante(planteDTO);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public PlanteDTO updatePlante(@RequestBody PlanteDTO planteDTO) {
	return planteService.updatePlante(planteDTO);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletePlante(@PathVariable("id") Long id)
	{
		planteService.deletePlanteById(id);
	}
	
	@RequestMapping(value="/plstype/{idType}",method = RequestMethod.GET)
	public List<Plante> getPlantesByTypeId(@PathVariable("idType") Long idType) {
	return planteService.findByTypeIdType(idType);
	}
	
	@RequestMapping(value="/plsByName/{nom}",method = RequestMethod.GET)
	public List<Plante> findByNomPlanteContains(@PathVariable("nom") String nom) {
	return planteService.findByNomPlanteContains(nom);
	}

	
	
	
	}