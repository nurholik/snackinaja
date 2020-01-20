package ac.id.amikom.snackinaje.ui.rencana;

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

public class RencanaFragment extends Fragment {

    private RencanaViewModel RencanaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RencanaViewModel =
                ViewModelProviders.of(this).get(RencanaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_rencana, container, false);
        final TextView textView = root.findViewById(R.id.text_rencana);
        RencanaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
