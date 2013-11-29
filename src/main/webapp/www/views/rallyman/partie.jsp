<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/views/partials/header.jsp" />

<c:if test="${isDemarre == true}">
	Joueur qui doit jouer : ${joueurCourant}
	Ton identifiant : ${sessionScope.joueur.identifiant}
	
	<c:choose>
		<c:when test="${sessionScope.joueur.identifiant == joueurCourant}">
			Champion, c'est � toi de jouer !
		</c:when>
		<c:otherwise>
			Ce n'est pas � toi de jouer, patiente !
		</c:otherwise>
	</c:choose>
	
</c:if>
<c:if test="${isDemarre != true}">
	En attente du nombre de joueurs ad�quat !
</c:if>


<a href="/partie">Rafraichir la page</a> 
<jsp:include page="/views/partials/footer.jsp" />