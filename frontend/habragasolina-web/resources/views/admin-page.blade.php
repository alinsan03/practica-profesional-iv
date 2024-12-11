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
                @foreach ($data as $fuel)
                <option value="option{{$fuel['id']}}">{{$fuel['name']}}</option>
                @endforeach
            </select>
        </div>
        <div class="available">
            <button>Disponible</button>
        </div>
        <div class="notavailable">
            <button>No disponible</button>
        </div>
        <div class="notsale">
            <button>No se vende</button>
        </div>
    </div>
</body>
@include('components.footer')