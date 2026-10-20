package Main;

public class Task {
    private final String title;
    private boolean completed;

    public Task(String title){
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Введите название задачи");
        }
        this.title = title.strip();
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted(){
        completed = true;
    }

    @Override
    public String toString(){
        return (completed ? "[o]"+title:"[ ]"+title);
    }

}
