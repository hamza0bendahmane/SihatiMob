package hamza.bendahmane.SihatiMob;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hamza.bendahmane.SihatiMob.R;
import com.google.android.material.button.MaterialButton;

public class InFragment extends Fragment {

    MaterialButton fb_login,number_login;
    Intent intent ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        intent = new Intent(getContext(),MainActivity.class);
        fb_login =view.findViewById(R.id.button_fb);
        number_login =view.findViewById(R.id.button_number);
        LoginActivity.fragment = this;
        view.findViewById(R.id.terms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext()).
                        setTitle("TERMS AND CONDITIONS").
                        setMessage(R.string.terms).setNeutralButton("OK",null).show();
            }
        });
        fb_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PreferenceManager(getContext()).setIsLoggedIn(true);
                startActivity(intent);
                getActivity().finish();
            }
        });
        number_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().add(R.id.full_container,new VerifyNumberFragment()).addToBackStack("app").commit();
            }
        });


    }
}