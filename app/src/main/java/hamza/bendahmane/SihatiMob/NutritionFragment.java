package hamza.bendahmane.SihatiMob;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hamza.bendahmane.SihatiMob.R;

public class NutritionFragment extends Fragment {

    Button go_button ;


    public NutritionFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nutrition, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        MainActivity.fragment_on = new NutritionFragment();

        go_button = view.findViewById(R.id.go_button);
        go_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        add(R.id.container_frag,new GeneralsNutrition()).
                        addToBackStack("app").commit();

            }
        });


    }
}