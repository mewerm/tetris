package com.maximmesh.tetris.views;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.maximmesh.tetris.R;
import com.maximmesh.tetris.models.GameModelFactory;
import com.maximmesh.tetris.models.GameType;
import com.maximmesh.tetris.presenters.GamePresenter;
import com.maximmesh.tetris.presenters.GameTurn;

public class TetrisActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.tetris_main);

      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
      MediaPlayer mp = MediaPlayer.create(TetrisActivity.this, R.raw.game_turn_sound);

      GameFrame gameFrame = findViewById(R.id.game_container);
      TextView gameScoreText = findViewById(R.id.game_score);
      TextView gameStatusText = findViewById(R.id.game_status);
      Button gameCtlBtn = findViewById(R.id.game_ctl_btn);

      GamePresenter gamePresenter = new GamePresenter();
      gamePresenter.setGameModel(GameModelFactory.newGameModel(GameType.TETRIS));
      gamePresenter.setGameView(GameViewFactory.newGameView(gameFrame, gameScoreText, gameStatusText, gameCtlBtn));

      Button upBtn = findViewById(R.id.up_btn);
      Button downBtn = findViewById(R.id.down_btn);
      Button leftBtn = findViewById(R.id.left_btn);
      Button rightBtn = findViewById(R.id.right_btn);
      Button fireBtn = findViewById(R.id.fire_btn);
      Button startMusic = findViewById(R.id.music_start_btn);
      Button stopMusic = findViewById(R.id.music_stop_btn);

      upBtn.setOnClickListener(v -> gamePresenter.turn(GameTurn.UP));
      downBtn.setOnClickListener(v -> gamePresenter.turn(GameTurn.DOWN));
      leftBtn.setOnClickListener(v -> gamePresenter.turn(GameTurn.LEFT));
      rightBtn.setOnClickListener(v -> gamePresenter.turn(GameTurn.RIGHT));
      fireBtn.setOnClickListener(v -> gamePresenter.turn(GameTurn.FIRE));
      gameCtlBtn.setOnClickListener(v -> gamePresenter.changeStatus());

      startMusic.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            mp.start();
         }
      });

      stopMusic.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            mp.pause();

         }
      });

      gamePresenter.init();
   }
}