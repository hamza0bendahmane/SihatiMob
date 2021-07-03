package hamza.bendahmane.SihatiMob;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class  GeneralsNutrition extends Fragment {
    MaterialButton hydramaterialButton, junkmaterialButton,dmaterialButton,cmaterialButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_generals_nutrition, container, false);
    }

    public  GeneralsNutrition() {
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {

        hydramaterialButton = view.findViewById(R.id.hydramaterialButton);
        dmaterialButton = view.findViewById(R.id.dmaterialButton);
        cmaterialButton = view.findViewById(R.id.cmaterialButton);
        junkmaterialButton = view.findViewById(R.id.junkmaterialButton);


        hydramaterialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        add(R.id.container_frag,new HNutrition()).
                        addToBackStack("app").commit();
            }
        });
        dmaterialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        add(R.id.container_frag,new DNutrition()).
                        addToBackStack("app").commit();
            }
        });
        cmaterialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        add(R.id.container_frag,new CNutrition()).
                        addToBackStack("app").commit();
            }
        });
        junkmaterialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        add(R.id.container_frag,new JNutrition()).
                        addToBackStack("app").commit();
            }
        });

    }
}