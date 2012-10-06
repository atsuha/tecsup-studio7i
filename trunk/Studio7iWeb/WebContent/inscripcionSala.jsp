<div class="container">
	<form action="">
		<table>
			<tr>
				<td> <label class="control-label" for="inputWarning">Nombre de la sala </label></td>
				<td><input class="input-xlarge" type="text" placeholder="nombre"/></td>
			</tr>
			<tr>
				<td>Seleccione Local :</td>
				<td>
					<select  class="span3">
						<option>::Seleccione::</option>
						<option>Local 1</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Capacidad Maxima :</td>
				<td><input class="input-mini" type="text" placeholder="0"/></td>
			</tr>
			<tr>
				<td>Caracteristicas :</td>
				<td>
					<textarea rows="3"></textarea>
				</td>
			</tr>
		</table>
		<div class="form-actions">
		  <button type="submit" class="btn btn-primary">Guardar</button>
		  <button type="button" class="btn" onclick="cancelar();">Cancelar</button>
		</div>
	</form>
</div>