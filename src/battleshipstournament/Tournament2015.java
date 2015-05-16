/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipstournament;

import battleship.implementations.Battleships;
import battleship.interfaces.BattleshipsPlayer;
import java.util.ArrayList;
import java.util.Collection;
import tournament.Tournament;
import tournament.game.GameFactory;
import tournament.impl.simpleui.TextTournamentUI;
import tournament.player.PlayerFactory;
import tournament.ui.TournamentUI;

/**
 *
 * @author Tobias Grundtvig
 */
public class Tournament2015
{
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */

    public static void main(String[] args) throws Exception
    {
        Loader loader = new Loader("D:/Battleships");
        
        Collection<PlayerFactory<BattleshipsPlayer>> all = new ArrayList<>();
        Collection<PlayerFactory<BattleshipsPlayer>> examples = loader.loadCategory("E", 50);
        Collection<PlayerFactory<BattleshipsPlayer>> green = loader.loadCategory("G", 50);
        Collection<PlayerFactory<BattleshipsPlayer>> yellow = loader.loadCategory("Y", 50);
        Collection<PlayerFactory<BattleshipsPlayer>> red = loader.loadCategory("R", 50);
        Collection<PlayerFactory<BattleshipsPlayer>> tutors = loader.loadCategory("T", 50);
        Collection<PlayerFactory<BattleshipsPlayer>> champs = loader.loadCategory("C", 50);
        all.addAll(examples);
        all.addAll(green);
        all.addAll(yellow);
        all.addAll(red);
        all.addAll(tutors);
        all.addAll(champs);
        
        green.addAll(examples);
        yellow.addAll(examples);
        red.addAll(examples);
        tutors.addAll(examples);
        champs.addAll(examples);
        
        
        GameFactory<BattleshipsPlayer> gameFactory = Battleships.getGameFactory();
        TournamentUI ui = new TextTournamentUI();
        
        
        
        System.out.println("Green tournament:");
        Tournament.run(gameFactory, green, 16, ui);
        
        System.out.println("Yellow tournament:");
        Tournament.run(gameFactory, yellow, 16, ui);
        
        System.out.println("Red tournament:");
        Tournament.run(gameFactory, red, 16, ui);
        
        System.out.println("TA tournament:");
        Tournament.run(gameFactory, tutors, 16, ui);
        
        System.out.println("TOTAL WAR:");
        Tournament.run(gameFactory, all, 16, ui);
       
    }
}
