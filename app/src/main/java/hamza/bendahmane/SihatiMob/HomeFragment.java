package hamza.bendahmane.SihatiMob;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import hamza.bendahmane.SihatiMob.R;
import com.google.android.material.card.MaterialCardView;

public class HomeFragment extends Fragment {
    ImageButton account,menu ;
    DrawerLayout drawerLayout;
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
        MainActivity.fragment_on = new HomeFragment();
        account_c = view.findViewById(R.id.account_settings);
        health_c = view.findViewById(R.id.account_health);
        nutrition_c = view.findViewById(R.id.account_nutritions);
        reminders_c = view.findViewById(R.id.account_reminders);
        account = getActivity().findViewById(R.id.account);
        drawerLayout = getActivity().findViewById(R.id.drawerLayout);


        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        replace(R.id.container_frag,new AccountFragment()).
                        addToBackStack("app").commit();


            }
        });
        menu = view.findViewById(R.id.menu);


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sidebar ....
                if( drawerLayout.isDrawerOpen(Gravity.LEFT))
                    drawerLayout.closeDrawer(Gravity.LEFT);
                else
                    drawerLayout.openDrawer(Gravity.LEFT);

            }
        });
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