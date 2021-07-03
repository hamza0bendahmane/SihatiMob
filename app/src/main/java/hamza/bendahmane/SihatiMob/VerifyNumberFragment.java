package hamza.bendahmane.SihatiMob;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import hamza.bendahmane.SihatiMob.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class VerifyNumberFragment extends Fragment {

    MaterialButton confirm;
    Spinner country_code_spinner;
    List<String> country_codes = new ArrayList<>();
    public VerifyNumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        confirm = view.findViewById(R.id.continue_button);
        country_code_spinner = view.findViewById(R.id.country_code_spinner);

        for (int i=1;i<250;i++){
            country_codes.add("+ "+i);
        }

    country_code_spinner.setAdapter(new ArrayAdapter<String>(getContext(),
            R.layout.changed_simple_spinner_item,country_codes));
        LoginActivity.fragment = this;
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        add(R.id.full_container,new CodeFragment()).addToBackStack("app").commit();
            }
        });


    }
}