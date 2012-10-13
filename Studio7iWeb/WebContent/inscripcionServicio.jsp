<%@page import="studio7i.negocio.GestionServicios;"%>



<div class="container">
	<form action="">
	
		<table>
			
			<tr>
				<td> <label class="control-label" for="inputWarning">Descripción Servicio: </label></td>
				<td><input class="input-xlarge" type="text" placeholder="nombre" /></td>
			</tr>
			<tr>
				<td>Seleccione Local :</td>
				<td>
					<select  class="span3">
						<option>::Seleccione::</option>
						<option>Santiago de Surco</option>
						<option>Miraflores</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Precio Hora :</td>
				<td><input class="input-mini" type="text" placeholder="0"/></td>
			</tr>
			
		</table>
		<div class="form-actions">
		  <button type="submit" class="btn btn-primary">Guardar</button>
		  <button type="button" class="btn" onclick="cancelar();">Cancelar</button>
		</div>
	</form>
</div>