<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla de Datos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Habrá Gasolina</h1>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Location</th>
                    <th>Gasolina</th>
                    <th>Date Gasolina</th>
                    <th>Premium</th>
                    <th>Date Premium</th>
                    <th>Diesel</th>
                    <th>Date Diesel</th>
                </tr>
            </thead>
            <tbody>
                @foreach ($data as $row)
                <tr>
                    <td>{{ $row['name'] }}</td>
                    <td>{{ $row['location'] }}</td>
                    <td>{{ $row['gasolina'] ?? 'N/A' }}</td>
                    <td>{{ $row['dateGasolina'] ?? 'N/A' }}</td>
                    <td>{{ $row['premium'] ?? 'N/A' }}</td>
                    <td>{{ $row['datePremium'] ?? 'N/A' }}</td>
                    <td>{{ $row['diesel'] ?? 'N/A' }}</td>
                    <td>{{ $row['dateDiesel'] ?? 'N/A' }}</td>
                </tr>
                @endforeach
            </tbody>
        </table>
    </div>
</body>
</html>