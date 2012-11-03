 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@include file="menu.jsp" %>
    <head>
    <script src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
    	
    	$(".ver_servicios").click(function(){
    		url = "rest/servicios?nombre=asd";
			$.getJSON(url, function(data) {
				var fila = '';
				$.each(data, function(i, item) {
					fila += '<tr>';
					fila += '<td><div align="center"><input type="checkbox" name="chkservicios['+i+']" id="chkservicios['+i+']" value="'+item.servicio_id+'" /></div></td>';
					fila += '<td>'+item.descripcion+'</td>';
					fila += '</tr>';
				});
				$("#servicios").show();
				$("#tableServicios").append(fila);
				//limipiar_tablaServicio();
				
			});
  		});
    	
    	function limipiar_tablaServicio(){
    		var n = $('#tableServicios >tbody >tr').length;
    		for(i=1;i<n;i++){
    			if(i >= 1){
    				$('#tableServicios >tbody >tr').css("display","none");
    			}
    		}
    	}
    	  	  
  	});
    </script>
    </head>
	<div class="container" style="height: 700px;">
		 <h1>Armar Salas</h1>
		 <p>Consultar las salas por el nombre.</p>
		<div class="" >
			<form class="form-search" name="frmBuscar" action="SalaServlet" method="POST">
				<input type="hidden" name="metodo" id="metodo" value="buscarPorNombre" />
				<input type="hidden" name="pagina" id="pagina" value="armarSala.jsp" />
				<table>
					<tr>
						<td>Nombre de la Sala :</td>
						<td><input type="text" name="txtSala" value="${TEXTO }" /></td>
						<td><button class="btn" type="submit"><i class="icon-search"></i>&nbsp;&nbsp;Buscar</button></td>
						<td align="right" width="60%">
							<button class="btn btn-primary" type="button" onclick="nueva_sala()">Nuevo</button>
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
					<th>id</th>
					<th>Nombre</th>
					<th>Capacidad</th>
					<th>Local</th>
					<th>Servicios</th>
					<th>Instrumentos</th>
				</tr>
				<c:forEach var="sala" items="${LISTA}">
				   <tr>
						<td>${sala.salaId}</td>
						<td>${sala.nombre}</td>
						<td>${sala.capacidad}</td>
						<td>${sala.local.nombre}</td>
						<td>
							<a href="javascript:;" class="ver_servicios" title="ver servicios" alt="ver servicios"><i class="icon-list"></i></a>
						</td>
						<td>
							<a href="javascript:;" class="ver_instrumentos" title="ver instrumentos" alt="ver instrumentos"><i class="icon-list"></i></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="servicios" style="display:none;">
			<table class="table table-hover" id="tableServicios">
				<tr>
					<th width="6%">Seleccionar</th>
					<th>Descripción</th>
				</tr>
			</table>
		</div>
		<div id="instrumentos" style="display:none;">
			
		</div>
	</div>
<%@include file="footer.jsp" %>