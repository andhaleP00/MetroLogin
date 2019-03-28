package pooja.andhale.pooja.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
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
    @BindView(R.id.pin_first_edittext)
     EditText pinFirstEditText;
    @BindView(R.id.pin_second_edittext)
     EditText pinSecondEditText;
    @BindView(R.id.pin_third_edittext)
     EditText pinThirdEditText;
    @BindView(R.id.pin_forth_edittext)
     EditText pinFourthEditText;
    Integer textLength;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        ButterKnife.bind(this);
        getOtp.setOnClickListener(onClickListener);
        submit.setOnClickListener(onClickListener);
        setPinListner()


        pinFirstEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textLength = pinFirstEditText.getText().length();

                if (textLength >= 1) {
                    pinSecondEditText.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pinSecondEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textLength = pinSecondEditText.getText().length();

                if (textLength >= 1) {
                    pinThirdEditText.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(textLength==0)
                {
//                    pinFirstEditText.setSelection(0);
                    pinFirstEditText.requestFocus();
                }

            }
        });

        pinThirdEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textLength = pinThirdEditText.getText().length();

                if (textLength >= 1) {
                    pinFourthEditText.requestFocus();
                }


            }

            @Override
            public void afterTextChanged(Editable s) {
                if(textLength==0)
                {
//                    pinSecondEditText.setSelection(0);
                    pinSecondEditText.requestFocus();
                }

            }
        });
        pinFourthEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textLength = pinFourthEditText.getText().length();

                if (textLength >= 1) {
                    pinFourthEditText.clearFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(textLength==0)
                {
//                    pinThirdEditText.setSelection(0);
                    pinThirdEditText.requestFocus();
                }

            }
        });
    }

    private void setPINListeners() {
        mPinHiddenEditText.addTextChangedListener(this);

        mPinFirstDigitEditText.setOnFocusChangeListener(this);
        mPinSecondDigitEditText.setOnFocusChangeListener(this);
        mPinThirdDigitEditText.setOnFocusChangeListener(this);
        mPinForthDigitEditText.setOnFocusChangeListener(this);
        mPinFifthDigitEditText.setOnFocusChangeListener(this);

        mPinFirstDigitEditText.setOnKeyListener(this);
        mPinSecondDigitEditText.setOnKeyListener(this);
        mPinThirdDigitEditText.setOnKeyListener(this);
        mPinForthDigitEditText.setOnKeyListener(this);
        mPinFifthDigitEditText.setOnKeyListener(this);
        mPinHiddenEditText.setOnKeyListener(this);
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
