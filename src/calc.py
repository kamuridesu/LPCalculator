import os
import sys
from datetime import datetime

class Log:
    def __init__(self, logname: str="") -> None:
        self.save_folder = self.checkIfFolderExists("logs")
        self.logname = logname
        if logname == "":
            timestamp = str(datetime.now())
            timestamp = timestamp.split(".")[0]
            self.logname = "log " + timestamp
        self.createFile()

    def checkIfFolderExists(self, folder: str) -> str:
        folder_path = os.path.join(os.getcwd(), folder)
        if not os.path.isdir(folder_path):
            os.mkdir(folder_path)
        return folder_path

    def createFile(self) -> None:
        file = os.path.join(self.save_folder, self.logname)
        with open(file, "w", encoding="utf-8") as file:
            file.write("")

    def log(self, content: str) -> None:
        file = os.path.join(self.save_folder, self.logname)
        timestamp = str(datetime.now())
        timestamp = timestamp.split(".")[0]

        with open(file, "a", encoding="utf-8") as file:
            file.write(timestamp + " " + str(content) + "\n")

class Player:
    def __init__(self, life_points: int=8000, playername: str="guest", playerid=0, log: Log=Log()) -> None:
        self.lifepoints = life_points
        self.playername = playername
        self.playerid = playerid
        self.duel_log = log

    def __sub__(self, value: int) -> int:
        self.duel_log.log("Player " + self.playername + " has lost -" + str(value) + " Life Points")
        self.lifepoints = self.lifepoints - value
        return self.lifepoints

    def __add__(self, value: int) -> int:
        self.duel_log.log("Player " + self.playername + " has gained +" + str(value) + " Life Points")
        self.lifepoints = self.lifepoints + value
        return self.lifepoints

    def __str__(self) -> str:
        out = ""
        out += "Player ID: " + str(self.playerid) + "\n"
        out += "Name: " + self.playername + "\n"
        out += "LP: " + str(self.lifepoints) + "\n"
        return out


class Game:
    def __init__(self, n_of_players: int=2, lifepoints_base: int=8000) -> None:
        self.nb_of_players = n_of_players
        self.lp_base = lifepoints_base
        self.duel_log = Log()
        self.players = self.createPlayers()
        
    def createPlayers(self) -> list:
        playerlist = []
        for i in range(self.nb_of_players):
            # playername = input("Enter the playername: ")
            playername = "player " + str(i)
            playerlist.append(Player(playername=playername, life_points=self.lp_base, playerid=i, log=self.duel_log))
        return playerlist

    def getPlayer(self, playername):
        for x in self.players:
            if x.playername == playername:
                return x

    def status(self):
        for player in self.players:
            print(player)

if __name__ == "__main__":
    pass
