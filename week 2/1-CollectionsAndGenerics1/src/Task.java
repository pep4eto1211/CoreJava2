public class Task {
    private int priority;
    private int timeNeeded;
    private String note;
    private boolean finished = false;
    private boolean canceled = false;

    public Task(int priority, int timeNeeded, String note) {
        this.priority = priority;
        this.timeNeeded = timeNeeded;
        this.note = note;
    }

    public int getPriority() {
        return priority;
    }

    public void setFinished(){
        this.finished = true;
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(){
        this.canceled = true;

    }

    public int getTimeNeeded() {
        return timeNeeded;
    }
}
