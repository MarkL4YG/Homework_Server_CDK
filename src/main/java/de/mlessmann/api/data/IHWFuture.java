package de.mlessmann.api.data;

import java.util.NoSuchElementException;

/**
 * Created by Life4YourGames on 09.08.16.
 */
public interface IHWFuture<T> {

    boolean isDone();

    boolean isPresent();

    T get() throws NoSuchElementException;

    T getOrElse(T def);

    int errorCode();

    void registerListener(IHWFutureListener listener);

    public class ERRORCodes {

        public static final int UNKNOWN = -1;
        public static final int OK = 200;
        public static final int LOGGEDIN = 2001;

        public static final int PROTOError = 400;
        public static final int DATETIMEError = 4001;

        public static final int LOGINREQ = 401;
        public static final int INVALIDCREDERR = 401;
        
        public static final int NOTFOUNDERR = 404;

    }

}