package edu.cnm.deepdive.tilematch.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.tilematch.model.entity.Gallery;
import edu.cnm.deepdive.tilematch.service.GalleryRepository;
import io.reactivex.disposables.CompositeDisposable;

public class MainViewModel extends AndroidViewModel {

  private final MutableLiveData<Gallery.SearchResult> result;
  private final MutableLiveData<Throwable> throwable;
  private final GalleryRepository galleryRepository;
  private final CompositeDisposable pending;

  public MainViewModel(@NonNull Application application) {
    super(application);
    result = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    galleryRepository = new GalleryRepository(application);
    pending = new CompositeDisposable();
    loadHits();
  }

  @SuppressLint("CheckResult")
  public void loadHits() {
    galleryRepository.getGallery()
        .subscribe(
            result::postValue,
            throwable::postValue
        );
  }

}
