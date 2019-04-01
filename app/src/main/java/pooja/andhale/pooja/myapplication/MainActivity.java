package pooja.andhale.pooja.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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
    @BindView(R.id.forgotPassword)
    TextView forgotPasswordTextview;
    @BindView(R.id.signup)
    TextView signupTextview;
    @BindView(R.id.passwordImage)
    ImageView passwordImage;
    Activity currentActivity=this;
    Intent intent;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        metroId.addTextChangedListener(textWatcher);
        metroIdPassword.addTextChangedListener(textWatcher);
        Login.setOnClickListener(onClickListener);
        forgotPasswordTextview.setOnClickListener(onClickListener);
        signupTextview.setOnClickListener(onClickListener);
//        passwordImage.setOnClickListener(onClickListener);
//        passwordImage.setVisibility(View.GONE);
//        passwordImage.setImageResource(R.drawable.ic_visibility_off_black_24dp);
//        metroIdPassword.setVisibility(View.INVISIBLE);
        flag=true;

    }

    private TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        private void hideSoftKeyboard(View v)
        {
            InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s==metroId.getEditableText())
            {
                if(s.length()==10)
                {
                    hideSoftKeyboard(metroId);
                    metroIdPassword.requestFocus();
                }
            }
            else if(s==metroIdPassword.getEditableText())
            {
                if(s.length()==6)
                {
                    hideSoftKeyboard(metroIdPassword);
                }

            }


        }
    };

    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId())
            {
                case R.id.Login:
                    if((metroId.length()==10)&&(metroIdPassword.length()>=6))
                    {
                        intent=new Intent(currentActivity,OTPActivity.class);
                        startActivity(intent);
                    }
                    else
                        if(metroId.length()==0)
                            metroId.setError("metroId cant be empty");
                        else if(metroIdPassword.length()==0)
                            metroIdPassword.setError("password cant be empty");
                    break;
                case R.id.forgotPassword:
                    intent=new Intent(currentActivity,ForgotPasswordActivity.class);
                    startActivity(intent);
                    break;
                case R.id.signup:
                    intent=new Intent(currentActivity,SignupActivity.class);
                    startActivity(intent);
                    break;
//                case R.id.passwordImage:
//                    passwordImage.setImageResource(R.drawable.ic_visibility_black_24dp);
//                    metroIdPassword.setVisibility(View.VISIBLE);
////                    if(passwordImage.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.ic_visibility_off_black_24dp).getConstantState())
////                    {
//////                        passwordImage.setImageResource(R.drawable.ic_visibility_black_24dp);
//////                        metroIdPassword.setVisibility(View.VISIBLE);
////                    }
////                    else if(passwordImage.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.ic_visibility_black_24dp).getConstantState())
////                    {
////                        passwordImage.setImageResource(R.drawable.ic_visibility_off_black_24dp);
////                        metroIdPassword.setVisibility(View.INVISIBLE);
////                    }
//                    break;
            }


        }
    };
    public void imageChange(View v)
    {
        Log.d("imageChange"," "+passwordImage.getDrawable());
        Log.d("imageChange"," "+getResources().getDrawable(R.drawable.ic_visibility_off_black_24dp));

//        if(passwordImage.getDrawable()==getResources().getDrawable(R.drawable.ic_visibility_off_black_24dp))
//        {
//            passwordImage.setImageResource(R.drawable.ic_visibility_black_24dp);
//            metroIdPassword.setInputType(InputType.TYPE_CLASS_TEXT);
//        }
//        else if(passwordImage.getDrawable()==getResources().getDrawable(R.drawable.ic_visibility_black_24dp))
//        {
//            passwordImage.setImageResource(R.drawable.ic_visibility_off_black_24dp);
//            metroIdPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
//        }
        if(flag==true)
        {
            passwordImage.setImageResource(R.drawable.ic_visibility_black_24dp);
//            metroIdPassword.setInputType(InputType.TYPE_CLASS_TEXT);
            metroIdPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            flag=false;
        }else if(flag==false)
        {
            passwordImage.setImageResource(R.drawable.ic_visibility_off_black_24dp);
//            metroIdPassword.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);
            metroIdPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            flag=true;
        }
    }
}
