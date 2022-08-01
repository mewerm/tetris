package com.maximmesh.tetris.presenters;

public enum GameStatus{
   START("START"),
   PLAYING("PLAYING"),
   OVER("GAME OVER"),
   PAUSED("GAME PAUSED");

   private final String mValue;

   GameStatus(String value){
      mValue = value;
   }

   public String getValue(){
      return mValue;
   }
}
