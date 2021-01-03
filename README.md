# Minoscape
Réalisé par MANOUBI Farah, DENDOUNE Rayane & OBEYESEKARA Avishka  
manoubi.farah@yahoo.com, rayane.dendoune@gmail.com, avishka2007@gmail.com  
30/12/20  
Université Cergy-Pontoise  


## I. Introduction  

### 1) Contexte du projet  

Dans le cadre du module Developping Application du premier semestre de troisième année de Licence Informatique, les étudiants doivent réaliser en trinôme un projet qui sera développer en java, notamment avec le logiciel "Android Studio", en réutilisant certains éléments appris en cours et lors des TDs. Sur les différents sujets proposés par nos enseignants, nous avons décidé de choisir la réalisation d’un jeu sur mobile dont nous allons vous présenter l’objectif dans la partie suivante.

### 2) Objectifs du projet

L’objectif de notre projet consiste en la réalisation d’un jeu sur mobile. En effet, ce dernier a pour but de déplacer un personnage dans un labyrinthe en récoltant des pièces dispersées aléatoirement sur la map. Il doit également éviter de croiser le minotaure présent à l’intérieur du labyrinthe, au risque d’y perdre la vie. Ainsi, après avoir récolté la totalité des pièces, une porte de sortie apparaitra, le joueur pourra terminer la partie et accéder à un nouveau labyrinthe s’il le souhaite. Le but étant de terminer la partie en un temps record.

### 3) Organisation du rapport

Tout d’abord, la première partie de ce rapport concernera les spécifications du projet. Elle contiendra toutes les informations concernant les données du projet "Minoscape" c’est à dire les notions de bases, les contraintes mais également leurs fonctionnalités. Ensuite nous traiterons de la partie réalisation, dans laquelle nous présenterons la conception des différentes activités et aussi quelques aspects techniques. Puis, viendra la partie "Manuel utilisateur" qui sera consacrée à l’utilisateur. En effet, cette partie expliquera comment est-ce que l’utilisateur pourra interagir avec notre jeu. Enfin, nous arriverons à la partie conclusion, où nous allons donner le bilan final de notre projet ainsi que les améliorations possibles pour celui-ci.

## II. Spécification du projet

### 1)	Notions de base et contraintes du projet

#### a) Héros

Le héros correspond au personnage principal de notre jeu. Lors du lancement de la partie, ce dernier est positionné dans la première case du labyrinthe. Il possède dès le début 3 vies, si le joueur ne possède plus de vie la partie se termine. Il se déplace de case en case à l’aide de mouvements effectués par le gyroscope du téléphone. Les mouvements horizontaux permettent de déplacer le personnage à gauche ou à droite. Quant aux mouvements verticaux, ils permettent de déplacer le personnage vers le haut ou vers le bas.

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

## III.	Conception et réalisation du projet  

Notre jeu est composé au totale de 5 activités :  
* MainActivity qui correspond à la page d’accueil de notre jeu  
* GameActivity qui est là page où se déroulera la partie du joueur  
* BreakActivity qui représente la page de pause au cours d’une partie  
* RulesActivity dans laquelle les règles du jeu sont affichées  
* HighScore qui contiendra les meilleurs scores du joueur  
* SettingsActivity qui permet au joueur de changer le niveau de difficulté  

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

Pour ce projet, nous avons aussi utiliser des boites de dialogues à différents emplacements. Tout d’abord, nous avons décidé d’utiliser une boite de dialogue dans la page « MainActivity » afin de permettre à l’utilisateur de choisir son niveau de difficulté. De plus, une boite de dialogue apparait à la fin de la partie si l’utilisateur à gagner ou perdu la partie avec en conséquence un message de victoire ou de défaite.  

## IV. Manuel d'utilisateur  


## V. Conclusion  

## VI. Références  
  
Pour la création du labyrinthe aléatoire :  
-	https://youtu.be/I9lTBTAk5MU  
-	https://youtu.be/iri0wZ3NvdQ  
-	https://youtu.be/kiG1BUa34lc  
-	https://youtu.be/IMan30VNi3A


