package com.smithleedon.device;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;

public class MyPhoneNumber extends CordovaPlugin {
    public static final String ACTION_ADD_CALENDAR_ENTRY = "getphonenumber";
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (ACTION_ADD_CALENDAR_ENTRY.equals(action)) { 
               JSONObject r = new JSONObject();
               r.put("mynumber","01062698888");

               callbackContext.success(r);
            }
            callbackContext.error("Invalid action");
            return false;
        } catch(Exception e) {
            callbackContext.error(e.getMessage());
            return false;
        } 
    }
}