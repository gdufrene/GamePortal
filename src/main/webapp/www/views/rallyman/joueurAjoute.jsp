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
<jsp:include page="/views/partials/footer.jsp" />

<div id="notification" style="position:absolute; top:0px; right:0px; background-color:black; color:white; padding:5px; display:none;"><p>Connexion avec le serveur perdue. =(</p></div>
