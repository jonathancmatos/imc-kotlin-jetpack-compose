package com.devjonathancosta.imc_calculator.ui.views.components

import android.graphics.Paint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.stringResource
import com.devjonathancosta.imc_calculator.R
import com.devjonathancosta.imc_calculator.ui.theme.Black
import com.devjonathancosta.imc_calculator.ui.theme.Gray900
import com.devjonathancosta.imc_calculator.ui.theme.Green600
import com.devjonathancosta.imc_calculator.ui.theme.Orange500
import com.devjonathancosta.imc_calculator.ui.theme.Pink500
import com.devjonathancosta.imc_calculator.ui.theme.Purple500
import com.devjonathancosta.imc_calculator.ui.theme.Red500
import com.devjonathancosta.imc_calculator.ui.theme.Typography
import java.util.Locale
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ImcGauge(
    value: Float,
    modifier: Modifier = Modifier
) {
    val animatedValue by animateFloatAsState(
        targetValue = value.coerceIn(0f, 50f),
    )

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val startAngle = 180f
            val sweepAngle = 180f
            val strokeWidth = size.minDimension * 0.1f
            val arcSize = Size(size.width, size.height)
            val center = Offset(size.width / 2, size.height / 2)
            val radius = size.minDimension / 2 - strokeWidth / 2

            val maxValue = 50f

            val ranges = listOf(
                Triple(0f, 18.5f, Purple500),
                Triple(18.5f, 24.9f, Green600),
                Triple(25f, 30f, Orange500),
                Triple(30.1f, 39.9f, Pink500),
                Triple(40f, maxValue, Red500)
            )

            drawArc(
                color = Color.LightGray.copy(alpha = 0.2f),
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                size = arcSize,
                topLeft = Offset.Zero
            )

            for ((start, end, color) in ranges) {
                val startSweep = (start / maxValue) * sweepAngle
                val rangeSweep = ((end - start) / maxValue) * sweepAngle
                drawArc(
                    color = color,
                    startAngle = startAngle + startSweep,
                    sweepAngle = rangeSweep,
                    useCenter = false,
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Butt),
                    size = arcSize,
                    topLeft = Offset.Zero
                )
            }

            val angle = startAngle + (animatedValue / maxValue * sweepAngle)
            val innerRadius = radius * 0.3f
            val startX = center.x + innerRadius * cos(Math.toRadians(angle.toDouble())).toFloat()
            val startY = center.y + innerRadius * sin(Math.toRadians(angle.toDouble())).toFloat()
            val endX = center.x + radius * cos(Math.toRadians(angle.toDouble())).toFloat()
            val endY = center.y + radius * sin(Math.toRadians(angle.toDouble())).toFloat()

            drawLine(
                color = Color.Black,
                start = Offset(startX, startY),
                end = Offset(endX, endY),
                strokeWidth = strokeWidth / 5,
                cap = StrokeCap.Round
            )

            val steps = listOf(0f, 18.5f, 24.9f, 30f, 40f, 50f)
            drawIntoCanvas { canvas ->
                val paint = Paint().apply {
                    color = android.graphics.Color.BLACK
                    textSize = 24f
                    textAlign = Paint.Align.CENTER
                }
                for (step in steps) {
                    val stepAngle = startAngle + (step / maxValue * sweepAngle)
                    val textRadius = radius * 0.85f
                    val textX = center.x + textRadius * cos(Math.toRadians(stepAngle.toDouble())).toFloat()
                    val textY = center.y + textRadius * sin(Math.toRadians(stepAngle.toDouble())).toFloat()
                    canvas.nativeCanvas.drawText(
                        if (step % 1f == 0f) step.toInt().toString() else step.toString(),
                        textX,
                        textY,
                        paint
                    )
                }
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = String.format(Locale.US, "%.1f", value),
                style = Typography.headlineLarge.copy(
                    color = Black
                )
            )
            Text(
                text = stringResource(R.string.graphic_legend),
                style = Typography.bodySmall.copy(
                    color = Gray900
                )
            )
        }
    }
}

