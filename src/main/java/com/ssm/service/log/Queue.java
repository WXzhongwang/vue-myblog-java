package com.ssm.service.log;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.ssm.base.util.SpringContextUtil;
import com.ssm.domain.Log;

public class Queue {
	protected static Logger logger = LoggerFactory.getLogger(Queue.class);
	// 高并发的基于链表的队列
	protected static ConcurrentLinkedQueue<Log> logQueue = new ConcurrentLinkedQueue<>();

	static {
		// 匿名内部类
		new Thread() {
			@Override
			public void run() {
				while (true) {
					Log entity = logQueue.poll();
					if (entity != null) {
						try {
							ApplicationContext appCtx = SpringContextUtil.getApplicationContext();
							
							LogService logService = (LogService) appCtx.getBean(LogService.class);	
							//LogService logService =(LogService) appCtx.getBean("logService");
							System.out.println("获取logservice" + logService);
							logService.insert(entity);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
							logger.error(e.toString());
						}
					} else {
						try {
							sleep(1000);
						} catch (InterruptedException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
	}
}
