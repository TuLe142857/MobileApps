package vn.edu.ptithcm.viewpagernavigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    BottomNavigationView navMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.viewPager);
        navMenu = findViewById(R.id.menuNav);

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(0);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:{
                        navMenu.getMenu().findItem(R.id.person).setChecked(true);
                        break;
                    }
                    case 1:{
                        navMenu.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    }
                    case 2: {
                        navMenu.getMenu().findItem(R.id.settings).setChecked(true);
                        break;
                    }

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        navMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.person){
                    viewPager.setCurrentItem(0);
                }
                else if (id == R.id.home){
                    viewPager.setCurrentItem(1);
                }else
                    viewPager.setCurrentItem(2);
                return true;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}