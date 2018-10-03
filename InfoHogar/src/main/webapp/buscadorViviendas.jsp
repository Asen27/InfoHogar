<%@include file="includes/header.jsp"%>

<title>Buscador de viviendas</title>
</head>

<body>

	<h1>�Cu�les son sus criterios?</h1>

	<form id="formulario2" action="controladorBuscadorSecundario"
		method="post">

		<p>
			<strong> Todos los campos que aparecen en esta p�gina son
				opcionales </strong>
		</p>

		<div>
			<input type="hidden" name="latitud" id="latitud" value="${latitud}">
		</div>

		<div>
			<input type="hidden" name="longitud" id="longitud"
				value="${longitud}">
		</div>

		<div>
			<input type="hidden" name="latitudPuntoMasSudoeste"
				id="latitudPuntoMasSudoeste" value="${latitudPuntoMasSudoeste}">
		</div>

		<div>
			<input type="hidden" name="longitudPuntoMasSudoeste"
				id="longitudPuntoMasSudoeste" value="${longitudPuntoMasSudoeste}">
		</div>

		<div>
			<input type="hidden" name="copiaTipoAnuncio" id="copiaTipoAnuncio"
				value="homes">
		</div>

		<div>
			<input type="hidden" name="copiaBusqueda" id="copiaBusqueda"
				value="${busqueda}">
		</div>

		<div>
			<label title="Elija el tipo de vivienda."> Tipo de vivienda:
			</label> <select name="tiposVivienda">
				<option value="flat">Piso</option>
				<option value="chalet">Chalet</option>
				<option value="countryHouse">Casa R�stica</option>
				<option value="studio">Estudio</option>
				<option value="duplex">Duplex</option>
				<option value="penthouse">�tico</option>

			</select>
		</div>


		<div>
			<fieldset>
				<legend>
					Tama�o <em>(m<sup>2</sup>)
					</em>:
				</legend>
				<input type="number" id="tamMin" name="tamMin" placeholder="min"
					min="60" max="1000" step="10"> <br> <input
					type="number" id="tamMax" name="tamMax" placeholder="max" min="60"
					max="1000" step="10">

			</fieldset>
		</div>

		<div>
			<fieldset>
				<legend>
					Precio
					<c:if test="${busqueda == 'sale'}">
						<em>(&euro;)</em>: </c:if>
					<c:if test="${busqueda == 'rent'}">
						<em>(&euro;/mes)</em>:  </c:if>
				</legend>
				<input type="number" id="precioMin" name="precioMin"
					placeholder="min"
					<c:if test="${busqueda == 'sale'}">  min="60000" max="3000000" step="20000"  </c:if>
					<c:if test="${busqueda == 'rent'}">  min="100" max="3000" step="50" </c:if>>
				<br> <input type="number" id="precioMax" name="precioMax"
					placeholder="max"
					<c:if test="${busqueda == 'sale'}">  min="60000" max="3000000" step="20000" </c:if>
					<c:if test="${busqueda == 'rent'}">  min="100" max="3000" step="50" </c:if>>

			</fieldset>

		</div>

		<div>

			<label
				title="Elija el n�mero de habitaciones. Puede elegir m�s de una opci�n.">
				N�mero de habitaciones: </label> <label> <input type="checkbox"
				id="hab0" name="habitaciones" value="0"> 0
			</label> <label> <input type="checkbox" id="hab1" name="habitaciones"
				value="1"> 1
			</label> <label> <input type="checkbox" id="hab2" name="habitaciones"
				value="2"> 2
			</label> <label> <input type="checkbox" id="hab3" name="habitaciones"
				value="3"> 3
			</label> <label> <input type="checkbox" id="hab4" name="habitaciones"
				value="4"> 4+
			</label>
		</div>


		<div>

			<label
				title="Elija el n�mero de ba�os. Puede elegir m�s de una opci�n.">
				N�mero de ba�os: </label> <label> <input type="checkbox" id="b0"
				name="banos" value="1"> 0
			</label> <label> <input type="checkbox" id="b1" name="banos"
				value="1"> 1
			</label> <label> <input type="checkbox" id="b2" name="banos"
				value="2"> 2
			</label> <label> <input type="checkbox" id="b3" name="banos"
				value="3"> 3+
			</label>
		</div>

		<hr>
		<h3>B�squeda avanzada</h3>

		<div>
			<fieldset>
				<legend
					title="Puede aplicar a su b�squeda uno o m�s de los siguientes filtros">
					Filtros: </legend>
				<label> <input type="checkbox" id="filtro1" name="filtros"
					value="newDevelopment"> Obra nueva
				</label> <label> <input type="checkbox" id="filtro2" name="filtros"
					value="garage"> Con garaje
				</label> <label> <input type="checkbox" id="filtro3" name="filtros"
					value="terrance"> Con terraza
				</label> <label> <input type="checkbox" id="filtro4" name="filtros"
					value="swimmingPool"> Con piscina
				</label> <label> <input type="checkbox" id="filtro5" name="filtros"
					value="elevator"> Con ascensor
				</label> <label> <input type="checkbox" id="filtro6" name="filtros"
					value="airConditioning"> Con aire acondicionado
				</label> <label> <input type="checkbox" id="filtro7" name="filtros"
					value="storeRoom"> Con trastero
				</label> <label> <input type="checkbox" id="filtro8" name="filtros"
					value="builtinWardrobes"> Con armarios empotrados
				</label> 
				</fieldset>
		</div>
		
			<div>	
				<input type="submit" name="buscar"
					title="Pulse el bot�n para buscar" value="Buscar">
			</div>		
		
	</form>
</body>
</html>