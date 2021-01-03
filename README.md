<h1 align="center"> Minoscape </h1>
<div align="center">
<img src="/capture/mino.png" alt="Minotaure" width=200/>  

Réalisé par MANOUBI Farah, DENDOUNE Rayane & OBEYESEKARA Avishka  
manoubi.farah@yahoo.com, rayane.dendoune@gmail.com, avishka2007@gmail.com  
30/12/20  
Université Cergy-Pontoise 
</div>



<h2 align="center"> I. Introduction </h2>

### 1) Contexte du projet  

Dans le cadre du module Developping Application du premier semestre de troisième année de Licence Informatique, les étudiants doivent réaliser en trinôme un projet qui sera développer en java, notamment avec le logiciel "Android Studio", en réutilisant certains éléments appris en cours et lors des TDs. Sur les différents sujets proposés par nos enseignants, nous avons décidé de choisir la réalisation d’un jeu sur mobile dont nous allons vous présenter l’objectif dans la partie suivante.

### 2) Objectifs du projet

L’objectif de notre projet consiste en la réalisation d’un jeu sur mobile. En effet, ce dernier a pour but de déplacer un personnage dans un labyrinthe en récoltant des pièces dispersées aléatoirement sur la map. Il doit également éviter de croiser le minotaure présent à l’intérieur du labyrinthe, au risque d’y perdre la vie. Ainsi, après avoir récolté la totalité des pièces, une porte de sortie apparaitra, le joueur pourra terminer la partie et accéder à un nouveau labyrinthe s’il le souhaite. Le but étant de terminer la partie en un temps record.

### 3) Organisation du rapport

Tout d’abord, la première partie de ce rapport concernera les spécifications du projet. Elle contiendra toutes les informations concernant les données du projet "Minoscape" c’est à dire les notions de bases, les contraintes mais également leurs fonctionnalités. Ensuite nous traiterons de la partie réalisation, dans laquelle nous présenterons la conception des différentes activités et aussi quelques aspects techniques. Puis, viendra la partie "Manuel utilisateur" qui sera consacrée à l’utilisateur. En effet, cette partie expliquera comment est-ce que l’utilisateur pourra interagir avec notre jeu. Enfin, nous arriverons à la partie conclusion, où nous allons donner le bilan final de notre projet ainsi que les améliorations possibles pour celui-ci.


<h2 align="center"> II. Spécification du projet </h2>


### 1)	Notions de base et contraintes du projet

#### a) Héros

L'utilisateur a le choix entre 3 héros différents avant de débuter la partie. Lors du lancement de la partie, ce dernier est positionné dans la première case du labyrinthe. Il possède dès le début 3 vies, si le joueur ne possède plus de vie la partie se termine. Il se déplace de case en case à l’aide de mouvements effectués par le gyroscope du téléphone. Les mouvements horizontaux permettent de déplacer le personnage à gauche ou à droite. Quant aux mouvements verticaux, ils permettent de déplacer le personnage vers le haut ou vers le bas.

#### b) Minotaure

Le minotaure est un personnage immobile, qui est positionné aléatoirement dans le labyrinthe. Il a pour but d’empêcher le héros de récupérer toutes les pièces afin qu’il ne puisse pas sortir du labyrinthe. En effet, lorsque le héros et le minotaure se croise, le nombre de vie du joueur décrémente de 1. 

#### c) Labyrinthe

La map du jeu est représenté par un labyrinthe dont la taille est modifiée selon le niveau de difficulté choisie préalablement par l’utilisateur. Le personnage est positionné initialement à la première case du labyrinthe (en haut à gauche) et la porte de sortie apparaitra (en bas à droite) une fois que le joueur aura récupérer toutes les pièces. A l’intérieur du labyrinthe, on retrouve le héros, le minotaure, les pièces dispersées, et la porte de sortie.

#### d) Pièces

