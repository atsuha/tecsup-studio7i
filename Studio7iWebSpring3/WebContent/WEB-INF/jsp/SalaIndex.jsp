 <%@page import="java.io.PrintWriter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@include file="menu.jsp" %>
    <head>
    <script src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
    	
    	
  	  
  	});
    
    function editar_sala(sala){
    	$('#mantenimiento').load('editar_sala.html?sala=' + sala);
    }
    function nueva_sala(){
    	$('#mantenimiento').load('nueva_sala.html');
    }
    function eliminar_sala(sala){
    	if(confirm("Esta seguro de eliminar la sala?")){
			$.ajax({
			       type: "GET",
			       url: "SalaServlet",
			       data: "metodo=eliminar&sala=" + sala+"",
			       success: function(){
			      		alert( "Se elimino su el registro");
			      		//location.href="";
			     }
			});
		}
		return false;
    }
    function cancelar(){
    	$('#mantenimiento').html('');
    }
    </script>
    </head>
	<div class="container" style="height: 700px;">
		<h1>Inscribir Salas</h1>
		<p>Consultar las salas por el nombre.</p>
		<div class="" >
			<form class="form-search" name="frmBuscar" action="SalaServlet" method="POST">
				<input type="hidden" name="metodo" id="metodo" value="buscarPorNombre" />
				<input type="hidden" name="pagina" id="pagina" value="SalaIndex.jsp" />
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
					<th>Codigo</th>
					<th>Nombre</th>
					<th>Capacidad</th>
					<th>Local</th>
					<th>&nbsp;</th>
				</tr>
				
				<c:forEach var="sala" items="${map.LISTA}">
				   <tr>
						<td>${sala.salaId}</td>
						<td>${sala.nombre}</td>
						<td>${sala.capacidad}</td>
						<td>${sala.local.nombre}</td>
						<td>
							<a href="javascript:;" onclick="editar_sala(${sala.salaId});" title="editar" alt="editar"><i class="icon-edit"></i></a>
							<a href="javascript:;" onclick="eliminar_sala(${sala.salaId});" title="eliminar" alt="eliminar"><i class="icon-remove"></i></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="mantenimiento"></div>
	</div>
<%-- <%@include file="footer.jsp" %> --%>