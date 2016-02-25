/*
 *  Copyright (C) 2015 The IDigiSign Android Project
 *
 *  Licensed under the Deepnet Security (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.deepnetsecurity.com/legal/
 *
 *  Under the international copyright law, neither the Deepnet
 *  Security software or documentation may be copied, reproduced,
 *  translated or reduced to any electronic medium or machine
 *  readable form, in whole or in part, without the prior written
 *  consent of Deepnet Security.
 *
 *  Please read your licence agreement with Deepnet carefully
 *  and make sure you understand the exact terms of usage.
 *  In particular, for which projects, on which platforms and
 *  at which sites, you are allowed to use the product.
 *  You are not allowed to make any modifications to the
 *  product. If you feel the need for any modifications, please
 *  contact Deepnet Security.
 */

package com.iclockin.alarmdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Android Studio.
 * User: xin
 * Date: 17/02/2016 0017
 * Time: 12:43:44 PM
 * Version: V 1.0
 */

public class AlarmBroadcast extends BroadcastReceiver{


    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent("NetworkBroadcast");
        i.putExtra("action", "alarm finish");
        context.sendBroadcast(i);
    }
}
