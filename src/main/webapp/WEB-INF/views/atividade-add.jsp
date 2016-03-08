<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="head.jspf"  %>

	<h2>Adicionando nova atividade</h2>

	<form:form action="/atividades/add" method="POST" modelAttribute="atividade">
		<p><font color="red">${errorMessage}</font></p>
		
		<form:input type="hidden" path="id"></form:input>
		<form:input type="hidden" value="${name}" path="user"></form:input>
				
		<div class="form-group">
			<form:label path="descricao" for="exampleInputUsuario">Descrição</form:label> 
			<form:textarea class="form-control" rows="3" path="descricao" required="required"></form:textarea>
			<form:errors path="descricao" class="text-warning"></form:errors>
		</div>
		
		<div class="form-group">
			<form:label path="data" for="exampleInputUsuario">Data</form:label> 
			<form:input class="form-control" rows="3" path="data" required="required"></form:input>
			<form:errors path="data" class="text-warning"></form:errors>
		</div>
		
		<input type="submit" class="btn btn-sucess" value="Enviar"/>
		
		
	</form:form>

	
<%@ include file="footer.jspf" %>