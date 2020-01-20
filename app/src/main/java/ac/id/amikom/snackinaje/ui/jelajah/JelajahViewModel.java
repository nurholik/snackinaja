package ac.id.amikom.snackinaje.ui.jelajah;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class JelajahViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public JelajahViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Hallowww elaaaa");
    }

    public LiveData<String> getText() {
        return mText;
    }
}