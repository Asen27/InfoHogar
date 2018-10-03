<%@include file="includes/header.jsp"%>

<title>Ver lugares cercanos </title>
</head>

<body>

<c:if test="${not empty coordenadas}">

<nav>
<h2> Seleccione un tipo de lugar: </h2>



<form method="post" id="formulario9" action="controladorVerLugaresCercanos">

<input type="hidden" name="coordenadas" value="${coordenadas}">
<button name="lugar" type="submit" value="bank">Banco</button> <br> <br>
<button name="lugar" type="submit" value="bus_station">Estación de autobuses</button> <br> <br>
<button name="lugar" type="submit" value="train_station">Estación de trenes</button> <br> <br>
<button name="lugar" type="submit" value="gym">Gimnasio</button> <br> <br>
<button name="lugar" type="submit" value="pharmacy">Farmacia</button> <br> <br>
<button name="lugar" type="submit" value="gas_station">Gasolinera</button> <br> <br>
<button name="lugar" type="submit" value="hospital">Hospital</button> <br> <br>
<button name="lugar" type="submit" value="police">Policía</button> <br> <br>
<button name="lugar" type="submit" value="hair_care">Peluquería</button> <br> <br>
<button name="lugar" type="submit" value="store">Tienda</button> <br> <br>
<button name="lugar" type="submit" value="restaurant">Restaurante</button> <br> <br>
</form>
</nav>

</c:if>






<section>

<c:if test="${empty coordenadas}">

<c:if test="${empty requestScope.lugaresCercanos}">
<div>
<h3> No hay contenido para mostrar</h3>
</div>

</c:if>


	<c:if test="${not empty requestScope.lugaresCercanos}">
	
	<p> A continuación se muestran los lugares más cercanos del tipo que has seleccionado </p>
	
	
	
	<c:forEach items="${requestScope.lugaresCercanos}" var="resultado" >
	<article>
	<div>
	Nombre: <c:if test="${not empty resultado.name}"> <c:out value="${resultado.name}" /> </c:if>
	        <c:if test="${empty resultado.name}"> <em>desconocido</em> </c:if>
	</div>
	
	<div>
	Dirección: <c:if test="${not empty resultado.vicinity}"> <c:out value="${resultado.vicinity}" /> </c:if>
	           <c:if test="${empty resultado.vicinity}"> <em>desconocida</em> </c:if>
	</div>
	
	<div>
	Nivel de precios: <c:if test="${not empty resultado.priceLevel}"> 
	<c:set var="precios" value="${resultado.priceLevel}"/>
	<c:if test="${precios == '0'}"> Gratis </c:if>
	<c:if test="${precios == '1'}"> Barato </c:if>
	<c:if test="${precios == '2'}"> Razonable </c:if>
	<c:if test="${precios == '3'}"> Caro </c:if>
	<c:if test="${precios == '4'}"> Muy caro </c:if>
	 </c:if>

	           <c:if test="${empty resultado.priceLevel}"> <em>desconocido</em> </c:if>
	</div>
	
	
	<div>
	Rating: <c:if test="${not empty resultado.rating}"> <c:out value="${resultado.rating}" /> </c:if>
	           <c:if test="${empty resultado.rating}"> <em>desconocido</em> </c:if>
	</div>
	</article>
	<hr>
	</c:forEach>
	
	</c:if>
	</c:if>
	</section>
	
	
	
	
	






</body>
</html>