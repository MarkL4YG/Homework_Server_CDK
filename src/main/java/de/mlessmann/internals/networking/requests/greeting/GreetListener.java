package de.mlessmann.internals.networking.requests.greeting;

import de.mlessmann.api.networking.CloseReason;
import de.mlessmann.api.networking.IMessageListener;
import de.mlessmann.api.networking.IRequest;
import de.mlessmann.internals.logging.LMgr;
import de.mlessmann.internals.networking.requests.RequestMgr;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Life4YourGames on 18.08.16.
 */
public class GreetListener implements IRequest, IMessageListener {

    static final JSONObject REQ = new JSONObject();

    private String id;
    private int cid;
    private RequestMgr reqMgr;
    private LMgr lMgr;

    //------------------------------------------------------------------------------------------------------------------

    public GreetListener(LMgr logger) {
        lMgr = logger;
        genID();
    }


    private void genID() {
        id = this.toString();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        id = id + sdf.format(cal.getTime());
    }

    //------------------------------------- IRequest -------------------------------------------------------------------

    @Override
    public String getUniqueID() {
        return id;
    }

    @Override
    public boolean locksQueue() {
        return true;
    }

    @Override
    public JSONObject getRequestMsg() {
        return REQ;
    }

    @Override
    public void reportCommID(int cid) {
        //Don't care
    }

    @Override
    public void poke() {
        //Don't care
    }

    @Override
    public void reportFail(Exception e) {
        //Don't care
    }

    @Override
    public IMessageListener getListener() {
        return this;
    }

    //------------------------------------ IMessageListener ------------------------------------------------------------

    @Override
    public void onClosed(CloseReason rsn) {
        //Don't care
    }

    @Override
    public boolean onMessage(JSONObject msg) {
        if (msg.optInt("commID", -1) == 1) {
            if (msg.optInt("status", -1) == 200) {
                reqMgr.unregisterListener(this);
                reqMgr.unregisterRequest(this);
                //reqMgr.unlockQueue(this);
            }
            return true;
        }
        return false;
    }

    @Override
    public void reportMgr(RequestMgr mgr) {
        if (reqMgr != null)
            reqMgr.unregisterListener(this);
        reqMgr = mgr;
        reqMgr.registerListener(this);
    }

}
