<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/views/partials/header.jsp" />

<script type="text/javascript">
	$(function() {
		window.setInterval(function() {
			$.ajax({
				type : "get",
				url : "/rallyman-refresh",
				cache : false,
				data : '',/* 'firstName=' + $("#firstName").val() + "&lastName=" + $("#lastName").val() + "&email=" + $("#email").val(), */
				success : function(response) {
					$("#notification").css("display", "none");
					var obj = JSON.parse(response);
					console.log(response);
					
					var joueurActuel;
					var joueurPrecedant = localStorage.getItem('joueurPrecedant');
					if (obj[0].estJoueurCourant)
						joueurActuel = obj[0].identifiant;
					if (obj[1].estJoueurCourant)
						joueurActuel = obj[1].identifiant;
					if (joueurPrecedant == null){
						localStorage.setItem('joueurPrecedant', joueurActuel);
					} else if(joueurPrecedant != joueurActuel){
						localStorage.setItem('joueurPrecedant', joueurActuel);
						location.href="/rallyman-partie";				//temporaire
					}
					
					$("#avancement1").text(obj[0].avancement);
					$("#avancement2").text(obj[1].avancement);
					/* if (obj[0].avancement == obj[1].avancement){
						$("#cellule"+obj[0].avancement).find(".occupation").text(2);
					} else{
						$("#cellule"+obj[0].avancement).find(".occupation").text(1);
						$("#cellule"+obj[1].avancement).find(".occupation").text(1);
					} */

					$("#vitesse1").text(obj[0].voiture.vitesseCourante);
					$("#vitesse2").text(obj[1].voiture.vitesseCourante);
					$("#temps1").text(obj[0].temps);
					$("#temps2").text(obj[1].temps);
				},
				error : function() {
					$("#notification").css("display", "block");
				}
			});
		}, 3000);
	});
</script>

<c:choose>
	<c:when test="${!isDemarre}">
		En attente du nombre de joueurs adéquat !
	</c:when>
	<c:when test="${isDemarre && !isTermine}">
		Joueur qui doit jouer : ${joueurCourant.identifiant}
		Ton identifiant : ${sessionScope.joueur.identifiant}
		<br />
		<c:choose>
			<c:when
				test="${sessionScope.joueur.identifiant == joueurCourant.identifiant}">
				<div id="controle">
					Champion, c'est à toi de jouer !

					<c:forEach var="de" items="${des}">
						<a
							href="/rallyman-partie?action=jouer&deJoue=<c:out value="${de}" />"><c:out
								value="${de}" /></a>
					</c:forEach>

					<a href="/rallyman-partie?action=passerSonTour">Fin du tour</a>
				</div>
			</c:when>
			<c:otherwise>
				Ce n'est pas à toi de jouer, patiente !
			</c:otherwise>
		</c:choose>

		<h1>
			Spéciale en cours :
			<c:out value="${specialeCourante}" />
		</h1>

		<h2>Avancement des joueurs</h2>

		<c:forEach var="joueur" items="${joueurs}">
			<c:choose>
				<c:when test="${joueur.aFiniLaSpeciale}">
					Le joueur <c:out value="${joueur.identifiant}" /> a fini la spéciale, temps courant =  <c:out
						value="${joueur.temps}" /> secondes !
				</c:when>
				<c:otherwise>
				Joueur <c:out value="${joueur.identifiant}" /> 
				à la cellule <span id="avancement${joueur.identifiant}"><c:out
							value="${joueur.avancement}" /> </span>
				roule à la vitesse <span id="vitesse${joueur.identifiant}"><c:out
							value="${joueur.voiture.vitesseCourante}" /></span>
				et a déjà passé <span id="temps${joueur.identifiant}"><c:out
							value="${joueur.temps}" /></span> secondes sur le rally.
				</c:otherwise>
			</c:choose>
			<br />
		</c:forEach>

		<h2>Plateau de jeu</h2>

		<c:forEach var="cellule" items="${carte.listeCellules}"
			varStatus="loop">
			<!--<c:forEach var="joueur" items="${joueurs}">
				<c:if test="${joueur.avancement == cellule.identifiant}">
					Jr<c:out value="${joueur.identifiant}" /> 
				</c:if>
			</c:forEach>-->

			<div id="cellule${loop.index}">
				Cellule
				<c:out value="${cellule.identifiant}" />
				,
				<c:out value="${cellule.type}" />

				- limitée à la vitesse
				<c:out value="${cellule.limitationVitesse}" />

				- occupée par <span class="occupation"><c:out
						value="${cellule.nombreVoitures}" /></span> voiture(s)

				<c:if test="${cellule.natureAGauche != null}">
					- à gauche, il y a : <c:out value="${cellule.natureAGauche}" />
				</c:if>

				<c:if test="${cellule.natureADroite != null}">
					- à droite, il y a : <c:out value="${cellule.natureADroite}" />
				</c:if>
				<br />
			</div>
		</c:forEach>

	</c:when>
	<c:when test="${isDemarre && isTermine}">
		Le jeu est terminé ! <br />

		<%
			int i = 1;
		%>
		<c:forEach var="joueur" items="${joueurs}">
			Position <%=i%> : Joueur <c:out value="${joueur.identifiant}" /> en <c:out
				value="${joueur.temps}" /> secondes 
			<%
			if (i++ == 1) {
		%>
			 (VAINQUEUR !)
			<%
			}
		%>
			<br />
		</c:forEach>

	</c:when>
</c:choose>





<a href="/rallyman-partie">Rafraichir la page</a>

<div id="notification"
	style="position: absolute; top: 0px; right: 0px; background-color: black; color: white; padding: 5px; display: none;">
	<p>Connexion avec le serveur perdue. =(</p>
</div>

<jsp:include page="/views/partials/footer.jsp" />
