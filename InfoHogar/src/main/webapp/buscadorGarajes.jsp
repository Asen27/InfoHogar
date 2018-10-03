<%@include file="includes/header.jsp"%>

<title>Buscador de garajes</title>
</head>

<body>

<h1> ¿Cuáles son sus criterios?</h1>

<form id="formulario5" action="controladorBuscadorSecundario" method="post">

<div>
<input type="hidden" name="latitud" id="latitud" value="${latitud}" >
</div>

<div>
<input type="hidden" name="longitud" id="longitud" value="${longitud}" >
</div>

<div>
<input type="hidden" name="latitudPuntoMasSudoeste" id="latitudPuntoMasSudoeste" value="${latitudPuntoMasSudoeste}" >
</div>

<div>
<input type="hidden" name="longitudPuntoMasSudoeste" id="longitudPuntoMasSudoeste" value="${longitudPuntoMasSudoeste}" >
</div>

<div>
<input type="hidden" name="copiaTipoAnuncio" id="copiaTipoAnuncio" value="garages" >
</div>

<div>
<input type="hidden" name="copiaBusqueda" id="copiaBusqueda" value="${busqueda}" >
</div>



	<div>
         <fieldset>
			<legend>Precio <c:if test="${busqueda == 'sale'}">  <em>(&euro;)</em>: </c:if> 
			<c:if test="${busqueda == 'rent'}">  <em>(&euro;/mes)</em>:  </c:if></legend> 
			<input type="number" id="precioMin" name="precioMin"
				placeholder="min" <c:if test="${busqueda == 'sale'}">  min="3000" max="50000" step="1000"  </c:if> 
				<c:if test="${busqueda == 'rent'}">  min="60" max="600" step="20" </c:if> >
				<br>
			<input type="number" id="precioMax" name="precioMax"
				placeholder="max" <c:if test="${busqueda == 'sale'}">  min="3000" max="50000" step="1000" </c:if> 
				<c:if test="${busqueda == 'rent'}">  min="60" max="600" step="20" </c:if> >	
		
		</fieldset>
	
		</div>




<hr>
		<h3>Búsqueda avanzada</h3>

		<div>
			<fieldset>
				<legend
					title="Puede aplicar a su búsqueda uno o más de los siguientes filtros">
					Filtros: </legend>
				<label> <input type="checkbox" id="filtro1" name="filtros"
					value="automaticDoor"> Puerta Automática
				</label> 
             <label> <input type="checkbox" id="filtro2" name="filtros"
					value="motorcycleParking"> Plaza para motos
				</label> 
				<label> <input type="checkbox" id="filtro3" name="filtros"
					value="security"> Con vigilancia
				</label> 
          </fieldset>
          </div>
          

<div>
  <input type="submit" name="buscar" title="Pulse el botón para buscar" value="Buscar">
</div>


</form>
</body>
</html>