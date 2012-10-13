<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">
	<form action="EventoServlet" method = "post">
		<input type = "hidden" name = "cmd" value = "editar" />
		<table>
			<tr>
				<td> <label class="control-label" for="inputWarning">Nombre del evento </label></td>
				<td><input class="input-xlarge" type="text" placeholder="nombre" name = "txtNombre" value="${EVENTO.nombre}"/></td>
			</tr>
			<tr>
				<td>Descripción del evento :</td>
				<td>
					<input type ="text" name ="txtDescripcion"  value="${EVENTO.descripcion}" />
				</td>
			</tr>
			<tr>
				<td>Donde se efectuara el evento:</td>
				<td>
					<input type="text" name ="txtLugar"  value="${EVENTO.lugar}"/>
				</td>
			</tr>
			<tr>
				<td>Fecha del evento: (AA-MM-DD)</td>
				<td><input type="text" name ="txtFecha"  value="${EVENTO.fecha}" /></td>
			</tr>
			<tr>
				<td>Cuales serán los premios del evento :</td>
				<td>
					<input type ="text" name ="txtPremios"  value="${EVENTO.premios}" />
				</td>
			</tr>
		</table>

		<div class="form-actions">
		  <button type="submit" class="btn btn-primary">Guardar</button>
		  <button type="button" class="btn" onclick="cancelar();">Cancelar</button>
		</div>
	</form>
</div>