package com.maximmesh.tetris.views;

import android.widget.Button;
import android.widget.TextView;

import com.maximmesh.tetris.presenters.GameView;

public class GameViewFactory {
   private GameViewFactory(){
   }

   public static GameView newGameView(GameFrame gameFrame, TextView gameScoreText,
                                      TextView gameStatusText, Button gameCtlBtn){
      return new GameViewImpl(gameFrame, gameScoreText, gameStatusText,gameCtlBtn);
   }
}
