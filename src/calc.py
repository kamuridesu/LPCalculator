import os
import sys
from datetime import datetime
import random

class Log:
    """Class for creating the duel logs
    Parameters:
        - logname: name of the log file

    Methods:
        - checkIfFolderExists(folder: str) -> str: checks if the folder exists and return its path
        - createFile() -> None: creates the log file
        - log(content: str) -> None: writes the content to the log file
    """
    def __init__(self, logname: str="") -> None:
        self.save_folder: str = self.checkIfFolderExists("logs")
        self.logname: str = logname
        if logname == "":
            timestamp: str = str(datetime.now())
            timestamp = timestamp.split(".")[0]
            self.logname = "log " + timestamp
        self.createFile()

    def checkIfFolderExists(self, folder: str) -> str:
        folder_path: str = os.path.join(os.getcwd(), folder)
        if not os.path.isdir(folder_path):
            os.mkdir(folder_path)
        return folder_path

    def createFile(self) -> None:
        file: str = os.path.join(self.save_folder, self.logname)
        with open(file, "w", encoding="utf-8") as file:
            file.write("")

    def log(self, content: str) -> None:
        file: str = os.path.join(self.save_folder, self.logname)
        timestamp: str = str(datetime.now())
        timestamp = timestamp.split(".")[0]

        with open(file, "a", encoding="utf-8") as file:
            file.write(timestamp + " " + str(content) + "\n")

class Player:
    """Creates the Player object
    Parameters:
         - life_points: the number of life points of the player, default: 8000
         - playername: the name of the player, default: guest
         - playerid: the id of the player, default: 0
         - log: the file to save the log info, default: new log file
    Methods:
        Magic Methods:
             - __sub__(value: int -> int: subtract the life points and log to the life
             - __add__(value: int -> int: adds the life points and log to the file
             - __str__() -> str: the output when printed
    """
    def __init__(self, life_points: int=8000, playername: str="guest", playerid=0, log: Log=Log()) -> None:
        self.lifepoints: int = life_points
        self.playername: str = playername
        self.playerid: str = playerid
        self.duel_log: str = log

    def __sub__(self, value: int) -> int:
        self.duel_log.log("Player " + self.playername + " has lost -" + str(value) + " Life Points")
        self.lifepoints = self.lifepoints - value
        return self.lifepoints

    def __add__(self, value: int) -> int:
        self.duel_log.log("Player " + self.playername + " has gained +" + str(value) + " Life Points")
        self.lifepoints = self.lifepoints + value
        return self.lifepoints

    def __str__(self) -> str:
        out: str = ""
        out += "Player ID: " + str(self.playerid) + "\n"
        out += "Name: " + self.playername + "\n"
        out += "LP: " + str(self.lifepoints) + "\n"
        return out


class Game:
    """
    ### TODO: implement a start function that retuns all the players ###
    Game class, it defines our game, creates the player and the log, and sets the defaults
    Parameters:
        - n_of_players: the number of player, default: 2
        - lifepoints_base: the default life points to be used, default: 8000
    Methods:
        - createPlayer() -> list: creates the players and saves it to the players list
        - getPlayer(playername: str) -> Player: retuns the current player object
        - status() -> None: shows the current game status
        - tossCoin(choice: str) -> bool: toss a coin and, if the choice is set, returns True if right, else always return False
    """
    def __init__(self, n_of_players: int=2, lifepoints_base: int=8000) -> None:
        self.nb_of_players: int = n_of_players
        self.lp_base: int = lifepoints_base
        self.duel_log: Log = Log()
        self.players: list = self.createPlayers()
        
    def createPlayers(self) -> list:
        playerlist: list = []
        for i in range(self.nb_of_players):
            # playername = input("Enter the playername: ")
            playername: str = "player " + str(i)
            playerlist.append(Player(playername=playername, life_points=self.lp_base, playerid=i, log=self.duel_log))
        return playerlist

    def getPlayer(self, playername: str) -> Player:
        for x in self.players:
            if x.playername == playername:
                return x

    def status(self) -> None:
        for player in self.players:
            print(player)

    def tossCoin(self, choice: str="") -> bool:
        choosen: str = random.choice(["heads", "tails"])
        self.duel_log.log("Coin tossed! It's " + choosen + "!")
        if choice != "":
            if choice == choosen:
                return True
        return False


if __name__ == "__main__":
    game: Game = Game()
    p1: Player = game.getPlayer("player 0")
    p2: Player = game.getPlayer("player 1")
    game.status()
    p1 - 3999
    p2 + 1000
    game.status()
