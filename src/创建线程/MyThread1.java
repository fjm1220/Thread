package 创建线程;
//this就代表的是当前线程
public class MyThread1{
      private static class MyThread extends Thread {
          @Override
          public void run() {
              System.out.println("这里是线程运行的代码");
          }
      }
    public static void main(String[] args)
    {
        MyThread t = new MyThread();
        t.start();
    }
}

