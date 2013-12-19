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
                                <h1></h1>
                                <p>Bienvenue sur le portail de jeux de plateaux en ligne</p>
                                <p><a href="#" class="btn btn-primary btn-large">Plus d'informations &raquo;</a></p>
                        </div>
                          <div class="row-fluid">
                                <!-- Span RallyMan -->
                                <div class="span4" id="rallyman">
                                        <h2>RallyMan</h2>
                                        <p>Spéciales chronométrées, routes enneigées, cordes piégeuses, dérapages, sauts ... ambiance 110% rallye ! La quatrième édition.</p>
                                        <p><a class="btn" href="#">Voir la fiche du jeu &raquo;</a><a class="btn btn-primary" href="#">Jouer</a></p>
                                </div>
                                <!--/Span RallyMan -->
        
         
         						<div class="span4" id="manhattan">
         							<h2>Manhattan</h2>
         							<p>Sur six villes, les joueurs construisent des étages de buildings dans le but de marquer des points. On joue autant de manches que de joueurs.</p>
         							<p><a class="btn" href="#">Voir la fiche du jeu &raquo;</a><a class="btn btn-primary" href="#">Jouer</a></p>
         						</div><!--/span-->
         						
                  </div><!--/row-->
                        <div class="row-fluid">
                                <div class="span4" id="bloom">
         							<h2>Bloom</h2>
         							<p>A vous de faire bonne cueillette pour vendre vos fleurs à bons prix. Mais quand vos adversaires marchent sur vos plates-bandes, c'est le bouquet !</p>
         							<p><a class="btn" href="#">Voir la fiche du jeu &raquo;</a><a class="btn btn-primary" href="#">Jouer</a></p>
         						</div><!--/span-->
                                <div class="span4" id="jeu4">
         							<h2>Jeu 4</h2>
         							<p>Description</p>
         							<p><a class="btn" href="#">Voir la fiche du jeu &raquo;</a><a class="btn btn-primary" href="#">Jouer</a></p>
         						</div><!--/span-->
                        </div><!--/row-->
                </div><!--/span-->
        </div><!--/row-->
        <hr>
        <footer>
                <p>&copy; Company 2013</p>
        </footer>        
</div><!--/.fluid-container-->

<script>
nom = prompt("Votre nom d'utilisateur : ", "Nom");
while (!nom || nom.length == 0 || nom == "Nom")
	nom = prompt("Votre nom d'utilisateur : ", "Nom");
$.ajax({
	url: "/connexion",
	type : 'GET',
	data: "nom="+nom,
	success: function(data){$(".hero-unit h1").text("Bonjour " + data); setMyself(data);},
	dataType: "text"
}); 

check_joueurs("manhattan",nom);
check_joueurs("rallyman",nom);
check_joueurs("bloom",nom);
check_joueurs("jeu4",nom);

function check_joueurs(jeu,myself) {
	$.ajax({
			url: "/check_joueurs",
			type : 'GET',
			data: "jeu=" + jeu,
			success: function(data){
				var ademarre;
				if (data == "Jouer") ademarre=1;
				else ademarre=0;
				$("#"+jeu+" a.btn-primary").text(data);
				$("#"+jeu+" a.btn-primary").attr("href", "attente?jeu="+jeu+"&nom="+myself+"&ademarre="+ademarre);
			},
			dataType: "text"
	});
}

function setMyself(nom) {
	$.ajax({
		url: "/setMyself",
		type : 'GET',
		data: "nom=" + nom,
		success: function(data){console.log("Myself set at " + data)},
		dataType: "text"
	});
}


function myself() {
	$.ajax({
		url: "/myself",
		type : 'GET',
		data: "",
		success: function(data){console.log("Myself is " + data)},
		dataType: "text"
	});
}

</script>

<jsp:include page="/views/partials/header.jsp" />