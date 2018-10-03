<%@include file="includes/header.jsp"%>

<title>Buscador de habitaciones</title>
</head>

<body>

<h1> ¿Cuáles son sus criterios?</h1>

<form id="formulario3" action="controladorBuscadorSecundario" method="post">

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
<input type="hidden" name="copiaTipoAnuncio" id="copiaTipoAnuncio" value="bedrooms" >
</div>

<div>
<input type="hidden" name="copiaBusqueda" id="copiaBusqueda" value="${busqueda}" >
</div>

<div>
<label title="Seleccione su sexo."> Sexo: </label>
 <label> <input type="radio" name="sexo" id = "s1" value="male" checked> Hombre </label>
 <label> <input type="radio" name="sexo"  id = "s2" value="female"> Mujer<br> </label>

</div>


           <div>
<label title="Indique si permite fumadores."> Fumadores: </label>
<select name="fumar">
<option value="valorNeutro">Indiferente</option>
					<option value="allowed">Se puede fumar</option>
					<option value="disallowed">Prohibido fumar</option>		
</select>
</div>


<div>

			<label
				title="Elija el número de personas con las que quiere comprartir el piso. Puede elegir más de una opción.">
				Personas para compartir: </label> 
			 <label> <input type="checkbox" id="per0" name="personas"
				value="2"> 2
			</label> <label> <input type="checkbox" id="per1" name="personas"
				value="3"> 3
			</label> <label> <input type="checkbox" id="per2" name="personas"
				value="4"> 4+
			</label>
		</div>

<div>
         <fieldset>
			<legend>Precio <em>(&euro;/mes)</em>: </legend> 
			<input type="number" id="precioMin" name="precioMin"
				placeholder="min"  min="100" max="700" step="50" >
			<input type="number" id="precioMax" name="precioMax"
				placeholder="max"  min="100" max="700" step="50"  >	
		
		</fieldset>
	
		</div>


		
		
		
            <div>
<label title="Indique si permite tener mascotas."> Mascotas: </label>
<select name="mascotas">
<option value="valorNeutro">Indiferente</option>
					<option value="allowed">Se admiten mascotas</option>
					<option value="disallowed">No se admiten mascotas</option>
					
					
</select>
</div>

<hr>
		<h3>Búsqueda avanzada</h3>

		<div>
			<fieldset>
				<legend
					title="Puede aplicar a su búsqueda uno o más de los siguientes filtros">
					Filtros: </legend>
				<label> <input type="checkbox" id="filtro1" name="filtros"
					value="gayPartners"> Gay friendly
				</label> 
             <label> <input type="checkbox" id="filtro2" name="filtros"
					value="hasMultimedia"> Con fotos o vídeo
				</label> 
          </fieldset>
          </div>

<div>
  <input type="submit" name="buscar" title="Pulse el botón para buscar" value="Buscar">
</div>


</form>
</body>
</html>