Les pièces sont au nombre de 5. Elles sont disposées aléatoirement dans le labyrinthe. Une fois que l’ensemble des pièces auront été récupérées par le joueur, la porte de sortie apparaitra.

#### e)	Chronomètre

Lorsque la partie débute, un chronomètre est lancé. Il permet d’indiquer le temps que le joueur aura mis pour terminer la partie. Si le jeu est mis sur pause, le chronomètre sera alors suspendu et reprendra une fois que le joueur aura décider de reprendre la partie. De même si l’utilisateur décide de mettre l’application en second plan et d’y revenir par la suite. Après avoir terminé, le temps est enregistré dans une base de données, et permettra au joueur de visualiser ses 3 meilleures performances à partir de la page « meilleur score ».

#### f)	Porte de sortie

Lorsque le héros aura récupéré la totalité des pièces, une porte de sortie se matérialisera à la dernière case en bas a droite de notre labyrinthe. Cette porte de sortie symbolisera la fin du niveau.

### 2)	Fonctionnalités attendues du projet

Les fonctionnalités de notre programme sont les suivantes :  

* Utilisation du gyroscope afin de déplacer le personnage  
* Utilisation de SQLite afin de stocker les scores du joueur  
* Utilise plus de 3 activités différentes  
* Gère efficacement les cycle de vie de l’activité  
* Permet au joueur de choisir son niveau de difficulté grâce aux paramètres  
* Possède un écran de jeu  
* Possède un écran de pause  

### 3)	Fonctionnalités du jeu

* Déplacer le personnage dans le labyrinthe.  
* Récupérer des pièces.  
* Mettre le jeu sur pause.  
* Accéder au paramètre.  
* Reprendre la partie.  
* Recommencer la partie.  
* Accéder à la page des meilleurs scores.  
* Accéder à la page concernant les règles du jeu.  

### 4)	Outils de développement

1. Java  
2. Android Studio  
3. GitHub  
4. SQLite  

Ces différents outils de développements sont ceux qui nous ont été imposés par notre enseignant et que nous avons utilisés au cours des TDs en Developping Application. Pour le développement en java nous avons utilisés le logiciel Android Studio. Nous avons synchronisé nos différents travaux en utilisant le service web d’hébergement GitHub qui nous a beaucoup servis pour travailler en groupe. Enfin, nous avons utilisé le service de base de données SQLite afin de stocker de manière efficace les scores du joueur et lui renvoyer ses 3 meilleurs scores.

<h2 align="center"> III.	Conception et réalisation du projet </h2>


Notre jeu est composé au totale de 5 activités :  
* MainActivity qui correspond à la page d’accueil de notre jeu  
* GameActivity qui est là page où se déroulera la partie du joueur  
* BreakActivity qui représente la page de pause au cours d’une partie  
* RulesActivity dans laquelle les règles du jeu sont affichées  
* HighScore qui contiendra les meilleurs scores du joueur  
* SettingsActivity qui permet au joueur de changer le niveau de difficulté  

<div align="center"><img src="/capture/lien.PNG" alt="Boite de dialogue avant le jeu" width=400/></div>

### 1)	Les différentes activités  

#### a) MainActivity  

Depuis la page principale « MainActivity » nous pouvons accéder à « GameActivity », « RulesActivity » et « ScoreActivity ».  
En effet, la page principale permet d’accéder à la page de jeu. Pour y accéder, l’utilisateur devra choisir son niveau de difficulté grâce à une boite de dialogue entre :  
*	Paladin  
*	Héros aguerri  
*	Guerrier légendaire  

La taille du labyrinthe du jeu s’adaptera donc au niveau de difficulté choisi par l’utilisateur.  
Cette page permet aussi d’accéder aux règles du jeu pour les gens qui vienne de découvrir l’application et également aux 3 meilleurs scores fait par l’utilisateur.  


#### b) GameActivity  

