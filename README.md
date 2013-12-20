GamePortal
==========
  
# Installation et lancement #  
  
Afin de faire tourner l'application � 100%, il est n�cessaire d'installer le gestionnaire de base de donn�es H2 [voir ici](http://www.h2database.com/html/main.html).  
La base de donn�es est disponible dans le r�pertoire racine de ce projet (test.h2.db). 
Dans le fichier de configuration (WebConfig.java), on sp�cifie le driver. L'URL est "jdbc:h2:~/test", cela signifie que H2 va rechercher le fichier test.h2.db dans le r�pertoire 
utilisateur (user home directory).  
  
Pour compiler le projet : mvn compile  
Pour d�ployer le projet : mvn jetty:start  
  
Atteindre la page de d�marrage : [http://localhost:8080/rallyman-rejoindre](http://localhost:8080/rallyman-rejoindre)  
Atteindre la page qui d�montre le bon fonctionnement de la base de donn�es pour les scores : [http://localhost:8080/portail-afficherScores](http://localhost:8080/portail-afficherScores)  
  
  
# Travail r�alis� #
- Portail : gestion des scores (sauvegarde des scores, r�cup�ration des scores).  
- Rallyman : d�veloppement du jeu et des r�gles de base.  
  
  
# R�partition #
Tout le travail a �t� commit sur une [branche du projet GitHub](https://github.com/gdufrene/GamePortal/commits/rallyman).  
L'historique des commits est visible [sur cette page](https://github.com/gdufrene/GamePortal/commits/rallyman).  
  
# Auteurs #
BESSET Thomas  
DUVAL Yann  
PEDE Emmanuel  
RAULIN Alexandre  

