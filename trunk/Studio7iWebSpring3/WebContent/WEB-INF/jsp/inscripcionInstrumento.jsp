<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">
	<form class="form-search" name="frmNuevoInstrumento" action="InstrumentoServlet" method="POST">
		<input type="hidden" name="metodo" value="nuevo" />
	
		<table>
			
			<tr>
				<td> <label class="control-label" for="inputWarning">Instrumento: </label></td>
				<td><input class="input-xlarge" type="text" placeholder="nombre" name="txtTipo"  /></td>
			</tr>
			<tr>
				<td> <label class="control-label" for="inputWarning">Caracteristicas: </label></td>
				<td><input class="input-xlarge" type="text" placeholder="nombre" name="txtCaracteristicas" /></td>
			</tr>
			<tr>
				<td> <label class="control-label" for="inputWarning">Marca: </label></td>
				<td><input class="input-xlarge" type="text" placeholder="nombre" name="txtMarca"  /></td>
			</tr>
			<tr>
				<td> <label class="control-label" for="inputWarning">Modelo: </label></td>
				<td><input class="input-xlarge" type="text" placeholder="nombre" name="txtModelo" /></td>
			</tr>
			<tr>
				<td>Local :</td>
				<td>
					<select  class="span3" name="cboLocal">
						<option>::Seleccione::</option>
						<c:forEach var="local" items="${LOCAL}">
							<c:if test="${local.local_id==INSTRUMENTO.local.local_id}">
								<option selected="selected" value="${local.local_id}">${local.nombre}</option>
							</c:if>
							<c:if test="${local.local_id!=INSTRUMENTO.local.local_id}">
								<option value="${local.local_id}">${local.nombre}</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Precio :</td>
				<td><input class="input-mini" type="text" placeholder="0" name="txtPrecio" /></td>
			</tr>
			
		</table>
		<div class="form-actions">
		  <button type="submit" class="btn btn-primary">Guardar</button>
		  <button type="button" class="btn" onclick="cancelar();">Cancelar</button>
		</div>
	</form>
</div>