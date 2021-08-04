package edu.cnm.deepdive.tilematch.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.tilematch.model.pojo.Tile;
import edu.cnm.deepdive.tilematch.service.GalleryRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainViewModel extends AndroidViewModel {

  private final MutableLiveData<List<Tile>> tiles;
  private final MutableLiveData<Throwable> throwable;
  private final GalleryRepository galleryRepository;
  private final CompositeDisposable pending;
  private final Random rng;

  public MainViewModel(@NonNull Application application) {
    super(application);
    tiles = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    galleryRepository = new GalleryRepository(application);
    pending = new CompositeDisposable();
    rng = new Random();
    loadHits();
  }

  public LiveData<List<Tile>> getTiles() {
    return tiles;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  @SuppressLint("CheckResult")
  public void loadHits() {
    pending.add(
        galleryRepository.getGallery()
            .subscribe(
                (value) -> {
                  Collections.shuffle(value,rng);
                  tiles.postValue(value);
                },
                throwable::postValue
            )
    );
  }



}
