<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>
<body>
    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">Studio7i</a>
          <div class="nav-collapse">
            <ul class="nav">
              <li class="dropdown active">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Administracion <b class="caret"></b></a>
	            <ul class="dropdown-menu">
	              <li><a href="SalaServlet?metodo=listar">Incribir sala</a></li>
	              <li><a href="#">Registra instrumentos</a></li>
	              <li><a href="SalaServlet?metodo=listar2">Armar Sala</a></li>
	              <li><a href="#">Registra servicios</a></li>
	              <li><a href="SalaServlet?metodo=listar3">Consultar Reservas</a></li>
	              <li><a href="#">Eventos musicales</a></li>
	            </ul>
	          </li>
              <li class="dropdown">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Cliente <b class="caret"></b></a>
	            <ul class="dropdown-menu">
	              <li><a href="#">Registrar Cliente</a></li>
	              <li><a href="#">Buscar Sala</a></li>
	              <li><a href="#">Inscripcion a Eventos</a></li>
	            </ul>
	          </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>