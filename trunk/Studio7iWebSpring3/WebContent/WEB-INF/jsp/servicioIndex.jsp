	<%@include file="menu.jsp" %>
    <head>
      <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
  
   
    <script src="js/jquery-1.7.2.min.js"></script>
    
    
    <script type="text/javascript">
    
    
   
    	$(document).ready(function() {    	    	
						    			    	    	        		
    			$(".success").hide().fadeIn('slow').delay(1500).fadeOut('slow').css({"background-color": "#DFF2BF","color": "#4F8A10","border": "1px solid","font-family":"Arial, Helvetica, sans-serif","font-size":"13px"});
    	    			        			
  	});
    
    	
   
   
    
    function editar_servicio(servicio){
    	$('#mantenimiento').load('editar_servicio.html?metodo=editar&servicio=' + servicio );
    }
    
    function nuevo_servicio(){
    	$('#mantenimiento').load('nuevo_servicio.html');
    }
    function eliminar_servicio(sevicio){
    	if(confirm("Esta seguro de eliminar el servicio?")){
			alert("Se eliminó");
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
			<form class="form-search" name="frmServicios" action="buscar_reg.html" method="POST">
				<input type="hidden" name="metodo" id="metodo" value="filtrar" />
				<table>
					<tr>
						<td>Servicio :</td>
						<td><input type="text" name="buscar" id="buscar" /></td>
						<td><button class="btn" type="submit"><i class="icon-search"></i>&nbsp;&nbsp;Buscar</button></td>
						<td align="right" width="60%">
							<button class="btn btn-primary" type="button" onclick="nuevo_servicio()">Nuevo</button>
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
			<div class="success"> ${MENSAJE}</div>			
			<table class="table table-hover">
				<tr>
					<th>#</th>
					<th>Descripción</th>
					<th>Precio Hora</th>
					<th>Local</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach var="servicio" items="${LISTA}">
				   <tr>
						<td>${servicio.servicio_id}</td>
						<td>${servicio.descripcion}</td>
						<td>${servicio.precio_hora}</td>
						<td>${servicio.local.nombre}</td>
						
						<td>
							<a href="javascript:;" onclick="editar_servicio(${servicio.servicio_id});" title="editar" alt="editar"><i class="icon-edit"></i></a>
							<a href="javascript:;" onclick="eliminar_servicio(${servicio.servicio_id});" title="eliminar" alt="eliminar"><i class="icon-remove"></i></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="mantenimiento"></div>
	</div>
<%@include file="footer.jsp" %>