package br.com.deivisondfs2.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.deivisondfs2.model.Atividade;
@Component
public class AtividadeValidation implements Validator {

	public boolean supports(Class<?> clazz) {
		return Atividade.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Atividade atividade = (Atividade) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user", "O campo usuário é obrigatório!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descricao", "O campo descrição é obrigatório! ");
		
		if (atividade.getDescricao().length() < 8) {
			errors.rejectValue("descricao", "", "O campo deve ter no min 8 caracteres!");
		}
	}

}
