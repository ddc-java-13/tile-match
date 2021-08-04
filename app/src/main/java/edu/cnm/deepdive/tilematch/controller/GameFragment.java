package edu.cnm.deepdive.tilematch.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.tilematch.adapter.GalleryAdapter;
import edu.cnm.deepdive.tilematch.databinding.FragmentGameBinding;
import edu.cnm.deepdive.tilematch.model.pojo.Tile;
import edu.cnm.deepdive.tilematch.model.pojo.Tile.State;
import edu.cnm.deepdive.tilematch.viewmodel.MainViewModel;

public class GameFragment extends Fragment {

  private FragmentGameBinding binding;
  private MainViewModel viewModel;
  private GalleryAdapter adapter;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentGameBinding.inflate(inflater, container, false);
    //TODO attach listeners to ui controllers
    NavController navController = Navigation.findNavController(container);
    binding.backButton.setOnClickListener(
        (v) -> navController.navigate(GameFragmentDirections.actionGameFragmentToHomeFragment()));
    return binding.getRoot();

  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    viewModel.getTiles().observe(getViewLifecycleOwner(), (tiles) -> {
      adapter = new GalleryAdapter(getContext(), tiles, (v, position) ->{
        Tile tile = tiles.get(position);
        tile.setState((tile.getState()== State.FACE_DOWN) ? State.FACE_UP : State.FACE_DOWN);
        adapter.notifyItemChanged(position);
      });
      binding.tileScheme.setAdapter(adapter);
    });
  }

}
