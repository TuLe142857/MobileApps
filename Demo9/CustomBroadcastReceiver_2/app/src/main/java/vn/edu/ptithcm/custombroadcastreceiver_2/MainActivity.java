package vn.edu.ptithcm.custombroadcastreceiver_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String ACTION = "vn.edu.ptithcm.ACTION";
    private static final String DATA_KEY = "vn.edu.ptithcm.KEY";

    TextView msgTextView;
    EditText editText;
    Button sendBroadcastButton;

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String msg = intent.getStringExtra(DATA_KEY);
            msgTextView.setText(msg);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ACTION);
        registerReceiver(broadcastReceiver, intentFilter, Context.RECEIVER_EXPORTED);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.editText);
        msgTextView = findViewById(R.id.msgDisplay);
        sendBroadcastButton = findViewById(R.id.button);
        sendBroadcastButton.setOnClickListener(this);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }


    @Override
    public void onClick(View v) {
        String msg = editText.getText().toString();

        Intent intent = new Intent(ACTION);
        intent.putExtra(DATA_KEY, msg);

        sendBroadcast(intent);
    }
}