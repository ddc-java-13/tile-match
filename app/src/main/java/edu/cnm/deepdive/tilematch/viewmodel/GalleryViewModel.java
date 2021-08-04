package edu.cnm.deepdive.tilematch.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.tilematch.model.dto.Image;
import edu.cnm.deepdive.tilematch.service.GalleryRepository;
import io.reactivex.disposables.CompositeDisposable;
import org.jetbrains.annotations.NotNull;

public class GalleryViewModel extends AndroidViewModel implements LifecycleObserver {

  private final MutableLiveData<Image> gallery;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;
  private final GalleryRepository galleryRepository;


  public GalleryViewModel(
      @NonNull @NotNull Application application) {
    super(application);
    galleryRepository = new GalleryRepository(application);
    gallery = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

  public LiveData<Image> getGallery() {
    return gallery;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }
}
