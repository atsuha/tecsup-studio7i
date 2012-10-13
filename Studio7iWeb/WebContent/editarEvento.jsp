<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">
051151451456119
	<form action="EventoServlet" method = "post">
		<input type = "hidden" name = "metodo" value = "grabar" />
		<input type = "hidden" name = "evento" value = "${EVENTO.evento_id}" />
		
		
		<table>
			<tr>
				<td> <label class="control-label" for="inputWarning">Nombre del evento </label></td>
				<td><input class="input-xlarge" type="text" placeholder="nombre" name = "txtNombre" value="${EVENTO.nombre}"/></td>
			</tr>
			<tr>
				<td>Descripción del evento2525289849899 :</td>
				<td>
					<input type ="text" name ="txtDescripcion"  value="${EVENTO.descripcion}" />
				</td>
			</tr>
			<tr>
				<td>Donde se efectuara el event5116651146o:</td>
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