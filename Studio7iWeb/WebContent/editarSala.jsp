<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">

	<form action="SalaServlet" method="POST">
		<input type="hidden" name="metodo" value="editar" />
		<table>
			<tr>
				<td> <label class="control-label" for="inputWarning">Nombre de la sala </label></td>
				<td><input class="input-xlarge" type="text" placeholder="nombre" value="${SALA.nombre}"/></td>
			</tr>
			<tr>
				<td>Seleccione Local :</td>
				<td>
					<select  class="span3">
						<c:forEach var="local" items="${LOCAL}">
							<c:if test="${local.local_id==SALA.local.local_id}">
								<option selected="selected" value="${local.local_id}">${local.nombre}</option>
							</c:if>
							<c:if test="${local.local_id!=SALA.local.local_id}">
								<option value="${local.local_id}">${local.nombre}</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Capacidad Maxima :</td>
				<td><input class="input-mini" type="text" placeholder="0" value="${SALA.capacidad}"/></td>
			</tr>
			<tr>
				<td>Caracteristicas :</td>
				<td>
					<textarea rows="3">${SALA.caracteristicas}</textarea>
				</td>
			</tr>
		</table>
		<div class="form-actions">
		  <button type="submit" class="btn btn-primary">Guardar</button>
		  <button type="button" class="btn" onclick="cancelar();">Cancelar</button>
		</div>
	</form>
</div>