package ru.vachok.networker.pasclass;



import ru.vachok.messenger.MessageCons;
import ru.vachok.messenger.MessageToUser;


/**
 * The type Person form.
 *
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
}