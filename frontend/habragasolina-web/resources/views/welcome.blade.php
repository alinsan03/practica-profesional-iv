@include('components.header')
<body>
    <div class="container">
        <h4>hola</h4>
        <h4>hola</h4>
        <h4>   ewr</h4>
        <h4>re</h4>
        <h4>re</h4>
        <h4>e</h4>
        <h4>rerw</h4>
        <table BORDER>
	<tr>
		<th COLSPAN=2>name 1</th>
		<th COLSPAN=2>name 2</ht>
	</tr>
	<tr>
		<th>this</th> <th>is</th> 
		<th>a</th> <th>example</th> 
	</tr>
	<tr>
		<td>Mosiremit</td> <td>i dont</td> <td>know</td> <td>xd</td> 
	</tr>
	<tr>
		<td>what</td> <td>are u</td> <td>talking</td> <td>about to me? bro</td> 
	</tr>
        </table>
    </div>
</body>
@include('components.footer')
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gas Stations</title>
</head>
<body>
    <h1>Gas Stations Availability</h1>

    @if (!empty($gasStations))
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Availability</th>
                </tr>
            </thead>
            <tbody>
                @foreach ($gasStations as $gasStation)
                    <tr>
                        <td>{{ $gasStation['id'] }}</td>
                        <td>{{ $gasStation['name'] }}</td>
                        <td>{{ $gasStation['availability'] }}</td>
                    </tr>
                @endforeach
            </tbody>
        </table>
    @else
        <p>No data available</p>
    @endif
</body>
</html>