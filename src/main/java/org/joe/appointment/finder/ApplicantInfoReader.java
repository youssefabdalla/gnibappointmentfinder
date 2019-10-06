package org.joe.appointment.finder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by AbdallaY on 05/10/2019.
 */
public class ApplicantInfoReader {

    public static final String GIVEN_NAME = "givenName";
    public static final String FAMILY_NAME = "familyName";
    public static final String DOB = "dob";
    public static final String NATIONAL = "national";
    public static final String EMAIL = "email";
    public static final String FAMILY_Y_OR_N = "familyYOrN";
    public static final String PASSPORT_NUM = "passportNum";

    public void getApplicantInfoInFile() throws IOException {
        File applicantInfoFile = new File("applicant-info.properties");
        if (applicantInfoFile.exists()) {
            System.out.println("applicant-info file exists use it?[y/n]");
            String shouldInfoFileUpdated = new Scanner(System.in).nextLine();
            switch (shouldInfoFileUpdated) {
                case "y":
                case "Y":
                    System.out.println("using same file found!");
                    break;
                case "n":
                case "N":
                    applicantInfoFile.delete();
                    applicantInfoFile.createNewFile();
                    Properties applicantInfosProp = getApplicantInfo();
                    FileWriter fw = new FileWriter(applicantInfoFile);
                    applicantInfosProp.store(fw, null);
                    break;
                default:
                    System.out.println("using same file found!");
            }
        } else {
            Properties applicantInfosProp = getApplicantInfo();
            FileWriter fw = new FileWriter(applicantInfoFile);
            applicantInfosProp.store(fw, null);
        }
    }

    private Properties getApplicantInfo() {
        Properties applicantInfosProp = new Properties();
        Scanner info = new Scanner(System.in);
        System.out.println("given name:");
        String givenName = info.nextLine();
        System.out.println("family name:");
        String familyName = info.nextLine();
        System.out.println("date of birth in format(dd/mm/yyyy):");
        String dob = info.nextLine();
        System.out.println("country of nationality:");
        String national = info.nextLine();
        System.out.println("email:");
        String email = info.nextLine();
        System.out.println("family application?[y/n]:");
        String familyYOrN = info.nextLine();
        System.out.println("passport number:");
        String passportNum = info.nextLine();

        applicantInfosProp.setProperty(GIVEN_NAME, givenName);
        applicantInfosProp.setProperty(FAMILY_NAME, familyName);
        applicantInfosProp.setProperty(DOB, dob);
        applicantInfosProp.setProperty(NATIONAL, national);
        applicantInfosProp.setProperty(EMAIL, email);
        applicantInfosProp.setProperty(FAMILY_Y_OR_N, familyYOrN);
        applicantInfosProp.setProperty(PASSPORT_NUM, passportNum);
        return applicantInfosProp;
    }
}
