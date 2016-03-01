package br.com.deivisondfs2.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.deivisondfs2.model.Atividade;
import br.com.deivisondfs2.service.AtividadeService;

@Controller
@RequestMapping(value = "/atividades")
@SessionAttributes("name")
public class AtividadeController {
	
	public final Logger LOGGER = Logger.getLogger(AtividadeController.class);
	
	Atividade atividade;
	
	@Autowired
	AtividadeService atividadeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listaAtividades(ModelMap map){
		
		map.addAttribute("atividades", atividadeService.getListaAtividades());
		return "lista-atividades";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showPageAddAtividade(ModelMap map){
		map.addAttribute("atividade", new Atividade());		
		return "atividade-add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addAtividade(ModelMap map, @RequestParam String user, @Valid Atividade atividade, BindingResult bindingResult){
		atividade = new Atividade(atividadeService.getListaAtividades().size() + 1, user, atividade.getDescricao(), new DateTime(), false);
		
		if (bindingResult.hasErrors()) {			
			return "atividade-add";
		}
		
		atividadeService.addListaAtividade(atividade);
		LOGGER.debug("Post add new atividade");
		map.clear();
		
		return "redirect:/atividades";
	}
	
	@RequestMapping(value = "/{id}/remover", method = RequestMethod.GET)
	public String removeAtividade(ModelMap map, @PathVariable("id") int id){
		
		if (ObjectUtils.notEqual(id, ObjectUtils.NULL)) {
			atividadeService.removerAtividade(id);			
		}
		
		map.clear();
		return "redirect:/atividades";
	}
	
}
