    <%@include file="menu.jsp" %>
    <head>
    <script src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
    	
    	
  	  
  	});
    
    function editar_sala(){
    	$('#mantenimiento').load('inscripcionSala.jsp');
    }
    function eliminar_sala(){
    	if(confirm("Esta seguro de eliminar la sala?")){
			alert("Elimino");
		}
		return false;
    }
    function cancelar(){
    	$('#mantenimiento').html('');
    }
    </script>
    </head>
	<div class="container">
		<form>
		
		</form>
		<div class="">
			<form class="form-search">
				<table>
					<tr>
						<td>Nombre de la Sala :</td>
						<td><input type="text" /></td>
						<td><button class="btn" type="button"><i class="icon-search"></i>&nbsp;&nbsp;Buscar</button></td>
						<td align="right" width="60%"><button class="btn btn-primary" type="button" onclick="editar_sala()">Nuevo</button></td>
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
					<th>Capacidad</th>
					<th>&nbsp;</th>
				</tr>
				<tr>
					<td>1</td>
					<td>Sala 1</td>
					<td>500 personas</td>
					<td>
						<a href="javascript:;" onclick="editar_sala();" title="editar" alt="editar"><i class="icon-edit"></i></a>
						<a href="javascript:;" onclick="eliminar_sala();" title="eliminar" alt="eliminar"><i class="icon-remove"></i></a>
					</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Sala 2</td>
					<td>500 personas</td>
					<td>
						<a href="javascript:;" onclick="editar_sala();" title="editar" alt="editar"><i class="icon-edit"></i></a>
						<a href="javascript:;" onclick="eliminar_sala();" title="eliminar" alt="eliminar"><i class="icon-remove"></i></a>
					</td>
				</tr>
				<tr>
					<td>3</td>
					<td>Sala 3</td>
					<td>500 personas</td>
					<td>
						<a href="javascript:;" onclick="editar_sala();" title="editar" alt="editar"><i class="icon-edit"></i></a>
						<a href="javascript:;" onclick="eliminar_sala();" title="eliminar" alt="eliminar"><i class="icon-remove"></i></a>
					</td>
				</tr>
			</table>
		</div>
		<div id="mantenimiento">
		
		</div>
	</div>
<%@include file="footer.jsp" %>