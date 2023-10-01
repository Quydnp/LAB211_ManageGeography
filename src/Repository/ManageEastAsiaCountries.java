/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Common.Validation;
import Model.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author HI
 */
public class ManageEastAsiaCountries implements IManageCountries{
    private ArrayList<EastAsiaCountries> countryList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Validation validation = new Validation();

    @Override
    public void addCountryInformation() {
        System.out.println("---------- Add Country -----------");
        System.out.print("Enter Code of country: ");
        String code = sc.nextLine();
        try {
            if (code.isEmpty()) {
                throw new NullPointerException("Null string entered.");
            }

            // Xử lý chuỗi nhập vào nếu không null
            if (validation.checkCodeExist(countryList, code) == -1) {
                String name = validation.inputString("Enter name of country: ", "[A-Za-z\\s]+");
                Float area = validation.inputFloat("Enter total Area: ", 0);
                String terrain = validation.inputString("Enter terrain of country: ", "[A-Za-z\\s]+");
                countryList.add(new EastAsiaCountries(terrain, code, name, area));
            } else {
                System.out.println("There has been a country with Code: " + code);
            }
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
            // Xử lý lỗi khi chuỗi nhập vào là null
        }
    }

    @Override
    public void getRecentlyEnteredInformation() {
        System.out.println("--------------------Country List------------------");
        if (countryList.isEmpty()) {
            System.out.println("Not found any country");
        } else {     
            System.out.printf("%-10s %-30s %-30s %-12s%n", "Code", "Name", "Total Area", "Terrain");
            this.countryList.stream().forEach(country -> country.display());
            System.out.println("Total: " + countryList.size());
        }
    }

    @Override
    public void searchInformationByName() {
        System.out.println("Input name to search: ");
        String name = sc.nextLine();
        Predicate<EastAsiaCountries> Predicate = EastAsiaCountries -> EastAsiaCountries.getCountryName().equalsIgnoreCase(name);
        List<EastAsiaCountries> foundCountries = new ArrayList<>();
        boolean isCountryFound = false;
        for (EastAsiaCountries eastAsiaCountry : countryList) {
            if (Predicate.test(eastAsiaCountry)) {
                foundCountries.add(eastAsiaCountry);
                isCountryFound = true;
            }
        }
        if (!isCountryFound) {
            System.out.println("Cannot find any country with the name: " + name);
        } else {
            System.out.printf("%-10s %-30s %-30s %-12s%n", "Code", "Name", "Total Area", "Terrain");
            foundCountries.stream().forEach(coutry -> coutry.display());
            System.out.println("Total: " + foundCountries.size());
        }
    }

    @Override
    public void sortInformationByAscendingOrder() {
        ArrayList<EastAsiaCountries> sortedList = new ArrayList<>();
        sortedList.addAll(countryList);
        Collections.sort(sortedList);
        System.out.println("--------------------Country List------------------");
        if (countryList.isEmpty()) {
            System.out.println("Not found any country");
        } else {     
            System.out.printf("%-10s %-30s %-30s %-12s%n", "Code", "Name", "Total Area", "Terrain");
            sortedList.stream().forEach(coutry -> coutry.display());
            System.out.println("Total: " + countryList.size());
        }
    }
}
