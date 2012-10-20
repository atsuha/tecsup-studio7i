<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="menu.jsp" %>
		<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
		<script src="js/jquery-ui-1.8.22.custom.min.js" type="text/javascript"></script>
		<link rel="stylesheet" href="css/ui-lightness/jquery-ui-1.8.22.custom.css" type="text/css" media="all" />
		<script src="js/jquery.ui.datepicker-es.js" type="text/javascript"></script>
  <script>
  $(document).ready(function() {
    
  });
  </script>

    <div class="container">
      <h1>Busqueda de Salas</h1>
      <p>Consultar las salas de ensayo que ofrece la empresa, así como sus características, <br> de manera que pueda decidir reservarlas.</p>
    <form name="f1" action="SalaServlet" method="post">
    	<input type="hidden" name="metodo" value="buscarPorNombre" >
    	<label>Sala</label>
    	<input type="text" placeholder="Type something" name="txtSala">
    	<button type="submit" class="btn">Buscar</button>
    	<table class="table table-condensed">
    		<tr>
				<td>Nombre</td>
				<td>Local</td>
				<td>Capacidad</td>
				<td>Instrumentos</td>
				<td>Servicios</td>
				<td>Reservar</td>
			</tr>
		      <c:forEach var="sala" items="${RESULTADO}">
        <tr>
          <td>${sala.nombre}</td>
			<td>Local</td>
			<td>Capacidad</td>
			<td>Instrumentos</td>
			<td><a href="javascript:;" class="reservar" >Reservar</a></td>
        </tr>
      </c:forEach>    	
		</table>
		
    </form>
    </div> <!-- /container -->
    


<%@include file="footer.jsp" %>
