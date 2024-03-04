<!DOCTYPE html>
<html>
<head>
    <title>Spring MVC JSP Example</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
<canvas id="myChart" width="400" height="400"></canvas>
<h1>Dynamic Number:</h1>
<div id="number">0</div>
<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: [], // Массив меток для оси X (временной оси)
            datasets: [{
                label: 'Dynamic Data',
                data: [], // Массив данных для отображения на графике
                backgroundColor: 'rgba(255, 99, 132, 0.2)', // Цвет области под графиком
                borderColor: 'rgba(255, 99, 132, 1)', // Цвет линии графика
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true // Начало оси Y с 0
                }
            }
        }
    });

    setInterval(function() {
        fetch('/binance/price/last/BTCUSDT')
            .then(response => response.text())
            .then(data => {
                // Добавляем новые данные к массиву данных графика
                myChart.data.labels.push(new Date().toLocaleTimeString());
                myChart.data.datasets[0].data.push(parseInt(data)); // Парсим строку в число
                // Ограничиваем количество отображаемых точек на графике до, например, 10
                if (myChart.data.labels.length > 10) {
                    myChart.data.labels.shift();
                    myChart.data.datasets[0].data.shift();
                }
                // Обновляем график
                myChart.update();
                // Обновляем число в div элементе
                document.getElementById('number').innerText = data;
            });
    }, 1000);
</script>
</body>
</html>
