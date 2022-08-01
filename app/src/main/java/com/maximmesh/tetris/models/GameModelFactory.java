package com.maximmesh.tetris.models;

import com.maximmesh.tetris.presenters.GameModel;

public class GameModelFactory {
   private GameModelFactory(){
   }

   public static GameModel newGameModel(GameType type){
      switch (type){
         case TETRIS:
            return new TetrisGameModel();
         default:
            return null;
      }
   }
}
