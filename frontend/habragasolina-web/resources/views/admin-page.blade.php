@include('components.header')
<body>
	<div class="container">
    <div class="admin-page">
		<br>
		<br> 
        <div class="label-group">
            <label for="label1">User:</label>
			<label for="label1">{{$user->name}}</label>
        </div>
        <div class="label-group">
            <label for="label2">Station:</label>
            <label for="label">{{$station->name}}</label>
        </div>
        <div class="label-group">
            <label for="dropdown">Fuel type:</label>
            <select id="dropdown">
                <option value="">Select an option:</option>
                @foreach ($fuel_type as $row)
                <option value="option{{$row->id}}">{{$row->name}}</option>              
                @endforeach
            </select>
        </div>
        <div class="buttons">
            <button><a href="">Available</a></button>
            <button><a href="">Just</a></button>
            <button><a href="">Don't sell</a></button>
        </div>
        <div class="return-link">
            <a href="/habragasolina-web/resources/views/welcome.blade.php">Return</a>
        </div>
    </div>
	</div>
</body>
@include('components.footer')