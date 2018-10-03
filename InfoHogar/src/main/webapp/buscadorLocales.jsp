<%@include file="includes/header.jsp"%>

<title>Buscador de locales</title>
</head>

<body>

<h1> ¿Cuáles son sus criterios?</h1>

<form id="formulario6" action="controladorBuscadorSecundario" method="post">

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
<input type="hidden" name="copiaTipoAnuncio" id="copiaTipoAnuncio" value="premises" >
</div>

<div>
<input type="hidden" name="copiaBusqueda" id="copiaBusqueda" value="${busqueda}" >
</div>


<div>
<label title="Elija el tipo."> Tipo: </label>
<label> <input type="checkbox"  name="tipo"  id = "t1" value="premises" > Nave </label>
 <label> <input type="checkbox" name="tipo"  id = "t2" value="industrialBuilding"> Local <br> </label> 
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

			<label title="Elija la ubicación."> Ubicación: </label> 
			<select name="ubicacion">
					<option value="shoppingcenter">En centro comercial</option>
					<option value="street">A pie de calle</option>
					<option value="mezzanine">Entreplanta</option>
					<option value="underground">Subterraneo</option>
					<option value="others">Otro</option>
					
</select> 
		</div>

<div>
         <fieldset>
			<legend>Precio <c:if test="${busqueda == 'sale'}">  <em>(&euro;)</em>: </c:if> 
			<c:if test="${busqueda == 'rent'}">  <em>(&euro;/mes)</em>:  </c:if></legend> 
			<input type="number" id="precioMin" name="precioMin"
				placeholder="min" <c:if test="${busqueda == 'sale'}">  min="100000" max="7000000" step="20000"  </c:if> 
				<c:if test="${busqueda == 'rent'}">  min="100" max="30000" step="50" </c:if> >
				<br>
			<input type="number" id="precioMax" name="precioMax"
				placeholder="max" <c:if test="${busqueda == 'sale'}">  min="100000" max="7000000" step="20000" </c:if> 
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
					value="airConditioning"> Con aire acondicionado
				</label> 
             <label> <input type="checkbox" id="filtro2" name="filtros"
					value="heating"> Con calefacción
				</label> 
				<label> <input type="checkbox" id="filtro3" name="filtros"
					value="corner"> Hace esquina
				</label>
				<label> <input type="checkbox" id="filtro4" name="filtros"
					value="smokeVentilation"> Salida de humos
				</label>  
          </fieldset>
          </div>



<div>
  <input type="submit" name="buscar" title="Pulse el botón para buscar" value="Buscar">
</div>


</form>
</body>
</html>