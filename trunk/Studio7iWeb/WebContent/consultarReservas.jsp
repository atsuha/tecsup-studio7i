<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

      <h1>Consultar reservas</h1>
      <p>Consultar las reservas que los clientes realizan.</p>
    <form name="f1" action="reservaServlet" method="post">
    	<input type="hidden" name="metodo" value="buscarPorFechaYSala" >
    	<label>Fecha</label>
    	<input name="txtFecha" type="text" id="txtFecha" />

    	<label>Sala</label>
    	<input type="text" placeholder="Type something" name="txtSala">
    	<label>Sala lista</label>
					<select  class="span3" name="local">
						<c:forEach var="sala" items="${LISTA}">
								<option value="${sala.salaId}">${sala.nombre}</option>
						</c:forEach>
					</select>    	
    	
    	<button type="submit" class="btn">Buscar</button>
    	<table class="table table-condensed">
    		<tr>
				<td>Cliente</td>
				<td>Horario</td>
				<td>Costo</td>
				<td>Instrumentos</td>
				<td>Servicios</td>
			</tr>
		      <c:forEach var="reserva" items="${RESULTADO}">
        <tr>
          <td>${reserva.opersona.nombres}</td>
			<td>${reserva.hora_inicio} - ${reserva.hora_fin}</td>
			<td>${reserva.osala.costo}</td>
			<td>Instrumentos</td>
			<td>Servicios</td>
        </tr>
      </c:forEach>    	
		</table>
		
    </form>
    </div> <!-- /container -->
    
<%@include file="footer.jsp" %>