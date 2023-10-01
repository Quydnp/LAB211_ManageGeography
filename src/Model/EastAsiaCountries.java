/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author HI
 */
public class EastAsiaCountries extends Country {

    private String countryTerrain;

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public EastAsiaCountries(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public EastAsiaCountries(String countryTerrain, String countryCode, String countryName, float totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        System.out.printf("%-10s %-30s %-30s %-12s%n", super.getCountryCode(), super.getCountryName(), super.getTotalArea(), this.getCountryTerrain());
    }

    @Override
    public int compareTo(Country o) {
        return super.countryName.compareTo(o.countryName);
    }
}
