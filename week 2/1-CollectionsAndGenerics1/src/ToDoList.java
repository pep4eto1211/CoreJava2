import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ToDoList {
    private int availableTime;

    public ToDoList(int availableTime) {
        this.availableTime = availableTime;
    }

    private List<Task> tasks = new ArrayList<>();

    public void markFinished(Task t){
        if (tasks.contains(t)){
            tasks.get(tasks.indexOf(t)).setFinished();
        }
    }

    public void markCancelled(Task t){
        if (tasks.contains(t)){
            tasks.get(tasks.indexOf(t)).setCanceled();
        }
    }

    public Task getTop(){
        return tasks.get(tasks.size() - 1);
    }

    public boolean canFinish(){
        int totalTime = 0;
        for (Task t : tasks){
            if ((!t.isCanceled()) && (!t.isFinished())){
                totalTime += t.getTimeNeeded();
            }
        }

        return (availableTime >= totalTime);
    }

    public int getRemainigTime(){
        int totalTime = 0;
        for (Task t : tasks){
            if ((!t.isCanceled()) && (!t.isFinished())){
                totalTime += t.getTimeNeeded();
            }
        }

        return availableTime - totalTime;
    }

    public void addTask(Task t){
        tasks.add(t);
        tasks.sort(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getPriority() - o2.getPriority();
            }
        });
    }
}
