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

        applicantInfosProp.setProperty("givenName", givenName);
        applicantInfosProp.setProperty("familyName", familyName);
        applicantInfosProp.setProperty("dob", dob);
        applicantInfosProp.setProperty("national", national);
        applicantInfosProp.setProperty("email", email);
        applicantInfosProp.setProperty("familyYOrN", familyYOrN);
        applicantInfosProp.setProperty("passportNum", passportNum);
        return applicantInfosProp;
    }
}
