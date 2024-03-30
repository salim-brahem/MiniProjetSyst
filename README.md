Ce projet contient les implémentations des services de gestion de tâches utilisant Java RMI, gRPC et les sockets.

## Structure du Répertoire

Le répertoire du projet contient les éléments suivants :

1. **ProjetRmi** : Contient les fichiers pour le service de gestion de tâches utilisant Java RMI.
2. **ProjetGRPC** : Contient les fichiers pour le service de messagerie utilisant gRPC.
3. **ProjetSocket** : Contient les fichiers pour le service de chat utilisant les sockets.

Chaque sous-répertoire contient le code source ainsi que d'autres fichiers nécessaires pour chaque service respectif.

1/ Gestionnaire de Tâches avec Java RMI

Installation

- Assurez-vous d'avoir Java JDK installé sur votre système.
- Clonez ce dépôt GitHub sur votre machine locale.

Déploiement
- Ouvrez le dossier server dans votre IDE.
- Exécutez la classe GestionListeServeur pour démarrer le serveur RMI.
- Ouvrez le dossier client dans votre IDE.
- Exécutez la classe Client pour démarrer le client.

Utilisation
Au démarrage du client, vous serez invité avec un menu vous permettant de choisir parmi plusieurs options :
- Ajouter une tâche : Permet d'ajouter une nouvelle tâche à la liste.
- Supprimer une tâche : Permet de supprimer une tâche existante en spécifiant son ID.
- Afficher la liste des tâches : Affiche la liste complète des tâches actuelles.
- Quitter : Termine l'application.

2/ Service de Messagerie avec gRPC

Prérequis
- Java JDK installé sur votre système.
- Eclipse ou un autre IDE Java pour ouvrir et exécuter les projets.

Installation
- Clonez les dépôts GitHub GRPCProjetServeur et grpcClient sur votre machine locale.
- Ouvrez les projets dans votre IDE.

Déploiement
 Serveur
- Ouvrez le projet GRPCProjetServeur dans votre IDE.
- Exécutez la classe GRPCserver pour démarrer le serveur gRPC.
 Client
- Ouvrez le projet grpcClient dans votre IDE.
- Exécutez la classe ChatClient pour démarrer le client.

Utilisation
- Au démarrage du client, vous serez invité à choisir parmi plusieurs options :
   - Envoyer un message : Permet d'envoyer un message texte à un destinataire spécifié.
   - Quitter : Termine l'application.

     
3/ Service de Chat avec Sockets

Prérequis
- Java JDK installé sur votre système.

Installation

- Clonez le dépôt GitHub SocketChatProjet sur votre machine locale.
- Ouvrez le projet dans votre IDE.

Déploiement

 Serveur
- Ouvrez le projet Server dans votre IDE.
- Exécutez la classe ChatServer pour démarrer le serveur de chat.
 Client
- Ouvrez le projet Client dans votre IDE.
- Exécutez la classe ChatClient pour démarrer le client de chat.

Utilisation

 Client
- Au démarrage du client, vous pouvez entrer des messages texte qui seront envoyés au serveur.
- Pour quitter l'application, vous pouvez entrer "quit" ou "exit".
 Serveur
- Le serveur affiche les messages reçus des clients sur sa console et peut également envoyer des réponses aux clients.

