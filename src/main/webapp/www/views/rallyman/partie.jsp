<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/views/partials/header.jsp" />

<c:choose>
	<c:when test="${!isDemarre}">
		En attente du nombre de joueurs ad�quat !
	</c:when>
	<c:when test="${isDemarre && !isTermine}">
		Joueur qui doit jouer : ${joueurCourant.identifiant}
		Ton identifiant : ${sessionScope.joueur.identifiant}
		<br />
		<c:choose>
			<c:when test="${sessionScope.joueur.identifiant == joueurCourant.identifiant}">
				Champion, c'est � toi de jouer !
				
				<c:forEach var="de" items="${des}">
					<a href="/rallyman-partie?action=jouer&deJoue=<c:out value="${de}" />"><c:out value="${de}" /></a>
				</c:forEach>			
				
				<a href="/rallyman-partie?action=passerSonTour">Fin du tour</a>
				
			</c:when>
			<c:otherwise>
				Ce n'est pas � toi de jouer, patiente !
			</c:otherwise>
		</c:choose>
		
		<h1>Sp�ciale en cours : <c:out value="${specialeCourante}" /></h1>
		
		<h2>Avancement des joueurs</h2>
	
		<c:forEach var="joueur" items="${joueurs}">
			<c:choose>
				<c:when test="${joueur.aFiniLaSpeciale}">
					Le joueur <c:out value="${joueur.identifiant}" /> a fini la sp�ciale, temps courant =  <c:out value="${joueur.temps}" /> secondes !
				</c:when>
				<c:otherwise>
				Joueur <c:out value="${joueur.identifiant}" /> 
				� la cellule <c:out value="${joueur.avancement}" /> 
				roule � la vitesse <c:out value="${joueur.voiture.vitesseCourante}" />
				et a d�j� pass� <c:out value="${joueur.temps}" /> secondes sur le rally.
				</c:otherwise>
			</c:choose>
			<br />
		</c:forEach>
		
		<h2>Plateau de jeu</h2>
		
		<c:forEach var="cellule" items="${carte.listeCellules}">
			<!--<c:forEach var="joueur" items="${joueurs}">
				<c:if test="${joueur.avancement == cellule.identifiant}">
					Jr<c:out value="${joueur.identifiant}" /> 
				</c:if>
			</c:forEach>-->
	
			Cellule <c:out value="${cellule.identifiant}" />, <c:out value="${cellule.type}" />
			
			- limit�e � la vitesse <c:out value="${cellule.limitationVitesse}" />
			
			- occup�e par <c:out value="${cellule.nombreVoitures}" /> voiture(s)
			
			<c:if test="${cellule.natureAGauche != null}">
				- � gauche, il y a : <c:out value="${cellule.natureAGauche}" /> 
			</c:if>
			
			<c:if test="${cellule.natureADroite != null}">
				- � droite, il y a : <c:out value="${cellule.natureADroite}" /> 
			</c:if>
			<br />
		</c:forEach>
		
	</c:when>
	<c:when test="${isDemarre && isTermine}">
		Le jeu est termin� ! <br />
		
		<%
		int i = 1;
		%>
		<c:forEach var="joueur" items="${joueurs}">
			Position <%= i %> : Joueur <c:out value="${joueur.identifiant}" /> en <c:out value="${joueur.temps}" /> secondes 
			<% if(i++ == 1) { %>
			 (VAINQUEUR !)
			<% } %>
			<br />
		</c:forEach>
		
	</c:when>
</c:choose>





<a href="/rallyman-partie">Rafraichir la page</a> 
<jsp:include page="/views/partials/footer.jsp" />
