package com.company.actors;

import com.company.game.EnumData;

import java.text.NumberFormat;
import java.util.Arrays;

public class Customer {
    public String firstName;
    public String lastName;
    EnumData.VechicleBrands[] brandPreference; // ulubione marki - tablica 2 obiektów
    public Double money;
    EnumData.VechicleType vechicleType;
    int vechicleCondition;
    Integer desiredCapacity;
    // do wyświetlania za pomocą toString() Id klienta na liście
    public static int id;


    public Customer(String firstName, String lastName, EnumData.VechicleBrands[] brandPreference, Double money, EnumData.VechicleType vechicleType, int vechicleCondition, Integer desiredCapacity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.brandPreference = brandPreference;
        this.money = money;
        this.vechicleType = vechicleType;
        this.vechicleCondition = vechicleCondition;
        this.desiredCapacity = desiredCapacity;
    }

    public String acceptableState(int vechicleCondition) {
        if (vechicleCondition <= EnumData.CustomerVechicleCondition.BROKEN.buyingVillingness) {
            return "Akceptuje dowolne uszkodzenie";
        } else if (vechicleCondition <= EnumData.CustomerVechicleCondition.FAULTYSUSPENSION.buyingVillingness) {
            return "Akceptuje uszkodzenie zawieszenia";
        } else {
            return "Akceptuje tylko sprawne pojazdy";
        }
    }

    // można by zrobić metode która pokazywała by tylko poządane pojazdy - jeśli bedzie czas.

    @Override
    public String toString() {
        return "\nKlient: " + "[" + id + "]\n" +
                "\tImię: " + firstName + '\n' +
                "\tNazwisko: " + lastName + '\n' +
                "\tPożądane marki" + Arrays.toString(brandPreference) + '\n' +
                "\tPosiadana gotówka: " + NumberFormat.getCurrencyInstance().format(money) + '\n' +
                "\tTyp pojazdu: " + ((vechicleType == EnumData.VechicleType.CAR) ? "Osobowy" : "Dostawczy") + '\n' +
                ((vechicleType == EnumData.VechicleType.TRUCK) ? "\tOczekiwana ładowność: " + desiredCapacity : "") +
                "\n\tDopuszczalny stan: " + acceptableState(vechicleCondition) +
                "\n------------------------------------------------------------\n";
    }

}
