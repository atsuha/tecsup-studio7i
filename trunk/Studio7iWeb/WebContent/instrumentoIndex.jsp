	<%@include file="menu.jsp" %>
    <head>
      <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    <script src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
    	
    	
  	  
  	});
    
    function editar_instrumento(instrumento){
    	$('#mantenimiento').load('InstrumentoServlet?metodo=editar&instrumento=' + instrumento );
    }
    
    function nuevo_instrumento(){
    	$('#mantenimiento').load('InstrumentoServlet?metodo=nuevo');
    }
    function eliminar_instrumento(instrumento){
    	if(confirm("Esta seguro de eliminar el instrumento?")){
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
			<form class="form-search" name="frmInstrumentos" action="InstrumentoServlet" method="POST">
				<input type="hidden" name="metodo" id="metodo" value="filtrar" />
				<table>
					<tr>
						<td>Instrumento :</td>
						<td><input type="text" name="buscar" id="buscar" /></td>
						<td><button class="btn" type="submit"><i class="icon-search"></i>&nbsp;&nbsp;Buscar</button></td>
						<td align="right" width="60%">
							<button class="btn btn-primary" type="button" onclick="nuevo_instrumento()">Nuevo</button>
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
					<th>Tipo</th>
					<th>Caracteristicas</th>
					<th>Local</th>
					<th>Marca</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach var="instrumento" items="${LISTA}">
				   <tr>
						<td>${instrumento.instrumento_id}</td>
						<td>${instrumento.tipo}</td>
						<td>${instrumento.caracteristicas}</td>
						<td>${instrumento.local.nombre}</td>
						<td>${instrumento.marca}</td>
						
						<td>
							<a href="javascript:;" onclick="editar_instrumento" title="editar" alt="editar"><i class="icon-edit"></i></a>
							<a href="javascript:;" onclick="eliminar_instrumento" title="eliminar" alt="eliminar"><i class="icon-remove"></i></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="mantenimiento"></div>
	</div>
<%@include file="footer.jsp" %>