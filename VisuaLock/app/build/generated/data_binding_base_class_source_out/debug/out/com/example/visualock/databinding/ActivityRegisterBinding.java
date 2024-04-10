// Generated by view binder compiler. Do not edit!
package com.example.visualock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.visualock.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView RegisterCardView;

  @NonNull
  public final Button createPassword;

  @NonNull
  public final FloatingActionButton helpbutton;

  @NonNull
  public final TextView loginRedirectText;

  @NonNull
  public final EditText registerEmail;

  @NonNull
  public final EditText registerName;

  private ActivityRegisterBinding(@NonNull ConstraintLayout rootView,
      @NonNull CardView RegisterCardView, @NonNull Button createPassword,
      @NonNull FloatingActionButton helpbutton, @NonNull TextView loginRedirectText,
      @NonNull EditText registerEmail, @NonNull EditText registerName) {
    this.rootView = rootView;
    this.RegisterCardView = RegisterCardView;
    this.createPassword = createPassword;
    this.helpbutton = helpbutton;
    this.loginRedirectText = loginRedirectText;
    this.registerEmail = registerEmail;
    this.registerName = registerName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.RegisterCardView;
      CardView RegisterCardView = ViewBindings.findChildViewById(rootView, id);
      if (RegisterCardView == null) {
        break missingId;
      }

      id = R.id.create_password;
      Button createPassword = ViewBindings.findChildViewById(rootView, id);
      if (createPassword == null) {
        break missingId;
      }

      id = R.id.helpbutton;
      FloatingActionButton helpbutton = ViewBindings.findChildViewById(rootView, id);
      if (helpbutton == null) {
        break missingId;
      }

      id = R.id.loginRedirectText;
      TextView loginRedirectText = ViewBindings.findChildViewById(rootView, id);
      if (loginRedirectText == null) {
        break missingId;
      }

      id = R.id.register_email;
      EditText registerEmail = ViewBindings.findChildViewById(rootView, id);
      if (registerEmail == null) {
        break missingId;
      }

      id = R.id.register_name;
      EditText registerName = ViewBindings.findChildViewById(rootView, id);
      if (registerName == null) {
        break missingId;
      }

      return new ActivityRegisterBinding((ConstraintLayout) rootView, RegisterCardView,
          createPassword, helpbutton, loginRedirectText, registerEmail, registerName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
