<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="menu.jsp" %>
    <head>
    <script src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
    	
    	
  	  
  	});
    
    function editar_evento(evento){
    	$('#mantenimiento').load('EventoServlet?metodo=editar&evento=' + evento);
    }
    
    
    function eliminar_evento(evento){
    	if(confirm("Esta seguro de eliminar el Evento?")){
    		$('#mantenimiento').load('EventoServlet?metodo=eliminar&evento=' + evento);
			alert("Elimino");
		}
		return false;
    }
    
    function cancelar(){
    	$('#mantenimiento').html('');
    }
    </script>
    </head>
	<div class="container" style="height: 400px;">
		<div class="" >
			<form class="form-search" name="frmBuscar" action="EventoServlet" method="POST">
				<input type = "hidden" name = "metodo" value = "buscarNombre" />

				<table>
					<tr>
						<td>Nombre del Evento :</td>
						<td><input type="text" name = "txtEvento"/></td>
						<td><button class="btn" type="submit"><i class="icon-search"></i>&nbsp;&nbsp;Buscar</button></td>
					</tr>
					<tr>
					<td><a href = "EventoIndex.jsp">Regresar</a></td>
					</tr>
				</table>
			

			

			
		<div class="">
			<table>
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
			
		<div>
			<table class="table table-hover">
		
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Descripción</th>
					<th>Lugar</th>
					<th>Fecha</th>
					<th>Premios</th>
					<th>&nbsp;</th>
				</tr>
						<c:forEach varStatus="i" var="eventos" items="${requestScope.resultado}">
						
				   <tr>
						<td>${i.count}</td>
						<td><c:out value ="${eventos.nombre}"></c:out></td>
						<td><c:out value ="${eventos.descripcion}"></c:out></td>
						<td><c:out value ="${eventos.lugar}"></c:out></td>
						<td><c:out value ="${eventos.fecha}"></c:out></td>
						<td><c:out value ="${eventos.premios}"></c:out></td>
						<td>
							<a href="javascript:;" onclick="editar_evento(${EVENTO.evento_id});" title="editar"><i class="icon-edit"></i></a>
							<a href="javascript:;" onclick="eliminar_evento(${EVENTO.evento_id});" title="eliminar"><i class="icon-remove"></i></a>
						</td>
					</tr>
						</c:forEach>

			</table>
		</div>
		</form>
		</div>
		

		<div id="mantenimiento"></div>
	</div>
	<br><br><br><br>
	<%@include file="footer.jsp" %>