package apps.zambrone.com.carpooling;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;


import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.crash.FirebaseCrash;


public class LoginActivity extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private Button loginbtn;
    private EditText et_email;
    private EditText et_password ;

    private ProgressDialog progress;
    private String email;
    private String password;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable ex) {
                FirebaseCrash.report(ex);
            }
        });

        loginbtn = (Button) findViewById(R.id.SignIn);
        et_email = (EditText) findViewById(R.id.login_et_email);
        et_password = (EditText) findViewById(R.id.login_et_password);

        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //  ButtonEffects.buttonEffect(findViewById(R.id.login_activity_btn_register_as_sharer));
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progress = new ProgressDialog(LoginActivity.this);
                progress.setMessage("Connecting..");
                progress.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
                progress.setCancelable(false);
                progress.show();

                email = et_email.getText().toString().trim();
                password = et_password.getText().toString().trim();
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            progress.dismiss();
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            et_email.setError(task.getException().getMessage());

                        } else {
                            progress.dismiss();
                            Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, SaveRouteActivity.class);
                            intent.putExtra("email", et_email.getText());
                            startActivity(intent);

                        }
                    }
                });


                Intent intent = new Intent(LoginActivity.this, RiderRegisterActivity.class);
                startActivity(intent);
            }
        });


    }

//    OkHttpClient client = new OkHttpClient();
//
//    String post(String url, String json) throws IOException {
//        RequestBody body = RequestBody.create(JSON, json);
//        Request request = new Request.Builder()
//                .url(url)
//                .post(body)
//                .build();
//        try (Response response = client.newCall(request).execute()) {
//            return response.body().string();
//        }
//    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