A partir de la page « GameActivity », nous avons accès à la page « BreakActivity » et « SettingsActivity ».  
Comme dit précédemment, la taille du labyrinthe s’adaptera donc au niveau de difficulté choisi par l’utilisateur :  
*	Le niveau Paladin correspond à un labyrinthe de taille 8x4  
*	Le niveau Héros aguerri correspond à un labyrinthe de taille 10x5  
*	Le niveau Guerrier légendaire correspond à un labyrinthe de taille 14x9  

Le jeu débute avec une totalité de 5 pièces disséminées aléatoirement dans le labyrinthe.  
Le jeu peut se terminer de deux différentes façons :  
*	L’utilisateur n’a plus de vie dans quel cas un message de défaite lui sera transmis via une boite de dialogue  
*	L’utilisateur a récupéré les 5 pièces et a réussi à accéder à la porte de sortie dans quel cas un message de victoire lui sera transmis via une boite de dialogue  

L’utilisateur sera aussi en mesure de changer la difficulté du jeu en pleine partie en allant sur la page de « SettingsActivity »  
Il pourra également mettre le jeu sur pause en accédant à la page « BreakActivity »  


#### c) SettingsActivity  

A partir de la page « SettingsActivity », nous avons uniquement accès à la page « GameActivity ».  
L’utilisateur pourra, comme dis précédemment, changer le niveau de difficulté du jeu s’il le souhaite.  
Ou il pourra revenir au jeu s’il ne veut pas changer de niveau de difficulté.  

#### d) BreakActivity  

Dans la page « BreakActivity » nous pouvons accéder aux pages « GameActivity » et « MainActivity ».  
Dans cette page, l’utilisateur pourra mettre le jeu en pause. En effet, il pourra y apercevoir différente information concernant la partie en cours tel que le temps écoulé depuis le début de la partie, le nombre de pièces récupéré ainsi que la vie qu’il lui reste.  
A partir de cette même page, l’utilisateur sera dans la capacité de recommencer la partie avec le même labyrinthe ainsi que les pièces et le minotaure disposés aux mêmes emplacements qu’avant.  
Il pourra aussi, s’il le souhaite, arrêter la partie et aller au menu principal.  

#### e) RulesActivity  

A partir de la page « RulesActivity », nous pouvons uniquement accéder à la page « MainActivity ».  
En effet, cette page est accessible uniquement à partir de la page principale « MainActivity » et permet au joueur de connaitre les règles du jeu.  


#### f) ScoreActivity  

A partie de la page « ScoreActivity », nous pouvons uniquement accéder à la page « MainActivity ».  
En effet, cette page est accessible uniquement à partir de la page principale « MainActivity » et permet au joueur de voir ses 3 meilleurs scores sur toutes les parties qu’il a faite.   
Les différents scores montreront le niveau où le meilleur score a été réalisé, le temps effectué pour terminer ce niveau, et le niveau de difficulté choisi.  

### 2)	Aspects techniques

Dans cette partie, nous allons vous montrer les différents aspects techniques de notre projet  

#### a)	Cycle de vie de l’activité

Lorsque nous lançons notre application, nos activités s’exécutent grâce à la méthode « onCreate » présente dans chacune de nos activités.  
Lorsque nous sortons de l’application pendant une partie, notre Thread de temps s’arrête grâce à la méthode « onPause » et reprend lorsque le joueur décide de revenir sur l’application à l’aide de la méthode « onResume ».  

#### b)	Intent

Depuis la méthode « startActivity() » présente dans chacune de nos activités, nous avons défini un intent qui est utiliser pour lancer toutes nos activités.  

#### c)	View pour le labyrinthe

