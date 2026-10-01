package Main;

public class Main {
    public static void main(String[] args) {
        DeliveryRequest[] requests = {
            new DeliveryRequest("Экспресс",340,500),
            new DeliveryRequest("Город",300,350),
            new DeliveryRequest("Посылка",320,420)
        };

        Thread[] threads = new Thread[requests.length];

        // Сначала запускаем все запросы

        for (int i=0; i<requests.length; i++){
            threads[i] = new Thread(requests[i]);
            threads[i].start();
        }

        // только после запуска всех запросов ждем их завершения
        try {
            for (Thread thread : threads){
                thread.join();
            }
        } catch (InterruptedException e) {
            // Если прервалось ожидание в main, отменяем все запросы
            for (Thread thread : threads){
                thread.interrupt();
            }
            Thread.currentThread().interrupt();
            System.out.println("Ожидание ответов прервано. Подбор доставки отменен");
            return;
        }

        System.out.println();
        System.out.println("Все запросы завершены");
        DeliveryRequest best = null;

        for (DeliveryRequest request : requests){
            // Пропускаем службы от которых не получили ответ

            if (!request.isSuccessful()){
                System.out.println("Служба " + request.getServiceName() + " не ответила на запрос");
                continue;
            }

            // Запомним первое предложение и самое дешевое

            if (best == null || request.getPrice() < best.getPrice()){
                best = request;
            }
        }
        if (best == null){
            System.out.println("Подобрать доставку не удалось: нет предложений.");
        } else {
            System.out.println("Самая дешевая доставка: "
                    + best.getServiceName() + ", " + best.getPrice() + " руб.");
        }
    }
}
