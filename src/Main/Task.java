package Main;

import java.time.LocalDateTime;

public class Task {
    private final String title;
    private String comment;
    private boolean completed;

    private final LocalDateTime createAt;
    LocalDateTime completeAt;

    // Сохранить возможность создать задачу только с названием.
    public Task(String title) {
        this(title, "");
    }

    // Создание новой задачи.
    public Task(String title, String comment) {
        this(title, comment, LocalDateTime.now(), false, null);
    }

    // Восстановление задачи из сохраненных данных

    public Task(String title, String comment, LocalDateTime createAt,
                boolean completed, LocalDateTime completeAt) {
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("Введите название задачи.");
        }
        if (createAt == null){
            throw new IllegalArgumentException("Не указана дата сохранения");
        }
        if (completed && completeAt == null){
            throw new IllegalArgumentException("Не указана дата выполнения");
        }
        if (!completed && completeAt == null){
            throw new IllegalArgumentException("Невыполненная задача имеет дату выполнения");
        }

        this.title = title.strip();
        setComment(comment);

        this.createAt = createAt;
        this.completed = completed;
        this.completeAt = completeAt;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? "" : comment;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getCompleteAt() {
        return completeAt;
    }

    public void markCompleted(){
        if (!completed){
            completeAt = LocalDateTime.now();
            completed = true;
        }
    }
    // Используется сервисом, если сохранить выполнение не удалось.

    void undoCompletion(){
        completed = false;
        completeAt = null;
    }
    @Override
    public String toString(){
        return (completed ? "[\uD83D\uDDF8]" : "[x]") + title;
    }
}
