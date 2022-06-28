package com.example.dialogcustomizado;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class LoginDialog extends DialogFragment implements DialogInterface.OnClickListener {

    private EditText edtLogin;
    private EditText edtSenha;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.titleDialog);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.dialog_login, null);

        builder.setView(layout);

        edtLogin = layout.findViewById(R.id.edtLogin);
        edtSenha = layout.findViewById(R.id.edtSenha);

        builder.setPositiveButton(R.string.positive, this);
        builder.setNegativeButton(R.string.negative, this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        String login = edtLogin.getText().toString();
        String senha = edtSenha.getText().toString();

        if(i == DialogInterface.BUTTON_POSITIVE){

            if (login.equals("login") && senha.equals("123456")){
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);

            }
            else
                Toast.makeText(getActivity(), R.string.loginFail,
                        Toast.LENGTH_SHORT).show();

        }
        else if (i == DialogInterface.BUTTON_NEGATIVE){
            Toast.makeText(getActivity(), R.string.loginCancel,
                    Toast.LENGTH_SHORT).show();
        }
    }
}