<div class="container">
	<form action="EventoServlet" method = "Post">
		<input type = "hidden" name = "cmd" value = "crear" />
		<table>
			<tr>
				<td> <label class="control-label" for="inputWarning">Nombre del evento </label></td>
				<td><input class="input-xlarge" type="text" placeholder="nombre" name = "txtNombre" /></td>
			</tr>
			<tr>
				<td>Descripci�n del evento :</td>
				<td>
					<textarea rows="3" name = "txtDescripcion"></textarea>
				</td>
			</tr>
			<tr>
				<td>Donde se efectuara el evento:</td>
				<td>
					<input type="text" name ="txtLugar" />
				</td>
			</tr>
			<tr>
				<td>Fecha del evento: (AA-MM-DD)</td>
				<td><input type="text" name ="txtFecha" /></td>
			</tr>
			<tr>
				<td>Cuales ser�n los premios del evento :</td>
				<td>
					<textarea rows="3" name ="txtPremios"></textarea>
				</td>
			</tr>
		</table>

		<div class="form-actions">
		  <button type="submit" class="btn btn-primary">Guardar</button>
		  <button type="button" class="btn" onclick="cancelar();">Cancelar</button>
		</div>
	</form>
</div>