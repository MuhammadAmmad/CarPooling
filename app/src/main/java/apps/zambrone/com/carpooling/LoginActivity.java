package apps.zambrone.com.carpooling;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class LoginActivity extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private EditText et_userName = (EditText) findViewById(R.id.login_et_email);
    private EditText et_password = (EditText) findViewById(R.id.login_et_password);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //  ButtonEffects.buttonEffect(findViewById(R.id.login_activity_btn_register_as_sharer));
        findViewById(R.id.login_activity_btn_register_as_sharer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_userName.getText().toString();
                String passwrd = et_password.getText().toString();
                User user = new User(username,passwrd);
                Gson gson =  new GsonBuilder()
                        .excludeFieldsWithoutExposeAnnotation()
                        .create();

                String jsonuser = gson.toJson(user);


                String response = null;
                try {
                    response = post("http://fort.lk/carpool/api/user/login", jsonuser);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(response);

                Intent intent = new Intent(LoginActivity.this, RiderRegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    OkHttpClient client = new OkHttpClient();

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
