/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * A class for presenting a service binder for API 21.
 *
 * MediaBrowserServiceCompat should inherit a private class, MediaBrowserService.ServiceBinder,
 * which extends IMediaBrowserService.Stub. As a way to inherit the private class,
 * ServiceBinderAdapterApi21 implements all necessary functionalities including the codes in the
 * auto generated hidden class, IMediaBrowserService.Stub for API 21.
 */
class ServiceBinderAdapterApi21 extends Binder implements IInterface {
    // Following TRANSACTION_XXX values are synchronized with the auto generated java file
    // from IMediaBrowserService.aidl
    private static final int TRANSACTION_connect = IBinder.FIRST_CALL_TRANSACTION + 0;
    private static final int TRANSACTION_disconnect = IBinder.FIRST_CALL_TRANSACTION + 1;
    private static final int TRANSACTION_addSubscription = IBinder.FIRST_CALL_TRANSACTION + 2;
    private static final int TRANSACTION_removeSubscription =
            IBinder.FIRST_CALL_TRANSACTION + 3;

    static final String DESCRIPTOR = "android.service.media.IMediaBrowserService";
    final MediaBrowserServiceCompatApi21.ServiceImplApi21 mServiceImpl;

    public ServiceBinderAdapterApi21(
            MediaBrowserServiceCompatApi21.ServiceImplApi21 serviceImpl) {
        mServiceImpl = serviceImpl;
        attachInterface(this, DESCRIPTOR);
    }

    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
            throws RemoteException {
        switch (code) {
            case IBinder.INTERFACE_TRANSACTION: {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            case TRANSACTION_connect: {
                data.enforceInterface(DESCRIPTOR);
                String arg0 = data.readString();
                Bundle arg1;
                if (data.readInt() != 0) {
                    arg1 = Bundle.CREATOR.createFromParcel(data);
                } else {
                    arg1 = null;
                }
                Object arg2 = ServiceCallbacksAdapterApi21.Stub.asInterface(
                        data.readStrongBinder());
                connect(arg0, arg1, arg2);
                return true;
            }
            case TRANSACTION_disconnect: {
                data.enforceInterface(DESCRIPTOR);
                Object arg0 = ServiceCallbacksAdapterApi21.Stub.asInterface(
                        data.readStrongBinder());
                disconnect(arg0);
                return true;
            }
            case TRANSACTION_addSubscription: {
                data.enforceInterface(DESCRIPTOR);
                String arg0 = data.readString();
                Object arg1 = ServiceCallbacksAdapterApi21.Stub.asInterface(
                        data.readStrongBinder());
                addSubscription(arg0, arg1);
                return true;
            }
            case TRANSACTION_removeSubscription: {
                data.enforceInterface(DESCRIPTOR);
                String arg0 = data.readString();
                Object arg1 = ServiceCallbacksAdapterApi21.Stub.asInterface(
                        data.readStrongBinder());
                removeSubscription(arg0, arg1);
                return true;
            }
        }
        return super.onTransact(code, data, reply, flags);
    }

    void connect(String pkg, Bundle rootHints, Object callbacks) {
        mServiceImpl.connect(pkg, rootHints,
                new MediaBrowserServiceCompatApi21.ServiceCallbacksImplApi21(callbacks));
    }

    void disconnect(Object callbacks) {
        mServiceImpl.disconnect(
                new MediaBrowserServiceCompatApi21.ServiceCallbacksImplApi21(callbacks));
    }

    void addSubscription(String id, Object callbacks) {
        mServiceImpl.addSubscription(id,
                new MediaBrowserServiceCompatApi21.ServiceCallbacksImplApi21(callbacks));
    }

    void removeSubscription(String id, Object callbacks) {
        mServiceImpl.removeSubscription(id,
                new MediaBrowserServiceCompatApi21.ServiceCallbacksImplApi21(callbacks));
    }
}