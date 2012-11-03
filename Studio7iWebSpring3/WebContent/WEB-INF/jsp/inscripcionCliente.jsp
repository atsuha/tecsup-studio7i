<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="menu.jsp" %>
		<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
		<script src="js/jquery-ui-1.8.22.custom.min.js" type="text/javascript"></script>
		<link rel="stylesheet" href="css/ui-lightness/jquery-ui-1.8.22.custom.css" type="text/css" media="all" />
		<script src="js/jquery.ui.datepicker-es.js" type="text/javascript"></script>
<script>
    $(function() {
    	 $( "#datepicker" ).datepicker({dateFormat: 'yy-mm-dd'});

    });
    </script>
		
<div class="container">
 <h1>Busqueda de Salas</h1>
      <p>Consultar las salas de ensayo que ofrece la empresa, así como sus características, <br> de manera que pueda decidir reservarlas.</p>

  


	<form action="inscripcion_cliente.html" method = "Post">
		<input type = "hidden" name = "metodo" value = "crear" />
		<table>
			<tr>
				<td>DNI</td>
				<td><input class="input-xlarge" type="text" placeholder="nombre" name="txtdni"></td>
			</tr>
			<tr>
				<td><label class="control-label" for="inputWarning">Nombres</label></td>
				<td><input class="input-xlarge" type="text"	placeholder="nombre" name="txtnombre" /></td>
			</tr>
			<tr>
				<td>Apellido Paterno :</td>
				<td><input type="text" name="txtpaterno"></td>
			</tr>
			<tr>
				<td>Apellido Materno:</td>
				<td><input type="text" name="txtmaterno" /></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="txtemail"></td>
			</tr>
			<tr>
				<td>Fecha de Nacimiento:</td>
				<td><input type="text" id="datepicker" name="txtfecha" /></td>
			</tr>

			<tr>
				<td>Usuario</td>
				<td><input type="text" name="txtusuario"></td>
			</tr>
			<tr>
				<td>Contraseña</td>
				<td><input type="text" name="txtpassword"></td>
			</tr>
		</table>

		<div class="form-actions">
		  <button type="submit" class="btn btn-primary">Guardar</button>
		  <button type="button" class="btn" onclick="cancelar();">Cancelar</button>
		</div>
	</form>
</div>

<%@include file="footer.jsp" %>