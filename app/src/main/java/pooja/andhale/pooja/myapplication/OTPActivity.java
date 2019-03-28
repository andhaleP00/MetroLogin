package pooja.andhale.pooja.myapplication;

import android.app.Service;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class OTPActivity extends AppCompatActivity implements View.OnFocusChangeListener, View.OnKeyListener, TextWatcher{

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
    @BindView(R.id.pin_hidden_edittext)
    EditText pinHiddenEditText;
    Integer textLength;


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        ButterKnife.bind(this);
        getOtp.setOnClickListener(onClickListener);
        submit.setOnClickListener(onClickListener);
        setPINListeners();



//        pinFirstEditText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                textLength = pinFirstEditText.getText().length();
//
//                if (textLength >= 1) {
//                    pinSecondEditText.requestFocus();
//                }
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//        pinSecondEditText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                textLength = pinSecondEditText.getText().length();
//
//                if (textLength >= 1) {
//                    pinThirdEditText.requestFocus();
//                }
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if(textLength==0)
//                {
////                    pinFirstEditText.setSelection(0);
//                    pinFirstEditText.requestFocus();
//                }
//
//            }
//        });
//
//        pinThirdEditText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                textLength = pinThirdEditText.getText().length();
//
//                if (textLength >= 1) {
//                    pinFourthEditText.requestFocus();
//                }
//
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if(textLength==0)
//                {
////                    pinSecondEditText.setSelection(0);
//                    pinSecondEditText.requestFocus();
//                }
//
//            }
//        });
//        pinFourthEditText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                textLength = pinFourthEditText.getText().length();
//
//                if (textLength >= 1) {
//                    pinFourthEditText.clearFocus();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if(textLength==0)
//                {
////                    pinThirdEditText.setSelection(0);
//                    pinThirdEditText.requestFocus();
//                }
//
//            }
//        });
    }


    private void setPINListeners() {
        pinHiddenEditText.addTextChangedListener(this);

        pinFirstEditText.setOnFocusChangeListener(this);
        pinSecondEditText.setOnFocusChangeListener(this);
        pinThirdEditText.setOnFocusChangeListener(this);
        pinFourthEditText.setOnFocusChangeListener(this);


        pinFirstEditText.setOnKeyListener(this);
        pinSecondEditText.setOnKeyListener(this);
        pinThirdEditText.setOnKeyListener(this);
        pinFourthEditText.setOnKeyListener(this);

        pinHiddenEditText.setOnKeyListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        final int id = v.getId();
        switch (id) {
            case R.id.pin_first_edittext:
                if (hasFocus) {
                    setFocus(pinHiddenEditText);
                    showSoftKeyboard(pinHiddenEditText);
                }
                break;

            case R.id.pin_second_edittext:
                if (hasFocus) {
                    setFocus(pinHiddenEditText);
                    showSoftKeyboard(pinHiddenEditText);
                }
                break;

            case R.id.pin_third_edittext:
                if (hasFocus) {
                    setFocus(pinHiddenEditText);
                    showSoftKeyboard(pinHiddenEditText);
                }
                break;

            case R.id.pin_forth_edittext:
                if (hasFocus) {
                    setFocus(pinHiddenEditText);
                    showSoftKeyboard(pinHiddenEditText);
                }
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            final int id = v.getId();
            switch (id) {
                case R.id.pin_hidden_edittext:
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        if (pinHiddenEditText.getText().length() == 4)
                            pinFourthEditText.setText("");
                        else if (pinHiddenEditText.getText().length() == 3)
                            pinThirdEditText.setText("");
                        else if (pinHiddenEditText.getText().length() == 2)
                            pinSecondEditText.setText("");
                        else if (pinHiddenEditText.getText().length() == 1)
                            pinFirstEditText.setText("");

                        if (pinHiddenEditText.length() > 0)
                            pinHiddenEditText.setText(pinHiddenEditText.getText().subSequence(0, pinHiddenEditText.length() - 1));

                        return true;
                    }

                    break;

                default:
                    return false;
            }
        }

        return false;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() == 0) {
            setFocusedPinBackground(pinFirstEditText);
            pinFirstEditText.setText("");
        } else if (s.length() == 1) {
            setFocusedPinBackground(pinSecondEditText);
            pinFirstEditText.setText(s.charAt(0) + "");
            pinSecondEditText.setText("");
            pinThirdEditText.setText("");
            pinFourthEditText.setText("");
        } else if (s.length() == 2) {
            setFocusedPinBackground(pinThirdEditText);
            pinSecondEditText.setText(s.charAt(1) + "");
            pinThirdEditText.setText("");
            pinFourthEditText.setText("");
        } else if (s.length() == 3) {
            setFocusedPinBackground(pinFourthEditText);
            pinThirdEditText.setText(s.charAt(2) + "");
            pinFourthEditText.setText("");
        } else if (s.length() == 4) {
//            setFocusedPinBackground(pinFourthEditText);
            pinFourthEditText.setText(s.charAt(3) + "");
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    /**
     * Sets default PIN background.
     *
     * @param editText edit text to change
     */

    /**
     * Sets focus on a specific EditText field.
     *
     * @param editText EditText to set focus on
     */
    public static void setFocus(EditText editText) {
        if (editText == null)
            return;

        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
    }

    /**
     * Sets focused PIN field background.
     *
     * @param editText edit text to change
     */
    private void setFocusedPinBackground(EditText editText) {
//            setViewBackground(editText, getResources().getDrawable(R.drawable.textfield_focused_holo_light));
        Log.d("otp","setFocusedPinBackground");
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
    public void showSoftKeyboard(EditText editText) {
        if (editText == null)
            return;

        InputMethodManager imm = (InputMethodManager) getSystemService(Service.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, 0);
    }



}
