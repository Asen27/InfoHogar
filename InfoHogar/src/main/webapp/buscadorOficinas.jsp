<%@include file="includes/header.jsp"%>

<title>Buscador de oficinas</title>
</head>

<body>

<h1> ¿Cuáles son sus criterios?</h1>

<form id="formulario4" action="controladorBuscadorSecundario" method="post">

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
<input type="hidden" name="copiaTipoAnuncio" id="copiaTipoAnuncio" value="offices" >
</div>

<div>
<input type="hidden" name="copiaBusqueda" id="copiaBusqueda" value="${busqueda}" >
</div>


<div>
<label title="Elija el tipo de edificio."> Tipo de edificio: </label>
<select name="tipoEdificio">
					<option value="valorNeutro">Indiferente</option>
					<option value="exclusive">Exclusivo de oficinas</option>
					<option value="mixed">Uso mixto</option>
					
					
</select>

</div>



<div>
<label title="Elija el tipo de distribución para el edificio."> Distribución: </label>
<select name="distribucion">
                    <option value="valorNeutro">Indiferente</option>
					<option value="withWalls">Tabicada</option>
					<option value="openPlan">Diáfana</option>
				
</select>
</div>



<div>
         <fieldset>
			<legend>Tamaño <em>(m<sup>2</sup>)</em>: </legend> 
			<input type="number" id="tamMin" name="tamMin"
				placeholder="min" min="60" max="1000" step="10">
				<br>
			<input type="number" id="tamMax" name="tamMax"
				placeholder="max" min="60" max="1000" step="10">	
		
		</fieldset>
		</div>



<div>
         <fieldset>
			<legend>Precio <c:if test="${busqueda == 'sale'}">  <em>(&euro;)</em>: </c:if> 
			<c:if test="${busqueda == 'rent'}">  <em>(&euro;/mes)</em>:  </c:if></legend> 
			<input type="number" id="precioMin" name="precioMin"
				placeholder="min" <c:if test="${busqueda == 'sale'}">  min="100000" max="5000000" step="20000"  </c:if> 
				<c:if test="${busqueda == 'rent'}">  min="100" max="30000" step="50" </c:if> >
				<br>
			<input type="number" id="precioMax" name="precioMax"
				placeholder="max" <c:if test="${busqueda == 'sale'}">  min="100000" max="5000000" step="20000" </c:if> 
				<c:if test="${busqueda == 'rent'}">  min="100" max="30000" step="50" </c:if> >	
		
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
					value="garage"> Con garaje
				</label> 
<label> <input type="checkbox" id="filtro2" name="filtros"
					value="hotWater"> Con agua caliente
				</label> 
<label> <input type="checkbox" id="filtro3" name="filtros"
					value="elevator"> Con ascensor
				</label> 
<label> <input type="checkbox" id="filtro4" name="filtros"
					value="heating"> Con calefacción
				</label> 
<label> <input type="checkbox" id="filtro5" name="filtros"
					value="airConditioning"> Con aire acondicionado
				</label> 
<label> <input type="checkbox" id="filtro6" name="filtros"
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