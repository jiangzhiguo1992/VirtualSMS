package com.example.administrator.virtualsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected Button sendBtn, receiveBtn, moreBtn;
    protected EditText sendEt, contentEt;
    protected MyResolver myResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myResolver = new MyResolver(this);

        loadUI();

        sendBtn.setOnClickListener(new SendListener());
        receiveBtn.setOnClickListener(new ReceiveListener());
    }

    /**
     * 加载UI
     */
    private void loadUI() {
        sendBtn = (Button) findViewById(R.id.btn_send);
        receiveBtn = (Button) findViewById(R.id.btn_receive);
        sendEt = (EditText) findViewById(R.id.et_send);
        contentEt = (EditText) findViewById(R.id.et_content);
    }

    /**
     * 发送按钮
     */
    private class SendListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            insert(2);
        }
    }

    /**
     * 接受按钮
     */
    private class ReceiveListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            insert(1);
        }
    }

    /**
     * 发送短信操作
     *
     * @param type 短信发送类型
     */
    private void insert(int type) {
        String phoneString = sendEt.getText().toString();
        if (!phoneString.equals("")) {
            String content = contentEt.getText().toString();
            if (!content.equals("")) {
                int phone = Integer.parseInt(phoneString);
                myResolver.insertSMS(phone, content, type);
            } else {
                Toast.makeText(MainActivity.this, "请输入信息内容", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "请输入电话号码", Toast.LENGTH_SHORT).show();
        }
    }

}
