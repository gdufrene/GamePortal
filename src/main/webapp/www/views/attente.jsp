<jsp:include page="/views/partials/header.jsp" />
<div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
                <div class="container-fluid">
                        <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                        </button>
                        <a class="brand" href="#">Game Portal</a>
                        <div class="nav-collapse collapse">
                                <p class="navbar-text pull-right">
                                        Logged in as <a href="#" class="navbar-link">Username</a>
                                </p>
                                <ul class="nav">
                                        <li><a href="/choix_jeu">Accueil</a></li>
                                        <li><a href="#classement">Classement</a></li>
                                </ul>
                        </div><!--/.nav-collapse -->
                </div>
        </div>
</div>


<div class="container-fluid">
        <div class="row-fluid">
                <div class="span9">
                        <div class="hero-unit">
                                <h1><%= request.getParameter("jeu") %></h1>
                                <p></p>
                                <% if (request.getParameter("ademarre").equals("1")) { %>
                                	<p><a onclick="javascript:commencer();" class="btn btn-primary btn-large">Commencer la partie &raquo;</a></p>
                                	<!-- <p><a href="/<%= request.getParameter("jeu") %>" class="btn btn-primary btn-large">Commencer la partie &raquo;</a></p> -->
  								<% } %>
                        </div>
                        <h1>Liste des joueurs en attente</h1>
                          <div class="row-fluid" id="j1">
                                <div class="span4" id="rallyman">
                                    <h2></h2>
                                </div>
                         </div>
                         <div class="row-fluid" id="j2">
                                <div class="span4" id="rallyman">
                                    <h2></h2>
                                </div>
                         </div>
                         <div class="row-fluid" id="j3">
                                <div class="span4" id="rallyman">
                                    <h2></h2>
                                </div>
                         </div>
                         <div class="row-fluid" id="j4">
                                <div class="span4" id="rallyman">
                                    <h2></h2>
                                </div>
                         </div>
                         <div class="row-fluid" id="j5">
                                <div class="span4" id="rallyman">
                                    <h2></h2>
                                </div>
                         </div>
                         <div class="row-fluid" id="j6">
                                <div class="span4" id="rallyman">
                                    <h2></h2>
                                </div>
                         </div>
                </div><!--/span-->
        </div><!--/row-->
        <hr>
        <footer>
                <p>&copy; Company 2013</p>
        </footer>        
</div><!--/.fluid-container-->



<script>

check_attente();
setInterval('check_attente()', 5000);
vademarre = false;

//Lorsque l'utilisateur quitte la page!
window.onbeforeunload = function(){
	if (!vademarre) {
		$.ajax({
			url: "/joueur_quit?jeu=<%=request.getParameter("jeu")%>&nom=<%=request.getParameter("nom")%>",
			data: "",
			success: function(data){},
			dataType: "text"
		});
		alert('Vous avez quitter la partie');
	}
};

function check_attente() {
	$.ajax({
		url: "/vacommencer",
		type : 'GET',
		data: "jeu=<%=request.getParameter("jeu")%>",
		success: function(data){
			if (data == "1") {
				commencer();
			}
		},
		dataType: "text"
	});
	$.ajax({
		url: "/check_attente",
		type : 'GET',
		data: "jeu=<%=request.getParameter("jeu")%>",
		success: function(data){
			var res = "";
			var sp = data.split(";");
			for (var j=1; j<=6; j++)
				$("#j"+j+" h2").text("");
			for (var i=1; i<sp.length; i++)
				$("#j"+i+" h2").text(sp[i-1]);
		},
		dataType: "text"
	});
}

function commencer() {
	vademarre = true;
	$.ajax({
		url: "/check_attente",
		type : 'GET',
		data: "jeu=<%=request.getParameter("jeu")%>",
		success: function(data){
			$.ajax({
				url: "/commencer",
				type : 'GET',
				data: "jeu=<%=request.getParameter("jeu")%>",
				success: function(data2) {
					console.log(data2);
					window.location =  "/<%= request.getParameter("jeu") %>?name=<%= request.getParameter("nom") %>&others=" + data;
				},
				dataType: "text"
			});
			//window.location =  "/<%= request.getParameter("jeu") %>?name=<%= request.getParameter("nom") %>&others=" + data;
		},
		dataType: "text"
	});
	
}



</script>

<jsp:include page="/views/partials/header.jsp" />