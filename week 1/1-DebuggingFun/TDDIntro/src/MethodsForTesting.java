public class MethodsForTesting {
    static int getNumberOfDigits(int number){
        int counter = 1;
        while(number / 10 > 0){
            number /= 10;
            counter++;
        }
        return counter;
    }

    static String stichMeUp(String glue, Object... ellements){
        String stich = "";
        for (Object singleObject : ellements){
            stich += singleObject.toString() + glue;
        }
        stich = stich.substring(0, stich.length() - 1);
        return stich;
    }

    static String reduceFilePath(String path){
        path = path.replaceAll("//", "/");

        while (path.indexOf("..") != -1){
            int index = -1;
            for (int i = path.indexOf("..") - 2; i > 0; i--){
                if (path.charAt(i) == '/'){
                    index = i;
                    break;
                }
            }
            if (index != -1){
                String newPath = path.substring(0, index) + path.substring(path.indexOf("..") + 2);
                path = newPath;
            }
            else{
                path = path.substring(path.indexOf("..") + 2);
            }
        }

        while(path.indexOf(".") != -1){
            path = path.replace(".", "");
        }
        path = path.replaceAll("//*", "/");

        if (path.charAt(path.length() - 1) == '/'){
            path = path.substring(0, path.length() - 1);
        }

        if (path.isEmpty()){
            path = "/";
        }
        return path;
    }
}
