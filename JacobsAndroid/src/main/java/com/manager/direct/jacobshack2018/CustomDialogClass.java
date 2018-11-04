package com.manager.direct.jacobshack2018;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class CustomDialogClass extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Intent i;
    public Button yes, no;

    public CustomDialogClass(Activity a, Intent intent) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        i = intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        yes = (Button) findViewById(R.id.btn_yes);
        no = (Button) findViewById(R.id.btn_no);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:
                Intent intent = new Intent(c, Main2Activity.class);
                intent.putExtra("date",i.getStringExtra("date"));
                c.startActivity(intent);

                c.finish();
                break;
            case R.id.btn_no:
                dismiss();

                break;
            default:
                break;
        }
        dismiss();
    }
}
