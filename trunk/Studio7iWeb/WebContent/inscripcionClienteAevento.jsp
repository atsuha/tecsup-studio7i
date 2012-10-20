<div class="container">


 <script>
    $(function() {
    	 $( "#datepicker" ).datepicker({dateFormat: 'yy-mm-dd'});

    });
    </script>
 

	<form action="InscripcionServlet" method = "Post">
		<input type = "hidden" name = "metodo" value = "inscribir"  />
		<input type="hidden" name = "evento" value="${EVENTO.evento_id}" />
	
		<table>
			<tr>
				<td>Fecha de inscripción AA-MM-DD:</td>
				<td>
						<input type="text" id="datepicker" name = "txtFecha" />
				</td>
			</tr>	
						<tr>
				<td>Presentación para su banda:</td>
				<td>
					<textarea rows="3" name = "txtPresentacion"></textarea>
				</td>
			</tr>	
		</table>

		<div class="form-actions">
		  <button type="submit" class="btn btn-primary">Guardar</button>
		  <button type="button" class="btn" onclick="cancelar();">Cancelar</button>
		</div>
	</form>
	
	
	
</div>