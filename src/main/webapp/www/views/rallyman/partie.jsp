<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/views/partials/header.jsp" />

<c:if test="${isDemarre == true}">
	Joueur qui doit jouer : ${joueurCourant}
	Ton identifiant : ${sessionScope.joueur.identifiant}
	
	<c:choose>
		<c:when test="${sessionScope.joueur.identifiant == joueurCourant}">
			Champion, c'est à toi de jouer !
			
			<c:forEach var="de" items="${des}">
				<a href="/rallyman-partie?action=jouer&deJoue=<c:out value="${de}" />"><c:out value="${de}" /></a>
			</c:forEach>			
			
			<a href="/rallyman-partie?action=passerSonTour">Fin du tour</a>
			
		</c:when>
		<c:otherwise>
			Ce n'est pas à toi de jouer, patiente !
		</c:otherwise>
	</c:choose>
	
	<h1>Spéciale en cours : <c:out value="${specialeCourante}" /></h1>
	
	<h2>Avancement des joueurs</h2>

	<c:forEach var="joueur" items="${joueurs}">
	
		Joueur <c:out value="${joueur.identifiant}" /> 
		à la cellule <c:out value="${joueur.avancement}" /> 
		roule à la vitesse <c:out value="${joueur.voiture.vitesseCourante}" />
		<br />
	</c:forEach>
	
	<h2>Plateau de jeu</h2>
	
	<c:forEach var="cellule" items="${carte.listeCellules}">
		Cellule <c:out value="${cellule.identifiant}" /> 
		
		- limitée à la vitesse <c:out value="${cellule.limitationVitesse}" />
		
		- occupée par <c:out value="${cellule.nombreVoitures}" /> voiture(s)
		
		<c:if test="${cellule.natureAGauche != null}">
			- à gauche, il y a : <c:out value="${cellule.natureAGauche}" /> 
		</c:if>
		
		<c:if test="${cellule.natureADroite != null}">
			- à droite, il y a : <c:out value="${cellule.natureADroite}" /> 
		</c:if>
		<br />
	</c:forEach>
	
</c:if>
<c:if test="${isDemarre != true}">
	En attente du nombre de joueurs adéquat !
</c:if>


<a href="/rallyman-partie">Rafraichir la page</a> 
<jsp:include page="/views/partials/footer.jsp" />
