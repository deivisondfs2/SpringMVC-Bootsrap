<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="head.jsp"></c:import>

	<h2>Ol� ${name}</h2>
	<br />
	<div>
		<a class="btn btn-success" href="/atividades/add">Nova atividade</a>
	</div>
	<br /> Segue sua lista de atividades:
	<br />

	<table class="table table-striped">
		<thead>
		<tr>
			<th>Codigo </th>
			<th>Usu�rio</th>
			<th>Descri��o</th>
			<th>Data</th>
			<th>Conclu�do?</th>
			<th>A��es</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${atividades}" var="atividade">
				<tr>
					<td>${atividade.id}</td>
					<td>${atividade.user}</td>
					<td>${atividade.descricao}</td>
					<td>${atividade.data}</td>
					<td>${atividade.done}</td>
					<td><a class="btn btn-success" href="/atividades/${atividade.id}/atualizar">Atualizar</a></td>
					<td><a class="btn btn-danger" href="/atividades/${atividade.id}/remover">Deletar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	${atividades}
	
<c:import url="footer.jsp"></c:import>
