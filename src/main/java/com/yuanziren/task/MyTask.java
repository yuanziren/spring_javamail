package com.yuanziren.task;

import com.yuanziren.test.SimpleOrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by xlf on 2019/5/28.
 */
@Component
public class MyTask {

    @Autowired
    private SimpleOrderManager manager;

    @Scheduled(cron = "0/3 * * * * ? ")
    public void job01(){
        System.out.println("Job01 ... ");
        manager.placeOrder();

    }

    @Scheduled(cron = "0/6 * * * * ? ")
    public void job02(){
        System.out.println("Job02 ... ");
    }
}



