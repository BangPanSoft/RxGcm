/*
 * Copyright 2016 Victor Albertos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rx_gcm.internal;


import android.os.Bundle;

import com.google.android.gms.gcm.GcmListenerService;

public class AppGcmListenerService extends GcmListenerService {

    @Override public void onMessageReceived(String from, Bundle data) {
        RxGcm.Notifications.onNotificationReceived(from, data);
    }

}
