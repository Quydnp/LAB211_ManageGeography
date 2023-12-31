package view;

import Common.Validation;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu<T>  {

    protected String title;
    protected ArrayList<String> list = new ArrayList();
    
    public Menu(){}
    public Menu(String title, String[] s) {
        this.title = title;
        for (String item : s) {
            list.add(item);
        }
    }

    public void display() {
        System.out.println(title);
        System.out.println("--------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = new Validation().inputInt("Enter selection: ");
        return choice;
    }

    public abstract void execute(int choice);

    public void run() {
        int choice;
        do {
            display();//hiện menu
            choice = getChoice();
            execute(choice);//xử lý 
        } while (choice > 0 && choice < list.size());

    }
}
