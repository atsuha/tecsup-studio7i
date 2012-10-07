<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="menu.jsp" %>
    <div class="container">

      <h1>Consultar reservas</h1>
      <p>Consultar las reservas que los clientes realizan.</p>
    <form name="f1" action="reservaServlet" method="post">
    	<input type="hidden" name="metodo" value="listar" >
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
		      <c:forEach var="reserva" items="${RESULTADO}">
        <tr>
          <td>${reserva.reserva_id}</td>
			<td>Horario</td>
			<td>Costo</td>
			<td>Instrumentos</td>
			<td>Servicios</td>
        </tr>
      </c:forEach>    	
		</table>
		
    </form>
    </div> <!-- /container -->
    
<%@include file="footer.jsp" %>