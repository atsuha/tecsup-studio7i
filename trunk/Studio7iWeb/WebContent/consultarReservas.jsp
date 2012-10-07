<%@include file="menu.jsp" %>
    <div class="container">

      <h1>Consultar reservas</h1>
      <p>Consultar las reservas que los clientes realizan.</p>
    <form name="f1" action="SalaServlet" method="post">
    	<input type="hidden" name="metodo" value="buscarPorNombre" >
    	<label>Fecha</label>
    	<input type="text" placeholder="Type something" name="txtFecha">
    	<label>Sala</label>
    	<input type="text" placeholder="Type something" name="txtSala">
    	<button type="submit" class="btn">Buscar</button>
    	<table class="table table-condensed">
    		<tr>
				<td>Cliente</td>
				<td>Horario</td>
				<td>Costo</td>
				<td>Instrumentos</td>
				<td>Servicios</td>
			</tr>
		      <c:forEach var="sala" items="${RESULTADO}">
        <tr>
          <td>${sala.nombre}</td>
			<td>Local</td>
			<td>Capacidad</td>
			<td>Instrumentos</td>
			<td>Servicios</td>
        </tr>
      </c:forEach>    	
		</table>
		
    </form>
    </div> <!-- /container -->
    
<%@include file="footer.jsp" %>