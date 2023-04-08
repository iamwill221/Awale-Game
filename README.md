# Awale Game
L’Awalé, appelé aussi Wouré (au Senegal) ou Awélé, est un jeu traditionnel africain qui est populaire dans de nombreux pays d'Afrique de l'Ouest, notamment au Burkina Faso, au Mali et au Niger.
Ce jeu se fait par deux joueurs. L’objectif est de s’emparer d’un maximum de graines. Le joueur qui a le plus de graines à la fin de la partie l’emporte. Le plateau est placé horizontalement entre les deux joueurs. Chaque joueur place 4 graines dans chacun des 6 trous devant lui.


## Presentation
It is a command-line based game playable by 2 players

## Démarrage
Au démarrage le programme demande à chaque joueur de saisir son nom. Ici la partie se jouera entre William et Moussa
![image](https://user-images.githubusercontent.com/103327500/230687337-507f5096-848e-4514-9606-4aec11e782cd.png)

## Affichage du plateau de jeu
Une fois les noms de joueurs connus, le plateau s’affiche chaque joueur a 4 graines dans chaque et les greniers sont vides. Le grenier de chaque joueur se trouvant à sa droite
![image](https://user-images.githubusercontent.com/103327500/230687411-8e086a1f-76d8-4e7d-a172-80b4ec4d89cc.png)

## Phase de jeu
La partie débute et c’est le tour de Moussa. Il choisit une case
![image](https://user-images.githubusercontent.com/103327500/230687526-b6190771-798d-4388-9bc2-e08716451aaa.png)
Tant que la case choisie n’est pas entre 0 et 5 (inclusif). Le programme redemande au joueur de saisir une nouvelle fois le numéro du trou. Dès que le numéro de la case est correcte, il distribue les graines prises et affiche la nouvelle configuration du plateau.
Le programme demande à l’autre joueur de saisir le numéro de la case à jouer et ainsi de suite.

## Capture
A chaque fois qu’il y’ait une capture, le programme affiche la nouvelle configuration avec la mention. 
Si la case précédente à la dernière graine contient 2 ou 3 graines, une autre capture est faite et ainsi de suite (rafale). Par contre, il est interdit de capturer toutes les graines d’un joueur en un coup.
![image](https://user-images.githubusercontent.com/103327500/230687583-0b9dbbf7-3ab5-41ef-99c9-7d7645526341.png)

## Fin du jeu
Lorsqu'un joueur n’a plus de graines dans son camp, le jeu se termine.
Il affiche le nom des joueurs ainsi que le score
![image](https://user-images.githubusercontent.com/103327500/230687616-cc088c62-e25f-4c8f-bd63-7222f446385d.png)
