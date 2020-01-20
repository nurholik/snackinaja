package ac.id.amikom.snackinaje.ui.rencana;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RencanaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RencanaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("mboten nopo-nopo bulek");
    }

    public LiveData<String> getText() {
        return mText;
    }
}