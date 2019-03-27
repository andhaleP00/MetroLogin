package pooja.andhale.pooja.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.metroId)
    EditText metroId;
    @BindView(R.id.metroIdPassword)
    EditText metroIdPassword;
    @BindView(R.id.Login)
    Button Login;
    Activity currentActivity=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        metroId.setOnClickListener(onClickListener);
        metroIdPassword.setOnClickListener(onClickListener);
        Login.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId())
            {
                case R.id.metroId:
                    if(metroId.length()==10)
                    {
                        Log.d("login","clicked to metroId");
                    }
                    break;
                case R.id.metroIdPassword:
                    if(metroIdPassword.length()==6)
                    {
                        Log.d("login","enterd min 6");
                    }
                    break;
                case R.id.Login:
                    if((metroId.length()==10)&&(metroIdPassword.length()>=6))
                    {
                        Intent intent=new Intent(currentActivity,OTPActivity.class);
                        startActivity(intent);
                    }


            }


        }
    };
}
