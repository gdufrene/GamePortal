<jsp:include page="/views/partials/header.jsp" />
Vous avez bien été ajouté à la partie !

<script type="text/javascript">
	$(function() {
		window.setInterval(function() {
			$.ajax({
				type : "get",
				url : "/rallyman-hub",
				cache : false,
				data : '',/* 'firstName=' + $("#firstName").val() + "&lastName=" + $("#lastName").val() + "&email=" + $("#email").val(), */
				success : function(response) {
					console.log(response);
					if (response=="true"){
						window.location.href = "/rallyman-partie";
					}
				},
				error : function() {
				}
			});
		}, 2500);
	});
</script>

Vous êtes maintenant en attentes des autres joueurs !
<jsp:include page="/views/partials/footer.jsp" />

<div style="float:right; top:0px"><p>Connexion avec le serveur perdue. =(</p></div>