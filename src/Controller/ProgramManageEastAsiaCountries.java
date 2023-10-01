/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Repository.ManageEastAsiaCountries;
import view.Menu;

/**
 *
 * @author HI
 */
public class ProgramManageEastAsiaCountries extends Menu<String> {
    private ManageEastAsiaCountries manager;
    static String[] options = {
        "Input the information of 11 countries in East Asia",
        "Display the information of country you 've just inputted",
        "Search the information of country by user-entered name",
        "Display the information of countries sorted name in ascending order",
        "Exit"
    };

    public ProgramManageEastAsiaCountries() {
        super("========= MENU =========", options);
        manager = new ManageEastAsiaCountries();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1: {
                manager.addCountryInformation();
                break;
            }
            case 2: {
                manager.getRecentlyEnteredInformation();
                break;
            }
            case 3: {
                manager.searchInformationByName();
                break;
            }
            case 4: {
                manager.sortInformationByAscendingOrder();
                break;
            }
            case 5: {
                System.exit(0);
            }
        }
    }
}
