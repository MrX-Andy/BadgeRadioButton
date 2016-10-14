package com.mph.badgeradiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.mph.badgeradiobutton.widget.BadgeRadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSetNumBtn;
    private Button mClearBtn;

    private BadgeRadioButton mMsgRb;
    private BadgeRadioButton mContactsRb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSetNumBtn = (Button) findViewById(R.id.set_num);
        mClearBtn = (Button) findViewById(R.id.clear_num);

        mMsgRb = (BadgeRadioButton) findViewById(R.id.rb_home_tab_msg);
        mContactsRb = (BadgeRadioButton) findViewById(R.id.rb_home_tab_contacts);


        mSetNumBtn.setOnClickListener(this);
        mClearBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.set_num:
                mMsgRb.setmNum(60);
                break;
            case R.id.clear_num:
                mContactsRb.clearNum();
                break;
        }
    }
}
