public class OnOffCollection <T> {
    //Class<T> clazz;
    Object[] OnOfArray = new Object[32];
    int currentCounter = 0;

    public OnOffCollection(){

    }

    private boolean contains(T item){
        for (Object singleItem : OnOfArray){
            if (singleItem == item){
                return true;
            }
        }
        return false;
    }

    boolean add(T item){
        if (item != null) {
            if (!contains(item)) {
                if (currentCounter <= OnOfArray.length - 1) {
                    OnOfArray[currentCounter] = item;
                    currentCounter++;
                } else {
                    Object[] newArray = new Object[OnOfArray.length * 2 + 1];
                    System.arraycopy(OnOfArray, 0, newArray, 0, OnOfArray.length - 1);
                    OnOfArray = newArray;
                    OnOfArray[currentCounter] = item;
                    currentCounter++;
                }
                return true;
            } else {
                for (int i = 0; i <= currentCounter; i++) {
                    if (OnOfArray[i] == item) {
                        Object[] newArray = new Object[OnOfArray.length];
                        int counter = 0;
                        for (int j = 0; j <= currentCounter; j++) {
                            if (j != i) {
                                newArray[counter] = OnOfArray[j];
                                counter++;
                            }
                        }
                        OnOfArray = newArray;
                        currentCounter--;
                        break;
                    }
                }
                return false;
            }
        }
        else {
            return false;
        }
    }

    void remove(int index){
        Object[] newArray = new Object[OnOfArray.length];
        int counter = 0;
        for (int j = 0; j <= currentCounter; j++) {
            if (j != index) {
                newArray[counter] = OnOfArray[j];
                counter++;
            }
        }
        OnOfArray = newArray;
        currentCounter--;
    }

    Object getItem(int index){
        return OnOfArray[index];
    }

    int size(){
        return currentCounter;
    }

}
