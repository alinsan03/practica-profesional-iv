@include('components.headerAdmin')
<body>
	<div class="container">
    <div class="admin-page">
		<br>
		<br>
        <div class="label-group">
            <label for="label1">User:</label>
			<label for="label1">Test</label>
        </div>
        <div class="label-group">
            <label for="label2">Station:</label>
            <label for="label">Test</label>
        </div>
        <div class="label-group">
            <label for="dropdown">Fuel type:</label>
            <select id="dropdown">
                <option value="">Select an option:</option>
                @foreach ($fueltypes as $fuel)
                <option value="option{{$fuel['id']}}">{{$fuel['name']}}</option>
                @endforeach
            </select>
        </div>
        <div>
            <button class="available">Disponible</button>
        </div>
        <div>
            <button  class="notavailable">No disponible</button>
        </div>
        <div>
            <button class="notsale">No se vende</button>
        </div>
    </div>
</body>
@include('components.footer')
