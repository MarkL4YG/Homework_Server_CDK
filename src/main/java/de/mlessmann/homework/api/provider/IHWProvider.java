package de.mlessmann.homework.api.provider;

import org.json.JSONObject;

/**
 * Created by Life4YourGames on 14.12.16.
 */
public interface IHWProvider {

    String getName();
    String getAddress();
    String getPostal();
    String getCountry();
    String getState();

    JSONObject getJSON();
}