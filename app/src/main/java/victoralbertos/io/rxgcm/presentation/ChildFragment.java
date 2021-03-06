package victoralbertos.io.rxgcm.presentation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import rx.Observable;
import rx_gcm.ForegroundMessage;
import rx_gcm.GcmForegroundReceiver;
import victoralbertos.io.rxgcm.BackgroundMessageReceiver;
import victoralbertos.io.rxgcm.R;

/**
 * Created by victor on 08/02/16.
 */
public class ChildFragment extends Fragment implements GcmForegroundReceiver {

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override public void onReceiveMessage(Observable<ForegroundMessage> oMessage) {
        final TextView tv_title = (TextView) getView().findViewById(R.id.tv_title_fragment);
        final TextView tv_body = (TextView) getView().findViewById(R.id.tv_body_fragment);

        oMessage.doOnError(error -> tv_title.setText(error.getMessage()))
                .subscribe(message -> {
                    String title = message.getPayload().getString(BackgroundMessageReceiver.TITLE);
                    tv_title.setText(title);
                    String body = message.getPayload().getString(BackgroundMessageReceiver.BODY);
                    tv_body.setText(body);
                });
    }
}
