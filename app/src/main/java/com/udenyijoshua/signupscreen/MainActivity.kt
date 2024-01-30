package com.udenyijoshua.signupscreen

import android.graphics.Color.rgb
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udenyijoshua.signupscreen.ui.theme.SignUpScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUpLayout()
                }
            }
        }
    }
}

@Composable
fun SignUpLayout(modifier: Modifier = Modifier) {

    var nameField by remember {
        mutableStateOf("")
    }
    var emailField by remember {
        mutableStateOf("")
    }
    var passKeyField by remember {
        mutableStateOf("")
    }
    var confirmPassKeyField by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        val context = LocalContext.current
        Row(){
            Text(
                stringResource(R.string.sign_up), fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp,
                modifier = Modifier.weight(1f).wrapContentWidth(align = Alignment.Start)
            )

            Text(
                "Rentr App", fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp,
                modifier = Modifier.weight(1f).wrapContentWidth(align = Alignment.End)
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 25.dp))
        OutlineButtonComponent()
        Box(
            modifier = Modifier
                .padding(top = 25.dp)
        ) {
            Divider(modifier = Modifier.padding(top = 20.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            ) {
                Box(
                    modifier = Modifier

//                        Be careful with your modifier chaining
                        .size(width = 30.dp, height = 30.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(Color.Black),

                    contentAlignment = Alignment.Center,
                ) {
                    Text(text = "Or", color = Color.White) // Adjust text color as needed
                }
            }
        }
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        Text(
            text = stringResource(R.string.name_field),
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        OutlineTextFieldComponent(
            value = nameField,
            onValueChange = { nameField = it },
            label = R.string.placeholder_name,
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = false,
                capitalization = KeyboardCapitalization.Words,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.padding(bottom = 20.dp))
        Text(
            text = stringResource(R.string.email_field),
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 10.dp)
            )
        OutlineTextFieldComponent(
            value = emailField,
            onValueChange = { emailField = it },
            label = R.string.placeholder_email,
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = false,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.padding(bottom = 20.dp))
        Text(
            text = stringResource(R.string.password_field),
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        OutlineTextFieldComponent(
            value = passKeyField,
            onValueChange = { passKeyField = it },
            label = R.string.placeholder_pass_key,
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = false,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.padding(bottom = 20.dp))
        Text(
            text = stringResource(R.string.confirm_password_field),
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        OutlineTextFieldComponent(
            value = confirmPassKeyField,
            onValueChange = { confirmPassKeyField = it },
            label = R.string.placeholder_confirm_pass_key,
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = false,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        TermsAndCondition()

        Spacer(modifier = Modifier.padding(bottom = 40.dp))
        FilledButtonComponent(
            onClick = {
                Toast.makeText(context , "Login Successful", Toast.LENGTH_SHORT).show()
            }
        )

        Spacer(modifier = Modifier.padding(bottom = 20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 50.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    stringResource(R.string.already_have_an_account_text),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    stringResource(R.string.log_in_text),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.clickable { }
                )
            }
        }

    }
}

@Composable
fun OutlineTextFieldComponent(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = { Text(stringResource(label)) },
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Black,
            unfocusedContainerColor = Color(rgb(239, 238, 247)),
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedPlaceholderColor = Color.LightGray,
            focusedPlaceholderColor = Color.LightGray
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
fun OutlineButtonComponent() {
    OutlinedButton(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        border = BorderStroke(.5.dp, Color(rgb(92, 90, 104))),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = stringResource(R.string.sign_up_with_google_btn),
            fontWeight = FontWeight.Black,
            fontSize = 20.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun FilledButtonComponent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(rgb(85, 76, 181))
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.sign_up_btn),
            fontWeight = FontWeight.Black,
            fontSize = 25.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsAndCondition() {
    var isChecked by remember {
        mutableStateOf(false)
    }
    CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
        Row() {
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                }
            )
            Text(
                text = stringResource(R.string.i_agree_to_the_terms_and_privacy_policy_tandc),
                modifier = Modifier
                    .padding(start = 10.dp, top = 2.dp),
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignUpLayout()
}