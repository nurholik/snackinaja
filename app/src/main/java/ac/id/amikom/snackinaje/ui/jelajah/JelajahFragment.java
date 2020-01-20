package ac.id.amikom.snackinaje.ui.jelajah;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import ac.id.amikom.snackinaje.R;

public class JelajahFragment extends Fragment {

    private JelajahViewModel JelajahViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        JelajahViewModel =
                ViewModelProviders.of(this).get(JelajahViewModel.class);
        View root = inflater.inflate(R.layout.fragment_jelajah, container, false);
        final TextView textView = root.findViewById(R.id.text_jelajah);
        JelajahViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}