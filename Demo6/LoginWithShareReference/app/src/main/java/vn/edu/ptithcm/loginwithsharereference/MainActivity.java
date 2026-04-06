package vn.edu.ptithcm.loginwithsharereference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String USER_NAME = "username";
    private static final String PASSWORD = "password";



    EditText usernameEdt;
    EditText passwordEdt;
    Button loginButton;
    CheckBox remeberMeCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        usernameEdt = findViewById(R.id.username);
        passwordEdt = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        remeberMeCheckbox = findViewById(R.id.rememberMe);

        checkLogin();


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEdt.getText().toString();
                String password = passwordEdt.getText().toString();
                if (username.equals(USER_NAME) && password.equals(PASSWORD)){
                    if (remeberMeCheckbox.isChecked()){
                        saveLogin();
                    }
                    Intent intent = new Intent(MainActivity.this, AfterLoginActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Username or password wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void checkLogin(){
        SharedPreferences sharedPreferences = getSharedPreferences("login_check", MODE_PRIVATE);
        if (sharedPreferences.getBoolean("login", false)){
            Intent intent = new Intent(MainActivity.this, AfterLoginActivity.class);
            startActivity(intent);
        }
    }

    private void saveLogin(){
        SharedPreferences sharedPreferences = getSharedPreferences("login_check", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putBoolean("login", true);
        editor.apply();
    }


}