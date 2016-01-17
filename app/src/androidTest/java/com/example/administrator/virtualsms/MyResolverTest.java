package com.example.administrator.virtualsms;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * Created by Administrator on 2015/11/18.
 */
public class MyResolverTest extends ApplicationTestCase<Application> {

    public MyResolverTest() {
        super(Application.class);
    }

    public void testInsertSMS() {
        MyResolver myResolver = new MyResolver(getContext());
        myResolver.insertSMS(95533, "转账一百亿元", 1);
    }

    public void testQuerySMS() {
        MyResolver myResolver = new MyResolver(getContext());
        myResolver.querySMS();
    }

}
