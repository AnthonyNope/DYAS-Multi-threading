import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static class FileProcessor implements Runnable {
        private String fileName;

        public FileProcessor(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            System.out.println("Procesando archivo: " + fileName + " en hilo: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Archivo procesado: " + fileName);
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new FileProcessor("datos1.csv"));
        executor.submit(new FileProcessor("datos2.csv"));
        executor.submit(new FileProcessor("datos3.csv"));
        executor.shutdown();
    }
}
