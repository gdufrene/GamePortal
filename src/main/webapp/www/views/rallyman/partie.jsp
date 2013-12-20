<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/views/partials/header.jsp" />
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="brand" href="#">Game Portal</a>
			<div class="nav-collapse collapse">
				<p class="navbar-text pull-right">
					Logged in as <a href="#" class="navbar-link">Username</a>
				</p>
				<ul class="nav">
					<li><a href="/rallyman-partie">Rafraichir la page</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>

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
					var joueurPrecedant = localStorage
							.getItem('joueurPrecedant');
					if (obj[0].estJoueurCourant)
						joueurActuel = obj[0].identifiant;
					if (obj[1].estJoueurCourant)
						joueurActuel = obj[1].identifiant;
					if (joueurPrecedant == null) {
						localStorage.setItem('joueurPrecedant', joueurActuel);
					} else if (joueurPrecedant != joueurActuel) {
						localStorage.setItem('joueurPrecedant', joueurActuel);
						location.href = "/rallyman-partie"; //temporaire
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

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<c:choose>
				<c:when test="${!isDemarre}">
					En attente du nombre de joueurs adéquat !
				</c:when>
				<c:when test="${isDemarre && !isTermine}">
					Joueur qui doit jouer : ${joueurCourant.identifiant}
					Ton identifiant : ${sessionScope.joueur.identifiant}
					<br />
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
					<%
						int nbCase = 0;
					%>
					<c:set var="estHorizontal" value="true"></c:set>
					<h2>Plateau de jeu</h2>
					<div id="plateau">
						<div id="menu">
							<c:choose>
								<c:when
									test="${sessionScope.joueur.identifiant == joueurCourant.identifiant}">
									Champion, c'est à toi de jouer !
									<%
									nbCase++;
								%>
									<c:forEach var="de" items="${des}">
										<a class="de"
											href="/rallyman-partie?action=jouer&deJoue=<c:out value="${de}" />">
											<c:if test="${de == 'vitesse1'}">
												<img src="resources/1.png" />
											</c:if> <c:if test="${de == 'vitesse2'}">
												<img src="resources/2.png" />
											</c:if> <c:if test="${de == 'vitesse3'}">
												<img src="resources/3.png" />
											</c:if> <c:if test="${de == 'vitesse4'}">
												<img src="resources/4.png" />
											</c:if> <c:if test="${de == 'vitesse5'}">
												<img src="resources/5.png" />
											</c:if> <c:if test="${de == 'gaz1'}">
												<img src="resources/gas.png" />
											</c:if> <c:if test="${de == 'gaz2'}">
												<img src="resources/gas.png" />
											</c:if>
										</a>
									</c:forEach>

									<a href="/rallyman-partie?action=passerSonTour">Fin du tour</a>

								</c:when>
								<c:otherwise>
									<p>Ce n'est pas à toi de jouer, patiente !</p>
									<br />
								</c:otherwise>
							</c:choose>
						</div>
						<table id="circuit">
							<tr>
							<c:forEach var="cellule" items="${carte.listeCellules}">
								<c:if test="${cellule.type == 'ligne droite'}">
									<c:choose>							
										<c:when test="${estHorizontal}">
											<% nbCase++; %>	
											<td>
												<c:choose>
													<c:when test="${cellule.limitationVitesse == 1 }"><img src="resources/case_droit_hori_1.jpg"/></c:when>
													<c:when test="${cellule.limitationVitesse == 2 }"><img src="resources/case_droit_hori_2.jpg"/></c:when>
													<c:when test="${cellule.limitationVitesse == 3 }"><img src="resources/case_droit_hori_3.jpg"/></c:when>
													<c:when test="${cellule.limitationVitesse == 4 }"><img src="resources/case_droit_hori_4.jpg"/></c:when>
													<c:when test="${cellule.limitationVitesse == 5 }"><img src="resources/case_droit_hori_5.jpg"/></c:when>
												</c:choose>
											</td>
										</c:when>
										<c:when test="${!estHorizontal}">
											<td>
												<c:choose>
													<c:when test="${cellule.limitationVitesse == 1 }"><img src="resources/case_droit_ver_1.jpg"/></c:when>
													<c:when test="${cellule.limitationVitesse == 2 }"><img src="resources/case_droit_ver_2.jpg"/></c:when>
													<c:when test="${cellule.limitationVitesse == 3 }"><img src="resources/case_droit_ver_3.jpg"/></c:when>
													<c:when test="${cellule.limitationVitesse == 4 }"><img src="resources/case_droit_ver_4.jpg"/></c:when>
													<c:when test="${cellule.limitationVitesse == 5 }"><img src="resources/case_droit_ver_5.jpg"/></c:when>
												</c:choose>
											</td></tr><tr>
											<% for(int i = 1 ; i < nbCase; i++) { %>
												<td></td>
											<% } %>
										</c:when>
									</c:choose>
								</c:if>
								
								<c:if test="${cellule.type == 'virage'}">
									<c:if test="${estHorizontal}">
									<% nbCase++; %>
										<td>
											<c:choose>
												<c:when test="${cellule.limitationVitesse == 1 }"><img src="resources/case_virage_gauche_1.jpg"/></c:when>
												<c:when test="${cellule.limitationVitesse == 2 }"><img src="resources/case_virage_gauche_2.jpg"/></c:when>
												<c:when test="${cellule.limitationVitesse == 3 }"><img src="resources/case_virage_gauche_3.jpg"/></c:when>
												<c:when test="${cellule.limitationVitesse == 4 }"><img src="resources/case_virage_gauche_4.jpg"/></c:when>
												<c:when test="${cellule.limitationVitesse == 5 }"><img src="resources/case_virage_gauche_5.jpg"/></c:when>
											</c:choose>
										</td>
									</c:if>
									<c:if test="${!estHorizontal}">
										<td>
											<c:choose>
												<c:when test="${cellule.limitationVitesse == 1 }"><img src="resources/case_virage_droite_1.jpg"/></c:when>
												<c:when test="${cellule.limitationVitesse == 2 }"><img src="resources/case_virage_droite_2.jpg"/></c:when>
												<c:when test="${cellule.limitationVitesse == 3 }"><img src="resources/case_virage_droite_3.jpg"/></c:when>
												<c:when test="${cellule.limitationVitesse == 4 }"><img src="resources/case_virage_droite_4.jpg"/></c:when>
												<c:when test="${cellule.limitationVitesse == 5 }"><img src="resources/case_virage_droite_5.jpg"/></c:when>
											</c:choose>
										</td>
									</c:if>
								
									<c:if test="${estHorizontal}">
										</tr><tr>
										<% for(int i = 1 ; i < nbCase; i++) { %>
											<td></td>
										<% } %>
									</c:if>
									<c:choose>
										<c:when test="${!estHorizontal}">
											<c:set var="estHorizontal" value="true"></c:set>
									</c:when>
									<c:when test="${estHorizontal}">
										<c:set var="estHorizontal" value="false"></c:set>
									</c:when>
								</c:choose>
							</c:if>
							</c:forEach>
							</tr>
						</table>
					</div>
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
		</div>
	</div>
	<!--/row-->
	<hr>
	<footer>
		<p>&copy; Company 2013</p>
	</footer>
</div>
<!--/.fluid-container-->

<a href="/rallyman-partie">Rafraichir la page</a>

<div id="notification"
	style="position: absolute; top: 0px; right: 0px; background-color: black; color: white; padding: 5px; display: none;">
	<p>Connexion avec le serveur perdue. =(</p>
</div>

<jsp:include page="/views/partials/footer.jsp" />
