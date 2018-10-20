package com.jdk1_8.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 16:22 2018/9/5
 * @Modified By:
 */
public class BlockingQueueService
{
	private static void linkedBlockingQueue() throws InterruptedException
	{
		LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>();
		queue.add("1");//底层调用offerLast，队列满了，抛出"Deque full"
		System.out.println(queue);
		queue.offer("2");//实际调用offerLast，不会进行重试
		System.out.println(queue);
		queue.addFirst("3");//不会进行重试
		System.out.println(queue);
		queue.addLast("4");//不会进行重试
		System.out.println(queue);
		queue.push("5");//实际调用addFirst
		System.out.println(queue);
		queue.put("6");//调用putLast，会进行重试
		System.out.println(queue);
		queue.putFirst("7");//会进行重试
		System.out.println(queue);
		queue.putLast("8");//会进行重试
		System.out.println(queue);

		queue.peek();
		System.out.println(queue);
		queue.peekFirst();
		System.out.println(queue);
		queue.peekLast();
		System.out.println(queue);
		System.out.println(queue.getFirst());
		System.out.println(queue.getLast());
		queue.poll();
		System.out.println(queue);
		queue.pollFirst();
		System.out.println(queue);
		queue.pollLast();
		System.out.println(queue);
		queue.poll(5, TimeUnit.MILLISECONDS);
		System.out.println(queue);
		queue.remove();
		System.out.println(queue);
		queue.removeFirst();
		System.out.println(queue);
		queue.removeLast();
		System.out.println(queue);

	}

	/**
	 * 不排队，每次任务来了创建线程处理
	 */
	public static void SynchronousQueue()
	{
		SynchronousQueue queue = new SynchronousQueue();
		try
		{
			queue.put("");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public static void ArrayBlockingQueue()
	{
		ArrayBlockingQueue queue = new ArrayBlockingQueue(100);
		for(int i = 0; i < 102; i++)
		{
			try
			{
				queue.put(i);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args)
	{
		try
		{
			linkedBlockingQueue();
			SynchronousQueue();
			ArrayBlockingQueue();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
