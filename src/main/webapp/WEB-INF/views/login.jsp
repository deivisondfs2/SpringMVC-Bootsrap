<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="head.jsp"></c:import>

Jsp response Servlet ${name}

<form class="form-horizontal" action="/login" method="POST">
	<p>
		<font color="red">${errorMessage}</font>
	</p>

	<div class="form-group">
		<label for="exampleInputUsuario">Usuário</label> 
		<input type="text" class="form-control" name="name" id="exampleInputUsuario" placeholder="Usuário">
	</div>
	
	<div class="form-group">
	    <label for="exampleInputPassword1">Password</label>
	    <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
	  </div>

	<button type="submit" class="btn btn-primary">Submit</button>
	

</form>

<c:import url="footer.jsp"></c:import>