package hamza.bendahmane.SihatiMob;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hamza.bendahmane.SihatiMob.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;

public class CodeFragment extends Fragment {
    MaterialCardView code_digits;
    MaterialButton change,confirm,imageView;
    TextInputEditText digit0,digit1,digit2,digit3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_code, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        change = view.findViewById(R.id.change);
        confirm = view.findViewById(R.id.continue_button);
        code_digits = view.findViewById(R.id.textInputEditText);
        imageView = view.findViewById(R.id.imageView);
        digit0 = view.findViewById(R.id.digit0);
        digit1 = view.findViewById(R.id.digit1);
        digit2 = view.findViewById(R.id.digit2);
        digit3 = view.findViewById(R.id.digit3);

        LoginActivity.fragment = this;
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().
                        add(R.id.full_container,new MapsFragment()).addToBackStack("app").commit();
            }
        });
        code_digits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (digit0.getText().toString().isEmpty())
                    digit0.requestFocus();
                else if (digit1.getText().toString().isEmpty())
                    digit1.requestFocus();
                else if (digit2.getText().toString().isEmpty())
                    digit2.requestFocus();
                else if (digit3.getText().toString().isEmpty())
                   digit3.requestFocus() ;

            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit0.setText("");
                digit1.setText("");
                digit2.setText("");
                digit3.setText("");
                digit0.requestFocus();

            }
        });
        digit0.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();
                if (!input.isEmpty()){
                    digit1.requestFocus();
                }
            }
        });
        digit1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();
                if (!input.isEmpty())
                    digit2.requestFocus();
                else
                    digit0.requestFocus();

            }
        });
        digit2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();
                if (!input.isEmpty())
                    digit3.requestFocus();
                else
                    digit1.requestFocus();

            }
        });
        digit3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();
                if (input.isEmpty()){
                    digit2.requestFocus();
                }
            }
        });
    }
}