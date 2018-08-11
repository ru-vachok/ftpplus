package ru.vachok.networker;



import ru.vachok.messenger.MessageCons;
import ru.vachok.messenger.MessageToUser;


/**
 * @since 11.08.2018 (21:29)
 */
public class PersonForm {

    /**
     * Simple Name класса, для поиска настроек
     */
    private static final String SOURCE_CLASS = PersonForm.class.getSimpleName();
    /**
     * {@link }
     */
    private static MessageToUser messageToUser = new MessageCons();
    private String firstName;
    private String lastName;


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