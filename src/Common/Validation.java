/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import Model.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HI
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public int checkCodeExist(ArrayList<EastAsiaCountries> students, String code) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getCountryCode().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }

    public float inputFloat(String mess, float min) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            try {
                float number = Float.parseFloat(input);
                if (number <= min) {
                    System.out.print("Please input greater than " + min + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an float number: ");
            }
        }
    }

    public String inputString(String mess, String regex) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            if (!input.matches(regex)) {
                System.out.println("Please input matched with regex:" + regex);
                continue;
            }
            if (input.equals("")) {
                System.out.print("Please input a non-empty string: ");
                continue;
            }
            return input;
        }
    }

    public int inputInt(String mess) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                return number;
            } catch (Exception e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }

}
