package edu.cnm.deepdive.tilematch.controller;

import android.os.Bundle;
import androidx.navigation.Navigation;
import androidx.preference.DropDownPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import edu.cnm.deepdive.tilematch.R;
import edu.cnm.deepdive.tilematch.model.entity.Game.Difficulty;
import java.util.Arrays;

public class PreferencesFragment extends PreferenceFragmentCompat {

  @Override
  public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
    setPreferencesFromResource(R.xml.preferences, rootKey);
    ListPreference pref = findPreference("difficulty_preference");
    String[] values = Arrays
        .stream(Difficulty.values())
        .map(Enum::toString)
        .toArray(String[]::new);
    String[] displayValues = Arrays
        .stream(Difficulty.values())
        .map(Enum::toString)
        .map((value) -> Character.toUpperCase(value.charAt(0)) + value.substring(1).toLowerCase())
        .toArray(String[]::new);
    pref.setEntries(displayValues);
    pref.setEntryValues(values);
    Preference backButton = findPreference("back_button");
    backButton.setOnPreferenceClickListener((p) -> {
      Navigation.findNavController(getActivity(), R.id.nav_host_fragment_container)
          .navigate(PreferencesFragmentDirections.actionPreferencesFragmentToHomeFragment());
      return true;
    });
  }
}
