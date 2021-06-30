package hamza.bendahmane.SihatiMob;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.SihatiMob.R;
import com.google.android.material.card.MaterialCardView;

public class HomeFragment extends Fragment {


    MaterialCardView account_c , health_c, nutrition_c,reminders_c;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {

        account_c = view.findViewById(R.id.account_settings);
        health_c = view.findViewById(R.id.account_health);
        nutrition_c = view.findViewById(R.id.account_nutritions);
        reminders_c = view.findViewById(R.id.account_reminders);


        reminders_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        add(R.id.container_frag,new ReminderFragment()).
                        addToBackStack("app").commit();

            }
        });
        nutrition_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        add(R.id.container_frag,new NutritionFragment()).
                        addToBackStack("app").commit();

            }
        });
        health_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        add(R.id.container_frag,new HealthFragment()).
                        addToBackStack("app").commit();

            }
        });
        account_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        add(R.id.container_frag,new AccountFragment()).
                        addToBackStack("app").commit();

            }
        });
        
        
    }
}