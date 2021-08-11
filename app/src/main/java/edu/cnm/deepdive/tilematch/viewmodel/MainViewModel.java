package edu.cnm.deepdive.tilematch.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.preference.PreferenceManager;
import edu.cnm.deepdive.tilematch.model.entity.Game;
import edu.cnm.deepdive.tilematch.model.entity.Game.Difficulty;
import edu.cnm.deepdive.tilematch.service.GameRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Random;

/**
 * MainViewModel extends AndroidViewModel.
 */
public class MainViewModel extends AndroidViewModel {

  private final MutableLiveData<Game> game;
  private final MutableLiveData<Throwable> throwable;
  private final GameRepository gameRepository;
  private final CompositeDisposable pending;
  private final Random rng;
  private final MutableLiveData<Difficulty> difficulty;
  private final SharedPreferences preferences;

  /**
   * MainViewModel constructor.
   * @param application
   */
  public MainViewModel(@NonNull Application application) {
    super(application);
    game = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    rng = new Random();
    gameRepository = new GameRepository(application, rng);
    pending = new CompositeDisposable();
    difficulty = new MutableLiveData<>();
    preferences = PreferenceManager.getDefaultSharedPreferences(application);
    startGame();
  }

  /**
   * Getter for game live data.
   * @return
   */
  public LiveData<Game> getGame() {
    return game;
  }

  public LiveData<Difficulty> getDifficulty() {
    return difficulty;
  }

  /**
   * Getter for throwable.
   * @return
   */
  public LiveData<Throwable> getThrowable() {
    return throwable;
  }



  /**
   * Subscribes on MutableLiveData for a game.
   */
  @SuppressLint("CheckResult")
  public void startGame() {
    pending.add(
        gameRepository.startGame(getDifficultyPreference())
            .subscribe(
                game::postValue,
                this::setThrowable
            )
    );
  }

  /**
   * Subscribes on clicks at given position in a game.
   * @param position
   */
  public void handleClick(int position) {

    //noinspection ConstantConditions
    pending.add(
        gameRepository.handleSelection(game.getValue(), position)
            .subscribe(
                game::postValue,
                this::setThrowable
            )
    );
  }

  public void setDifficulty(Difficulty difficulty) {
    this.difficulty.setValue(difficulty);
  }

  private void setThrowable(Throwable throwable) {
    Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable);
    this.throwable.postValue(throwable);
  }

  private Difficulty getDifficultyPreference() {
    return Difficulty.valueOf(preferences.getString("difficulty_preference", Difficulty.EASY.toString()));
  }

}
