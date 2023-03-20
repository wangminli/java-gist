package wang.minli.java.gist.async;

import lombok.SneakyThrows;

public class AsyncTest {
    @SneakyThrows
    public static void main(String[] args) {
        FutureManager manager = new FutureManager();
        FutureManager2 manager2 = new FutureManager2();

        manager.execute();
        manager2.execute();
    }
}
