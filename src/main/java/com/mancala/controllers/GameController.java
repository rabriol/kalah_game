package com.mancala.controllers;

import com.mancala.domain.*;
import com.mancala.logic.GameBoard;
import com.mancala.logic.WinnerChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

/**
 * Created by peo_rboliveira on 04/03/16.
 */
@Controller
public class GameController {
    public static final int STONES_PER_CUP = 6;

    @Autowired
    private HttpSession session;

    @Autowired
    private GameBoard gameBoard;

    @Autowired
    private WinnerChecker winnerChecker;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/play", method = RequestMethod.GET)
    public String start(Model model) {
        Player p1 = initPlayer(PlayerId.PLAYER_ONE);
        Player p2 = initPlayer(PlayerId.PLAYER_TWO);

        session.setAttribute(p1.getPlayerId().getValue(), p1);
        session.setAttribute(p2.getPlayerId().getValue(), p2);

        model.addAttribute("payload", new Payload());

        addCupValuesToModel(model, p1, p2);

        model.addAttribute("player", PlayerId.PLAYER_ONE.getValue());

        return "board";
    }

    @RequestMapping(value = "/play",
            method = RequestMethod.POST)
    public String play(@ModelAttribute Payload payload, Model model) {
        Player p1 = (Player)session.getAttribute(PlayerId.PLAYER_ONE.getValue());
        Player p2 = (Player)session.getAttribute(PlayerId.PLAYER_TWO.getValue());

        if (PlayerId.get(payload.getPlayer()).equals(PlayerId.PLAYER_ONE)) {
            gameBoard.doMovement(payload.getIndex(), p1, p2);
        } else  {
            gameBoard.doMovement(payload.getIndex(), p2, p1);
        }

        winnerChecker.check(p1, p2);

        model.addAttribute("p1HasWin", p1.hasWin());
        model.addAttribute("p2HasWin", p2.hasWin());
        model.addAttribute("anyoneHasWin", p2.hasWin() || p1.hasWin());

        addCupValuesToModel(model, p1, p2);

        model.addAttribute("player", (p1.canPlay() ? p1.getPlayerId().getValue() : p2.getPlayerId().getValue()));

        return "board";
    }

    private void addCupValuesToModel(Model model, Player p1, Player p2) {
        model.addAttribute("mancala" + p1.getPlayerId().getNumber(), p1.getMancala().size());

        model.addAttribute("cup" + p1.getPlayerId().getNumber() + "0", p1.getCups().getStones(0));
        model.addAttribute("cup" + p1.getPlayerId().getNumber() + "1", p1.getCups().getStones(1));
        model.addAttribute("cup" + p1.getPlayerId().getNumber() + "2", p1.getCups().getStones(2));
        model.addAttribute("cup" + p1.getPlayerId().getNumber() + "3", p1.getCups().getStones(3));
        model.addAttribute("cup" + p1.getPlayerId().getNumber() + "4", p1.getCups().getStones(4));
        model.addAttribute("cup" + p1.getPlayerId().getNumber() + "5", p1.getCups().getStones(5));

        model.addAttribute("mancala" + p2.getPlayerId().getNumber(), p2.getMancala().size());

        model.addAttribute("cup" + p2.getPlayerId().getNumber() + "0", p2.getCups().getStones(0));
        model.addAttribute("cup" + p2.getPlayerId().getNumber() + "1", p2.getCups().getStones(1));
        model.addAttribute("cup" + p2.getPlayerId().getNumber() + "2", p2.getCups().getStones(2));
        model.addAttribute("cup" + p2.getPlayerId().getNumber() + "3", p2.getCups().getStones(3));
        model.addAttribute("cup" + p2.getPlayerId().getNumber() + "4", p2.getCups().getStones(4));
        model.addAttribute("cup" + p2.getPlayerId().getNumber() + "5", p2.getCups().getStones(5));
    }

    private Player initPlayer(PlayerId playerId) {
        return new Player(new Cups(STONES_PER_CUP), new Mancala(), playerId);
    }
}
