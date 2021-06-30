package hamza.bendahmane.SihatiMob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;

import com.apps.SihatiMob.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
ImageButton menu , account ;
DrawerLayout drawerLayout;
NavigationView navigation;
ConstraintLayout header_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);
        drawerLayout =findViewById(R.id.drawerLayout);
        navigation =findViewById(R.id.nav);

        header_title =findViewById(R.id.header_title);


        drawerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.header_title)
                    drawerLayout.closeDrawer(Gravity.LEFT);

            }
        });



        getSupportFragmentManager().beginTransaction().
                add(R.id.container_frag,new HomeFragment()).
                addToBackStack("app").commit();

        menu = findViewById(R.id.menu);
        account = findViewById(R.id.account);

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.container_frag,new AccountFragment()).
                        addToBackStack("app").commit();


            }
        });

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

    }

    @Override
    public void onBackPressed() {
        if( drawerLayout.isDrawerOpen(Gravity.LEFT))
            drawerLayout.closeDrawer(Gravity.LEFT);
        else
        super.onBackPressed();
    }
}