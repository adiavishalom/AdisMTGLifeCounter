package com.adiavishalom.adismtglifecounter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class TokenDialog extends AppCompatDialogFragment {
    private EditText editAmount, editPower, editToughness;
    private TokenDialogListener listener;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_token_options, null);
        editAmount = view.findViewById(R.id.editAmount);
        editPower = view.findViewById(R.id.editPower);
        editToughness = view.findViewById(R.id.editToughness);


        builder.setView(view)
                .setTitle("Creating Tokens")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Generate", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            int amount = Integer.parseInt(editAmount.getText().toString());
                            int power = Integer.parseInt(editPower.getText().toString());
                            int toughness = Integer.parseInt(editToughness.getText().toString());
                            listener.applyGenerate(amount, power, toughness);
                        } catch (Exception e) {

                        }
                    }
                });


        return builder.create();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (TokenDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement");
        }
    }


    public interface TokenDialogListener {
        void applyGenerate(int amount, int power, int toughness);
    }
}
