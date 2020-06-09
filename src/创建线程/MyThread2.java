package 创建线程;
//需要用Thread.currentThread()来获取当前线程
public class MyThread2 {
    private static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"这里是线程运行代码");
        }
    }
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
