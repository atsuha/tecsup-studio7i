<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@include file="menu.jsp" %>
		<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
		<script src="js/jquery-ui-1.8.22.custom.min.js" type="text/javascript"></script>
		<link rel="stylesheet" href="css/ui-lightness/jquery-ui-1.8.22.custom.css" type="text/css" media="all" />
		<script src="js/jquery.ui.datepicker-es.js" type="text/javascript"></script>
  <script>
  $(document).ready(function() {
	$("#txtFecha").datepicker($.datepicker.regional['es']);  
    $("#txtFecha").datepicker({dateFormat: 'yy-mm-dd'});
  });
  </script>


<div class="container">
		<form class="form-search" name="frmreservasala" action="reservaServlet" method="POST">
		<input type="hidden" name="metodo" value="nuevo" />

		<table>

			<tr>
				<td>Sala:</td>

				<td><select class="span3" name="cboSala" style="width: 232px; ">

						<c:forEach var="sala" items="${SALA}">

							<option selected="selected" value="${sala.sala_id}">${sala.nombre}</option>
						</c:forEach>
						<option>::Seleccione::</option>
				</select></td>

			</tr>
			<tr>

				<td><label class="control-label" for="inputWarning">Fecha:
				</label></td>

				<td style="width: 240px; "><input name="txtFecha" type="text" id="txtFecha"
					value="${fecha}" /></td>


			</tr>

			<tr>

				<td><label class="control-label" for="inputWarning">H.
						Inicio: </label></td>

				<td><input class="input-xlarge" type="text"
					placeholder="ingrese hora de inicio" name="txtInicio" style="width: 67px; "/></td>
				<td><label class="control-label" for="inputWarning">Hasta:</label></td>
				<td><input class="input-xlarge" type="text"
					placeholder="ingrese hora final" name="txtFin" style="width: 91px; "></td>
			</tr>


		
		</table>
		<div class="form-actions">
		  <button type="submit" class="btn btn-primary">Guardar</button>
		  <button type="button" class="btn" onclick="cancelar();">Cancelar</button>
		</div>
	</form>
</div>