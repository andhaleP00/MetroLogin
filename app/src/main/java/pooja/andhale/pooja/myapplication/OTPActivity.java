package pooja.andhale.pooja.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class OTPActivity extends AppCompatActivity {

    @BindView(R.id.mobNumber)
    EditText mobNumber;
    @BindView(R.id.getOtp)
    Button getOtp;
    @BindView(R.id.submit)
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        ButterKnife.bind(this);
        getOtp.setOnClickListener(onClickListener);
        submit.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId())
            {
                case R.id.getOtp:
                    if(mobNumber.length()==10)
                    {
                        //above will check for valid mobile
                    }
            }

        }
    };



}
