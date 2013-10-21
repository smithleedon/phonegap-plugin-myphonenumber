/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/
package com.smithleedon.device;

import java.util.TimeZone;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.DroidGap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.telephony.TelephonyManager;

public class MyPhoneNumber extends CordovaPlugin {

    public static final String ACTION_ADD_CALENDAR_ENTRY = "getphonenumber";
    public static String strPhoneNumber;
    private CordovaInterface mGap;
    
    /**
     * Constructor.
     */
    public MyPhoneNumber() {
        
    }
    
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.initTelephonyReceiver();
    }
    private void initTelephonyReceiver() {
        mGap = this.cordova;
        TelephonyManager mTelephonyMgr = (TelephonyManager) mGap.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
        strPhoneNumber = mTelephonyMgr.getLine1Number();
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (ACTION_ADD_CALENDAR_ENTRY.equals(action)) { 
            JSONObject r = new JSONObject();
            r.put("mynumber",strPhoneNumber);
           
            callbackContext.success(r);
        }
        else {
            return false;
        }
        return true;
    }
}

