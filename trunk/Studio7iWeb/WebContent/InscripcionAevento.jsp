<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="menu.jsp" %>
    <head>
    <!-- para datepicker -->
    <script src="js/jquery-1.7.2.min.js"></script>
       <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
    <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css" />
   

    
    <script type="text/javascript">
  
    function inscripcion_Cliente(evento){
    	$('#mantenimiento').load('InscripcionServlet?metodo=mostrar&evento=' + evento);
    	
    }
    
    function cancelar(){
    	$('#mantenimiento').html('');
    }
    </script>
    </head>
	<div class="container" style="height: 400px;">
		<div class="" >

			<h1>Inscripcion a Eventos</h1>
   			<p>Encuentre los eventos de su preferencia e inscriba a su banda cuanto antes!!.</p>
			<form action="InscripcionServlet" method="POST">
			<input type = "hidden" name = "metodo" value = "buscarNombre" />
					<table align = "right">
						<tr>
							<td >Evento a inscribirse :</td>
							<td><input type="text" name = "txtEvento"/></td>
						</tr>
						<tr>
							<td></td>
							<td align = "right" >
							<button class="btn tbn-primary" type="submit"><i class="icon-search"></i>&nbsp;&nbsp;Buscar</button>
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
					<th>¿Insripción?</th>
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
							<a href="javascript:;" onclick="inscripcion_Cliente(${EVENTO.evento_id});" title="inscripcion"><i class="icon-edit"></i></a>
														
						</td>
					</tr>
			</c:forEach>
			</table>
		</div>
		
	</form>	
	<br><br>
	<h3>${mensaje}</h3>	
	</div>
		<div id="mantenimiento"></div>
	</div>
	
	<br><br><br><br>
	<table>
	
	<tr align="right">
	<%@include file="footer.jsp" %>
	</tr>
	</table>