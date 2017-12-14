package org.wzz.test.string;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.wangzz.core.queue.QueueConsumer;
import org.wangzz.core.queue.QueuesHolder;

public class TestQue {


	public static void main(String[] args) throws Exception {
		String queueName = "testBackup";
		String filePath = System.getProperty("java.io.tmpdir") + File.separator + "queue" + File.separator + queueName;
//		
		BlockingQueue queue = QueuesHolder.getQueue(queueName);
		Date date1 = new Date();
		
		queue.offer(date1);
		
		Thread.sleep(2000);
		
		Date date2 = new Date();
		queue.offer(date2);
		Thread.sleep(2000);
		

		MockConsumerTask task = new MockConsumerTask();
		task.run();
//		task.stop();
//		
//		//判断存在持久化文件
//		File file = new File(filePath);
//		
//		System.out.println(file.exists());
//		
//		ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file));
//		List list = new ArrayList();
//		while (true) {
//			try {
//				Object obj = oos.readObject();
//				list.add(obj);
//			} catch (EOFException e) {
//				break;
//			}
//		}
//		System.out.println(list.size());
		
//		System.out.println(filePath);
		
		
		
	}
	
	static class MockConsumerTask implements Runnable {
		public void run() {
			BlockingQueue queue = QueuesHolder.getQueue("testBackup");
			Date date3 = (Date) queue.poll();
			System.out.println(date3);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Date date4 = (Date) queue.poll();
			System.out.println(date4);
		}
	}

}