Notre classe java « Labyrinthe » hérite de la classe View. Cela nous permet de l’intégrer dans le fichier XML de « GameActivity » afin que tous les changements effectués dans la classe « Labyrinthe » se passe également dans « GameActivity ». Ainsi l’affichage de notre labyrinthe, des pièces, du minotaure, de la porte de sortie, du thread ainsi que les compteurs se passera dans « GameActivity » à travers le View de la classe java « Labyrinthe ». De ce fait, tous les traitements (déplacement, compteur vie/pièce etc …) s’effectuent en réalité dans la classe java « Labyrinthe ».  
Il faut aussi savoir que tous les labyrinthes sont générés de manière aléatoire. En effet, il est impossible d’avoir deux fois le même labyrinthe.  

#### d)	Niveau de difficulté

Le niveau de difficulté est paramétrable par l’utilisateur. En effet, il peut choisir entre 3 différents niveaux de difficulté :  
*	Paladin  
*	Héros aguerri  
*	Guerrier légendaire  

Ces différents niveaux de difficulté correspondent en réalité à la taille du labyrinthe. En effet :  
*	Le niveau Paladin correspond à un labyrinthe de taille 8x4  
*	Le niveau Héros aguerri correspond à un labyrinthe de taille 10x5  
*	Le niveau Guerrier légendaire correspond à un labyrinthe de taille 14x9   

Suivant le niveau de difficulté du jeu, les images seront redimensionnées selon la taille de la case. En effet, si l’utilisateur choisit le niveau « Guerrier Légendaire », la taille de la case sera petite étant donné que le nombre de cellule du labyrinthe est plus important, et par conséquent, les images le seront aussi. En revanche, si l’utilisateur choisit le niveau « Paladin », la taille de la case sera plus grande étant donné que le nombre de cellule du labyrinthe est plus faible, ainsi les images le seront également.  

#### e)	Gyroscope

Pour ce projet, nous avons décidé d’utiliser gyroscope en tant que capteur de mouvement. Effectivement, les déplacements de notre personnage se font uniquement grâce à ce capteur.  
Si le téléphone est orienté vers le bas (écran vers le sol), le personnage se déplacera d’une case vers le bas sur l’axe des ordonnées.  
Si le téléphone est orienté vers le haut (écran vers le ciel), le personnage se déplacera d’une case vers le haut sur l’axe des ordonnées.  
Si le téléphone est orienté vers la droite, le personnage se déplacera d’une case vers la droite sur l’axe des abscisses.  
Si le téléphone est orienté vers la gauche, le personnage se déplacera d’une case vers la gauche sur l’axe des abscisses.  

#### f)	Thread

Afin de créer une ambiance de jeu, nous avons décidé de créer un thread pour le temps. En effet, le thread s’incrémente toutes les secondes afin de donnée une base de temps au joueur, le but étant bien sûr de terminer le jeu en un temps record.  
Le thread se lance à chaque début de partie et s’arrête a chaque fois que le joueur mettra le jeu en pause ou qu’il mette l’application en second plan. Mais le thread reprendra au moment où il s’était arrêté.  

#### g)	Base de données

Afin de stocker les informations de l’utilisateur, nous avons décidé d’utiliser une base de données interne qui est SQLite. En effet, cette base de données nous permet de récupérer les informations en fin de partie tel que le niveau atteint, le temps écouler pour finir la partie, ainsi que la difficulté du niveau. Toutes ces informations nous permettent à la fin de sélectionner les 3 meilleurs scores de l’utilisateur et de les afficher dans la page « ScoreActivity ». 

#### h)	Boite de dialogue  

Pour ce projet, nous avons aussi utiliser des boites de dialogues à différents emplacements. Tout d’abord, nous avons décidé d’utiliser une boite de dialogue dans la page « MainActivity » afin de permettre à l’utilisateur de choisir son niveau de difficulté ainsi que le personnage avec lequel il veut jouer. De plus, une boite de dialogue apparait à la fin de la partie si l’utilisateur à gagner ou perdu la partie avec en conséquence un message de victoire ou de défaite.  

<h2 align="center"> IV. Manuel d'utilisateur </h2>

