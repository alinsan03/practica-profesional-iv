@include('components.header')
<body>
	<div class="container">
    <div class="admin-page">
		<br>
		<br>
        <div class="label-group">
            <label for="label1">Label 1:</label>
			<label for="label1">label.</label>
        </div>
        <div class="label-group">
            <label for="label2">Label 2:</label>
            <label for="label">Label.</label>
        </div>
        <div class="label-group">
            <label for="dropdown">Fuel type:</label>
            <select id="dropdown">
                <option value="">Select an option:</option>
                <option value="option1">Regular Gasoline</option>
                <option value="option2">Premium Gasoline</option>
                <option value="option3">Diesel</option>
            </select>
        </div>
        <div class="buttons">
            <button>Available</button>
            <button>Just</button>
            <button>Don't sell</button>
        </div>
        <div class="return-link">
            <a href="/habragasolina-web/resources/views/welcome.blade.php">Return</a>
        </div>
    </div>
	</div>
</body>
@include('components.footer')