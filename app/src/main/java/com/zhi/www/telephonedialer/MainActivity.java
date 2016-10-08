package com.zhi.www.telephonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements OnClickListener{
    private EditText mPhoneNum;
    private Button mCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvent();
    }

    private void initViews() {
        mPhoneNum = (EditText) findViewById(R.id.phone_num);
        mCall = (Button) findViewById(R.id.call);
    }

    private void initEvent() {
        mCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.call:
                call();
                break;
        }
    }

    private void call(){
        String phone = mPhoneNum.getText().toString();

        Intent intent = new Intent();
        intent.setAction("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:"+phone));
        startActivity(intent);
    }
}
