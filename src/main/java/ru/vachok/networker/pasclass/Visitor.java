package ru.vachok.networker.pasclass;



import java.io.IOException;


/**
 * Created by 14350 on 12.08.2018 1:19
 */
public class Visitor {

    /**
     * The Time st.
     */
    long timeSt;
    /**
     * The Rem addr.
     */
    String remAddr;
    private Repo repo;

    {
        try {
            repo = Repo.getI(timeSt , remAddr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Instantiates a new Visitor.
     *
     * @param timeSt  the time st
     * @param remAddr the rem addr
     */
    public Visitor( long timeSt , String remAddr ) {
        this.timeSt = timeSt;
        this.remAddr = remAddr;
    }


    /**
     * Gets time st.
     *
     * @return the time st
     */
    public long getTimeSt() {
        return timeSt;
    }


    /**
     * Sets time st.
     *
     * @param timeSt the time st
     */
    public void setTimeSt( long timeSt ) {
        this.timeSt = timeSt;
    }


    /**
     * Gets rem addr.
     *
     * @return the rem addr
     */
    public String getRemAddr() {
        return remAddr;
    }


    /**
     * Sets rem addr.
     *
     * @param remAddr the rem addr
     */
    public void setRemAddr( String remAddr ) {
        this.remAddr = remAddr;
    }
}
