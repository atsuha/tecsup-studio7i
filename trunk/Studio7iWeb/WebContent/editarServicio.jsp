<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">
	<form class="form-search" name="frmEditarServicio" action="ServicioServlet" method="POST">
		<input type="hidden" name="metodo" value="editar" />
		<input type="hidden" name="txtServicio" value="${SERVICIO.servicio_id}" />
		<table>
	
			
			<tr>
				<td> <label class="control-label" for="inputWarning">Servicio: </label></td>
				<td><input class="input-xlarge" type="text" placeholder="nombre" name="txtDescripcion"  value=${SERVICIO.descripcion }/></td>
			</tr>
			<tr>
				<td>Local :</td>
				<td>
					<select  class="span3" name="cboLocal">
						<option>::Seleccione::</option>
						<c:forEach var="local" items="${LOCAL}">
							<c:if test="${local.local_id==SERVICIO.local.local_id}">
								<option selected="selected" value="${local.local_id}">${local.nombre}</option>
							</c:if>
							<c:if test="${local.local_id!=SERVICIO.local.local_id}">
								<option value="${local.local_id}">${local.nombre}</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Precio Hora :</td>
				<td><input class="input-mini" type="text" placeholder="0" name="txtPrecioHora" value="${SERVICIO.precio_hora }"/></td>
			</tr>
			
		</table>
		<div class="form-actions">
		  <button type="submit" class="btn btn-primary">Guardar</button>
		  <button type="button" class="btn" onclick="cancelar();">Cancelar</button>
		</div>
	</form>
</div>