<%@include file="includes/header.jsp"%>

<title>Resultado de la búsqueda</title>
</head>

<body>



<h1> Resultados de la búsqueda </h1>

<c:if test="${empty requestScope.anuncios}">
<p> No hay contenido para mostrar</p>
</c:if>

<c:if test="${not empty requestScope.anuncios}">


<c:if test="${numAnuncios <= 50}">
<p> Su búsqueda ha devuelto <c:out value="${numAnuncios}"/> resultados. </p>
</c:if>

<c:if test="${numAnuncios > 50}">
<p> Sú búsqueda es demasiado genérica por lo que se muestran sólo 50 de los <c:out value="${numAnuncios}" /> resultados. </p>
</c:if>

<table id="tablaResultados" class="resultados">



<c:forEach items="${requestScope.anuncios}" var="anuncio" >
 <tr>
    <td rowspan="4"> <c:if test="${not empty anuncio.thumbnail}"> <img src="${anuncio.thumbnail}" alt="${anuncio.address}" height="128" width="158">
    </c:if>
    <c:if test="${empty anuncio.thumbnail}"> <img src="images/nohayfoto.png" alt="No hay foto disponible" height="128" width="158">
    </c:if>
    
     </td>
    <td > <c:if test="${not empty anuncio.address}"> <c:out value="${tipoDeAnuncio}">  </c:out> en <c:out value="${anuncio.address}"> </c:out> </c:if>
    <c:if test="${empty anuncio.address}"> <c:out value="${tipoDeAnuncio}"> </c:out> </c:if>
   
     </td>
    <td > <strong> Acciones: </strong></td>
    </tr>
    
    <tr>
    <td> <c:out value="${anuncio.price}"> </c:out> &euro; </td>
    <td> <a href="${anuncio.url}"> <img src="images/idealista.png" alt="Idealista" title="Ver en Idealista"> </a></td>
    </tr>
    
    <tr >
    <td> <c:if test="${not empty anuncio.rooms}"> <c:out value="${anuncio.rooms}"> </c:out> habitaciones </c:if>
    <c:if test="${empty anuncio.rooms}"> </c:if>
     </td>
    <td> <form id="${anuncio.propertyCode}" method="post" action="obtenerCoordenadas"> <input type="hidden" name="latitud" value="${anuncio.latitude}"> 
    <input type="hidden" name="longitud" value="${anuncio.longitude}">
     <input type="submit" name="GooglePlaces" value="Ver lugares cercanos">
    </form></td>
    </tr>
    
    <tr>
    <td> <c:out value="${anuncio.numPhotos}"> </c:out> fotos disponibles </td>
    <td>  
    <form id="${anuncio.propertyCode}2" method="post" action="controladorGuardarInformacion" target="_blank"> 
    <input type="hidden" name="direccion" value="${anuncio.address}"> 
    <input type="hidden" name="anuncio" value="${tipoDeAnuncio}"> 
    <input type="hidden" name="precio" value="${anuncio.price}"> 
    <input type="hidden" name="baños" value="${anuncio.bathrooms}"> 
    <input type="hidden" name="provincia" value="${anuncio.province}"> 
    <input type="hidden" name="municipio" value="${anuncio.municipality}">
    <input type="hidden" name="comarca" value="${anuncio.district}"> 
    <input type="hidden" name="obraNueva" value="${anuncio.newDevelopment}"> 
    <input type="hidden" name="habitaciones" value="${anuncio.rooms}">
    <input type="hidden" name="tamaño" value="${anuncio.size}">
    <input type="hidden" name="operacion" value="${anuncio.operation}">
    <input type="hidden" name="url" value="${anuncio.url}">
    
    <button type="submit" name="boton" value="GuardarInformacion"> <img src="images/googleDrive.png" alt = "Google Drive" title="Guardar la información en GoogleDrive" width="84" height="75"></button>
    </form>
    </td>
  </tr>
  
 <tr>
 
 </tr>
<tr>
 
 </tr>
  <tr>
 
 </tr>
<tr>
 
 </tr>
 
 </c:forEach>
 </table>
 </c:if>
</body>
</html>