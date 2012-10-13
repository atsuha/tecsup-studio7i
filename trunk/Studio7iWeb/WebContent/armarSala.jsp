 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@include file="menu.jsp" %>
    <head>
    <script src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
    	
    	$("#ver_instrumentos_servicios").click(function(){
    		/*$.ajax({
			       type: "POST",
			       url: "InstrumentoServlet",
			       success: function(data){
			      		
			     }
			});*/
			$("#instrumentos_servicios").show();
    	});
    	  	  
  	});
    </script>
    </head>
	<div class="container" style="height: 700px;">
		 <h1>Armar Salas</h1>
		 <p>Consultar las salas por el nombre.</p>
		<div class="" >
			<form class="form-search" name="frmBuscar" action="SalaServlet" method="POST">
				<input type="hidden" name="metodo" id="metodo" value="buscarPorNombre" />
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
					<th>&nbsp;&nbsp</th>
				</tr>
				<c:forEach var="sala" items="${LISTA}">
				   <tr>
						<td>${sala.salaId}</td>
						<td>${sala.nombre}</td>
						<td>${sala.capacidad}</td>
						<td>
							<a href="javascript:;" onclick="editar_sala(${sala.salaId});" title="editar" alt="editar"><i class="icon-edit"></i></a>
							<a href="javascript:;" id="ver_instrumentos_servicios" title="ver instrumentos y servicios" alt="ver instrumentos y servicios"><i class="icon-list"></i></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="instrumentos_servicios" style="display:none;">
			<input type="checkbox" />HOLAAA
			
		</div>
	</div>
<%@include file="footer.jsp" %>