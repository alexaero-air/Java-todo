package Main;

public class DeliveryRequest implements Runnable{
    private final String serviceName;
    private final long delayMillis;
    private final double price;

    // станет true, только если дождались ответа
    private boolean successful;

    public DeliveryRequest(String serviceName, long delayMillis, double price) {
        this.serviceName = serviceName;
        this.delayMillis = delayMillis;
        this.price = price;
    }


    @Override
    public void run() {
        System.out.println("Запрашиваем стоимость у службы " + serviceName);
        try {
            // имитируем ожидание службы
            Thread.sleep(delayMillis);
            successful = true;
            System.out.println(serviceName + " доставка стоит " + price + " руб.");
        } catch (InterruptedException e) {
            // восстанавливаем признак прерывания текущего потока
            Thread.currentThread().interrupt();
            System.out.println("Запрос в службу " + serviceName + " прерван.");
        }
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
