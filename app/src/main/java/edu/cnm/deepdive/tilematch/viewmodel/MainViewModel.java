package edu.cnm.deepdive.tilematch.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.tilematch.model.entity.Game;
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
    startGame();
  }

  /**
   * Getter for game live data.
   * @return
   */
  public LiveData<Game> getGame() {
    return game;
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
        gameRepository.startGame()
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

  private void setThrowable(Throwable throwable) {
    Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable);
    this.throwable.postValue(throwable);
  }
}
