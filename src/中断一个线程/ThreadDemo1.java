package 中断一个线程;
//通过共享标记进行沟通
public class ThreadDemo1 {
    private static class MyRunnable implements Runnable{
        public volatile boolean isQuit = false;

        @Override
        public void run() {
            while(!isQuit)
            {
                System.out.println(Thread.currentThread().getName()+"别管我，我在忙着转账呢");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e) {
                  e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":险些误了大事");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        MyRunnable runnable = new MyRunnable();
        Thread t = new Thread(runnable,"李四");
        System.out.println("李四开始转账");
        t.start();
        t.sleep(5*1000);
        System.out.println("赶紧通知李四对方是个骗子");
        runnable.isQuit = true;
    }
}
