package br.com.deivisondfs2.model;

import java.util.Date;

import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Atividade {

	private int id;
	private String user;
	@Size(min = 10, message = "Minimo 10 caracteres.")
	private String descricao;
	private Date data;
	private boolean isDone;

	public Atividade() {
	
	}
	
	public Atividade(int id, String user, String descricao, Date data,
			boolean isDone) {

		this.id = id;
		this.user = user;
		this.descricao = descricao;
		this.data = data;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if (obj == this) {
			equals = true;
		} else if (obj instanceof Atividade) {
			Atividade object = (Atividade) obj;
			equals = new EqualsBuilder().append(id, object.id)						
					.isEquals();
		}
		return equals;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	@Override
	public String toString() {

		return String.format(
				"Atividade [id=%s, user=%s, desc=%s, data=%s, isDone=%s]", id,
				user, descricao, data, isDone);
	}

}
