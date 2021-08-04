package edu.cnm.deepdive.tilematch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.tilematch.adapter.GalleryAdapter.Holder;
import edu.cnm.deepdive.tilematch.databinding.FragmentGameBinding;
import edu.cnm.deepdive.tilematch.databinding.ItemGalleryBinding;
import edu.cnm.deepdive.tilematch.model.dto.Image;
import edu.cnm.deepdive.tilematch.model.pojo.Tile;
import edu.cnm.deepdive.tilematch.model.pojo.Tile.State;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private final LayoutInflater inflater;
  private final List<Tile> tiles;
  private final OnTileClickHelper onTileClickHelper;

  public GalleryAdapter(Context context, List<Tile> tiles,
      OnTileClickHelper onTileClickHelper) {
    this.context = context;
    inflater = LayoutInflater.from(context);
    this.tiles = tiles;
    this.onTileClickHelper = onTileClickHelper;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    ItemGalleryBinding binding = ItemGalleryBinding.inflate(inflater, parent, false);
    return new Holder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return tiles.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final ItemGalleryBinding binding;
    private Image image;

    public Holder(ItemGalleryBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    public void bind(int position) {
      Tile tile = tiles.get(position);
      if (tile.getState()== State.FACE_DOWN) {
        binding.number.setText(String.valueOf(position+1));
        binding.image.setVisibility(View.GONE);
        binding.number.setVisibility(View.VISIBLE);
      } else {
        Picasso.get().load(tile.getUrl())
            .into(binding.image);
        binding.number.setVisibility(View.GONE);
        binding.image.setVisibility(View.VISIBLE);
      }
      itemView.setOnClickListener((v) -> onTileClickHelper.onTileClick(v, position));
    }

  }

  public interface OnTileClickHelper {

    void onTileClick(View view, int position);
  }
}