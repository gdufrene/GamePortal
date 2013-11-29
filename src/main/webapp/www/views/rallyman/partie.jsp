<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${isDemarre == true}">
	Joueur qui doit jouer : ${joueurCourant}
	Ton identifiant : ${sessionScope.joueur.identifiant}
	
	<c:choose>
		<c:when test="${sessionScope.joueur.identifiant == joueurCourant}">
			Champion, c'est à toi de jouer !
		</c:when>
		<c:otherwise>
			Ce n'est pas à toi de jouer, patiente !
		</c:otherwise>
	</c:choose>
	
</c:if>
<c:if test="${isDemarre != true}">
	En attente du nombre de joueurs adéquat !
</c:if>


<a href="/partie">Rafraichir la page</a> 