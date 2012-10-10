<%@include file="menu.jsp" %>
    <head>
    <script src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
    	
    	
  	  
  	});
    
    function editar_evento(evento){
    	$('#mantenimiento').load('inscripcionEvento.jsp');
    }
    function eliminar_sala(sala){
    	if(confirm("Esta seguro de eliminar el Evento?")){
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
				<input type="hidden" name="metodo" id="metodo" value="listar" />
				<table>
					<tr>
						<td>Nombre del Evento :</td>
						<td><input type="text" name = "txtEvento"/></td>
						<td><button class="btn" type="submit"><i class="icon-search"></i>&nbsp;&nbsp;Buscar</button></td>
						<td align="right" width="60%">
							<button class="btn btn-primary" type="button" onclick="editar_evento()">Nuevo</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
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
				<c:forEach var="evento" items="${lista}">
				   <tr>
						<td>1</td>
						<td>${evento.nombre}</td>
						<td>${evento.descripcion}</td>
						<td>${evento.lugar}</td>
						<td>${evento.fecha}</td>
						<td>${evento.premios}</td>
						<td>
							<a href="javascript:;" onclick="editar_evento(${evento.evento_id});" title="editar" alt="editar"><i class="icon-edit"></i></a>
							<a href="javascript:;" onclick="eliminar_evento(${evento.evento_id});" title="eliminar" alt="eliminar"><i class="icon-remove"></i></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="mantenimiento"></div>
	</div>
	<br><br><br><br>
	<%@include file="footer.jsp" %>