Cette partie est consacrée à l’utilisateur. Elle va permettre d’expliquer le fonctionnement de l’application et comment l’utilisateur va pouvoir interagir avec celle-ci.  
Lorsque l’utilisateur lance l’application, la page principale s’affiche alors à l’écran (à savoir la page « MainActivity »)  

<div align="center"><img src="/capture/ecranPrincipale.PNG" alt="Ecran Principal" width=200/></div>

Sur cette page de menu principal, l’utilisateur peut visualiser différents boutons tel que le bouton « Règles du jeu », le bouton « Meilleurs scores » et « Lancer jeu ». Lorsque l’utilisateur appuie sur le bouton « Règles du jeu » il sera redirigé vers la page de règle (à savoir « RulesActivity »). S’il appuie sur le bouton « Meilleurs scores », il sera alors redirigé vers la page affichant les 3 meilleurs score (à savoir « ScoreActivity »). Enfin, lorsque l’utilisateur clique sur le bouton « Lancer jeu », une boite de dialogue apparaitra alors à l’écran et permettra à l’utilisateur de choisir le niveau de difficulté souhaité.  

Si nous appuyons sur « Règles du jeu » à partir du menu principal, la page « RulesActivity » se lancera :  

<div align="center"><img src="/capture/regleJeu.PNG" alt="Regle du jeu" width=200/></div>

Sur cette page, l’utilisateur pourra lire toutes les règles du jeu et pourra par la suite appuyer sur le bouton retour qui le renverra vers le menu principal.  

Si nous appuyons sur « Meilleurs Scores » depuis le menu principal, la page « ScoreActivity » se lancera :  

<div align="center"><img src="/capture/meilleurScore.PNG" alt="Page des scores" width=200/></div>

Sur cette page, l’utilisateur pourra y apercevoir ses 3 meilleurs scores et pourra par la suite appuyer sur le bouton retour qui le renverra vers le menu principal.  

Si l’utilisateur appuie sur le bouton « Lancer jeu » depuis le menu principal, une boite de dialogue apparaitra :  

<div align="center"><img src="/capture/avantLancerjeu.PNG" alt="Boite de dialogue avant le jeu" width=200/></div>

Sur cette boite de dialogue, l’utilisateur pourra choisir le niveau de difficulté qu’il voudra puis en appuyant sur « Commencer » la page « GameActivity » s’affichera alors à l’écran et la partie débutera. Ou alors il peut décider d’appuyer sur le bouton « Retour » afin de rester sur la page principale.  

Si l’utilisateur décide de commencer une partie avec le niveau de difficulté « Paladin », un labyrinthe de taille 8x4 s’affichera alors à l’écran :  

<div align="center"><img src="/capture/labDebutant.PNG" alt="Difficulté Paladin" width=200/></div>

Si l’utilisateur décide de commencer une partie avec le niveau de difficulté « Héros aguerri », un labyrinthe de taille 10x5 s’affichera alors à l’écran :  

<div align="center"><img src="/capture/labInter.PNG" alt="Difficulté Heros Aguerri" width=200/></div>

Si l’utilisateur décide de commencer une partie avec le niveau de difficulté « Guerrier légendaire », un labyrinthe de taille 14x9 s’affichera alors à l’écran :  

<div align="center"><img src="/capture/labExpert.PNG" alt="Difficulté Guerrier Legendaire" width=200/></div>

Voici comment se présente la page « GameActivity » après avoir sélectionner son niveau à partir de la boite de dialogue :  

<div align="center"><img src="/capture/apresLancerDebutant.PNG" alt="Page de jeu" width=200/></div>

Sur cette page, nous pouvons apercevoir deux différents compteurs au bas de l’écran : L’un pour le nombre de vie, et l’autre pour le nombre de pièces récupérées, ainsi qu’un chronomètre qui mesurera le temps mis par l’utilisateur pour finir la partie.  
En haut de l’écran, on remarque deux différents boutons, l’un pour les paramètres, et l’autre pour mettre le jeu en pause. On peut également visualiser le niveau actuel affiché au dessus du labyrinthe.  

