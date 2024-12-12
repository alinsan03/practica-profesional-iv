@include('components.headerAdmin')
<body>
    <div class="container">
        <div class="admin-page">
            <br><br>
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
                    <option value="">Select an option:</option>
                    @foreach ($fueltypes as $fuel)
                        <option value="{{ $fuel['id'] }}">{{ $fuel['name'] }}</option>
                    @endforeach
                </select>
            </div>
            <div>
                <center>
                    <table>
                        <tr>
                            <td>
                                <div>
                                    <button class="available status-btn" data-status="1">Disponible</button>
                                </div>
                            </td>
                            <td>
                                <div>
                                    <button class="notavailable status-btn" data-status="2">No disponible</button>
                                </div>
                            </td>
                            <td>
                                <div>
                                    <button class="notsale status-btn" data-status="3">No se vende</button>
                                </div>
                            </td>
                        </tr>
                    </table>
                </center>
            </div>
        </div>
    </div>
    <script>
        // JavaScript para manejar eventos y enviar datos
        document.querySelectorAll('.status-btn').forEach(button => {
            button.addEventListener('click', () => {
                // Obtener valores del dropdown y del botón
                const idFuelType = document.getElementById('dropdown').value;
                const idStatus = button.getAttribute('data-status');

                if (!idFuelType) {
                    alert('Por favor selecciona un tipo de gasolina.');
                    return;
                }

                // Crear el objeto de datos
                const postData = {
                    idFuelType: idFuelType,
                    idStatus: idStatus
                };
                console.log(postData);
                //Enviar datos con Axios
                fetch('/admin-page', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'X-CSRF-TOKEN': document.querySelector('meta[name="csrf-token"]').content,
                    },
                    body: JSON.stringify(postData),
                })
                    .then(response => response.json())
                    .then(data => {
                        if (data.error) {
                            console.error(data.error);
                            alert('Error: ' + data.detalle);
                        } else {
                            alert(data.mensaje);
                        }
                    })
                    .catch(error => console.error('Error:', error));
             });
        });
    </script>
</body>
@include('components.footer')
