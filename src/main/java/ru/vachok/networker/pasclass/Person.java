package ru.vachok.networker.pasclass;



import ru.vachok.messenger.MessageCons;
import ru.vachok.messenger.MessageToUser;

import java.io.FileWriter;
import java.io.IOException;


/**
 * The type Person.
 *
 * @since 11.08.2018 (21:14)
 */
public class Person {

    /**
     * Simple Name класса, для поиска настроек
     */
    private static final String SOURCE_CLASS = Person.class.getSimpleName();
    /**
     * {@link }
     */
    private static MessageToUser messageToUser = new MessageCons();
    private String firstName;
    private String lastName;



    /**
     * Instantiates a new Person.
     */
    public Person() {
        writeToWriter();
    }


    /**
     * Instantiates a new Person.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public Person( String firstName , String lastName ) {
        this.firstName = firstName;
        this.lastName = lastName;
        writeToWriter();
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }


    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }


    public void writeToWriter() {
        try (FileWriter fileWriter = new FileWriter(System.currentTimeMillis() + "_personID.txt")) {
            for (char c : lastName.toCharArray()) {
                fileWriter.append(c);
            }
            fileWriter.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}