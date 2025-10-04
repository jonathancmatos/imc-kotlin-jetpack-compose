import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.devjonathancosta.imc_calculator.R
import com.devjonathancosta.imc_calculator.ui.components.DSScaffold
import com.devjonathancosta.imc_calculator.ui.theme.Gray900
import com.devjonathancosta.imc_calculator.ui.theme.Green500
import com.devjonathancosta.imc_calculator.ui.theme.Orange500
import com.devjonathancosta.imc_calculator.ui.theme.Pink500
import com.devjonathancosta.imc_calculator.ui.theme.Purple500
import com.devjonathancosta.imc_calculator.ui.views.components.ImcGauge

@Composable
fun ResultView(navController: NavController, imc: Float) {
    val title  = when {
        imc < 18.5 -> stringResource(R.string.underweight_text)
        imc in 18.5..24.9 -> stringResource(R.string.healthy_text)
        imc in 25.0..29.9 -> stringResource(R.string.overweight)
        imc in 30.0..34.9 -> stringResource(R.string.grade_1_obesity)
        imc in 35.0..39.9 -> stringResource(R.string.grade_2_obesity)
        imc >= 40.0 -> stringResource(R.string.grade_3_obesity)
        else -> stringResource(R.string.n_a_text)
    }

    val subtitle = when {
        imc < 18.5 -> stringResource(R.string._0_to_18_4_text)
        imc in 18.5..24.9 -> stringResource(R.string._18_5_a_24_9_text)
        imc in 25.0..29.9 -> stringResource(R.string._25_0_a_29_9_text)
        imc in 30.0..34.9 -> stringResource(R.string._30_0_a_34_9_text)
        imc in 35.0..39.9 -> stringResource(R.string._35_0_a_39_9_text)
        imc >= 40.0 -> stringResource(R.string._40_0_a_50_0_text)
        else -> stringResource(R.string.n_a_text)
    }

    val color = when {
        imc < 18.5 -> Purple500
        imc in 18.5..24.9 -> Green500
        imc in 25.0..29.9 -> Orange500
        imc in 30.0..34.9 -> Orange500
        imc in 35.0..39.9 -> Pink500
        imc >= 40.0 -> Color.Red
        else -> Color.Red
    }

    DSScaffold (
        title = stringResource(id = R.string.app_name),
        textAlign = TextAlign.Center,
        navController = navController,
        content = { padding ->
            Column (
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(Color.White)
                    .padding(
                        vertical = 24.dp,
                        horizontal = 16.dp
                    )
            ) {
                Text(
                    stringResource(R.string.you_are_text),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Gray900
                    ),
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(title,
                    style = MaterialTheme.typography.displayMedium.copy(
                        color = color,
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = Modifier.size(32.dp))
                Text(
                    stringResource(R.string.your_weight_comes_between_text),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Gray900
                    ),
                )
                Text(subtitle,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = color
                    )
                )
                Spacer(modifier = Modifier.size(100.dp))
                ImcGauge(value = imc, modifier = Modifier.size(300.dp))
            }
        }
    )
}

@Preview
@Composable
fun ResultViewPreview(){
    val fakeNavController = rememberNavController()
    ResultView(navController = fakeNavController, imc = 22.5f)
}

