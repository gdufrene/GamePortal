<jsp:include page="/views/partials/header.jsp" />
<h2></h2>
<table>
	<tr>
		<td>Manathan</td>
		<td id="manathan">
			<a href=""></a>
		</td>
	</tr>
	<tr>
		<td>RallyMan</td>
		<td id="rallyman">
			<a href=""></a>
		</td>
	</tr>
	<tr>
		<td>jeu3</td>
		<td id="jeu3">
			<a href=""></a>
		</td>
	</tr>
	<tr>
		<td>jeu4</td>
		<td id="jeu4">
			<a href=""></a>
		</td>
	</tr>
</table>
<p>
</p>


<script>
nom = prompt("Votre nom d'utilisateur : ", "Nom");

$.ajax({
	url: "/connexion",
	type : 'GET',
	data: "nom="+nom,
	success: function(data){$("h2").text("Bonjour " + data); setMyself(data);},
	dataType: "text"
}); 

check_joueurs("manathan",nom);
check_joueurs("rallyman",nom);
check_joueurs("jeu3",nom);
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
				$("#"+jeu+" a").text(data);
				$("#"+jeu+" a").attr("href", "attente?jeu="+jeu+"&nom="+myself+"&ademarre="+ademarre);
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

setInterval('myself()', 5000);
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