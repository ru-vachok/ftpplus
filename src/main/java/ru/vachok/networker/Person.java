package ru.vachok.networker;



import ru.vachok.messenger.MessageCons;
import ru.vachok.messenger.MessageToUser;


/**
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


    public Person() {

    }


    public Person( String firstName , String lastName ) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }
}