package com.example.msg1;
        import androidx.appcompat.app.AppCompatActivity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText messageEditText = findViewById(R.id.message);

        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageEditText.getText().toString();
                sendMessage(message);
            }
        });
    }

    private void sendMessage(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);


        if (intent.resolveActivity(getPackageManager()) != null) {

            intent.setPackage("com.whatsapp");
            startActivity(intent);
        } else {

            Toast.makeText(this, "Please install WhatsApp first.", Toast.LENGTH_SHORT).show();
        }
    }
}