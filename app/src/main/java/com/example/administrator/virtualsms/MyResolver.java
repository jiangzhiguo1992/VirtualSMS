package com.example.administrator.virtualsms;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by Administrator on 2015/11/18.
 */
public class MyResolver {

    private Context context;

    public MyResolver(Context context) {
        this.context = context;
    }

    /**
     * @param phone 发送或被发送信息的号码
     * @param body  消息内容
     * @param type  1是接受，2是发送
     */
    public void insertSMS(int phone, String body, int type) {
        ContentResolver resolver = context.getContentResolver();
        Uri uri = Uri.parse("content://sms");
        ContentValues values = new ContentValues();
        values.put("address", String.valueOf(phone));
        values.put("type", String.valueOf(type));
        values.put("date", System.currentTimeMillis());
        values.put("body", body);
        resolver.insert(uri, values);
    }

    /**
     * 这个方法是用来查询sms的provider里的字段值得
     */
    public void querySMS() {
        ContentResolver resolver = context.getContentResolver();
        Uri uri = Uri.parse("content://sms");
        Cursor cursor = resolver.query(uri, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int number = cursor.getColumnCount();
            for (int i = 0; i < number; i++) {
                String name = cursor.getColumnName(i);
                System.out.println("name----------->" + name);
            }
            cursor.close();
        }
    }
}
