<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="menu.jsp" %>
    <head>
    <script src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
    	    	
  	  
  	});
    
    function nuevo_evento(evento){
    	$('#mantenimiento').load('inscripcionEvento.jsp');
    }
    
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

			<form action="EventoServlet" method="POST">
			<input type = "hidden" name = "metodo" value = "buscarNombre" />
					<table>
						<tr>
							<td>Nombre del Evento :</td>
							<td><input type="text" name = "txtEvento"/></td>
						</tr>
						<tr>
							<td align = "left" >
							<button class="btn tbn-primary" type="submit"><i class="icon-search"></i>&nbsp;&nbsp;Buscar</button>
							</td>
							<td align="left" >
							<button class="btn btn-primary" type="button" onclick="nuevo_evento()">Nuevo</button>
							</td>
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
					<c:forEach varStatus="i" var="EVENTO" items="${requestScope.resultado}">
				   <tr>
				   
						<td>${i.count}</td>
						<td><c:out value="${EVENTO.nombre}"></c:out></td>
						<td><c:out value="${EVENTO.descripcion}"></c:out></td>
						<td><c:out value="${EVENTO.lugar}"></c:out></td>
						<td><c:out value="${EVENTO.fecha}"></c:out></td>
						<td><c:out value="${EVENTO.premios}"></c:out></td>
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