package hamza.bendahmane.SihatiMob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import hamza.bendahmane.SihatiMob.R;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
DrawerLayout drawerLayout;
NavigationView navigation;
ConstraintLayout header_title;
    public static Fragment fragment_on = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);


        getSupportFragmentManager().beginTransaction().
                replace(R.id.container_frag,new HomeFragment()).addToBackStack("app").
                commit();
        fragment_on = new HomeFragment();
        drawerLayout =findViewById(R.id.drawerLayout);
        navigation =findViewById(R.id.nav);
        navigation.setNavigationItemSelectedListener(this);
        header_title =findViewById(R.id.header_title);


        drawerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.header_title)
                    drawerLayout.closeDrawer(Gravity.LEFT);

            }
        });




    }

    private void WannaTakeOff(final boolean exit_only) {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Wanna Take off ?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (! exit_only){
                        new PreferenceManager(getApplicationContext()).setIsLoggedIn(false);
                            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(intent);}
                            finish();
                    }
                }).setNegativeButton("No",null).show();
    }

    @Override
    public void onBackPressed() {
        if( drawerLayout.isDrawerOpen(Gravity.LEFT))
            drawerLayout.closeDrawer(Gravity.LEFT);
        else if (fragment_on instanceof HomeFragment)
            WannaTakeOff(true);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
        int id = item.getItemId();
        switch (id){

            case R.id.reminders:
                fragment_on = new ReminderFragment();
                break;
            case R.id.home_id:
                fragment_on = new HomeFragment();
                break;
            case R.id.new_reminder:
                fragment_on = new AddReminder();
                break;
            case R.id.health:
                fragment_on = new HealthFragment();
                break;
            case R.id.account:
                fragment_on = new AccountFragment();
                break;
            case R.id.nutrition:
                fragment_on = new NutritionFragment();
                break;
            case R.id.logout:
                WannaTakeOff(false);
                break;

            default:
                break;


        }


        if (fragment_on != null) {

            getSupportFragmentManager().beginTransaction().
                    replace(R.id.container_frag,fragment_on).addToBackStack("app").
                  commit();
            drawerLayout.closeDrawer(Gravity.LEFT);


            return true;
        }
        return false;
    }
}