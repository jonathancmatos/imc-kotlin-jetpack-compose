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
import com.devjonathancosta.imc_calculator.ui.theme.Green600
import com.devjonathancosta.imc_calculator.ui.views.components.ImcGauge

@Composable
fun ResultView(navController: NavController) {
    DSScaffold (
        title = stringResource(id = R.string.app_name),
        textAlign = TextAlign.Center,
        navController = navController,
        canNavigateBack = true,
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
                        horizontal = 16.dp)
            ) {
                Text("VOCÊ ESTÁ:",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Gray900
                    ),
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text("SAUDÁVEL",
                    style = MaterialTheme.typography.displayMedium.copy(
                        color = Green600
                    )
                )
                Spacer(modifier = Modifier.size(32.dp))
                Text("SEU PESO ESTÁ ENTRE:",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Gray900
                    ),
                )
                Text("18,5 a 24,9",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = Green600
                    )
                )
                Spacer(modifier = Modifier.size(100.dp))
                ImcGauge(value = 22.0F, modifier = Modifier.size(300.dp))
            }
        }
    )
}

@Preview
@Composable
fun ResultViewPreview(){
    val fakeNavController = rememberNavController()
    ResultView(navController = fakeNavController)
}

