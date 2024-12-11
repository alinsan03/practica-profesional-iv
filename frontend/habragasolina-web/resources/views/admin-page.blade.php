@include('components.headerAdmin')
<body>
	<div class="container">
    <div class="admin-page">
		<br>
		<br>
        <div class="label-group">
            <label for="label1">Usuario:</label>
			<label for="label1">Test</label>
        </div>
        <div class="label-group">
            <label for="label2">Estación de Gasolina:</label>
            <label for="label">Test</label>
        </div>
        <div class="label-group">
            <label for="dropdown">Tipo de Gasolina:</label>
            <select id="dropdown">
                <option value="">Selecciona una opción:</option>
                @foreach ($data as $fuel)
                <option value="option{{$fuel['id']}}">{{$fuel['name']}}</option>
                @endforeach
            </select>
        </div>
            <div>
                <center>
                <table>
                    <tr>
                        <td>
                <div>
                    <button class="available">Disponible</button>
                </div>
                        </td>
                        <td>
        <div>
            <button  class="notavailable">No disponible</button>
        </div>
        </td>
        <td>
        <div>
            <button class="notsale">No se vende</button>
        </div>
        </td>
        </tr>
        </table>
        </center>
    </div>
    </div>
</body>
@include('components.footer')
