<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>



<div class="container">
		<form class="form-search" name="frmInscripcionServicio" action="nuevo_registro.html" method="POST">
		<input type="hidden" name="metodo" value="nuevo" />
	
		<table>
			
			<tr>

				<td> <label class="control-label" for="inputWarning">Servicio: </label></td>
				<td><input class="input-xlarge" type="text" placeholder="ingrese descripción" name="txtDescripcion" /></td>

			</tr>
			<tr>
				<td>Local :</td>
				<td>
					<select  class="span3" name="cboLocal">
					
						<c:forEach var="local" items="${map.LOCAL}">
							
								<option selected="selected" value="${local.local_id}">${local.nombre}</option>
						</c:forEach>
							<option>::Seleccione::</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Precio Hora :</td>

				<td><input class="input-mini" type="text" placeholder="0.00" name="txtPrecioHora"/></td>
			</tr>
			
		</table>
		<div class="form-actions">
		  <button type="submit" class="btn btn-primary">Guardar</button>
		  <button type="button" class="btn" onclick="cancelar();">Cancelar</button>
		</div>
	</form>
</div>