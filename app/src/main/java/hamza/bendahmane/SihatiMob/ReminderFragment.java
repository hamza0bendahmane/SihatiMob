package hamza.bendahmane.SihatiMob;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.security.auth.Destroyable;

import hamza.bendahmane.SihatiMob.R;


public class ReminderFragment extends Fragment {


    ConstraintLayout aspirine;
    public ReminderFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reminder, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        MainActivity.fragment_on = new ReminderFragment();
        aspirine = view.findViewById(R.id.aspirine);

        aspirine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container_frag,new DrugDesc())
                        .addToBackStack("app").commit();
            }
        });


    }
}