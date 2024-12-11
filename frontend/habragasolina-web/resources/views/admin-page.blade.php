@include('components.headerAdmin')
<body>
	<div class="container">
    <div class="admin-page">
		<br>
		<br>
        <div class="label-group">
            <label for="label1">Usuario:</label>
			<label for="label1">{{ session('name') }}</label>
        </div>
        <div class="label-group">
            <label for="label2">Estación de Gasolina:</label>
            <label for="label">{{ session('idGasStation') }}</label>
        </div>
        <div class="label-group">
            <label for="dropdown">Tipo de Gasolina:</label>
            <form method="POST" action="{{ route('updateStatus') }}">
                @csrf
                <input type="hidden" name="idGasStation" value="{{ session('idGasStation') }}">
                <select name="idFuelType" required>
                    <option value="">Selecciona una opción:</option>
                    @foreach ($fueltypes as $fuel)
                    <option value="{{$fuel['id']}}">{{$fuel['name']}}</option>
                    @endforeach
                </select>
                <div>
                    <center>
                    <table class="no-borders">
                        <tr>
                            <td>
                    <div>
                        <button type="submit" name="idStatus" value="1" class="available">Disponible</button>
                    </div>
                            </td>
                            <td>
                    <div>
                        <button type="submit" name="idStatus" value="2" class="notavailable">No disponible</button>
                    </div>
                            </td>
                            <td>
                    <div>
                        <button type="submit" name="idStatus" value="3" class="notsale">No se vende</button>
                    </div>
                            </td>
                            </tr>
                    </table>
                    </center>
                </div>
            </form>
        </div>
    </div>
</body>
@include('components.footer')
