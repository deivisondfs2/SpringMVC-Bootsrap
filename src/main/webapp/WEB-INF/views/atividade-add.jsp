<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="head.jsp"></c:import>

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
		
		<input type="submit" class="btn btn-sucess" value="Enviar"/>
		
		
	</form:form>

	
<c:import url="footer.jsp"></c:import>