package hamza.bendahmane.SihatiMob;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.apps.SihatiMob.R;

public class LoginActivity extends AppCompatActivity {

    public static Fragment fragment = new InFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (new PreferenceManager(this).isIsLoggedIn()){
           Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            getSupportFragmentManager().beginTransaction().
                    add(R.id.full_container,new InFragment()).commit();
        }

    }

    @Override
    public void onBackPressed() {
        if (!(fragment instanceof InFragment)){
            super.onBackPressed();
        }else
            this.finish();
    }
}
