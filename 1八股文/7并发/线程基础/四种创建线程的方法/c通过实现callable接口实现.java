import java.util.concurrent.Callable;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-13 17:41
 **/
public class c通过实现callable接口实现 implements Callable {
    @Override
    public Object call() throws Exception {
        return "创建线程方法3-----通过实现Callable接口实现";
    }
}
