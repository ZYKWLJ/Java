import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-13 17:43
 **/
public class d通过线程池 {
    public void threadPool(int n){
        System.out.println("创建线程方法4-----通过线程池来创建");
        ExecutorService es = Executors.newFixedThreadPool(n);
        for (int i = 0; i < n; i++) {
           es.execute(()->{
               System.out.println(Thread.currentThread()+"is running");
           });
        }
    }
}
