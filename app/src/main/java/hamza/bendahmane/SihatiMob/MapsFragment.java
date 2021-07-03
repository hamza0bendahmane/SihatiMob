package hamza.bendahmane.SihatiMob;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import hamza.bendahmane.SihatiMob.R;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.button.MaterialButton;

public class MapsFragment extends Fragment {
    MaterialButton change,confirm,imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        confirm = view.findViewById(R.id.continue_button);
        LoginActivity.fragment = this;
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PreferenceManager(getContext()).setIsLoggedIn(true);
                Intent intent = new Intent(getContext(),MainActivity.class);
                startActivity(intent);
                getActivity().finish();

                 }
        });
        EditText digit0 = view.findViewById(R.id.digit0);
        digit0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.full_container,new WholeMap())
                        .addToBackStack("app").commit();
            }
        });


    }


}
