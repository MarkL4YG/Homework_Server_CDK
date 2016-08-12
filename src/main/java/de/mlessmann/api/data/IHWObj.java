package de.mlessmann.api.data;

import de.mlessmann.api.annotations.API;
import de.mlessmann.api.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Life4YourGames on 09.08.16.
 */
@API
public interface IHWObj extends IHWCarrier {

    boolean isDummy();

    String id();

    String subject();

    int[] date();

    @Nullable
    String getDescription(boolean fromLongSrc);

    String optDescription(boolean fromLongSrc, String d);

}
