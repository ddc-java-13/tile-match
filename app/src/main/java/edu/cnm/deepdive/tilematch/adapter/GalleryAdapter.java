package edu.cnm.deepdive.tilematch.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.tilematch.adapter.GalleryAdapter.Holder;
import edu.cnm.deepdive.tilematch.adapter.GalleryAdapter.Holder.OnGalleryClickHelper;
import edu.cnm.deepdive.tilematch.databinding.FragmentGameBinding;
import edu.cnm.deepdive.tilematch.model.entity.Gallery;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private final LayoutInflater inflater;
  private final List<Gallery> galleries;
  private final OnGalleryClickHelper onGalleryClickHelper;

  public GalleryAdapter(Context context, List<Gallery> galleries,
      OnGalleryClickHelper onGalleryClickHelper) {
    this.context = context;
    inflater = LayoutInflater.from(context);
    this.galleries = galleries;
    this.onGalleryClickHelper = onGalleryClickHelper;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    FragmentGameBinding binding = (FragmentGameBinding.inflate(inflater, parent, false));
    return new Holder(binding, onGalleryClickHelper);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return galleries.size();
  }

  static class Holder extends RecyclerView.ViewHolder implements OnClickListener {

    private final FragmentGameBinding binding;
    OnGalleryClickHelper onGalleryClickHelper;
    private Gallery gallery;

    public Holder(FragmentGameBinding binding, OnGalleryClickHelper onGalleryClickHelper) {
      super(binding.getRoot());
      this.binding = binding;
      this.onGalleryClickHelper = onGalleryClickHelper;
      binding.getRoot().setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    public void bind(int position) {

    }


    public interface OnGalleryClickHelper {

      void onGalleryClick(String galleryId, View view);
    }
  }
}