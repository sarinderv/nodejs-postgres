package com.cmpe277.hackathon.mainactivity;


        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.CompoundButton;
        import android.widget.Toast;

        import androidx.annotation.Nullable;
        import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ChoiceSheetDialog extends BottomSheetDialogFragment {
    boolean isgdp;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.choice_sheet_layout,
                container, false);

        Button algo_button = v.findViewById(R.id.show_btn);

        CheckBox box=v.findViewById(R.id.checkbox_gdp_growth_rage);
        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                update(isChecked);
            }
        }
        );
        algo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity(),
                        "Options Shared "+getGdp(), Toast.LENGTH_SHORT)
                        .show();
                dismiss();
            }
        });
        return v;
    }
    public boolean getGdp(){
        return this.isgdp;
    }
    public void update(boolean isgdp){
        this.isgdp=isgdp;
    }
}
