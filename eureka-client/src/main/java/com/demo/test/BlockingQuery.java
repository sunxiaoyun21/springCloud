package com.demo.test;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞队列
 * @author 孙小云
 * @version 4.0
 * @date 2020/11/25$ 13:19
 **/
public class BlockingQuery {

    private Object[] tab;//队列容器
    private int takeIndex;//出队下标
    private int putIndex;//入队下标
    private int size;//元素数量
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition notEmpty;//读条件
    private Condition notFull;//写条件

    public BlockingQuery(int tableCount){
        if(tableCount<=0){
             new NullPointerException();
        }

       tab = new Object[tableCount];
       notEmpty = reentrantLock.newCondition();
        notFull = reentrantLock.newCondition();

    }

   public Boolean offer(Object obj){
        if(obj==null){
            throw new NullPointerException();
        }

       try {
           //获取锁
           reentrantLock.lock();
           while (size == tab.length){
               System.out.println("队列已满");
               //堵塞
               notFull.await();
           }
           tab[putIndex] = obj ;
           if(++putIndex==tab.length){
               putIndex=0;
           }
           size++;
           //唤醒读线程
           notEmpty.signal();
           return true;
       } catch (Exception e) {
           notEmpty.signal();
       }finally {
            reentrantLock.unlock();
       }

       return false;
   }


   public Object  take(){
        try {
            reentrantLock.lock();
            while (size==0){
                System.out.println("队列空了");
                notEmpty.await();
            }
        Object object = tab[takeIndex];
         //如果到了最后一个，则从头开始
            if(++takeIndex == tab.length){
                takeIndex=0;
                notEmpty.await();
            }
            takeIndex--;
            notEmpty.signal();
            return object;

        }catch (Exception e){

            notEmpty.signal();

        }finally {
            reentrantLock.unlock();
        }
        return null;
   }

    public static void main(String[] args) {
        Random random = new Random(100);
        BlockingQuery blockingQuery = new BlockingQuery(5);
        Thread thread = new Thread(()->{
           for (int i=0;i<100;i++){
               try {
                   Thread.sleep(300);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               blockingQuery.offer(i);
               System.out.println("生产者生产了"+i);
           }
        });

        Thread thread1 = new Thread(()->{
            for (int i=0; i<100;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            Object o = blockingQuery.take();
                System.out.println("消费者消费了"+o );
            }
        });
        thread.run();
        thread1.run();
    }
}
