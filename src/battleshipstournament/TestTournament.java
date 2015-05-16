/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates

 */
package battleshipstournament;

import battleship.implementations.Battleships;
import battleship.interfaces.BattleshipsPlayer;
import java.util.Collection;
import tournament.Tournament;
import tournament.game.GameFactory;
import tournament.impl.simpleui.TextTournamentUI;
import tournament.player.PlayerFactory;
import tournament.ui.TournamentUI;

/**
 *
 * 
 * @author Tobias Grundtvig
 */
public class TestTournament
{
    public static void main(String[] args) throws Exception
            
    {
        String path = "C:\\Users\\Steffen\\Documents\\NetBeansProjects\\BattleshipsTest";
        Loader loader = new Loader(path);
        
        Collection<PlayerFactory<BattleshipsPlayer>> examples = loader.loadCategory("E", 50);
        Collection<PlayerFactory<BattleshipsPlayer>> test = loader.loadCategory("TEST", 100);
        test.addAll(examples);
  
        GameFactory<BattleshipsPlayer> gameFactory = Battleships.getGameFactory();
        TournamentUI ui = new TextTournamentUI();
        
        System.out.println("Test tournament:");
        Tournament.run(gameFactory, test, 16, ui);       
    }
}
