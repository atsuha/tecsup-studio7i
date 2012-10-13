<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">

	<form action="SalaServlet" method="POST">
		<input type="hidden" name="metodo" value="grabar" />
		<table>
			<tr>
				<td> <label class="control-label" for="inputWarning">Nombre de la sala </label></td>
				<td><input class="input-xlarge" type="text" placeholder="nombre" name="nombre" /></td>
			</tr>
			<tr>
				<td>Seleccione Local :</td>
				<td>
					<select  class="span3" name="local">
						<c:forEach var="local" items="${LOCAL}">
							<option value="${local.local_id}">${local.nombre}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Capacidad Maxima :</td>
				<td><input class="input-mini" type="text" name="capacidad" placeholder="0"/></td>
			</tr>
			<tr>
				<td>Caracteristicas :</td>
				<td>
					<textarea rows="3" name="caracteristicas"></textarea>
				</td>
			</tr>
			<tr>
				<td>Costo :</td>
				<td><input class="input-mini" type="text" name="costo" placeholder="0"/></td>
			</tr>
		</table>
		<div class="form-actions">
		  <button type="submit" class="btn btn-primary">Guardar</button>
		  <button type="button" class="btn" onclick="cancelar();">Cancelar</button>
		</div>
	</form>
</div>