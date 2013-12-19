<jsp:include page="/views/partials/header.jsp" />
<h2><%= request.getParameter("jeu") %></h2>
<h3>Liste des joueurs présents</h3>
<h4></h4>
<script>



check_attente();
setInterval('check_attente()', 5000);
//setInterval('quitter()', 10000);
console.log("/joueur_quit?jeu=<%=request.getParameter("jeu")%>&nom=<%=request.getParameter("nom")%>");


//Lorsque l'utilisateur quitte la page!
window.onbeforeunload = function(){
	$.ajax({
		url: "/joueur_quit?jeu=<%=request.getParameter("jeu")%>&nom=<%=request.getParameter("nom")%>",
		data: "",
		success: function(data){},
		dataType: "text"
	});
	alert('Vous avez quitter la partie');
};

function quitter(){
	$.ajax({
		url: "/joueur_quit",
		type : 'GET',
		data: "jeu=<%=request.getParameter("jeu")%>&nom=<%=request.getParameter("nom")%>",
		success: function(data){},
		dataType: "text"
	});
}

function check_attente() {
	$.ajax({
		url: "/check_attente",
		type : 'GET',
		data: "jeu=<%=request.getParameter("jeu")%>",
		success: function(data){$("h4").text(data)},
		dataType: "text"
	});
}

</script>

<jsp:include page="/views/partials/header.jsp" />