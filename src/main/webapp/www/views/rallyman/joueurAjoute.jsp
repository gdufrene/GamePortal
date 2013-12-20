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
					<li><a href="/rallyman-partie">Rafraichir la page</a> </li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			Vous avez bien été ajouté à la partie !
			
			Suivez l'évolution du jeu ici : <a href="/rallyman-partie">évolution de la partie</a> !
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function() {
		window.setInterval(function() {
			$.ajax({
				type : "get",
				url : "/rallyman-hub",
				cache : false,
				data : '',/* 'firstName=' + $("#firstName").val() + "&lastName=" + $("#lastName").val() + "&email=" + $("#email").val(), */
				success : function(response) {
					$("#notification").css("display","none");
					console.log(response);
					if (response=="true"){
						window.location.href = "/rallyman-partie";
					}
				},
				error : function() {
					$("#notification").css("display","block");
				}
			});
		}, 2500);
	});
</script>

Vous êtes maintenant en attentes des autres joueurs !

<div id="notification" style="position:absolute; top:0px; right:0px; background-color:black; color:white; padding:5px; display:none;"><p>Connexion avec le serveur perdue. =(</p></div>

<jsp:include page="/views/partials/footer.jsp" />

