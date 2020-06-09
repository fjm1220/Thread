package 中断一个线程;

//通过interrupt()方法
public class ThreadDemo2 {
    private static class MyRunnable implements Runnable{
        @Override
        public void run() {
            while(!Thread.interrupted()){
         //while(!Thread.currentThread().isInterrupted())
                System.out.println(Thread.currentThread().getName()+":别管我，我在忙着转账呢");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName()+":险些误了大事");
        }
    }
    public static void main(String[] args) throws InterruptedException{
        MyRunnable runnable = new MyRunnable();
        Thread t = new Thread(runnable,"李四");
        System.out.println(Thread.currentThread().getName()+":李四开始转账");
        t.start();
        t.sleep(5*1000);
        System.out.println("赶紧通知李四对方是个骗子");
        t.interrupt();
    }
}

