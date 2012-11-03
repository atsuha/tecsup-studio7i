<div class="container">


 <script>
    $(function() {
    	 $( "#datepicker" ).datepicker({dateFormat: 'yy-mm-dd'});

    });
    </script>
 


	<form action="insertarEvento.html" method = "get">
		<input type = "hidden" name = "metodo" value = "crear" />
		<table>
			<tr>
				<td> <label class="control-label" for="inputWarning">Nombre del evento </label></td>
				<td><input class="input-xlarge" type="text" placeholder="nombre" name = "txtNombre" /></td>
			</tr>
			<tr>
				<td>Descripción del evento :</td>
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
				<td>Fecha del evento: </td>
				<td><input type="text" id="datepicker" name = "txtFecha" /></td>
			</tr>
			<tr>
				<td>Cuales serán los premios del evento :</td>
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