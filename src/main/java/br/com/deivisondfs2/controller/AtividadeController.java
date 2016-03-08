package br.com.deivisondfs2.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.deivisondfs2.model.Atividade;
import br.com.deivisondfs2.service.AtividadeService;
import br.com.deivisondfs2.validation.AtividadeValidation;

@Controller
@RequestMapping(value = "/atividades")
@SessionAttributes("name")
public class AtividadeController {
	
	public final Logger LOGGER = Logger.getLogger(AtividadeController.class);
	
	Atividade atividade;
	
	@Autowired
	AtividadeService atividadeService;
	
	@Autowired
	AtividadeValidation atividadeValidation;
	
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
		
		SimpleDateFormat dateDisplayFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
        		dateDisplayFormat.getDateInstance(), false));
    }
	
	
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
		
		
		if (bindingResult.hasErrors()) {			
			return "atividade-add";
		}
		if (ObjectUtils.notEqual(atividade.getId(), 0)) {
			atividade = new Atividade(atividade.getId(), getLoggedInUserName(), atividade.getDescricao(), atividade.getData(), false);
			atividadeService.atualizarAtividade(atividade);
		}else{
			atividade = new Atividade(atividadeService.getListaAtividades().size() + 1, getLoggedInUserName(), atividade.getDescricao(), atividade.getData(), false);
			atividadeService.addListaAtividade(atividade);
		}
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
	
	@RequestMapping(value = "/{id}/atualizar", method = RequestMethod.GET)
	public String atualizarAtividade(ModelMap modelMap ,@PathVariable("id") int id){
		Atividade atividade = atividadeService.buscarAtividade(id);
		modelMap.addAttribute("atividade", atividade);		
		
		return "atividade-add";
	}
	
	
	private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
    }
	
	/*
	@ExceptionHandler
	private String exceptionEspecificaDaClasse(HttpServletRequest request, Exception exception){
		LOGGER.error("Request: " + request.getRequestURL() + " exception: " + exception.getMessage());
		return "error";
	}
	*/
	
}
