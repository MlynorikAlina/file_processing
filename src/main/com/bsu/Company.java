package com.bsu;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Company {
    private final String name;
    private final String shortName;
    private final Date actualizationDate;
    private final String address;
    private final Date dateOfFoundation;
    private final int employeeNumber;
    private final String auditor;
    private final String telephoneNumber;
    private final String email;
    private final String industry;
    private final String activity;
    private final String site;

    public static final SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    Company(String[] args) throws ParseException {
        name = args[0];
        shortName = args[1];
        actualizationDate = format.parse(args[2]);
        address = args[3];
        dateOfFoundation = format.parse(args[4]);
        employeeNumber = Integer.parseInt(args[5]);
        auditor = args[6];
        telephoneNumber = args[7];
        email = args[8];
        industry = args[9];
        activity = args[10];
        site = args[11];
    }

    private String getStringLine(Character sep) {
        return (name + sep + shortName + sep + format.format(actualizationDate) + sep + address + sep + format.format(dateOfFoundation) + sep +
                employeeNumber + sep + auditor + sep + telephoneNumber + sep + email + sep + industry + sep + activity + sep + site);
    }

    @Override
    public String toString() {
        return getStringLine(';');
    }

    static List<Company> readListOfCompanies(Scanner input) throws ParseException {
        String[] lineArgs;
        List<Company> companyList = new ArrayList<>();

        while (input.hasNextLine()) {
            lineArgs = input.nextLine().split(";");
            companyList.add(new Company(lineArgs));
        }
        return companyList;
    }

    public String getShortName() {
        return shortName;
    }

    public String getIndustry() {
        return industry;
    }

    public String getActivity() {
        return activity;
    }

    public Date getDateOfFoundation() {
        return dateOfFoundation;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }
}
