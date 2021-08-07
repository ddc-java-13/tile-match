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

public class MainViewModel extends AndroidViewModel {

  private final MutableLiveData<Game> game;
  private final MutableLiveData<Throwable> throwable;
  private final GameRepository gameRepository;
  private final CompositeDisposable pending;
  private final Random rng;

  public MainViewModel(@NonNull Application application) {
    super(application);
    game = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    rng = new Random();
    gameRepository = new GameRepository(application, rng);
    pending = new CompositeDisposable();
    startGame();
  }

  public LiveData<Game> getGame() {
    return game;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

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
