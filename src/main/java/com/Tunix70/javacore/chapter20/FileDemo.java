package Tunix70;

import java.io.File;

class FileDemo {
    static void p(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {
	File f1 = new File("C:\\Users\\Konstantin\\IdeaProjects\\20\\src\\Tunix70\\COPYRIGHT");
	p("Имя файла: " + f1.getName());
	p("Путь: " + f1.getPath());
	p("Абсолютный путь: " + f1.getAbsolutePath());
	p("Родительский каталог: " + f1.getParent());
	p(f1.exists() ? "Существует" : "не существует");
	p(f1.canWrite() ? "Доступен для записи" : "недоступен для записи");
	p(f1.canRead() ? "Доступен для чтения" : "Недоступен для чтения");
	p(f1.isDirectory() ? "является каталогом" : "не является каталогом");
	p(f1.isFile() ? "является обычным файлом" : "может быть именнованным каталогом");
	p(f1.isAbsolute() ? "является абсолютным" : "не является абсолютным");
	p("последнее изменение в файле: " + f1.lastModified());
	p("Размер: " + f1.length() + " байт");
    }
}
