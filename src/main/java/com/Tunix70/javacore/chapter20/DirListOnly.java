package main.java.com.Tunix70.javacore.chapter20;


import java.io.File;
import java.io.FilenameFilter;

class OnlyExt implements FilenameFilter{
    String ext;

    public OnlyExt(String ext){
        this.ext = "." + ext;
    }
    public boolean accept(File dir, String name){
        return name.endsWith(ext);
    }
}

// вывести только файлы с расширением .html
class DirListOnly {
    public static void main(String[] args) {
        String dirname = "C:\\Users\\Konstantin\\IdeaProjects\\20";
        File f1 = new File(dirname);
        FilenameFilter only = new OnlyExt("html");
        String s[] = f1.list(only);

        for (int i = 0; i <s.length ; i++) {
            System.out.println(s[i]);
        }
    }
}
