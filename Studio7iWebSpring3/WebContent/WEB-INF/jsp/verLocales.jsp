<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="menu.jsp"%>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.8.22.custom.min.js" type="text/javascript"></script>
<link rel="stylesheet"
	href="css/ui-lightness/jquery-ui-1.8.22.custom.css" type="text/css"
	media="all" />
<script src="js/jquery.ui.datepicker-es.js" type="text/javascript"></script>
<script>
	$(document).ready(function() {

	});
</script>

<div class="container">
	<h1>Ver locales</h1>
	<p>Consultar los locales que tiene la empresa, así como sus
		características.</p>
	<form name="f1" action="buscarPorNombre.html" method="post">
		<label>Local</label>
		<!--  <select  class="span3" name="sala_id">
						<c:forEach var="sala" items="${LISTA}">
								<option value="${sala.salaId}">${sala.nombre}</option>
						</c:forEach>
					</select> -->
		<input name="nombre">
		<button type="submit" class="btn">Buscar</button>
		<br/>
		<table class="table table-condensed">
			<tr>
				<td></td>
				<td>Local</td>
				<td>Dirección</td>
				<td>Instrumentos</td>
				<td>Servicios</td>
				<td>Salas</td>
			</tr>
			<c:forEach var="local" items="${RESULTADO.locales}">
				<tr>
					<td>${local.local_id}</td>
					<td>${local.nombre}</td>
					<td>${local.direccion}</td>
					<c:forEach var="instrumento" items="${local.instrumentos}">
								
					</c:forEach>
					<td>${RESULTADO.instrumentos}</td>
					<td><a href="javascript:;" class="reservar">Ver</a></td>
					<td><a href="javascript:;" class="reservar">Reservar</a></td>
				</tr>
			</c:forEach>
		</table>

	</form>
</div>
<!-- /container -->



<%@include file="footer.jsp"%>