Si l’utilisateur appuie sur le bouton des paramètres à partir de la page de jeu « GameActivity », il sera alors redirigé vers « SettingsActivity » qui lui permettra alors de choisir un autre niveau de difficulté :  

<div align="center"><img src="/capture/parametre.PNG" alt="Page des paramètres" width=200/></div>

Si l’utilisateur appuie sur le bouton « Retour », cela le renverra vers la page de jeu où il était en continuant la même partie.  
Mais si l’utilisateur sélectionne un nouveau niveau de difficulté puis appuie sur le bouton « Commencer », une nouvelle partie débutera avec un nouveau labyrinthe redimensionner en conséquence. Il peut également changer de personnage s'il le souhaite en cliquant sur un des trois personnages visibles à l'écran.  

Si l’utilisateur appuie sur le bouton de pause à partir de la page de jeu « GameActivity », il sera alors redirigé vers « BreakActivity » qui lui permettra alors de mettre le jeu en pause :  

<div align="center"><img src="/capture/pagePause.PNG" alt="Page de Pause" width=200/></div>

A partir de cette page, l’utilisateur pourra reprendre la partie exactement là où elle a été interrompue c’est-à-dire avec les mêmes valeurs pour le compteur de temps, qui reprendra de nouveau.  
Dans le cas ou l’utilisateur voudrait recommencer la partie, le même labyrinthe sera redessiné avec les pièces à leur position initiale. Le compteur de pièce et de temps recommencera à 0 et le compteur de vie reviendra à 3.  
Si l’utilisateur appuie sur menu principal, cela le redirigera sur la page « MainActivity ».  

Le jeu qui se déroule dans « GameActivity » se terminera à deux conditions :  

* Si le joueur a perdu toutes ses vies, dans quel cas une boite de dialogue avec un message de défaite apparaitra  

<div align="center"><img src="/capture/perdu.PNG" alt="Perdu" width=200/></div>

* Si le joueur a récupéré l’intégralité des pièces et a réussi à accéder à la porte de sortie dans quel cas une boite de dialogue avec un message de victoire apparaitra

<div align="center"><img src="/capture/gagner.PNG" alt="Gagner" width=200/></div>

Dans ces deux cas, l’utilisateur sera dans la capacité d’accéder au menu principal en appuyant sur le bouton « menu » et commencer une nouvelle partie en appuyant sur l’autre bouton.  

<h2 align="center"> V. Conclusion </h2>

Dans cette section, nous résumons la réalisation du projet et nous présentons également les extensions et améliorations possibles du projet.  
En conclusion, nous avons traité en grande partie les attendus du projet. En effet, notre application gère efficacement les cycles de vie de l’activité. Elle comporte au totale 6 activités communiquant entre elles. Notre personnage se déplace dans le labyrinthe grâce au capteur de mouvement que nous avons choisit qui est le gyroscope. L’utilisateur peut paramétrer le niveau de difficulté qu’il souhaite avant chaque partie. Il peut également mettre le jeu sur pause et reprendre au moment voulu. Les scores obtenus sont stockés dans une base de données SQLite en local et il pourra accéder à ses trois meilleurs scores depuis une des pages du menu.  
Cependant, quelques améliorations auraient été les bienvenues par exemple que l'utilisateur puisse créer son propre personnage pour qu'il puisse évoluer avec au cours des différentes parties. De plus, nous aurions pu ajouter des déplacements au minotaure pour rendre le jeu un peu plus dynamique.   


<h2 align="center"> VI. Références   </h2>
  
Pour la création du labyrinthe aléatoire :  
-	https://youtu.be/I9lTBTAk5MU  
-	https://youtu.be/iri0wZ3NvdQ  
-	https://youtu.be/kiG1BUa34lc  
-	https://youtu.be/IMan30VNi3A


